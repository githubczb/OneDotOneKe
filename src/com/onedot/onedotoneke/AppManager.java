package com.onedot.onedotoneke;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;

/*
 * @author:莫胜磊
 * @time:2015.8.3
 * @function: 管理 Activity
 * @class:AppManager
 */
public class AppManager {

	private static AppManager mInstance;
	
	private AppManager(){}
	
	public synchronized static AppManager getInstance(){
		
		if(mInstance == null){
			mInstance = new AppManager();
		}
		return mInstance;
	}
	
	/*
	 * @parm Activity 容器
	 */
	private List<Activity> mActivityList = new LinkedList<Activity>();
	
	/*
	 * @parm 添加到容器中
	 */
	public void addActivity(Activity activity){
		
		if(activity != null)
			mActivityList.add(activity);
	}
	
	/*
	 * @parm 关闭所有的Activity
	 */
	public void exit(){
		try {
			for (Activity activity : mActivityList) {
				if (activity != null)
					activity.finish();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
	
	/*
	 * @parm 移除特定的Activity
	 */
	public void removeActivity(Activity activity){
		mActivityList.remove(activity);
	}
	
	/*
	 *@parm:根据类名移除Activity
	 */
	public void removeActivity(@SuppressWarnings("rawtypes") Class className){
		
		try{
			for(Activity activity : mActivityList){
				if(activity != null && activity.getClass() == className){
					activity.finish();
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
