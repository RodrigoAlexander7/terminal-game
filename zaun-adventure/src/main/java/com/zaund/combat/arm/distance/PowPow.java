package com.zaund.combat.arm.distance;
import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.Entity;

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
   public void shot(Entity entity) {
      if (armAmmo <= 0) {
         System.out.println("Out of ammo!");
         return;
      }
      System.out.println("Firing Pow-Pow at " + entity.getType() + " for " + armDamage + " damage.");
      entity.receiveAttack(armDamage);
      armAmmo--;
   }

   public void rainShot(Entity entity) {
      if (armAmmo < 25) {
         System.out.println("Not enough ammo for Rain Shot!");
         return;
      }
      System.out.println("Firing Rain Shot at " + entity.getType() + " for " + (armDamage * 5) + " damage.");
      entity.receiveAttack(armDamage * 5); // rain shot does 5x damage but use 25x ammo
      armAmmo -= 25;
   }   

   public boolean isReloading() {
      return false;
   }
}