package com.tvd12.ezyfoxserver.testing.function;

import org.testng.annotations.Test;

import com.tvd12.ezyfoxserver.function.EzyCastIntToByte;
import com.tvd12.test.base.BaseTest;

public class EzyCastIntToByteTest extends BaseTest {

	@Test
	public void test() {
		EzyCastIntToByte cast = new EzyCastIntToByte() {};
		assert cast.cast(100) == (byte)100;
		assert cast.cast(100L) == (byte)100;
	}
	
}
