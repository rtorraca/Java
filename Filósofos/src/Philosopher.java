/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rtorraca
 */

import java.util.Random;
import java.util.concurrent.locks.Lock;


public class Philosopher implements Runnable {
 private int id;
 private Lock leftChopstick;
 private Lock rightChopstick;
 private static  int noMeals[]=new int [5];
 private Random timeGenerator = new Random();
 private static int state[]=new int[5];
 private static int quote[]=new int[5];
 private Chopstick chopstick=new Chopstick();
 public Philosopher(){
  
 }
 
 public Philosopher(int id,Lock leftChopstick, Lock rightChopstick){
  this.id=id;
  this.leftChopstick=leftChopstick;
  this.rightChopstick=rightChopstick;
 }
 public void run(){
  try {
   while (true) {
    think();
    pickUpChopstick(leftChopstick,rightChopstick);
    eat();
    putDownChopsticks();
   }
  } catch (InterruptedException e) {
   System.out.println("Philosopher " + id + " was interrupted.\n");   
  }
  
 }
 
 private void think() throws InterruptedException {
  System.out.println("Philosopher " + id + " is thinking.\n");
  System.out.flush();
  if(id==0){
   state[0]=4;
  }
  if(id==1){
   state[1]=4;
  }
  if(id==2){
   state[2]=4;
  }
  if(id==3){
   state[3]=4;
  }
  if(id==4){
   state[4]=4;
  }//
  Thread.sleep (1000+timeGenerator.nextInt(1000));
 }
 
 private void pickUpChopstick(Lock leftChopstick,Lock rightChopstick){
  
  while(true){
   boolean lc=false;
   boolean rc=false;
   try{
    lc=leftChopstick.tryLock();
    rc=rightChopstick.tryLock();
   }finally{
    if(lc&&rc){
     System.out.println("Philosopher " + id + " Pick Up both Chop Stick.\n");
     quote[id]=3;
     return;
    }
    if(lc){
     System.out.println("Philosopher " + id + " Pick Up  leftChop Stick And RightChop Stick is Busy.\n");
     leftChopstick.unlock();
     System.out.println("Philosopher " + id + " Put Down  leftChop Stick.\n");
     quote[id]=1;
    }
    if(rc){
     System.out.println("Philosopher " + id + " Pick Up  RightChop Stick And lefttChop Stick is Busy.\n");
     rightChopstick.unlock();
     System.out.println("Philosopher " + id + " Put Down  RightChop Stick.\n");
     quote[id]=2;
    }
   }
   
   try {
    Thread.sleep(1000);
   } catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
   }
  }
  
 }
 
 private void eat() throws InterruptedException {
  Thread.sleep(50);
  quote[id]=0;
  increment(id);
  System.out.println("Philosopher " + id + " is eating.\n");
  if(id==0){
   chopstick.setAxis(0, 340, 350);
   chopstick.setAxis(4, 380, 350);
   state[0]=0;
  }
  if(id==1){
   chopstick.setAxis(0, 220, 290);
   chopstick.setAxis(1, 200, 250); 
   state[1]=0;
  }
  if(id==2){
   chopstick.setAxis(1, 240, 150);
   chopstick.setAxis(2, 280, 120);
   state[2]=0;
  }
  if(id==3){
   chopstick.setAxis(2, 430, 120);
   chopstick.setAxis(3, 500, 150);
   state[3]=0;
  }
  if(id==4){
   chopstick.setAxis(3, 530, 270);
   chopstick.setAxis(4, 490, 315);
   state[4]=0;
  }
  System.out.flush();
  Thread.sleep (400);
  //
  if(id==0){
   state[0]=1;
  }
  if(id==1){
   state[1]=1;
  }
  if(id==2){
   state[2]=1;
  }
  if(id==3){
   state[3]=1;
  }
  if(id==4){
   state[4]=1;
  }
  //
  Thread.sleep (400);
  //
  if(id==0){
   state[0]=2;
  }
  if(id==1){
   state[1]=2;
  }
  if(id==2){
   state[2]=2;
  }
  if(id==3){
   state[3]=2;
  }
  if(id==4){
   state[4]=2;
  }//
  
  //
  Thread.sleep (400);
  //
  if(id==0){
   state[0]=3;
  }
  if(id==1){
   state[1]=3;
  }
  if(id==2){
   state[2]=3;
  }
  if(id==3){
   state[3]=3;
  }
  if(id==4){
   state[4]=3;
  }//
  
  
  Thread.sleep (200+timeGenerator.nextInt(200));
  
  
 }
 
 
 private void putDownChopsticks() {
  leftChopstick.unlock();
  rightChopstick.unlock();
  System.out.println("Philosopher " + id + " put down Both ChopStick\n");
  if(id==0){
   chopstick.setAxis(0, 270, 330);
   chopstick.setAxis(4, 430, 330); 
   state[0]=4;
  }
  if(id==1){
   chopstick.setAxis(0, 270, 330);
   chopstick.setAxis(1, 200, 200); 
   state[1]=4;
  }
  if(id==2){
   chopstick.setAxis(1, 200, 200);
   chopstick.setAxis(2, 350, 120);
   state[2]=4;
  }
  if(id==3){
   chopstick.setAxis(2, 350, 120);
   chopstick.setAxis(3, 500, 210);
   state[3]=4;
  }
  if(id==4){
   chopstick.setAxis(3, 500, 210);
   chopstick.setAxis(4, 430, 330);
   state[4]=4;
  }
 }
 
 public int getS(int id){
  return state[id];
  
 }
 public void setS(int id,int s){
  state[id]=s;
 }
 public void increment(int id){
  noMeals[id]++;
 }
 
 public int getNoMeals(int id){
  return noMeals[id];
 }
 public int getQuote(int id){
  return quote[id];
 }
 
 
}
