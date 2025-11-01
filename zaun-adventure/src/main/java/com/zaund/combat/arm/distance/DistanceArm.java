package com.zaund.combat.arm.distance;

import com.zaund.combat.arm.Arm;
import com.zaund.combat.arm.Reloadable;

public abstract class DistanceArm extends Arm implements Reloadable {
   protected int armRange;
   protected int armAmmo;
   protected int maxAmmo;

   public DistanceArm(String name, String description, int maxAmmo) {
      super(name, description);
      this.maxAmmo = maxAmmo;
      this.armAmmo = maxAmmo;
   }

   @Override
   public void reload() {
      this.armAmmo = maxAmmo;
      System.out.println(name + " reloaded! Ammo: " + armAmmo + "/" + maxAmmo);
   }

   @Override
   public boolean needsReload() {
      return armAmmo <= 0;
   }

   @Override
   public int getAmmoCount() {
      return armAmmo;
   }

   @Override
   public int getMaxAmmo() {
      return maxAmmo;
   }

   public int getRange() {
      return armRange;
   }

   public void setRange(int range) {
      this.armRange = range;
   }
   
}
