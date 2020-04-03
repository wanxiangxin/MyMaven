package com.wxx;

import com.wxx.push.IPushListener;
import com.wxx.push.WeChatPush;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        testPush();
    }

    private static void testPush() {
        WeChatPush.pushText("试试看", new IPushListener() {
            @Override
            public void onSuccess() {
                System.out.println("推送成功");
            }

            @Override
            public void onFail(String message) {
                System.out.println("推送失败：" + message);
            }
        });
    }
}
