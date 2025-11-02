package com.zaund.combat.arm.melee;

import com.zaund.combat.arm.Arm;

/**
 * Base class for melee weapons.
 * Melee weapons have durability that degrades with use.
 */
public abstract class MeleeArm extends Arm {
   protected int durability;
   protected final int maxDurability;

   public MeleeArm(String name, String description, int damage, int range, int maxDurability) {
      super(name, description, damage, range);
      if (maxDurability <= 0) {
         throw new IllegalArgumentException("Max durability must be positive");
      }
      this.maxDurability = maxDurability;
      this.durability = maxDurability;
   }

   public int getDurability() {
      return durability;
   }

   public int getMaxDurability() {
      return maxDurability;
   }

   public boolean isBroken() {
      return durability <= 0;
   }

   /**
    * Consumes durability when weapon is used
    * @param amount Amount of durability to consume
    * @return true if weapon is still usable, false if broken
    */
   protected boolean consumeDurability(int amount) {
      if (durability > 0) {
         durability = Math.max(0, durability - amount);
         if (durability == 0) {
            System.out.println(getName() + " is broken!");
            return false;
         }
         return true;
      }
      return false;
   }

   /**
    * Consumes one point of durability
    * @return true if weapon is still usable, false if broken
    */
   protected boolean consumeDurability() {
      return consumeDurability(1);
   }

   /**
    * Repairs the weapon to full durability
    */
   public void repair() {
      this.durability = maxDurability;
      System.out.println(getName() + " repaired! Durability: " + durability + "/" + maxDurability);
   }
}
