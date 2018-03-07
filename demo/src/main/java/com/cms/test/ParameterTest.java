package com.cms.test;

import com.cms.utils.UploadFileUtils;

public class ParameterTest {

	public static void main(String[] args) {
		try {
			UploadFileUtils.calcPath("d:\\upload");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public static void printStr(String... strings){
		for(String str:strings){
			System.out.print(str+"/");
		}
	}

}
