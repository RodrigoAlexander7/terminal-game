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
      // Check if we can fire (need both energy and ammo)
      if (!canFire(5, 1)) {
         if (needsRecharge()) {
            System.out.println(getName() + " needs energy recharge!");
            recharge();
         }
         if (needsReload()) {
            System.out.println(getName() + " out of energy cells! Reloading...");
            reload();
         }
         return;
      }
      
      // Fire the energy bullet
      System.out.println("⚡ Firing energy bullet at " + entity.getType() + " for " + getDamage() + " damage!");
      entity.receiveAttack(getDamage());
      consumeAmmo();
      consumeEnergy(5);
      System.out.println("Energy: " + getEnergyCount() + "/" + getMaxEnergy() + " | Cells: " + getAmmoCount() + "/" + getMaxAmmo());
   }

   @Override
   public boolean isReloading() {
      return needsReload();
   }
}
