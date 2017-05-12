package shanshan.spring.boot.common.model;

import java.util.Date;

import shanshan.spring.boot.common.model.base.BaseModelObject;


public class UserModel extends BaseModelObject{
	
	private String id;
	
	private String name;
	
	private String mobile;
	
	private Date timeCreated;
	
	public UserModel(){
		
	}
	
	public UserModel(String id, String name, String mobile, Date timeCreated){
		this.id = id;
		this.name = name;
		this.mobile = mobile;
		this.timeCreated = timeCreated;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getTimeCreated() {
		return timeCreated;
	}

	public void setTimeCreated(Date timeCreated) {
		this.timeCreated = timeCreated;
	}	
		
}
