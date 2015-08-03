package com.onedot.onedotoneke.adapter;
/**
 * @author ˧
 * 2015.7.30
 */
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.onedot.onedotoneke.R;
import com.onedot.onedotoneke.api.OneDotAPI.OneDotInfo;
import com.onedot.onedotoneke.base.BaseAdapter;

public class OneDotAdapter extends BaseAdapter {
//	private List<String> infos;
	private Context context;
	
	public OneDotAdapter(Context context){
//		this.infos = oneDotInfo;
		this.context = context;
	}

	@Override
	public int getCount() {
		return 10;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
//		String info = infos.get(position);
//		ViewHolder viewHolder = null;
//		if(convertView == null) {
//			viewHolder = new ViewHolder();
//			convertView = LayoutInflater.from(context).inflate(R.layout.onedot_item, null);
//			viewHolder.nick_nm = (TextView) convertView.findViewById(R.id.nick_nm);
//			viewHolder.nick_nm.setText("info.getNick_nm()");
//			viewHolder.addr = (TextView) convertView.findViewById(R.id.addr);
//			viewHolder.addr.setText("info.getAddr()");
//			viewHolder.time = (TextView) convertView.findViewById(R.id.time);
//			viewHolder.time.setText("info.getTime()");
//			viewHolder.msg = (TextView) convertView.findViewById(R.id.msg);
//			viewHolder.msg.setText("info.getMsg()");
//		}else {
//			viewHolder = (ViewHolder) convertView.getTag();
//			viewHolder.nick_nm.setText("info.getNick_nm()");
//			viewHolder.addr.setText("info.getAddr()");
//			viewHolder.time.setText("info.getTime()");
//			viewHolder.msg.setText("info.getMsg()");
//		}
//		return convertView;
//	}
//	
//	public final class ViewHolder {
//		public ImageView image;
//		public TextView nick_nm,addr,time,msg;
//	}
		View view = LayoutInflater.from(context).inflate(R.layout.onedot_item,
				null);
		return view;
	}

}
