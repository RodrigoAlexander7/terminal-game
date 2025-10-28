package com.zaund.combat.atack;
import com.zaund.entity.character.enemies.*;

public interface MeleeAtack {
   void heavyAttack(Enemy enemy);
   void middleAttack(Enemy enemy);
   void lightAttack(Enemy enemy);
}