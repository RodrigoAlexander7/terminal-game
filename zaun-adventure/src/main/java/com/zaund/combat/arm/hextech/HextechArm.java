package com.zaund.combat.arm.hextech;

import com.zaund.combat.arm.Arm;
import com.zaund.combat.arm.Rechargeable;

/**
 * Base class for hextech weapons that use energy.
 * All hextech weapons consume energy when used and can be recharged.
 * 
 * Subclasses:
 * - Pure hextech weapons (like Gauntlet): Only use energy
 * - Hextech distance weapons: Should extend HextechDistanceArm for dual-resource management
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
