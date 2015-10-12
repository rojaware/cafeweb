package com.rojaware.members;

import java.util.Enumeration;
import java.util.Vector;

public class TextWrapper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "this is a long line of \n\n\n            text that needs to be wrapped";
		String s = wrapText(text);
		    System.out.println(s);
		     s = "글쎄요. 공인성적이 딱히 필요한 적이 없었습니다. 이민을 고민한 후로 IELTS를 준비하기 시작했습니다. 여기서 6.5점을 받고 칼리지 본과에 등록할 생각입니다. 영국문화원의 Advenced 과정과 한국";
			
		     System.out.println(s.length());
	}

	public static String  wrapText (String text)
	{
       
        String adjusted = text.replaceAll("(?m)^[ \t]*\r?\n", "");
		return adjusted;
	}
	
	
}
