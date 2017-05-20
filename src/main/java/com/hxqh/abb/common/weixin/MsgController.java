package com.hxqh.abb.common.weixin;

import com.jfinal.aop.Before;
import com.jfinal.core.Controller;
import com.jfinal.ext.interceptor.NotAction;
import com.jfinal.kit.HttpKit;
import com.jfinal.kit.StrKit;
import com.jfinal.log.Log;
import com.jfinal.weixin.sdk.kit.MsgEncryptKit;
import com.jfinal.weixin.sdk.msg.InMsgParser;
import com.jfinal.weixin.sdk.msg.in.InImageMsg;
import com.jfinal.weixin.sdk.msg.in.InLinkMsg;
import com.jfinal.weixin.sdk.msg.in.InLocationMsg;
import com.jfinal.weixin.sdk.msg.in.InMsg;
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
import com.jfinal.weixin.sdk.msg.out.OutMsg;
import com.jfinal.weixin.sdk.msg.out.OutTextMsg;

import com.jfinal.weixin.sdk.api.ApiConfig;
import com.jfinal.weixin.sdk.api.ApiConfigKit;

public abstract class MsgController extends Controller {
	private static final Log log = Log.getLog(MsgController.class);
	private String inMsgXml = null;
	private InMsg inMsg = null;

	public abstract ApiConfig getApiConfig();

	@Before({ MsgInterceptor.class })
	public void index() {
		if (ApiConfigKit.isDevMode()) {
			System.out.println("接收消息查看  位置cn.edu.ncut.istc.weixin.util.MsgController");
			// System.out.println(getInMsgXml());
		}

		InMsg msg = getInMsg();
		if ((msg instanceof InTextMsg))
			processInTextMsg((InTextMsg) msg);
		else if ((msg instanceof InImageMsg))
			processInImageMsg((InImageMsg) msg);
		else if ((msg instanceof InSpeechRecognitionResults))
			processInSpeechRecognitionResults((InSpeechRecognitionResults) msg);
		else if ((msg instanceof InVoiceMsg))
			processInVoiceMsg((InVoiceMsg) msg);
		else if ((msg instanceof InVideoMsg))
			processInVideoMsg((InVideoMsg) msg);
		else if ((msg instanceof InShortVideoMsg))
			processInShortVideoMsg((InShortVideoMsg) msg);
		else if ((msg instanceof InLocationMsg))
			processInLocationMsg((InLocationMsg) msg);
		else if ((msg instanceof InLinkMsg))
			processInLinkMsg((InLinkMsg) msg);
		else if ((msg instanceof InCustomEvent))
			processInCustomEvent((InCustomEvent) msg);
		else if ((msg instanceof InFollowEvent))
			processInFollowEvent((InFollowEvent) msg);
		else if ((msg instanceof InQrCodeEvent))
			processInQrCodeEvent((InQrCodeEvent) msg);
		else if ((msg instanceof InLocationEvent))
			processInLocationEvent((InLocationEvent) msg);
		else if ((msg instanceof InMassEvent))
			processInMassEvent((InMassEvent) msg);
		else if ((msg instanceof InMenuEvent))
			processInMenuEvent((InMenuEvent) msg);
		else if ((msg instanceof InTemplateMsgEvent))
			processInTemplateMsgEvent((InTemplateMsgEvent) msg);
		else if ((msg instanceof InShakearoundUserShakeEvent))
			processInShakearoundUserShakeEvent((InShakearoundUserShakeEvent) msg);
		else if ((msg instanceof InVerifySuccessEvent))
			processInVerifySuccessEvent((InVerifySuccessEvent) msg);
		else if ((msg instanceof InVerifyFailEvent))
			processInVerifyFailEvent((InVerifyFailEvent) msg);
		else if ((msg instanceof InPoiCheckNotifyEvent))
			processInPoiCheckNotifyEvent((InPoiCheckNotifyEvent) msg);
		else if ((msg instanceof InWifiEvent))
			processInWifiEvent((InWifiEvent) msg);
		else
			log.error("未能识别的消息类型。 消息 xml 内容为：\n" + getInMsgXml());
	}

	public void render(OutMsg outMsg) {
		String outMsgXml = outMsg.toXml();

		if (ApiConfigKit.isDevMode()) {
			System.out.println("发送消息 位置cn.edu.ncut.istc.weixin.util.MsgController");
			// System.out.println(outMsgXml);
			// System.out.println("--------------------------------------------------------------------------------\n");
		}

		if (ApiConfigKit.getApiConfig().isEncryptMessage()) {
			outMsgXml = MsgEncryptKit.encrypt(outMsgXml, getPara("timestamp"), getPara("nonce"));
		}

		renderText(outMsgXml, "text/xml");
	}

	public void renderOutTextMsg(String content) {
		OutTextMsg outMsg = new OutTextMsg(getInMsg());
		outMsg.setContent(content);
		render(outMsg);
	}

	@Before({ NotAction.class })
	public String getInMsgXml() {
		if (this.inMsgXml == null) {
			this.inMsgXml = HttpKit.readData(getRequest());

			if (ApiConfigKit.getApiConfig().isEncryptMessage()) {
				this.inMsgXml = MsgEncryptKit.decrypt(this.inMsgXml, getPara("timestamp"), getPara("nonce"),
						getPara("msg_signature"));
			}
		}
		if (StrKit.isBlank(this.inMsgXml)) {
			throw new RuntimeException("异常信息，请联系管理员");
		}
		return this.inMsgXml;
	}

	@Before({ NotAction.class })
	public InMsg getInMsg() {
		if (this.inMsg == null)
			this.inMsg = InMsgParser.parse(getInMsgXml());
		return this.inMsg;
	}

	protected abstract void processInTextMsg(InTextMsg paramInTextMsg);

	protected abstract void processInImageMsg(InImageMsg paramInImageMsg);

	protected abstract void processInVoiceMsg(InVoiceMsg paramInVoiceMsg);

	protected abstract void processInVideoMsg(InVideoMsg paramInVideoMsg);

	protected abstract void processInShortVideoMsg(InShortVideoMsg paramInShortVideoMsg);

	protected abstract void processInLocationMsg(InLocationMsg paramInLocationMsg);

	protected abstract void processInLinkMsg(InLinkMsg paramInLinkMsg);

	protected abstract void processInCustomEvent(InCustomEvent paramInCustomEvent);

	protected abstract void processInFollowEvent(InFollowEvent paramInFollowEvent);

	protected abstract void processInQrCodeEvent(InQrCodeEvent paramInQrCodeEvent);

	protected abstract void processInLocationEvent(InLocationEvent paramInLocationEvent);

	protected abstract void processInMassEvent(InMassEvent paramInMassEvent);

	protected abstract void processInMenuEvent(InMenuEvent paramInMenuEvent);

	protected abstract void processInSpeechRecognitionResults(
			InSpeechRecognitionResults paramInSpeechRecognitionResults);

	protected abstract void processInTemplateMsgEvent(InTemplateMsgEvent paramInTemplateMsgEvent);

	protected abstract void processInShakearoundUserShakeEvent(
			InShakearoundUserShakeEvent paramInShakearoundUserShakeEvent);

	protected abstract void processInVerifySuccessEvent(InVerifySuccessEvent paramInVerifySuccessEvent);

	protected abstract void processInVerifyFailEvent(InVerifyFailEvent paramInVerifyFailEvent);

	protected abstract void processInPoiCheckNotifyEvent(InPoiCheckNotifyEvent paramInPoiCheckNotifyEvent);

	protected abstract void processInWifiEvent(InWifiEvent paramInWifiEvent);
}
