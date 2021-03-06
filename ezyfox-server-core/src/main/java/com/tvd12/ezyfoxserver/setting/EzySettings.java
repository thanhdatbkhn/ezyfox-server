package com.tvd12.ezyfoxserver.setting;

import java.util.Set;

public interface EzySettings {

    int getMaxUsers();
    
    int getMaxSessions();
    
    int getWorkerPoolSize();
    
    EzyHttpSetting getHttp();
    
    EzySocketSetting getSocket();
    
    EzyWebSocketSetting getWebsocket();
    
    EzyAdminsSetting getAdmins();
    
    EzyLoggerSetting getLogger();
    
    EzyUserManagementSetting getUserManagement();
    
    EzySessionManagementSetting getSessionManagement();
    
    EzyPluginsSetting getPlugins();
    
    EzyAppsSetting getApplications();
    
    Set<Integer> getAppIds();
    
    Set<String> getAppNames();
    
    EzyAppSetting getAppById(Integer id);
    
    EzyAppSetting getAppByName(String name);
    
    Set<Integer> getPluginIds();
    
    Set<String> getPluginNames();
    
    EzyPluginSetting getPluginById(Integer id);
    
    EzyPluginSetting getPluginByName(String name);
    
}
