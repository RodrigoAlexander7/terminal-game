package com.zaund.combat.arm.melee;
import com.zaund.combat.arm.Arm;

public abstract class MeleeArm extends Arm {
   public int armRange;
   public int armDamage;

   public MeleeArm(String name, String description) {
      super(name, description);
   }
}
