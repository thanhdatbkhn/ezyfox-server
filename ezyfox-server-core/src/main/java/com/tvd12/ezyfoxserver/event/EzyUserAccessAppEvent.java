package com.tvd12.ezyfoxserver.event;

import com.tvd12.ezyfoxserver.entity.EzyData;

public interface EzyUserAccessAppEvent extends EzyUserEvent {

	EzyData getOutput();
	
	void setOutput(EzyData output);
	
}
