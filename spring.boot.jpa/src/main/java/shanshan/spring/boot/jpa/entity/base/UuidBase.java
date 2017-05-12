package shanshan.spring.boot.jpa.entity.base;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * 数据库主键
 * @author zss
 * @date 2017年4月20日
 */
@MappedSuperclass  //@MappedSuperclass 用在父类上面。如果改成@Entity，则继承后，多个类继承，只会生成一个表，而不是多个继承，生成多个表
public abstract class UuidBase extends EntityBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5923852121927680199L;

	@Id
	@GeneratedValue(generator = "uuidGenerator")
	@GenericGenerator(name = "uuidGenerator", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name="ID",nullable = false,length = 36)
	private String id;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="TIME_CREATE",nullable = false)
	private Date timeCreated;
	
	//初始化创建时间
	@PrePersist
    private void initCreateTime() {
    	if(this.timeCreated==null){
    		this.timeCreated = new Date();
    	}
    }
	
	protected UuidBase() {
	}
	
	public UuidBase(String id, Date timeCreated){
		this.id = id;
		this.timeCreated = timeCreated;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getTimeCreate() {
		return timeCreated;
	}

	public void setTimeCreate(Date createTime) {
		this.timeCreated = createTime;
	}	
	
}
