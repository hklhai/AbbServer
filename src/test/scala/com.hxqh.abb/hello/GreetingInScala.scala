package com.hxqh.abb.hello

import com.hxqh.abb.interscala.GreetingInJava

/**
  * Created by Ocean lin on 2017/8/2.
  */

class GreetingInScala {
  def greet: String = {
    val delegate: GreetingInJava = new GreetingInJava
    delegate.greet
  }
}