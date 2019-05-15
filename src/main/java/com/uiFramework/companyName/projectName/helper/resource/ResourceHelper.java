package com.uiFramework.companyName.projectName.helper.resource;

public class ResourceHelper {
	public static String getResourcePath(String path)
	{
		String basepath = System.getProperty("user.dir");
		System.out.println("basepath " + basepath);
		System.out.println(basepath + path);
		return basepath + path;
	}
	
	/*public static void main(String[] args) {
		String path = ResourceHelper.getResourcePath("\\src\\main\\resources\\configfile\\log4j.properties");
		System.out.println(path);
	}*/

}
