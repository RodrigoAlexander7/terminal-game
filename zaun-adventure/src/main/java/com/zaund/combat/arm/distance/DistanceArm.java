package com.zaund.combat.arm.distance;

import com.zaund.combat.arm.Arm;
import com.zaund.combat.arm.Reloadable;

/**
 * Base class for distance weapons that use ammunition.
 * Implements Reloadable interface for ammo management.
 */
public abstract class DistanceArm extends Arm implements Reloadable {
   protected int currentAmmo;
   protected final int maxAmmo;

   public DistanceArm(String name, String description, int damage, int range, int maxAmmo) {
      super(name, description, damage, range);
      if (maxAmmo <= 0) {
         throw new IllegalArgumentException("Max ammo must be positive");
      }
      this.maxAmmo = maxAmmo;
      this.currentAmmo = maxAmmo;
   }

   @Override
   public void reload() {
      this.currentAmmo = maxAmmo;
      System.out.println(getName() + " reloaded! Ammo: " + currentAmmo + "/" + maxAmmo);
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
      return maxAmmo;
   }

   /**
    * Consumes ammunition when firing
    * @param amount Amount of ammo to consume
    * @return true if ammo was consumed, false if insufficient ammo
    */
   protected boolean consumeAmmo(int amount) {
      if (currentAmmo >= amount) {
         currentAmmo -= amount;
         return true;
      }
      return false;
   }

   /**
    * Consumes one unit of ammunition
    * @return true if ammo was consumed, false if out of ammo
    */
   protected boolean consumeAmmo() {
      return consumeAmmo(1);
   }
}
