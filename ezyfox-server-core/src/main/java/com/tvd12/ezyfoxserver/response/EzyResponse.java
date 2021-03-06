package com.tvd12.ezyfoxserver.response;

import java.io.Serializable;

import com.tvd12.ezyfoxserver.constant.EzyConstant;
import com.tvd12.ezyfoxserver.io.EzyArraySerializable;
import com.tvd12.ezyfoxserver.util.EzyReleasable;

public interface EzyResponse extends EzyArraySerializable, EzyReleasable, Serializable {

	EzyConstant getCommand();
	
}
