package com.bonc.example.demo.PCTest;

/**
 * @author luoaojin
 * @CreateTime 2019-03-04
 * @Description
 */
public class Message {
    private String title;
    private String context;
    private boolean flag =false;

    public synchronized void set(String title,String context){
        if (flag) {

            try {
               super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }
        setTitle(title);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        setContext(context);
        flag = true;

        notify();
    }
    public  synchronized  void get(){
        if (!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(toString());
        flag = false;
        notify();
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "Message{" +
                "title='" + title + '\'' +
                ", context='" + context + '\'' +
                '}';
    }
}
