package com.hxqh.abb.common.weixin;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.weixin.sdk.api.ApiConfig;


@Before({ApiInterceptor.class})
public abstract class ApiController extends Controller
{
  public abstract ApiConfig getApiConfig();
}

