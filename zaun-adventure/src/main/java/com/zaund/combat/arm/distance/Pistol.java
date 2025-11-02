package com.zaund.combat.arm.distance;

import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.Entity;

public class Pistol extends DistanceArm implements DistanceAttack {

   public Pistol() {
      super("Pistol", "A basic pistol with moderate damage and accuracy.", 50, 8, 12);
   }

   @Override
   public void shot(Entity entity) {
      if (needsReload()) {
         System.out.println("Out of ammo! Reloading...");
         reload();
         return;
      }
      System.out.println("Firing Pistol at " + entity.getType() + " for " + getDamage() + " damage.");
      entity.receiveAttack(getDamage());
      consumeAmmo();
   }

   @Override
   public boolean isReloading() {
      return needsReload();
   }
}
