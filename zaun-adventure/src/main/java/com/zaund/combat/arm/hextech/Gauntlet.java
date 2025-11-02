package com.zaund.combat.arm.hextech;

import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.Entity;

/**
 * Gauntlet - Hextech-powered gauntlet for melee combat
 * Only uses energy (no ammunition)
 */
public class Gauntlet extends HextechArm implements MeleeAttack {
   
   public Gauntlet() {
      super("Gauntlet", "A hextech gauntlet that enhances melee attacks with energy.", 300, 2, 100);
   }

   @Override
   public void heavyAttack(Entity entity) {
      if (currentEnergy < 30) {
         System.out.println("Not enough energy for heavy attack!");
         return;
      }
      int damage = getDamage() + 100;
      System.out.println("💥 Performing HEAVY PUNCH with " + getName() + " on " + entity.getType() + " for " + damage + " damage!");
      entity.receiveAttack(damage);
      consumeEnergy(30);
   }

   @Override
   public void middleAttack(Entity entity) {
      if (currentEnergy < 20) {
         System.out.println("Not enough energy for middle attack!");
         return;
      }
      int damage = getDamage() + 50;
      System.out.println("👊 Performing POWER STRIKE with " + getName() + " on " + entity.getType() + " for " + damage + " damage!");
      entity.receiveAttack(damage);
      consumeEnergy(20);
   }

   @Override
   public void lightAttack(Entity entity) {
      if (needsRecharge()) {
         System.out.println(getName() + " needs energy recharge!");
         recharge();
         return;
      }
      int damage = getDamage() + 25;
      System.out.println("✊ Performing QUICK JAB with " + getName() + " on " + entity.getType() + " for " + damage + " damage!");
      entity.receiveAttack(damage);
      consumeEnergy(10);
   }
}
