package main01;

public class CharacterMain {

//	char: 문자 하나를 저장하는 데이터 타입, 2바이트
//	-문자의 유니코드 값(0또는 양의 정수)를 저장하는 타입
//  -0~62535 
//	-문자 (character)는 작은 따옴표('')를 사용
//	-'한''글''': 문자(character) 리터럴
//	-"한글","한국","한","": 문자열(string) 리터럴
	
	public static void main(String[] args) {
    System.out.println("문자(char) 자료형");
		
    char ch1='A';
    		System.out.println("ch1="+ch1);
    		
    char ch2=65;
    		System.out.println("ch2="+ch2);    		
    
    char ch3='1';
    		System.out.println("ch3="+ch3);    		
    
    char ch4=1;
    		System.out.println("ch4="+ch4);    		
    
    char ch5='\n';
    		System.out.println("ch5="+ch5);    		
            System.out.println("다음 줄");
            
    boolean b= '가'< '나';
    System.out.println("b="+b);
    
    System.out.println("문자열(string) 자료형");
    String str="안녕하세요";
    System.out.println("str="+str);
	}// end Main

}//end CharacterMain
