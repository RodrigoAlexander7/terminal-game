package com.zaund.combat.arm.melee;

public class Sword extends MeleeArm{
   public int armDamage;
   public int armDurability;

   public Sword(String name, String description, int armDamage, int armDurability) {
      super(name, description);
      this.armDamage = armDamage;
      this.armDurability = armDurability;
   }
   
}
