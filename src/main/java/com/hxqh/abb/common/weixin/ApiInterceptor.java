 package com.hxqh.abb.common.weixin;
 
 import com.jfinal.aop.Interceptor;
 import com.jfinal.aop.Invocation;
 import com.jfinal.core.Controller;

import com.jfinal.weixin.sdk.api.ApiConfigKit;

 
 public class ApiInterceptor
   implements Interceptor
 {
   public void intercept(Invocation inv)
   {
     Controller controller = inv.getController();
     if (!(controller instanceof ApiController))
       throw new RuntimeException("控制器需要继承 ApiController");
     try
     {
       ApiConfigKit.setThreadLocalApiConfig(((ApiController)controller).getApiConfig());
       inv.invoke();
     }
     finally {
       ApiConfigKit.removeThreadLocalApiConfig();
     }
   }
 }

