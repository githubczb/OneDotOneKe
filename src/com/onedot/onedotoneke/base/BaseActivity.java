package com.onedot.onedotoneke.base;

import com.onedot.onedotoneke.AppManager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

/*
 * @author:莫胜磊
 * @time��2015.7.31
 * @class:BaseActivity
 * @function:基础Activity
 */
public class BaseActivity extends FragmentActivity {

	private String TAG = BaseActivity.class.getSimpleName();
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		Log.d(TAG, "BaseActivity onCreate");
		AppManager.getInstance().addActivity(this);
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		AppManager.getInstance().removeActivity(this);
	}
}
