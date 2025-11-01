package com.zaund.combat.arm.hextech;
import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.Entity;

public class Gauntlet extends HextechArm implements MeleeAtack {
   public Gauntlet() {
      super("Gauntlet", "A hextech gauntlet that enhances melee attacks.");
      this.armDamage = 300;
      this.armAmmoCapacity = 0; // Melee weapons typically don't use ammo
      this.armRange = 2;
   }

   @Override
   public void heavyAttack(Entity entity) {
      System.out.println("Performing heavy attack with Gauntlet on " + entity.getType() + " for " + (armDamage + 100) + " damage.");
   }

   @Override
   public void middleAttack(Entity entity) {
      System.out.println("Performing middle attack with Gauntlet on " + entity.getType() + " for " + (armDamage + 50) + " damage.");
   }

   @Override
   public void lightAttack(Entity entity) {
      System.out.println("Performing light attack with Gauntlet on " + entity.getType() + " for " + (armDamage + 25) + " damage.");
      entity.receiveAttack(armDamage + 25);
   }

}
