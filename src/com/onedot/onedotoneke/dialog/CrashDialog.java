package com.onedot.onedotoneke.dialog;

import android.app.AlertDialog;
import android.content.Context;

/*
 * @author:莫胜磊
 * @time:2015.8.4
 * @class CrashDialog
 * @function:崩溃的Dialog 提示框
 */
public class CrashDialog extends AlertDialog {

	protected CrashDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
	}

}
