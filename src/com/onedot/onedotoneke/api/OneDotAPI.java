package com.onedot.onedotoneke.api;

/**
 * @author ˧
 * 2015.7.30
 */

import java.io.Serializable;
import java.util.List;

public class OneDotAPI extends BaseAPI {
	
	private List<OneDotInfo> item;
	
	public List<OneDotInfo> getItem() {
		return item;
	}

	public void setItem(List<OneDotInfo> item) {
		this.item = item;
	}
	
	public final static class OneDotInfo implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = -6934976511522627324L;
		private int update_tmtp;
		private String nick_nm;
		private String addr;
		private String time;
		private int user_id;
		private String msg;
		
		public int getUpdate_tmtp() {
			return update_tmtp;
		}
		public void setUpdate_tmtp(int update_tmtp) {
			this.update_tmtp = update_tmtp;
		}
		public String getNick_nm() {
			return nick_nm;
		}
		public void setNick_nm(String nick_nm) {
			this.nick_nm = nick_nm;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		public String getTime() {
			return time;
		}
		public void setTime(String time) {
			this.time = time;
		}
		public int getUser_id() {
			return user_id;
		}
		public void setUser_id(int user_id) {
			this.user_id = user_id;
		}
		public String getMsg() {
			return msg;
		}
		public void setMsg(String msg) {
			this.msg = msg;
		}
		
		
		
	}

}
