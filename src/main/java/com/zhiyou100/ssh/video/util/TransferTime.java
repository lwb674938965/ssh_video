package com.zhiyou100.ssh.video.util;


public class TransferTime {
	

	public static String transfer(Integer time){
		String str1 = null;
		String str2 = null;
		String str3 = null;
		String str = null;
		int a = time/3600;
		if(a<10){
			str1=0+""+a;
		}else{
			str1=""+a;
		}
		int b = time%3600/60;
		if(b<10){
			str2 = 0+""+b;
		}
		else{
			str2=""+b;
		}
		int c = time%60;
		if(c<10){
			str3 = 0+""+c;
		}
		else{
			str3=""+c;
		}
		
		str = str1+":"+str2+":"+str3;
		return str;
	}

}
