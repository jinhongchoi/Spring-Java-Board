package side_project;

import java.util.ArrayList;

public interface TeamInfoDAO {
	
	public abstract int insert(TeamInfoVO vo);
	
	public abstract ArrayList<TeamInfoVO>select(String id);
	
	public abstract TeamInfoVO select(int contactId, String id);
	
	public abstract int update(TeamInfoVO vo);
	
	public abstract int delete(String teamName, String id);
	

}
