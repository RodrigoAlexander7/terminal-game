package com.zaund.combat.arm.distance;
import com.zaund.combat.atack.*;
import com.zaund.entity.character.enemies.Enemy;

public class PowPow extends DistanceArm implements DistanceAtack {
   public int armRange;
   public int armAmmo;
   public int armDamage;

   public PowPow() {
      super("Pow-Pow", "Jinx's signature weapon, a compact submachine gun that fires a rapid stream of bullets.");
      this.armRange = 10;
      this.armAmmo = 100;
      this.armDamage = 100;
   }

   @Override
   public void shot(Enemy enemy) {
      if (armAmmo <= 0) {
         System.out.println("Out of ammo!");
         return;
      }
      System.out.println("Firing Pow-Pow at " + enemy.getType() + " for " + armDamage + " damage.");
      enemy.receiveAttack(armDamage);
      armAmmo--;
   }

   public void rainShot(Enemy enemy) {
      if (armAmmo < 25) {
         System.out.println("Not enough ammo for Rain Shot!");
         return;
      }
      System.out.println("Firing Rain Shot at " + enemy.getType() + " for " + (armDamage * 5) + " damage.");
      enemy.receiveAttack(armDamage * 5); // rain shot does 5x damage but use 25x ammo
      armAmmo -= 25;
   }   

   public boolean isReloading() {
      return false;
   }
}