package com.paytm.JavaUtils;

import java.util.Random;

import freemarker.core.ReturnInstruction.Return;

public class JavaUtils {

	
	public int RandomNo(int num)
	{
		Random no = new Random();
		int count=no.nextInt(num);
		return count;
	}
}
