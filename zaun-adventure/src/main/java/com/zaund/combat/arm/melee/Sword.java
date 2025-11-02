package com.zaund.combat.arm.melee;

import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.Entity;

/**
 * Sword - Traditional melee weapon with durability
 */
public class Sword extends MeleeArm implements MeleeAttack {

   public Sword(String name, String description, int damage, int range, int durability) {
      super(name, description, damage, range, durability);
   }

   @Override
   public void heavyAttack(Entity entity) {
      if (isBroken()) {
         System.out.println(getName() + " is broken! Cannot attack.");
         return;
      }
      int damage = (int) (getDamage() * 1.5);
      System.out.println("⚔️ " + getName() + " HEAVY SLASH on " + entity.getType() + " for " + damage + " damage!");
      entity.receiveAttack(damage);
      consumeDurability(3);
   }

   @Override
   public void middleAttack(Entity entity) {
      if (isBroken()) {
         System.out.println(getName() + " is broken! Cannot attack.");
         return;
      }
      int damage = (int) (getDamage() * 1.2);
      System.out.println("🗡️ " + getName() + " POWER STRIKE on " + entity.getType() + " for " + damage + " damage!");
      entity.receiveAttack(damage);
      consumeDurability(2);
   }

   @Override
   public void lightAttack(Entity entity) {
      if (isBroken()) {
         System.out.println(getName() + " is broken! Cannot attack.");
         return;
      }
      System.out.println("⚔ " + getName() + " QUICK SLASH on " + entity.getType() + " for " + getDamage() + " damage!");
      entity.receiveAttack(getDamage());
      consumeDurability(1);
   }
}
