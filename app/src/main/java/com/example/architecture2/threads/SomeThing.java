package com.example.architecture2.threads;

public class SomeThing implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello with thread SomeThing");
    }
}
