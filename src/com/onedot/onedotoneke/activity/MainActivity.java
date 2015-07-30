package com.onedot.onedotoneke.activity;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseActivity;
import com.onedot.onedotoneke.fragment.CircleFragment;
import com.onedot.onedotoneke.fragment.OneDotFragment;
import com.onedot.onedotoneke.fragment.OneKeFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

/*
 * author:莫胜磊
 * class：MainActivity
 * time:2015/7/29
 */
public class MainActivity extends BaseActivity implements View.OnClickListener{

	private OneDotFragment mOneDotFragment;
	private OneKeFragment mOneKeFragment;
	private CircleFragment mCircleFragment;
	
	private FrameLayout mContainer;
	private View mtab1,mtab2,mtab3;
	
	private TextView mTitleText;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        initTabs();
        mOneDotFragment = new OneDotFragment();
        mOneKeFragment = new OneKeFragment();
        mCircleFragment = new CircleFragment();
        
        mContainer = (FrameLayout)findViewById(R.id.container);
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, mOneDotFragment);
        ft.commit();
    }

	private void initTabs() {
		
		mtab1 = findViewById(R.id.tab1);
		mtab2 = findViewById(R.id.tab2);
		mtab3 = findViewById(R.id.tab3);
		
		mtab1.setOnClickListener(this);
		mtab2.setOnClickListener(this);
		mtab3.setOnClickListener(this);
		
		mTitleText = (TextView)findViewById(R.id.title_text);
	}

	@Override
	public void onClick(View view) {
		FragmentManager fm = getSupportFragmentManager();
		FragmentTransaction ft = fm.beginTransaction();
		switch (view.getId()) {
		case R.id.tab1:
	        ft.replace(R.id.container, mOneDotFragment);
	        ft.commit();
	        mTitleText.setText("一点");
			break;
		case R.id.tab2:
	        ft.replace(R.id.container, mOneKeFragment);
	        ft.commit();
	        mTitleText.setText("一刻");
			break;
		case R.id.tab3:
	        ft.replace(R.id.container, mCircleFragment);
	        ft.commit();
	        mTitleText.setText("圈子");
			break;
		default:
			break;
		}
	}

}
