package com.onedot.onedotoneke.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import com.onedot.onedotoneke.base.BaseActivity;

public class SplashActivity extends BaseActivity {

	private  final int sleepTime = 2000;
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		
		new Thread(new Runnable() {
			public void run() {
				long start = System.currentTimeMillis();
				long costTime = System.currentTimeMillis() - start;
					if (sleepTime - costTime > 0) {
						try {
							Thread.sleep(sleepTime - costTime);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					startActivity(new Intent(SplashActivity.this, RegisterActivity.class));
					finish();
			}
		}).start();
	}
	/**
	 * 获取当前应用程序的版本号
	 */
	private String getVersion() {
		String st = "worong";
		PackageManager pm = getPackageManager();
		try {
			PackageInfo packinfo = pm.getPackageInfo(getPackageName(), 0);
			String version = packinfo.versionName;
			return version;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return st;
		}
	}
}
