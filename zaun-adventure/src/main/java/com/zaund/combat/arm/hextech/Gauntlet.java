package com.zaund.combat.arm.hextech;
import com.zaund.combat.atack.*;
import com.zaund.entity.character.enemies.Enemy;

public class Gauntlet extends HextechArm implements MeleeAtack {
   public Gauntlet() {
      super("Gauntlet", "A hextech gauntlet that enhances melee attacks.");
      this.armDamage = 300;
      this.armAmmoCapacity = 0; // Melee weapons typically don't use ammo
      this.armRange = 2;
   }

   @Override
   public void heavyAttack(Enemy enemy) {
      System.out.println("Performing heavy attack with Gauntlet on " + enemy.getType() + " for " + (armDamage + 100) + " damage.");
   }

   @Override
   public void middleAttack(Enemy enemy) {
      System.out.println("Performing middle attack with Gauntlet on " + enemy.getType() + " for " + (armDamage + 50) + " damage.");
   }

   @Override
   public void lightAttack(Enemy enemy) {
      System.out.println("Performing light attack with Gauntlet on " + enemy.getType() + " for " + (armDamage + 25) + " damage.");
      enemy.receiveAttack(armDamage + 25);
   }

}
