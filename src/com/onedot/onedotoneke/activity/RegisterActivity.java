package com.onedot.onedotoneke.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;

import com.onedot.onedotoneke.EMChatHandler;
import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseActivity;

/*
 * @author:ÄªÊ¤ÀÚ
 * @time:2015.7.31
 * @function:×¢²á½çÃæ
 * @class£ºRegisterActivity
 */
public class RegisterActivity extends BaseActivity implements OnClickListener{

	private Button mRegisterBtn;
	
	private EditText mNameEdit;
	
	private EditText mPasswordEdit;
	
	private View mGoLogin;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_register);
		
		mRegisterBtn = (Button)findViewById(R.id.register_btn);
		mNameEdit = (EditText)findViewById(R.id.name_edit);
		mPasswordEdit = (EditText)findViewById(R.id.password_edit);
		mGoLogin = (TextView)findViewById(R.id.go_login);
		mRegisterBtn.setOnClickListener(this);
		mGoLogin.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View view) {
		
		switch (view.getId()) {
		case R.id.register_btn:
			EMChatHandler.getInstance().register("moshenglei1", "12345");
			break;
		case R.id.go_login:
			startActivity(new Intent(this,LoginActivity.class));
			finish();
		default:
			break;
		}
	}
}
