package com.bloghub.velocity.generator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class BaseContext {

	private final String rootPath = System.getProperty("user.dir")+"/src/main";
	private final String extName = ".java";
	//Velocity引擎
	private VelocityEngine ve;
	//Velocity上下文
	private VelocityContext ctx;
	//包路径
	private String packageName;
	//类名
	private String className;
	//模版文件
	private String vmFileName;
	//模版标识
	private String vmFlag;
	
	/**
	 * 
	 * @param packageName 包路径，例如com.bloghub.web.entity
	 * @param className 类名，例如User
	 * @param vmFlag 模版标识, 例如Dao, DaoImpl, Entity等
	 */
	public void init(String packageName, String className, String vmFlag){
		ve = new VelocityEngine();
		ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		ve.setProperty("classpath.resource.loader.class",
				ClasspathResourceLoader.class.getName());

        Properties prop = new Properties();
        prop.setProperty(Velocity.ENCODING_DEFAULT, "UTF8");
        prop.setProperty(Velocity.INPUT_ENCODING, "UTF8");
        prop.setProperty(Velocity.OUTPUT_ENCODING, "UTF8");       
		ve.init(prop);

		ctx = new VelocityContext();
		ctx.put("package", packageName);
		ctx.put("UpperClassName", className);
		
		this.packageName = packageName;
		this.className = className;
		this.vmFileName = getVmFileName(vmFlag);
		this.vmFlag = vmFlag;
	}
	
	/**
	 * 增加上下文参数
	 * @param key
	 * @param value
	 */
	public void addParam(String key, Object value){
		ctx.put(key, value);
	}
	
	/**
	 * 生成目标文件
	 */
	public void merge(){
		String path = getFilePath()+"/"+targetFileName();
		Template t = ve.getTemplate(vmFileName);
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(path);
			t.merge(ctx, writer);
			writer.flush();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
	
	private String getVmFileName(String vmName){
		return vmName + ".vm";
	}
	
	private String getFilePath(){
		String path = rootPath + "/java/"+packageName.replaceAll("[\\.]", "/");
		File file = new File(path);
		if(!file.exists()){
			file.mkdirs();
		}
		return path;
	}
	
	private String targetFileName(){
		if(vmFlag.equals("Entity")){
			return className + extName;
		}
		else{
			return className + vmFlag + extName;
		}
	}
	
}
