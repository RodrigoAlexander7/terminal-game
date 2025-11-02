package com.zaund.combat.arm.hextech;

import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.Entity;

/**
 * RifleHex - Hextech energy rifle
 * Uses both energy and ammunition
 */
public class RifleHex extends HextechDistanceArm implements DistanceAttack {
   
   public RifleHex() {
      super("RifleHex", "A hextech rifle that shoots energy bullets.", 600, 10, 100, 20);
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
         System.out.println(getName() + " out of energy cells! Reloading...");
         reload();
         return;
      }
      
      System.out.println("⚡ Firing energy bullet at " + entity.getType() + " for " + getDamage() + " damage!");
      entity.receiveAttack(getDamage());
      consumeAmmo();
      consumeEnergy(5); // Each shot consumes energy
   }

   @Override
   public boolean isReloading() {
      return needsReload();
   }
}
