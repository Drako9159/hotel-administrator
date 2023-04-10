package com.hotel.test;

public class ThreadLoader extends Thread{

    Runnable r1 = new Runnable(){
        @Override
        public void run(){
            try{
                Thread.sleep(1000);
            } catch (Exception e){
                System.out.println(e);
            }
        }

    };
    Runnable r2 = new Runnable(){
        @Override
        public void run(){
            try{
                Thread.sleep(1000);
            } catch (Exception e){
                System.out.println(e);
            }
        }

    };
    public void start(){
        Thread t1 = new Thread(r1);
        t1.start();
    }


}
