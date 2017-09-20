package com.zhiyou100.ssh.video.util;

import java.io.File;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;

public class PicSubUtil {
	//图片存储路径
	private static final String BASE_PICTURE_FILE_PATH = "D:\\upload";
	//浏览器获取图片路径
	private static final String BASE_PICTURE_URL_PATH = "/pic/";
	//通过图片原始名称生成名称
	private static String getPictureName(String originalFilename){
		 String str = UUID.randomUUID().toString().replaceAll("-", "");
		 String ext = FilenameUtils.getExtension(originalFilename);
		 String fileName = str+"."+ext;
		 return fileName;
	}
	//通过图片原始名称生成路径
	public static File getPictureFile(String pictureUrl){
		String [] st = pictureUrl.split("/");
		return new File(BASE_PICTURE_FILE_PATH+"\\"+st[2]);	 
	}
	
	//通过原始名称生成url路径
	public static String getPictureUrl(String originalFilename){
		return BASE_PICTURE_URL_PATH+getPictureName(originalFilename);
	}
	
	

}
