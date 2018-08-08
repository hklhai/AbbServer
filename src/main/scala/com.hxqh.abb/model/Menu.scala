package com.hxqh.abb.model

import scala.beans.BeanProperty

/**
  * Created by Ocean lin on 2017/12/7.
  */
class Menu(@BeanProperty val modelname: String,
           @BeanProperty val appname: String,
           @BeanProperty val appchinesename: String,
           @BeanProperty val appurl: String) {
}
