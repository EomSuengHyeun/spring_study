package com.cms.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

public class UploadFileUtils {
	
	//upload file name
	public static String uploadFile(String sourcePath,String uploadPath, 
								    String originalName)
								    		throws Exception{
		

		UUID uid=UUID.randomUUID();
		String saveName=uid.toString().replace("-", "")+"_"+originalName;
		String savePath=calcPath(uploadPath);
		
		File source= new File(sourcePath,originalName);		
		File target = new File(uploadPath+savePath,saveName);
		
		int read=0;
		byte[] buf=new byte[1024];
		
		FileInputStream fin=new FileInputStream(source);
		FileOutputStream fout=new FileOutputStream(target);
		read=0;
		while((read=fin.read(buf,0,buf.length))!=-1){
			fout.write(buf, 0, read);
		}
		fin.close();
		fout.close();
		
		String uploadFileName=uploadPath+savePath+File.separator+saveName;
		
		return uploadFileName;
	}
	
	//daily dir 생성
	public static void makeDir(String uploadPath, String... paths){
		if(new File(paths[paths.length-1]).exists()){
			return;
		}
		for(String path:paths){
			File dirPath=new File(uploadPath+path);
			if(!dirPath.exists()){
				dirPath.mkdirs();
			}
		}
	}
	
	//upload folder 지정
	public static String calcPath(String uploadPath)throws Exception{
		
		Calendar cal=Calendar.getInstance();
		
		String yearPath=File.separator+cal.get(Calendar.YEAR);
		String monthPath=yearPath+File.separator+
				new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);
		String datePath=monthPath+File.separator+
				new DecimalFormat("00").format(cal.get(Calendar.DATE));
		
		makeDir(uploadPath,yearPath,monthPath,datePath);
		
		return datePath;				
	}
	
	
	
}

