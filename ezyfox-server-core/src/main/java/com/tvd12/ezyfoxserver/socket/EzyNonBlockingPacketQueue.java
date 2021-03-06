package com.tvd12.ezyfoxserver.socket;

import java.util.LinkedList;
import java.util.Queue;

import com.tvd12.ezyfoxserver.util.EzyLoggable;

public class EzyNonBlockingPacketQueue extends EzyLoggable implements EzyPacketQueue {

	private final int capacity;
	private final Queue<EzyPacket> queue ;
	
	public EzyNonBlockingPacketQueue() {
		this(128);
	}
	
	public EzyNonBlockingPacketQueue(int capacity) {
		this.capacity = capacity;
		this.queue = new LinkedList<>();
	}
	
	@Override
	public int size() {
	    return queue.size();
	}
	
	@Override
	public void clear() {
	    queue.clear();
	}
	
	
	@Override
	public EzyPacket take() {
	    EzyPacket packet = queue.poll();
	    return packet;
	}
	
	@Override
	public EzyPacket peek() {
	    EzyPacket packet = queue.peek();
	    return packet;
	}
	
	@Override
	public boolean isFull() {
	    return queue.size() >= capacity;
	}
	
	@Override
	public boolean isEmpty() {
	    return queue.isEmpty();
	}
	
	@Override
	public boolean add(EzyPacket packet) {
	    if(isFull()) 
	        return false;
	    boolean answer = queue.offer(packet);
	    return answer;
	}
	
}
