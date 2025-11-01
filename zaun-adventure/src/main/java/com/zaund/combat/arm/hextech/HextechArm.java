package com.zaund.combat.arm.hextech;

import com.zaund.combat.arm.Arm;
import com.zaund.combat.arm.Reloadable;

public abstract class HextechArm extends Arm implements Reloadable {
   protected int armRange;
   protected int armDamage;
   protected int armAmmoCapacity;
   protected int currentAmmo;

   public HextechArm(String name, String description, int maxAmmo) {
      super(name, description);
      this.armRange = 1;
      this.armDamage = 100;
      this.armAmmoCapacity = maxAmmo;
      this.currentAmmo = maxAmmo;
   }

   @Override
   public void reload() {
      this.currentAmmo = armAmmoCapacity;
      System.out.println(name + " recharged! Energy: " + currentAmmo + "/" + armAmmoCapacity);
   }

   @Override
   public boolean needsReload() {
      return currentAmmo <= 0;
   }

   @Override
   public int getAmmoCount() {
      return currentAmmo;
   }

   @Override
   public int getMaxAmmo() {
      return armAmmoCapacity;
   }

   public int getRange() {
      return armRange;
   }

   public void setRange(int range) {
      this.armRange = range;
   }

   public int getDamage() {
      return armDamage;
   }

   public void setDamage(int damage) {
      this.armDamage = damage;
   }
}
