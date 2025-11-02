package com.zaund.combat.arm.hextech;

import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.*;

/**
 * Fishbone - Hextech rocket launcher
 * Uses both energy and ammunition
 */
public class Fishbone extends HextechDistanceArm implements DistanceAttack {
   
   public Fishbone() {
      super("Fishbone", "A hextech rocket launcher that shoots explosive rockets.", 800, 15, 100, 5);
   }

   @Override
   public void shot(Entity entity) {
      // Check both energy and ammo
      if (needsRecharge()) {
         System.out.println(getName() + " needs energy recharge!");
         recharge();
         return;
      }
      if (needsReload()) {
         System.out.println(getName() + " out of rockets! Reloading...");
         reload();
         return;
      }
      
      System.out.println("🚀 Firing explosive rocket at " + entity.getType() + " for " + getDamage() + " damage!");
      entity.receiveAttack(getDamage());
      consumeAmmo();
      consumeEnergy(20); // Each shot consumes energy too
   }

   @Override
   public boolean isReloading() {
      return needsReload();
   }
}
