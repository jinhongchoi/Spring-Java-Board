package edu.web.MemberPr;

public interface MemberDAO {
	public abstract int insert(MemberVO vo);
	
	public abstract int Login(String userid, String password);
	
	public abstract MemberVO select(String userid);
	
	public abstract int update(MemberVO vo);
	
	public abstract int delete(String userid);
}
