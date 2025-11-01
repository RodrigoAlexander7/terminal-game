// Abstract class to shape all the enemies
package com.zaund.entity.character.enemies;

import com.zaund.combat.Attackable;
import com.zaund.entity.Damageable;
import com.zaund.entity.Entity;

public abstract class Enemy extends Entity implements Damageable, Attackable {
   protected String type;
   protected int life;
   protected boolean isLive;

   public Enemy(int life){
      this.life = life; 
      isLive = true;
   }

   public abstract void executeAttack(Damageable target);

   public String getType(){ 
      return this.type;
   }

   @Override
   public void receiveAttack(int attackStat){
      life = life - attackStat;
      if(life <= 0){
         isLive = false;
         System.out.println("You finish the enemy!");
      }
   }

   @Override
   public boolean isAlive() {
      return isLive;
   }

   // affects only Damageable types (can receive attacks)
   @Override
   public void attack(Damageable target) {
      int damage = getAttackPower();
      target.receiveAttack(damage);
      System.out.println(getClass().getSimpleName() + " attacks for " + damage + " damage!");

   }

   @Override
   public abstract int getAttackPower();

}