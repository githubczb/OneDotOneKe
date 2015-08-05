package com.onedot.onedotoneke.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseActivity;
import com.onedot.onedotoneke.handler.UserHandler;

/*
 * @author:莫胜磊
 * @time:2015.7.31
 * @function:注册界面
 * @class:RegisterActivity
 */
public class RegisterActivity extends BaseActivity implements OnClickListener{

	private Button mRegisterBtn;
	
	private EditText mNameEdit;
	private EditText mPasswordEdit;
	private EditText mConformEdit;
	
	private View mGoLogin;
	
	private String mUserNameStr;
	private String mPasswordStr;
	private String mConformPasswordStr;
	private UserHandler mUserHandler;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_register);
		mUserHandler = new UserHandler();
		mRegisterBtn = (Button)findViewById(R.id.register_btn);
		mNameEdit = (EditText)findViewById(R.id.name_edit);
		mPasswordEdit = (EditText)findViewById(R.id.password_edit);
		mConformEdit = (EditText)findViewById(R.id.conform_password_edit);
		mGoLogin = (TextView)findViewById(R.id.go_login);
		mRegisterBtn.setOnClickListener(this);
		mGoLogin.setOnClickListener(this);
		
	}


	@Override
	public void onClick(View view) {
		
		switch (view.getId()) {
		case R.id.register_btn:
			mUserNameStr = mNameEdit.getText().toString();
			mPasswordStr = mPasswordEdit.getText().toString();
			mConformPasswordStr = mConformEdit.getText().toString();
			if(conformPassword()){
				go_regiser();
			}
			break;
		case R.id.go_login:
			startActivity(new Intent(this,LoginActivity.class));
			finish();
		default:
			break;
		}
	}
	
	private boolean conformPassword(){
		
		if(mPasswordStr != null && mConformPasswordStr != null){
			
			if(mPasswordStr.equals(mConformPasswordStr))
				return true;
			return false;
		}
		return false;
	}
	
	private void go_regiser(){
		if(mUserNameStr != null && mPasswordStr != null){
			mUserHandler.register(mUserNameStr, mPasswordStr);
		}
	}
}
