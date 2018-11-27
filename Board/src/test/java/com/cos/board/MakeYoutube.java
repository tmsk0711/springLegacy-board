package com.cos.board;

import org.junit.Test;

public class MakeYoutube {
	final String URL1 = "https://www.youtube.com/watch?v=nM0xDI5R50E";
	final String URL2 = "https://www.youtube.bt/nM0xDI5R50E";
	String myParse = "https://www.youtube.com/embed/";
	
	@Test
	public void youtubeTest(){
		
		if(URL2.contains("=")){
			System.out.println("=을 가지고있습니다.");
		}else{
			System.out.println("=을 가지고있지 않습니다.");
		}
//		String parsing = URL2;
//		String myparsing = parsing.replaceAll("https://", "com/");
//		System.out.println(myparsing);
//		
//		myParse = myParse + URL1;
//		if(URL1.lastIndexOf(URL, fromIndex))
		String parsing = URL2;
		String result = parsing.substring(parsing.lastIndexOf("/")+1);
		System.out.println(result);
		String parsing1 = myParse + result;
		System.out.println(parsing1);
		System.out.println("테스트중");
	
	
	
	}
	
}
