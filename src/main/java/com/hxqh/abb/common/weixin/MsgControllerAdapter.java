package com.hxqh.abb.common.weixin;

import com.jfinal.weixin.sdk.msg.in.InImageMsg;
import com.jfinal.weixin.sdk.msg.in.InLinkMsg;
import com.jfinal.weixin.sdk.msg.in.InLocationMsg;
import com.jfinal.weixin.sdk.msg.in.InShortVideoMsg;
import com.jfinal.weixin.sdk.msg.in.InTextMsg;
import com.jfinal.weixin.sdk.msg.in.InVideoMsg;
import com.jfinal.weixin.sdk.msg.in.InVoiceMsg;
import com.jfinal.weixin.sdk.msg.in.event.InCustomEvent;
import com.jfinal.weixin.sdk.msg.in.event.InFollowEvent;
import com.jfinal.weixin.sdk.msg.in.event.InLocationEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMassEvent;
import com.jfinal.weixin.sdk.msg.in.event.InMenuEvent;
import com.jfinal.weixin.sdk.msg.in.event.InPoiCheckNotifyEvent;
import com.jfinal.weixin.sdk.msg.in.event.InQrCodeEvent;
import com.jfinal.weixin.sdk.msg.in.event.InShakearoundUserShakeEvent;
import com.jfinal.weixin.sdk.msg.in.event.InTemplateMsgEvent;
import com.jfinal.weixin.sdk.msg.in.event.InVerifyFailEvent;
import com.jfinal.weixin.sdk.msg.in.event.InVerifySuccessEvent;
import com.jfinal.weixin.sdk.msg.in.event.InWifiEvent;
import com.jfinal.weixin.sdk.msg.in.speech_recognition.InSpeechRecognitionResults;

public abstract class MsgControllerAdapter extends MsgController
{
  protected abstract void processInFollowEvent(InFollowEvent paramInFollowEvent);

  protected abstract void processInTextMsg(InTextMsg paramInTextMsg);

  protected abstract void processInMenuEvent(InMenuEvent paramInMenuEvent);

  protected void processInImageMsg(InImageMsg inImageMsg)
  {
  }

  protected void processInVoiceMsg(InVoiceMsg inVoiceMsg)
  {
  }

  protected void processInVideoMsg(InVideoMsg inVideoMsg)
  {
  }

  protected void processInLocationMsg(InLocationMsg inLocationMsg)
  {
  }

  protected void processInLinkMsg(InLinkMsg inLinkMsg)
  {
  }

  protected void processInQrCodeEvent(InQrCodeEvent inQrCodeEvent)
  {
  }

  protected void processInLocationEvent(InLocationEvent inLocationEvent)
  {
  }

  protected void processInSpeechRecognitionResults(InSpeechRecognitionResults inSpeechRecognitionResults)
  {
  }

  protected void processInTemplateMsgEvent(InTemplateMsgEvent inTemplateMsgEvent)
  {
  }

  protected void processInMassEvent(InMassEvent inMassEvent)
  {
  }

  protected void processInShortVideoMsg(InShortVideoMsg inShortVideoMsg)
  {
  }

  protected void processInCustomEvent(InCustomEvent inCustomEvent)
  {
  }

  protected void processInShakearoundUserShakeEvent(InShakearoundUserShakeEvent inShakearoundUserShakeEvent)
  {
  }

  protected void processInVerifySuccessEvent(InVerifySuccessEvent inVerifySuccessEvent)
  {
  }

  protected void processInVerifyFailEvent(InVerifyFailEvent inVerifyFailEvent)
  {
  }

  protected void processInPoiCheckNotifyEvent(InPoiCheckNotifyEvent inPoiCheckNotifyEvent)
  {
  }

  protected void processInWifiEvent(InWifiEvent inWifiEvent)
  {
  }
}

