package com.zaund.combat.arm.hextech;
import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.Entity;

public class RifleHex extends HextechArm implements DistanceAtack {
   public RifleHex() {
      super("RifleHex", "A hextech rifle that shoots energy bullets.");
      this.armRange = 10;
      this.armDamage = 600;
      this.armAmmoCapacity = 20;
   }

   @Override
   public void shot(Entity entity) {
      // Implement the shot logic
   }

   @Override
   public boolean isReloading() {
      // Implement the reloading logic
      return false;
   }
   
}
