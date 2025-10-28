package com.zaund.combat.arm.distance;

import com.zaund.combat.arm.Arm;

public abstract class DistanceArm extends Arm{
   public int armRange;
   public int armAmmo;

   public DistanceArm(String name, String description) {
      super(name, description);
   }
   
}
