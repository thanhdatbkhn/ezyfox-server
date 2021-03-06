package com.tvd12.ezyfoxserver.io;

import java.nio.ByteBuffer;

public final class EzyBytes {

	private EzyBytes() {
	}
	
	public static byte[] getBytes(ByteBuffer buffer) {
		return EzyByteBuffers.getBytes(buffer);
	}
	
	public static byte[] copy(ByteBuffer buffer, int size) {
		return EzyByteBuffers.getBytes(buffer, size);
	}
	
	public static byte[] getBytes(int first, int value, int size) {
		return getBytes(first, (long)value, size);
	}
	
	public static byte[] getBytes(int first, long value, int size) {
		return getBytes((byte)first, value, size);
	}
	
	public static byte[] getBytes(byte first, long value, int size) {
		return EzyArrays.merge(first, getBytes(value, size));
	}
	
	public static byte[] getBytes(byte first, double value) {
		return EzyArrays.merge(first, getBytes(value));
	}
	
	public static byte[] getBytes(byte first, float value) {
		return EzyArrays.merge(first, getBytes(value));
	}
	
	public static byte[] getBytes(double value) {
		return getBytes(Double.doubleToLongBits(value), 8);
	}
	
	public static byte[] getBytes(float value) {
		return getBytes(Float.floatToIntBits(value), 4);
	}
	
	public static byte[] getBytes(long value) {
		return getBytes(value, 8);
	}
	
	public static byte[] getBytes(int value) {
		return getBytes(value, 4);
	}
	
	public static byte[] getBytes(short value) {
		return getBytes(value, 2);
	}
	
	public static byte[] getBytes(byte first, byte[] value) {
		return EzyArrays.merge(first, value);
	}
	
	public static byte[] copy(byte[][] bytess) {
		int index = 0;
		byte[] answer = new byte[totalBytes(bytess)];
		for(byte[] bytes : bytess) {
			EzyArrays.copy(bytes, answer, index);
			index += bytes.length;
		}
		return answer;
	}
	
	public static int totalBytes(byte[][] bytess) {
		int size = 0;
		for(byte[] bytes : bytess)
			size += bytes.length;
		return size;
	}
	
	public static byte[] getBytes(long value, int size) {
		byte[] bytes = new byte[size];
		for(int i = 0 ; i < size ; i++)
			bytes[i] = (byte)((value >> ((size - i - 1) * 8) & 0xff));
		return bytes;
	}
	
}
