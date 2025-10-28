package com.zaund.combat.arm.hextech;
import com.zaund.combat.arm.Arm;

public abstract class HextechArm extends Arm {
   public int armRange;
   public int armDamage;
   public int armAmmoCapacity;

   public HextechArm(String name, String description) {
      super(name, description);
      this.armRange = 1;
      this.armDamage = 100;
      this.armAmmoCapacity = 0; 
   }
}
