package shanshan.spring.boot.interview.algorithm.task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TaskSequence3 {
	
	public class Task{
		int r;
		int o;
		int b;
		
		public Task(int r, int o){
			this.r = r;
			this.o = o;
			this.b = r-o;
		}
		
		public int getR(){
			return this.r;
		}
		
		public int getB(){
			return this.b;
		}
	}
	
	private static List<Task> taskSort(List<Task> activities){
		//排序
		Collections.sort(activities, new Comparator() {
            @Override
			public int compare(Object o1, Object o2) {
            	Task a1 = (Task)o1;
            	Task a2 = (Task)o2;
            	return a2.getB() - a1.getB();
			}
        });
		return activities;
	}
	
	private static long getSum(List<Task> taskList) {
		long sum = taskList.get(0).getR();
		int dvalue = taskList.get(0).getR();
		for(Task task:taskList){
			if(dvalue < task.getR()){
				sum += task.getR() - dvalue;
				dvalue = task.getR();
			}
			dvalue = dvalue - task.getR() + task.getB();
		}
		return sum;
	}

	
	public static void main(String[] args){
		int n = 0; //n个任务

		TaskSequence3 t3 = new TaskSequence3();
		List<Task> taskList = new ArrayList<>();
		try{
			Scanner sc =new Scanner(System.in);
			n = sc.nextInt();
			for(int i=0; i<n; i++){
				taskList.add(t3.new Task(sc.nextInt(),sc.nextInt()));
			}
		}catch(Exception e){
			System.out.println("输入异常");
		}		
		
		taskSort(taskList);
		
		System.out.println(getSum(taskList));
	}

}
