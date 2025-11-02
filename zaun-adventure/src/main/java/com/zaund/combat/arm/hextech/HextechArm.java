package com.zaund.combat.arm.hextech;

import com.zaund.combat.arm.Arm;
import com.zaund.combat.arm.Rechargeable;
import com.zaund.combat.arm.Reloadable;

/**
 * Base class for hextech weapons that use energy.
 * All hextech weapons implement Rechargeable for energy management.
 * Distance hextech weapons can also implement Reloadable for ammo.
 */
public abstract class HextechArm extends Arm implements Rechargeable {
   protected int currentEnergy;
   protected final int maxEnergy;

   public HextechArm(String name, String description, int damage, int range, int maxEnergy) {
      super(name, description, damage, range);
      if (maxEnergy <= 0) {
         throw new IllegalArgumentException("Max energy must be positive");
      }
      this.maxEnergy = maxEnergy;
      this.currentEnergy = maxEnergy;
   }

   @Override
   public void recharge() {
      this.currentEnergy = maxEnergy;
      System.out.println(getName() + " recharged! Energy: " + currentEnergy + "/" + maxEnergy);
   }

   @Override
   public boolean needsRecharge() {
      return currentEnergy <= 0;
   }

   @Override
   public int getEnergyCount() {
      return currentEnergy;
   }

   @Override
   public int getMaxEnergy() {
      return maxEnergy;
   }

   /**
    * Consumes energy when using hextech abilities
    * @param amount Amount of energy to consume
    * @return true if energy was consumed, false if insufficient energy
    */
   protected boolean consumeEnergy(int amount) {
      if (currentEnergy >= amount) {
         currentEnergy -= amount;
         return true;
      }
      return false;
   }

   /**
    * Consumes one unit of energy
    * @return true if energy was consumed, false if out of energy
    */
   protected boolean consumeEnergy() {
      return consumeEnergy(1);
   }
}

/**
 * Extended hextech arm for distance weapons that use both energy and ammunition
 */
abstract class HextechDistanceArm extends HextechArm implements Reloadable {
   protected int currentAmmo;
   protected final int maxAmmo;

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
}
