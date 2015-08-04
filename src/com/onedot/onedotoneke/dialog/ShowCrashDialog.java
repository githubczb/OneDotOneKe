package com.onedot.onedotoneke.dialog;

import android.app.AlertDialog;
import android.content.Context;

public class ShowCrashDialog extends AlertDialog {

	protected ShowCrashDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
	}

}
