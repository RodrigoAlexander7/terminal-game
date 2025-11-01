package com.zaund.combat.arm.hextech;

import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.Entity;

public class RifleHex extends HextechArm implements DistanceAttack {
   public RifleHex() {
      super("RifleHex", "A hextech rifle that shoots energy bullets.", 20);
      setRange(10);
      setDamage(600);
   }

   @Override
   public void shot(Entity entity) {
      if (needsReload()) {
         System.out.println("RifleHex out of energy! Recharging...");
         reload();
         return;
      }
      System.out.println("Firing energy bullet at " + entity.getType() + " for " + getDamage() + " damage!");
      entity.receiveAttack(getDamage());
      currentAmmo--;
   }

   @Override
   public boolean isReloading() {
      return needsReload();
   }
   
}
