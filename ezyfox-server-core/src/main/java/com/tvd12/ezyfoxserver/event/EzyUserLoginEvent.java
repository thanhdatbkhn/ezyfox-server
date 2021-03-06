package com.tvd12.ezyfoxserver.event;

import com.tvd12.ezyfoxserver.entity.EzyData;

public interface EzyUserLoginEvent extends EzySessionEvent {

	EzyData getOutput();
	
	String getUsername();
	
	String getPassword();
	
	EzyData getData();

	void setOutput(EzyData output);
	
	void setUsername(String username);
	
	void setPassword(String password);
	
}
