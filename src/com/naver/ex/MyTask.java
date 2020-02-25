package com.naver.ex;

public class MyTask extends Thread{

    private String name;
    private long sleep;
    private MyTask[] prevTasks;

    public MyTask(String name,long sleep){
        this.setName(name);
        this.name = name;
        this.sleep = sleep;
    }

    public void setPrevTasks(MyTask[] prevTasks) {
        this.prevTasks = prevTasks;
    }

    @Override
    public void run() {
        if(prevTasks != null && prevTasks.length > 0){
            for(MyTask task:prevTasks){
                try {
                    task.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        try {
            Thread.sleep(sleep);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Task"+name+"执行完成");
    }

    public static void main(String[] args) {
        MyTask taskA = new MyTask("A",1000);
        MyTask taskB = new MyTask("B",2000);
        MyTask taskC = new MyTask("C",3000);
        MyTask taskD = new MyTask("D",1000);
        MyTask taskE = new MyTask("E",2000);
        MyTask taskF = new MyTask("F",1500);
        MyTask taskG = new MyTask("G",3000);
        MyTask taskH = new MyTask("H",1000);

        MyTask[] fPrev = new MyTask[]{taskD,taskE};
        taskF.setPrevTasks(fPrev);
        MyTask[] dPrev = new MyTask[]{taskA};
        taskD.setPrevTasks(dPrev);
        MyTask[] ePrev = new MyTask[]{taskB,taskG};
        taskE.setPrevTasks(ePrev);
        MyTask[] gPrev = new MyTask[]{taskB};
        taskG.setPrevTasks(gPrev);
        MyTask[] aPrev = new MyTask[]{taskC,taskG};
        taskA.setPrevTasks(aPrev);
        MyTask[] cPrev = new MyTask[]{taskH};
        taskC.setPrevTasks(cPrev);

        taskA.start();
        taskB.start();
        taskC.start();
        taskD.start();
        taskE.start();
        taskF.start();
        taskG.start();
        taskH.start();

    }
}
