package com.java.thread;
import java.util.Random;
import java.util.concurrent.Phaser;
/*  ww w . j  av a 2  s .  c o  m*/
class StartTogetherTask extends Thread {
  private Phaser phaser;
  private String taskName;
  private static Random rand = new Random();

  public StartTogetherTask(String taskName, Phaser phaser) {
    this.taskName = taskName;
    this.phaser = phaser;
  }

  @Override
  public void run() {
    System.out.println(taskName + ":Initializing...");
    int sleepTime = rand.nextInt(5) + 1;
    try {
      Thread.sleep(sleepTime * 1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(taskName + ":Initialized...");
    phaser.arriveAndAwaitAdvance();
    System.out.println(taskName + ":Started...");
  }
}

public class Main {
  public static void main(String[] args) {
    Phaser phaser = new Phaser(1);
    for (int i = 1; i <= 3; i++) {
      phaser.register();
      String taskName = "Task  #" + i;
      StartTogetherTask task = new StartTogetherTask(taskName, phaser);
      task.start();
    }
    phaser.arriveAndDeregister();
  }
}