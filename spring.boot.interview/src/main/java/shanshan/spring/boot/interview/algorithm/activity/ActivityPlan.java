package shanshan.spring.boot.interview.algorithm.activity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import shanshan.spring.boot.interview.algorithm.activity.Activity;

/**
 * 活动安排
 * 	有若干个活动，第i个开始时间和结束时间是[Si,fi)，只有一个教室，活动之间不能交叠，求最多安排多少个活动？
 * @author zss
 * @date 2017年6月20日
 */
public class ActivityPlan {
	
	/**
	 * 对活动进行排序，按结束时间进行排序
	 * @param activities
	 * @return
	 */
	public static List<Activity> activitySort(List<Activity> activities){
		//排序
		Collections.sort(activities, new Comparator() {
            @Override
			public int compare(Object o1, Object o2) {
            	Activity a1 = (Activity)o1;
            	Activity a2 = (Activity)o2;
            	return a1.getEndTime() - a2.getEndTime();
			}
        });
		return activities;
	}
	
	public static void main(String[] args){
		int n = 0;
		List<Activity> activities = null;
		
		//输入
		try{
			Scanner in=new Scanner(System.in);
			String str=in.nextLine().trim();
			
			n = Integer.valueOf(str);
			activities = new ArrayList<>(n);
			for(int i=0; i<n; i++){
				str=in.nextLine().trim();
				String[] inStr = str.split(" ");
				activities.add(new Activity(Integer.parseInt(inStr[0]), Integer.parseInt(inStr[1])));
			}
			
		}catch(Exception e){
			System.out.println("输入异常");
		}
		
		//排序
		if(activities != null){
			activitySort(activities);
		}
		
		//统计可安排的数量
		int sum = 1;
		int end = activities.get(0).getEndTime();
		for(int i=1; i<n; i++){
			if(activities.get(i).getStartTime() >= end){
				sum += 1;
				end = activities.get(i).getEndTime();
			}
		}
		System.out.println(sum);
	}
}
