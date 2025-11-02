// Abstract class to shape all the players (heroes)
package com.zaund.entity.character;

import com.zaund.combat.Attackable;
import com.zaund.entity.Damageable;
import com.zaund.entity.Entity;

public abstract class Player extends Entity implements Damageable, Attackable {
   protected int powerStatus;  // The power level capacity status | based on every kind of player (e.g., Ekko)
   protected int maxPower;     // Maximum power capacity
   protected boolean isProtected; // If protected, avoid enemy attacks
   protected boolean isDodgeAttack; // if is dodge there are probabilities that not take damage
   protected double dodgeAttackProbability; // the probability to dodge an attack

   public Player(int x, int y, String type, int maxLife, int maxPower){
      super(x, y, type, maxLife);
      this.maxPower = maxPower;
      this.powerStatus = maxPower;
   }
   
   @Override
   public void receiveAttack(int attackStat){
      if (attackStat < 0) {
         throw new IllegalArgumentException("Damage cannot be negative");
      }
      
      if(isProtected){
         System.out.println("Attack avoided, you are protected!");
      } else if(isDodgeAttack){
         double prob = Math.random();
         if(prob < dodgeAttackProbability){
            System.out.println("Attack dodged!");
            return;
         } else {
            setLife(getLife() - attackStat);
            System.out.println("Attack hit you despite dodging!");
         }
      } else {
         setLife(getLife() - attackStat);
         System.out.println("You received an attack!");
      }
   }

   @Override
   protected void onDeath() {
      System.out.println("You have been defeated!");
   }

   public int getPowerStatus() {
      return powerStatus;
   }

   public int getMaxPower() {
      return maxPower;
   }

   protected void setPowerStatus(int power) {
      this.powerStatus = Math.max(0, Math.min(power, maxPower));
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