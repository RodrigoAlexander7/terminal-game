// abstract class to shepe all the players (heros)
package com.zaund.entity.character;

import com.zaund.entity.Entity;
import com.zaund.entity.character.enemies.Enemy;

public abstract class Player extends Entity{
   public int powerStatus;  // the power level capacity status | based on every kind of player (eg:ekko)
   public int lifeStatus;   // the live capacity status
   public boolean isProtected; // if is protected avoid enemy atacs
   public boolean isDodgeAtack; // if is dodge there are probabilities that not take damage
   public double dodgeAtackProbability; // the probability to dodge an atack

   public Player(int x, int y){
      super(x,y);
   }
   
   public void receiveAttack(int attackStat){
      if(isProtected){
         System.out.println("Attack avoided, you are protected!");
      } else if(isDodgeAtack){
         double prob = Math.random();
         if(prob < dodgeAtackProbability){
            System.out.println("Attack dodged!");
            return;
         } else {
            lifeStatus = lifeStatus - attackStat;
            System.out.println("Attack hit you despite dodging!");
         }
      } else {
         lifeStatus = lifeStatus - attackStat;
         System.out.println("You received an attack!");
      }
      if(lifeStatus <= 0){
         System.out.println("You have been defeated!");
      }
   }

   public abstract void basicAtack(Enemy enemy);
   public abstract void middleAtack(Enemy enemy);
   public abstract void maxAtack(Enemy enemy);
   public abstract void protect();
   public abstract void dodgeAtack();
}