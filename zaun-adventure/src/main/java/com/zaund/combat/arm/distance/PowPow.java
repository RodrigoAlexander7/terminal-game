package com.zaund.combat.arm.distance;

import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.Entity;

public class PowPow extends DistanceArm implements DistanceAttack {

   public PowPow() {
      super("Pow-Pow", "Jinx's signature weapon, a compact submachine gun that fires a rapid stream of bullets.", 100, 10, 100);
   }

   @Override
   public void shot(Entity entity) {
      if (needsReload()) {
         System.out.println("Out of ammo! Reloading...");
         reload();
         return;
      }
      System.out.println("Firing Pow-Pow at " + entity.getType() + " for " + getDamage() + " damage.");
      entity.receiveAttack(getDamage());
      consumeAmmo();
   }

   /**
    * Special ability: Rain Shot - consumes 25 ammo for 5x damage
    */
   public void rainShot(Entity entity) {
      if (currentAmmo < 25) {
         System.out.println("Not enough ammo for Rain Shot!");
         return;
      }
      int damage = getDamage() * 5;
      System.out.println("Firing Rain Shot at " + entity.getType() + " for " + damage + " damage.");
      entity.receiveAttack(damage);
      consumeAmmo(25);
   }

   @Override
   public boolean isReloading() {
      return needsReload();
   }
}