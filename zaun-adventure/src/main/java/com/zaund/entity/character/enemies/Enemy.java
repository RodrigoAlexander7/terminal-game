// Abstract class to shape all the enemies
package com.zaund.entity.character.enemies;

import com.zaund.combat.Attackable;
import com.zaund.entity.Damageable;
import com.zaund.entity.Entity;

public abstract class Enemy extends Entity implements Damageable, Attackable {

   public Enemy(int x, int y, String type, int maxLife){
      super(x, y, type, maxLife);
   }

   public abstract void executeAttack(Damageable target);

   @Override
   public void receiveAttack(int attackStat){
      if (attackStat < 0) {
         throw new IllegalArgumentException("Damage cannot be negative");
      }
      setLife(getLife() - attackStat);
   }

   @Override
   protected void onDeath() {
      System.out.println("You finished the " + getType() + "!");
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