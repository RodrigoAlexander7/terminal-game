package com.zaund.combat.arm.distance;
import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.Entity;

public class Pistol extends DistanceArm implements DistanceAtack {
   private int armRange;
   private int armAmmo;
   private int armDamage;
   private int maxAmmo;
   private boolean reloading;

   public Pistol() {
      super("Pistol", "A basic pistol with moderate damage and accuracy.");
      this.armRange = 8;
      this.armAmmo = 12;
      this.maxAmmo = 12;
      this.armDamage = 50;
      this.reloading = false;
   }

   @Override
   public void shot(Entity entity) {
      if (reloading) {
         System.out.println("Currently reloading!");
         return;
      }
      if (armAmmo <= 0) {
         System.out.println("Out of ammo! Need to reload.");
         reload();
         return;
      }
      System.out.println("Firing Pistol at " + entity.getType() + " for " + armDamage + " damage.");
      entity.receiveAttack(armDamage);
      armAmmo--;
   }

   @Override
   public boolean isReloading() {
      return reloading;
   }

   public void reload() {
      System.out.println("Reloading Pistol...");
      reloading = true;
      armAmmo = maxAmmo;
      reloading = false;
      System.out.println("Reload complete!");
   }
}
