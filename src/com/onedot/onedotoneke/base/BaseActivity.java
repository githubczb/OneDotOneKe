package com.onedot.onedotoneke.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

/*
 * @author:莫胜磊
 * @time：2015.7.31
 * @class:BaseActivity
 * @function:基础Activity，所有的Activity都要继承这个类
 */
public class BaseActivity extends FragmentActivity {

	private String TAG = BaseActivity.class.getSimpleName();
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		Log.d(TAG, "BaseActivity onCreate");
	}
}
