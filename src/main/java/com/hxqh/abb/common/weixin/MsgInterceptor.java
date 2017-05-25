package com.hxqh.abb.common.weixin;

import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;
import com.jfinal.weixin.sdk.kit.SignatureCheckKit;

import com.jfinal.weixin.sdk.api.ApiConfigKit;

public class MsgInterceptor
  implements Interceptor
{
  private static final Log log = Log.getLog(MsgInterceptor.class);

  public void intercept(Invocation inv) {
    Controller controller = inv.getController();
    if (!(controller instanceof MsgController)) {
      throw new RuntimeException("控制器需要继承 MsgController");
    }
    try
    {
      ApiConfigKit.setThreadLocalApiConfig(((MsgController)controller).getApiConfig());

      if (isConfigServerRequest(controller)) {
        configServer(controller);
      }
      else if (ApiConfigKit.isDevMode()) {
        inv.invoke();
      }
      else if (checkSignature(controller)) {
        inv.invoke();
      }
      else {
        controller.renderText("签名验证失败，请确定是微信服务器在发送消息过来");
      }

    }
    finally
    {
      ApiConfigKit.removeThreadLocalApiConfig();
    }
  }

  private boolean checkSignature(Controller controller)
  {
    String signature = controller.getPara("signature");
    String timestamp = controller.getPara("timestamp");
    String nonce = controller.getPara("nonce");
    if ((StrKit.isBlank(signature)) || (StrKit.isBlank(timestamp)) || (StrKit.isBlank(nonce))) {
      controller.renderText("check signature failure");
      return false;
    }

    if (SignatureCheckKit.me.checkSignature(signature, timestamp, nonce)) {
      return true;
    }

    log.error("check signature failure:  signature = " + controller.getPara("signature") + " timestamp = " + controller.getPara("timestamp") + " nonce = " + controller.getPara("nonce"));

    return false;
  }

  private boolean isConfigServerRequest(Controller controller)
  {
    return StrKit.notBlank(controller.getPara("echostr"));
  }

  public void configServer(Controller c)
  {
    String echostr = c.getPara("echostr");
    String signature = c.getPara("signature");
    String timestamp = c.getPara("timestamp");
    String nonce = c.getPara("nonce");
    boolean isOk = SignatureCheckKit.me.checkSignature(signature, timestamp, nonce);
    if (isOk)
      c.renderText(echostr);
    else
      log.error("验证失败：configServer");
  }
}

