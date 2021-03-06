package com.tvd12.ezyfoxserver.command.impl;

import static com.tvd12.ezyfoxserver.context.EzyPluginContexts.handleException;

import com.tvd12.ezyfoxserver.command.EzyFireEvent;
import com.tvd12.ezyfoxserver.constant.EzyConstant;
import com.tvd12.ezyfoxserver.context.EzyPluginContext;
import com.tvd12.ezyfoxserver.controller.EzyEventController;
import com.tvd12.ezyfoxserver.event.EzyEvent;
import com.tvd12.ezyfoxserver.setting.EzyPluginSetting;
import com.tvd12.ezyfoxserver.wrapper.EzyEventControllers;

@SuppressWarnings({ "unchecked", "rawtypes" })
public class EzyPluginFireEventImpl 
		extends EzyAbstractCommand 
		implements EzyFireEvent {

	private EzyPluginContext context;
	
	public EzyPluginFireEventImpl(EzyPluginContext context) {
		this.context = context;
	}
	
    @Override
	public void fire(EzyConstant type, EzyEvent event) {
	    EzyEventController ctrl = getEventController(type);
	    getLogger().debug("fire event {}, controller = {}", type, ctrl);
	    fire(ctrl, event);
	}
	
    protected void fire(EzyEventController ctrl, EzyEvent event) {
        if(ctrl != null)
            handle(ctrl, event);
    }
	
	protected void handle(EzyEventController ctrl, EzyEvent event) {
	    try {
	        ctrl.handle(context, event);
	    }
	    catch(Exception e) {
	        handleException(context, Thread.currentThread(), e);
	    }
	}
	
    protected EzyEventController getEventController(EzyConstant type) {
	    return getEventControllers().getController(type);
	}
	
	protected EzyEventControllers getEventControllers() {
		return getPluginSetting().getEventControllers();
	}
	
	protected EzyPluginSetting getPluginSetting() {
		return context.getPlugin().getSetting();
	}
}
