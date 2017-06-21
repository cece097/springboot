package shanshan.spring.boot.interview.algorithm.activity;

public class Activity {
	int startTime;
	int endTime;
	public Activity(int start, int end){
		this.startTime = start;
		this.endTime = end;
	}
	
	public int getStartTime(){
		return this.startTime;
	}
	
	public int getEndTime(){
		return this.endTime;
	}
}
