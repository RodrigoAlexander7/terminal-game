package com.zaund.combat.atack;
import com.zaund.entity.character.enemies.*;

public interface DistanceAtack {
   void shot(Enemy enemy); 
   boolean isReloading();   
} 
