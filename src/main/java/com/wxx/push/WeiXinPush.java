package com.wxx.push;

import com.zjiecode.wxpusher.client.WxPusher;
import com.zjiecode.wxpusher.client.bean.Message;
import com.zjiecode.wxpusher.client.bean.MessageResult;
import com.zjiecode.wxpusher.client.bean.Result;

import java.util.List;

/**
 * 通过api推送到微信
 */
public class WeiXinPush {

    private static final String WX_TOKEN = "AT_F8mCMtagZEV4xnJ2rVyXHyuQtL0LPMKb";
    private static final String WX_UID = "UID_3AtCsJnWcrpF3yZcyoTw2OmzyVzx";

    /**
     * 推送一段文本到微信
     * @param text 文本内容
     * @param url  点击之后跳转的链接
     * @param listener  监听推送回调
     */
    public static void pushText(String text, String url, IPushListener listener) {
        push(text, url, PushType.TEXT, listener);
    }
    public static void pushText(String text, IPushListener listener) {
        push(text, null, PushType.TEXT, listener);
    }
    public static void pushText(String text) {
        push(text, null, PushType.TEXT, null);
    }

    /**
     * 推送一段html到微信
     * @param html          html内容
     * @param listener      监听推送回调
     */
    public static void pushHtml(String html, IPushListener listener) {
        push(html, null, PushType.HTML, listener);
    }


    private static void push(String text, String url, PushType pushType, IPushListener listener) {
        if (text == null || text.isEmpty()) {
            if (listener != null) {
                listener.onFail("发送的文本不能为空");
            }
            return;
        }

        Message message = new Message();

        message.setAppToken(WX_TOKEN);
        int mPushType = Message.CONTENT_TYPE_TEXT;
        if (pushType == PushType.HTML) {
            mPushType = Message.CONTENT_TYPE_HTML;
        } else if (pushType == PushType.MARKDOWN) {
            mPushType = Message.CONTENT_TYPE_MD;
        }
        message.setContentType(mPushType);

        message.setContent(text);
        message.setUid(WX_UID);

        message.setUrl(url);

        Result<List<MessageResult>> result = WxPusher.send(message);

        if (result.isSuccess()) {
            // 成功
            if (listener != null) {
                listener.onSuccess();
            }
        } else {
            // 失败
            String errorInfo = result.getMsg();
            if (listener != null) {
                listener.onFail(errorInfo);
            }
        }
    }
}
