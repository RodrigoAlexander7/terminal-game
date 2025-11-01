package com.zaund.combat.arm.hextech;
import com.zaund.combat.attack.weapon.*;
import com.zaund.entity.*;

public class Fishbone extends HextechArm implements DistanceAtack {
   public Fishbone() {
      super("Fishbone", "A hextech crossbow that shoots explosive bolts.");
      this.armRange = 15;
      this.armDamage = 800;
      this.armAmmoCapacity = 5;
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
