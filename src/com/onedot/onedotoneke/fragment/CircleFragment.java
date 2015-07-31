package com.onedot.onedotoneke.fragment;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.activity.CircleContentActivity;
import com.onedot.onedotoneke.adapter.CircleAdapter;
import com.onedot.onedotoneke.base.BaseFragment;
import com.onedot.onedotoneke.view.RefreshLayout;
import com.onedot.onedotoneke.view.RefreshLayout.OnRefreshListener;
/*
 * @author:ÄªÊ¤ÀÚ
 * @time£º2015.7.30
 * @class:CircleFragment
 * @function:È¦×Ó
 */
public class CircleFragment extends BaseFragment implements OnItemClickListener{

	private ListView mListViewCircle;
	private CircleAdapter mCircleAdapter;
	private RefreshLayout mRefreshLayout;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
		
		View view = LayoutInflater.from(getActivity()).inflate(
				R.layout.fragment_circle, null);
		mListViewCircle = (ListView)view.findViewById(R.id.list_view_circle);
		mRefreshLayout = (RefreshLayout)view.findViewById(R.id.refresh_layout);
		
		mRefreshLayout.setRefreshCompleteListener(new OnRefreshListener() {
			
			@Override
			public void refresh() {
				new HideHeaderTask().execute(); 
			}
		});
		mCircleAdapter = new CircleAdapter(getActivity());
		mListViewCircle.setAdapter(mCircleAdapter);
		
		mListViewCircle.setOnItemClickListener(this);
		return view;	
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		
		startActivity(new Intent(this.getActivity(),
				CircleContentActivity.class));
	}
	
	 class HideHeaderTask extends AsyncTask<Void, Integer, Integer> {  
		  
	        @Override  
	        protected Integer doInBackground(Void... params) {  
	             
	        	try {  
	                Thread.sleep(3000);  
	            } catch (InterruptedException e) {  
	                e.printStackTrace();  
	            }  
	            return 0;  
	        }  
	  
	        @Override  
	        protected void onProgressUpdate(Integer... topMargin) {  
	        }  
	  
	        @Override  
	        protected void onPostExecute(Integer topMargin) { 
	        	mRefreshLayout.refreshComplete();
	        }  
	    }
}
