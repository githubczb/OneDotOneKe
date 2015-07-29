package com.onedot.onedotoneke.activity;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseActivity;
import com.onedot.onedotoneke.fragment.CircleFragment;
import com.onedot.onedotoneke.fragment.OneDotFragment;
import com.onedot.onedotoneke.fragment.OneKeFragment;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;


public class MainActivity extends BaseActivity {

	private OneDotFragment mOneDotFragment;
	private OneKeFragment mOneKeFragment;
	private CircleFragment mCircleFragment;
	
	private FrameLayout mContainer;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mOneDotFragment = new OneDotFragment();
        mOneKeFragment = new OneKeFragment();
        mCircleFragment = new CircleFragment();
        
        mContainer = (FrameLayout)findViewById(R.id.container);
        FragmentManager fm = getSupportFragmentManager();
        
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, mOneDotFragment);
        ft.commit();
    }

}
