package com.onedot.onedotoneke.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;

public class BaseActivity extends FragmentActivity {

	private String TAG = BaseActivity.class.getSimpleName();
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		Log.d(TAG, "BaseActivity onCreate");
	}
}
