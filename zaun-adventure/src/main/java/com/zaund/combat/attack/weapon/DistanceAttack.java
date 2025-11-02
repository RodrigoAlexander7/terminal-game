package com.zaund.combat.attack.weapon;
import com.zaund.entity.Entity;

public interface DistanceAttack {
   void shot(Entity entity); 
   boolean isReloading();   
} 
