package com.onedot.onedotoneke;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;

/*
 * @author:Īʤ��
 * @time:2015.8.3
 * @function: ���� Activity
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
	 * @parm Activity ����
	 */
	private List<Activity> mActivityList = new LinkedList<Activity>();
	
	/*
	 * @parm ��Activity ��������
	 */
	public void addActivity(Activity activity){
		
		if(activity != null)
			mActivityList.add(activity);
	}
	
	/*
	 * @parm �رյ����е�Activity
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
	 * @parm �Ƴ��ض���Activity
	 */
	public void removeActivity(Activity activity){
		mActivityList.remove(activity);
	}
	
	/*
	 *@parm:�Ƴ�ָ�����Activity 
	 */
	public void removeActivity(Class className){
		
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
