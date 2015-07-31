package com.onedot.onedotoneke.view;

import com.onedot.onedotoneke.R;

import android.content.Context;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;
import android.widget.ListView;

public class RefreshLayout extends LinearLayout implements OnScrollListener{

	private View mHeader;
	private int mInitScrollY;
	private int mLastY;
	private int mYOffset;
	private ListView mListView;
	private OnRefreshListener mOnRefreshListener;
	
	//构造函数
	public RefreshLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		mHeader = LayoutInflater.from(context).inflate(R.layout.layout_pull_to_fresh_header, null, true);
		setOrientation(VERTICAL);  
        addView(mHeader , 0);
	}
	
	public void setRefreshCompleteListener(OnRefreshListener onRefreshListener){
		mOnRefreshListener = onRefreshListener;
	}
	
	//刷新结束
	public void refreshComplete(){
		scrollTo(0, mInitScrollY);
	}
	
	private boolean isTop(){
		 View firstChild = mListView.getChildAt(0);  
	        if (firstChild != null) {  
	            int firstVisiblePos = mListView.getFirstVisiblePosition();  
	            if (firstVisiblePos == 0 && firstChild.getTop() == 0) {  
	               return true;
	            } else {   
	                return false;  
	            }  
	        } else {  
	            return true;  
	        }  
	}
	
	//拦截监听事件
	@Override  
    public boolean onInterceptTouchEvent(MotionEvent ev) {  
        final int action = MotionEventCompat.getActionMasked(ev);  
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP) {  
            return false;  
        }  
        switch (action) {  
            case MotionEvent.ACTION_DOWN:  
                mLastY = (int) ev.getRawY();  
                break;  
  
            case MotionEvent.ACTION_MOVE:
                mYOffset = (int) ev.getRawY() - mLastY;
                if ( isTop() && mYOffset > 0) {  
                    return true;  
                }  
                break;  
        }  
        return false;  
    } 
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		super.onTouchEvent(event);
		switch (event.getAction()) {  
        case MotionEvent.ACTION_DOWN:  
            mLastY = (int) event.getRawY();  
            break;  
        case MotionEvent.ACTION_MOVE:  
            int currentY = (int) event.getRawY();  
            mYOffset = currentY - mLastY;
            changeScrollY(mYOffset);
            mLastY = currentY;  
            break;  
        case MotionEvent.ACTION_UP:
        	scrollTo(0, 0);
        	if(mOnRefreshListener != null){
        		mOnRefreshListener.refresh();
        	}
            break;  
        default:  
            break;  
            }  
    return true;  
	}
	
	//测量函数
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		int width = MeasureSpec.getSize(widthMeasureSpec);  
        int childCount = getChildCount();  
        int finalHeight = 0;  
        for (int i = 0; i < childCount; i++) {  
            View child = getChildAt(i);  
            measureChild(child, widthMeasureSpec, heightMeasureSpec);  
            finalHeight += child.getMeasuredHeight();  
        }  
        setMeasuredDimension(width, finalHeight); 
	}
	
	//布局函数
	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		super.onLayout(changed, l, t, r, b);
		mListView = (ListView)getChildAt(1);
		mListView.setOnScrollListener(this);
		// 计算初始化滑动的y轴距离  
        mInitScrollY = mHeader.getMeasuredHeight();
        scrollTo(0, mInitScrollY);
	}
	
	/** 
     * 修改y轴上的滚动值，从而实现header被下拉的效果 
     * @param distance 
     * @return 
     */  
    private void changeScrollY(int distance) {   
        int curY = getScrollY(); 
        scrollBy(0, -distance);  
        curY = getScrollY();  
        int slop = mInitScrollY / 2;
    }
    
	@Override
	public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount,  
            int totalItemCount) {
		
	}
	
	@Override
	public void onScrollStateChanged(AbsListView arg0, int arg1) {
		
		refreshComplete();
	}

	//刷新接口
	public interface OnRefreshListener{
		
		public void refresh();
	}

	public void setRefreshCompleteListener(OnRefreshListener onRefreshListener) {
		// TODO Auto-generated method stub
		
	}
}
