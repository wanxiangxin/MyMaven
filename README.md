- ### 介绍
    自己的Maven仓库，写一些常用工具类支持自己其他项目直接使用，目前该工具支持发送文本消息到微信


- ### 添加引用

1、在自己项目的  *pom.xml* 中加入一下引用 

```
<repositories>
    <repository>
        <id>wxx-mvn-repo</id>
        <url>https://gitee.com/wanxx/MyMaven/master/repo</url>
    </repository>
</repositories>
```
<br/>

2、在 *dependencies* 中加入以下引用
```
<dependency>
    <groupId>com.wxx</groupId>
    <artifactId>util</artifactId>
    <version>1.0-RELEASE</version>
</dependency>
```

#### 恭喜到这里你就可以使用啦!!!!

- ### 功能使用

1、微信推送

参考微信推送api:[推送文档](http://wxpusher.zjiecode.com/docs/#/)

```
// 推送文本信息到微信
WeChatPush.pushText("我是通过api过来的", new IPushListener() {
    @Override
    public void onSuccess() {
    	System.out.println("推送成功");
    }

    @Override
    public void onFail(String message) {
        System.out.println("推送失败：" + message);
    }
});
```

