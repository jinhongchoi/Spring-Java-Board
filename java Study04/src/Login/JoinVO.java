package Login;

public class JoinVO {
	
	private String id;
	private String pw;
	private String name;
	private String gender;
	private String age;	
	
	public JoinVO() {}

	public JoinVO(String id, String pw, String name, String gender, String age) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "JoinVO [id=" + id + ", pw=" + pw + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
	

}