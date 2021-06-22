package com.example.listossimage.service;

import org.apache.rocketmq.common.message.MessageExt;

import java.io.UnsupportedEncodingException;

public interface MessageHandle {

    String handleMessage(MessageExt messageExt) throws UnsupportedEncodingException;
}
