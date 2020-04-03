package com.wxx.push;

public interface IPushListener {
    void onSuccess();
    void onFail(String message);
}
