package side_project;

public class TeamMateVO {
	
	private String name; //변수명/메소드명은 항상 소문자!
	private String gender;
	private int age;
	private int height;
	private String position;
	private int backNo;
	private String teamName;
	private int cid;
	
	public TeamMateVO() {
		
	}

	public TeamMateVO(String name, String gender, int age, int height, String position, int backNo, String teamName,
			int cid) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.height = height;
		this.position = position;
		this.backNo = backNo;
		this.teamName = teamName;
		this.cid = cid;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getBackNo() {
		return backNo;
	}

	public void setBackNo(int backNo) {
		this.backNo = backNo;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@Override
	public String toString() {
		return "TeamMateVO [name=" + name + ", gender=" + gender + ", age=" + age + ", height=" + height + ", position="
				+ position + ", backNo=" + backNo + ", teamName=" + teamName + ", cid=" + cid + "]";
	}
	
	
	

}
