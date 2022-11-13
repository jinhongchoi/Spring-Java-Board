package edu.web.Member;

import java.util.ArrayList;

public interface MemberDAO {
	
	public abstract int insert(MemberVO vo);
	
	public abstract int userCheck(MemberVO vo);
	
	public abstract ArrayList<MemberVO>selectAll();
	
	public abstract MemberVO select(String userid);
	
	public abstract int update(MemberVO vo);
	
	public abstract int delete(String userid);
	
}//end MemberDAO
