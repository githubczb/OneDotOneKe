package com.onedot.onedotoneke.dialog;

import com.onedot.onedotoneke.R;

import android.app.Dialog;
import android.content.Context;
import android.widget.TextView;
/*
 * @author:莫胜磊
 * @time:2015.8.4
 * @class DialogUtil
 * @function:Dialog 帮助类
 */
public class DialogUtil {

	/*
	 * 加载 loading dialog
	 */
	private static Dialog progressDialog;
	
	/*
	 * 显示loading dialog
	 */
	public static void showProgressDialog(Context context){
		
		if(progressDialog == null){
			progressDialog = new Dialog(context,R.style.progress_dialog);
	        progressDialog.setContentView(R.layout.progress_dialog);
	        progressDialog.setCancelable(true);
	        progressDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
	        TextView msg = (TextView) progressDialog.findViewById(R.id.id_tv_loadingmsg);
	        msg.setText("卖力加载中");
	        progressDialog.setCanceledOnTouchOutside(false);
		}
		 progressDialog.show();
	}
	
	/*
	 * 消失 loading dialog
	 */
	public static void dimissProgressDialog(){
		if(progressDialog != null && progressDialog.isShowing()){
			progressDialog.dismiss();
		}
	}
}
