package com.zaund.combat.arm.hextech;

import com.zaund.combat.arm.Reloadable;

/**
 * Base class for hextech distance weapons that use both energy and ammunition.
 * 
 * These weapons have a dual-resource system:
 * - Energy (from HextechArm): Required for all shots, rechargeable
 * - Ammunition (from this class): Physical projectiles, reloadable
 * 
 * Both resources must be available to fire.
 */
public abstract class HextechDistanceArm extends HextechArm implements Reloadable {
   protected int currentAmmo;
   protected final int maxAmmo;

   /**
    * Creates a new hextech distance weapon
    * @param name Weapon name
    * @param description Weapon description
    * @param damage Base damage
    * @param range Attack range
    * @param maxEnergy Maximum energy capacity
    * @param maxAmmo Maximum ammunition capacity
    */
   public HextechDistanceArm(String name, String description, int damage, int range, int maxEnergy, int maxAmmo) {
      super(name, description, damage, range, maxEnergy);
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
   
   /**
    * Checks if the weapon can fire (has both energy and ammo)
    * @param energyCost Energy required to fire
    * @param ammoCost Ammo required to fire
    * @return true if both resources are available
    */
   protected boolean canFire(int energyCost, int ammoCost) {
      return currentEnergy >= energyCost && currentAmmo >= ammoCost;
   }
}
