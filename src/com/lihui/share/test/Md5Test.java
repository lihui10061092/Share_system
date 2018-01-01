package com.lihui.share.test;

import org.junit.Test;

import com.lihui.share.util.MyMD5Util;

public class Md5Test
{
	@SuppressWarnings("static-access")
	@Test
	public void testMd5()
	{
		MyMD5Util md5 = new MyMD5Util();
		String pwd = "admin";
		System.out.println(MyMD5Util.getMD5(pwd));
		System.out.println(md5.MD5(pwd));
	}
}
