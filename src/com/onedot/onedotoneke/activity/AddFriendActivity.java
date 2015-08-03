package com.onedot.onedotoneke.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.easemob.chat.EMContactManager;
import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.base.BaseActivity;

/*
 * @author:莫胜磊
 * @time:2015.7.31
 * @function:添加联系人界面
 * @class:AddFriendActivity
 */
public class AddFriendActivity extends BaseActivity {

	private EditText editText;
	private LinearLayout searchedUserLayout;
	private TextView nameText,mTextView;
	private Button searchBtn;
	private ImageView avatar;
	private InputMethodManager inputMethodManager;
	private String toAddUsername;
	private ProgressDialog progressDialog;
	
	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_add_friend);
		
		mTextView = (TextView) findViewById(R.id.add_list_friends);
		editText = (EditText) findViewById(R.id.edit_note);
		String strAdd = "添加";
		mTextView.setText(strAdd);
		String strUserName = "用户";
		editText.setHint(strUserName);
		searchedUserLayout = (LinearLayout) findViewById(R.id.ll_user);
		nameText = (TextView) findViewById(R.id.name);
		searchBtn = (Button) findViewById(R.id.search);
		avatar = (ImageView) findViewById(R.id.avatar);
		inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	
	}
	
	/**
	 * 查找contact
	 * @param v
	 */
	public void searchContact(View v) {
		final String name = editText.getText().toString();
		String saveText = searchBtn.getText().toString();
		
			
			// TODO 从服务器获取此contact,如果不存在提示不存在此用户
			
			//服务器存在此用户，显示此用户和添加按钮
			searchedUserLayout.setVisibility(View.VISIBLE);
			nameText.setText(toAddUsername);
			
	}	
	
	/**
	 *  添加contact
	 * @param view
	 */
	public void addContact(View view){
		
		progressDialog = new ProgressDialog(this);
		String stri = "ss";
		progressDialog.setMessage(stri);
		progressDialog.setCanceledOnTouchOutside(false);
		progressDialog.show();
		
		new Thread(new Runnable() {
			public void run() {
				
				try {
					//demo写死了个reason，实际应该让用户手动填入
					String s = "sdf";
					EMContactManager.getInstance().addContact(toAddUsername, s);
					runOnUiThread(new Runnable() {
						public void run() {
							progressDialog.dismiss();
							String s1 = "success";
							Toast.makeText(getApplicationContext(), s1, 1).show();
						}
					});
				} catch (final Exception e) {
					runOnUiThread(new Runnable() {
						public void run() {
							progressDialog.dismiss();
							String s2 = "fail";
							Toast.makeText(getApplicationContext(), s2 + e.getMessage(), 1).show();
						}
					});
				}
			}
		}).start();
	}
	
	public void back(View v) {
		finish();
	}
}
