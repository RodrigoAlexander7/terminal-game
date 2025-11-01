package com.zaund.combat.arm.hextech;

import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.*;

public class Fishbone extends HextechArm implements DistanceAttack {
   public Fishbone() {
      super("Fishbone", "A hextech crossbow that shoots explosive bolts.", 5);
      setRange(15);
      setDamage(800);
   }

   @Override
   public void shot(Entity entity) {
      if (needsReload()) {
         System.out.println("Fishbone needs recharging!");
         reload();
         return;
      }
      System.out.println("Firing explosive bolt at " + entity.getType() + " for " + getDamage() + " damage!");
      entity.receiveAttack(getDamage());
      currentAmmo--;
   }

   @Override
   public boolean isReloading() {
      return needsReload();
   }
   
}
