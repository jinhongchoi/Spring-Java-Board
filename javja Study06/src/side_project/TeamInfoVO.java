package side_project;

public class TeamInfoVO {
	
	private String teamName;
	private String sport;
	private String location;
	private String information;
	private String id;
	private int contactId;
	
	public TeamInfoVO () {}

	public TeamInfoVO(String teamName, String sport, String location, String information, String id, int contactId) {
		super();
		this.teamName = teamName;
		this.sport = sport;
		this.location = location;
		this.information = information;
		this.id = id;
		this.contactId = contactId;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getContactId() {
		return contactId;
	}

	public void setContactId(int contactId) {
		this.contactId = contactId;
	}

	@Override
	public String toString() {
		return "TeamInfoVO [teamName=" + teamName + ", sport=" + sport + ", location=" + location + ", information="
				+ information + ", id=" + id + ", contactId=" + contactId + "]";
	}
	
	

}
