// Abstract class to shape all the players (heroes)
package com.zaund.entity.character;

import com.zaund.combat.Attackable;
import com.zaund.entity.Damageable;
import com.zaund.entity.Entity;

public abstract class Player extends Entity implements Damageable, Attackable {
   public int powerStatus;  // The power level capacity status | based on every kind of player (e.g., Ekko)
   public int lifeStatus;   // The life capacity status
   public boolean isProtected; // If protected, avoid enemy attacks
   public boolean isDodgeAtack; // if is dodge there are probabilities that not take damage
   public double dodgeAtackProbability; // the probability to dodge an atack

   public Player(int x, int y){
      super(x,y);
   }
   
   @Override
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

   @Override
   public boolean isAlive() {
      return lifeStatus > 0;
   }

   @Override
   public void attack(Damageable target) {
      // Default implementation delegates to basicAttack
      basicAttack((Entity) target);
   }

   @Override
   public abstract int getAttackPower();

   public abstract void basicAttack(Entity target);
   public abstract void middleAttack(Entity target);
   public abstract void maxAttack(Entity target);
   public abstract void protect();
   public abstract void dodgeAttack();
}