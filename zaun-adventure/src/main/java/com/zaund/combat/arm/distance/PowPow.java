package com.zaund.combat.arm.distance;

import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.Entity;

public class PowPow extends DistanceArm implements DistanceAtack {
   private int armDamage;

   public PowPow() {
      super("Pow-Pow", "Jinx's signature weapon, a compact submachine gun that fires a rapid stream of bullets.", 100);
      setRange(10);
      this.armDamage = 100;
   }

   @Override
   public void shot(Entity entity) {
      if (needsReload()) {
         System.out.println("Out of ammo! Reloading...");
         reload();
         return;
      }
      System.out.println("Firing Pow-Pow at " + entity.getType() + " for " + armDamage + " damage.");
      entity.receiveAttack(armDamage);
      armAmmo--;
   }

   public void rainShot(Entity entity) {
      if (armAmmo < 25) {
         System.out.println("Not enough ammo for Rain Shot!");
         return;
      }
      System.out.println("Firing Rain Shot at " + entity.getType() + " for " + (armDamage * 5) + " damage.");
      entity.receiveAttack(armDamage * 5); // rain shot does 5x damage but use 25x ammo
      armAmmo -= 25;
   }

   @Override
   public boolean isReloading() {
      return needsReload();
   }

   public int getDamage() {
      return armDamage;
   }
}