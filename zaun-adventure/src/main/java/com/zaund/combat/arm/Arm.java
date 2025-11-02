package com.zaund.combat.arm;

/**
 * Base class for all weapons in the game.
 * Contains common attributes like name, description, damage, and range.
 */
public abstract class Arm {
   protected final String name;
   protected final String description;
   protected int damage;
   protected int range;

   public Arm(String name, String description, int damage, int range) {
      if (name == null || name.trim().isEmpty()) {
         throw new IllegalArgumentException("Arm name cannot be empty");
      }
      if (damage < 0) {
         throw new IllegalArgumentException("Damage cannot be negative");
      }
      if (range < 0) {
         throw new IllegalArgumentException("Range cannot be negative");
      }
      
      this.name = name;
      this.description = description;
      this.damage = damage;
      this.range = range;
   }

   public String getName() {
      return name;
   }

   public String getDescription() {
      return description;
   }

   public int getDamage() {
      return damage;
   }

   public int getRange() {
      return range;
   }

   protected void setDamage(int damage) {
      if (damage < 0) {
         throw new IllegalArgumentException("Damage cannot be negative");
      }
      this.damage = damage;
   }

   protected void setRange(int range) {
      if (range < 0) {
         throw new IllegalArgumentException("Range cannot be negative");
      }
      this.range = range;
   }

   @Override
   public String toString() {
      return name + " (DMG: " + damage + ", Range: " + range + ")";
   }
} 