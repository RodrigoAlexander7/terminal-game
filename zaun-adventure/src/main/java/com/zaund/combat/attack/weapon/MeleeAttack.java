package com.zaund.combat.attack.weapon;
import com.zaund.entity.Entity;

public interface MeleeAttack {
   void heavyAttack(Entity entity);
   void middleAttack(Entity entity);
   void lightAttack(Entity entity);
}