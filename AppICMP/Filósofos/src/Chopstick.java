/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author rtorraca
 */

import java.util.concurrent.locks.ReentrantLock;


public class Chopstick extends ReentrantLock {
 private int id;
 private static int xpos[]=new int[5]; 
 private static int ypos[]=new int[5];
 
 public Chopstick(){
  
 }
 
 public Chopstick(int id, int xpos,int ypos){
  this.id=id;
  this.xpos[id]=xpos;
  this.ypos[id]=ypos;
 }
 
 public static void setAxis(int id,int x,int y){
  xpos[id]=x;
  ypos[id]=y;
 }
 
 public int getXpos(int id){
  return xpos[id];
 }
 
 public int getYpos(int id){
  return ypos[id];
 }

}
