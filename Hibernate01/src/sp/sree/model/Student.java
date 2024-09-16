package sp.sree.model;


//code should provide the flexibility of migration from one ORM to another ORM
//so, if we use javax.persistence.* annotations, it means it is from SUNMS API
//our ORM tool vendors will implement from this API , so the migration will be done and sopports WODA/WORA
//so, don't use the annotation given by specific ORM tool (org.hibernate.annotations.Entity)
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

//Entity Class
//Mapping -> annotations

@Entity //marking the class as an Entity for Mapping
@Table(name="student") //Mapping this Entity to the table
public class Student
{
	@Id //primary key
	@Column(name="stdId")
	private Integer sid;
	
	@Column(name="stdName", length=20) //for String type data, we need to mention length for VARCHAR datatype in sql
	private String sname;
	
	@Column(name="stdAge")
	private Integer sage;
	
	@Column(name="stdCity", length=30)
	private String scity;
	
	
	//this constructor internally used by the hibernaate
	public Student() 
	{
		System.out.println("Student() called by Hibernate");
	}

	
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}

	public Integer getSage() {
		return sage;
	}
	public void setSage(Integer sage) {
		this.sage = sage;
	}

	public String getScity() {
		return scity;
	}
	public void setScity(String scity) {
		this.scity = scity;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", sage=" + sage + ", scity=" + scity + "]";
	}
}
