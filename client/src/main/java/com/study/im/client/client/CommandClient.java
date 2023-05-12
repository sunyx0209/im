package com.study.im.client.client;

import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service("CommandClient")
public class CommandClient {

    private volatile boolean connectFlag;

    public void startCommandThread() throws InterruptedException{
//        Thread.currentThread().setName("主线程");
//        while (true) {
//            while (connectFlag == false) {
//                startConnectServer();
//                waitCommandThread();
//            }
//            while (session != null && session.isConnected()) {
//                Scanner scanner = new Scanner(System.in);
//
//            }
//        }
    }
}
