package com.tvd12.ezyfoxserver.request;

import com.tvd12.ezyfoxserver.entity.EzyArray;

import lombok.Getter;

@Getter
public class EzySimpleRequestPluginParams 
        extends EzySimpleRequestParams
        implements EzyRequestPluginParams {
    private static final long serialVersionUID = 1875560863565659154L;
    
    protected String pluginName;
    protected EzyArray data;
    
    @Override
    public void deserialize(EzyArray t) {
        this.pluginName = t.get(0, String.class);
        this.data = t.get(1, EzyArray.class);
    }
    
    @Override
    public void release() {
        super.release();
        this.data = null;
    }
    
}
