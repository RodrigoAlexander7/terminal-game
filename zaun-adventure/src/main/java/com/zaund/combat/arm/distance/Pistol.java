package com.zaund.combat.arm.distance;

import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.Entity;

public class Pistol extends DistanceArm implements DistanceAtack {
   private int armDamage;

   public Pistol() {
      super("Pistol", "A basic pistol with moderate damage and accuracy.", 12);
      setRange(8);
      this.armDamage = 50;
   }

   @Override
   public void shot(Entity entity) {
      if (needsReload()) {
         System.out.println("Out of ammo! Reloading...");
         reload();
         return;
      }
      System.out.println("Firing Pistol at " + entity.getType() + " for " + armDamage + " damage.");
      entity.receiveAttack(armDamage);
      armAmmo--;
   }

   @Override
   public boolean isReloading() {
      return needsReload();
   }

   public int getDamage() {
      return armDamage;
   }
}
