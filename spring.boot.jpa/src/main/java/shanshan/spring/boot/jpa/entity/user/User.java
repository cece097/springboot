package shanshan.spring.boot.jpa.entity.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import shanshan.spring.boot.jpa.entity.base.UuidBase;


/**
 * 用户信息
 * @author zss
 * @date 2017年4月20日
 */
@Entity
@Table(name="TEST_USER")
public class User extends UuidBase{
	
	@Column(name="NAME",nullable = false)
	private String name;
	
	@Column(name="MOBILE",nullable = false)
	private String mobile;
	
	/**
	 * 空构建函数，不建议使用
	 */
	protected User() {
	}
	
	public User(String name, String mobile){
		this.name = name;
		this.mobile = mobile;
	}
	
	public User(String id, String name, String mobile, Date timeCreate){
		super(id,timeCreate);
		this.name = name;
		this.mobile = mobile;
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
	
}
