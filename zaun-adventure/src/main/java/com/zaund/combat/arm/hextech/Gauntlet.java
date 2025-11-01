package com.zaund.combat.arm.hextech;

import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.Entity;

public class Gauntlet extends HextechArm implements MeleeAtack {
   public Gauntlet() {
      super("Gauntlet", "A hextech gauntlet that enhances melee attacks.", 10); // Uses hextech energy
      setDamage(300);
      setRange(2);
   }

   @Override
   public void heavyAttack(Entity entity) {
      if (currentAmmo < 3) {
         System.out.println("Not enough energy for heavy attack!");
         return;
      }
      int damage = getDamage() + 100;
      System.out.println("Performing heavy attack with Gauntlet on " + entity.getType() + " for " + damage + " damage.");
      entity.receiveAttack(damage);
      currentAmmo -= 3;
   }

   @Override
   public void middleAttack(Entity entity) {
      if (currentAmmo < 2) {
         System.out.println("Not enough energy for middle attack!");
         return;
      }
      int damage = getDamage() + 50;
      System.out.println("Performing middle attack with Gauntlet on " + entity.getType() + " for " + damage + " damage.");
      entity.receiveAttack(damage);
      currentAmmo -= 2;
   }

   @Override
   public void lightAttack(Entity entity) {
      if (needsReload()) {
         System.out.println("Gauntlet needs recharging!");
         reload();
         return;
      }
      int damage = getDamage() + 25;
      System.out.println("Performing light attack with Gauntlet on " + entity.getType() + " for " + damage + " damage.");
      entity.receiveAttack(damage);
      currentAmmo--;
   }

}
