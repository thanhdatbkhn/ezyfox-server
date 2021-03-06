package com.tvd12.ezyfoxserver.sercurity;

import org.apache.commons.codec.binary.Base64;

import com.tvd12.ezyfoxserver.io.EzyStrings;

public final class EzyBase64 {

	private EzyBase64() {
	}
	
	public static byte[] encode(byte[] input) {
		return Base64.encodeBase64(input);
	}
	
	public static byte[] decode(byte[] input) {
		return Base64.decodeBase64(input);
	}
	
	public static byte[] decode(String input) {
		return Base64.decodeBase64(input);
	}
	
	public static byte[] encode(String input) {
		return Base64.encodeBase64(EzyStrings.getUtfBytes(input));
	}
	
	public static String encodeUtf(String input) {
		return Base64.encodeBase64String(EzyStrings.getUtfBytes(input));
	}
	
	public static String decodeUtf(String input) {
		return EzyStrings.newUtf(Base64.decodeBase64(input));
	}
	
	public static String encode2utf(byte[] input) {
		return EzyStrings.newUtf(encode(input));
	}
	
	public static String decode2utf(byte[] input) {
		return EzyStrings.newUtf(decode(input));
	}
	
}
