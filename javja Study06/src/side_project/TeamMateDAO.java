package side_project;

import java.util.ArrayList;

public interface TeamMateDAO {
	
	public abstract int insert(TeamMateVO vo);
	
	public abstract ArrayList<TeamInfoVO>selectAll();
	
	public abstract int delete(int cid);

}
