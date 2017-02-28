package com.bloghub.test.file;
import java.io.File;

import junit.framework.TestCase;

import org.junit.Assert;
import org.junit.Test;


public class TestFilePath extends TestCase {

	public void testCurrentPath(){
		System.out.println(System.getProperty("user.dir"));
	}
	
	@Test
	public void testFileSeparator(){
//		System.out.println(File.separator);
		String packageName = "com.bloghub.web.entity";
		packageName = packageName.replaceAll("[\\.]", "\\"+File.separator);
//		System.out.println(packageName);
		Assert.assertEquals("com\\bloghub\\web\\entity", packageName);
	}
	
}
