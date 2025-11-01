package com.zaund.entity.character.enemies;

import com.zaund.entity.Entity;

public class PiltoverGuard extends Enemy {
   public static final int LIFE_POINTS = 1000;
   public static final int BASIC_ATTACK_POWER = 300;
   public static final String RENDER_SYMBOL = "🛡️";


   public PiltoverGuard(int x, int y) {
      super(LIFE_POINTS);
      setPosition(x, y);
      this.renderSymbol = RENDER_SYMBOL;
   }

   @Override
   public void basicAttack(Entity target) {
      System.out.println("Piltover Guard attacks!");
      target.receiveAttack(BASIC_ATTACK_POWER);
   }

   @Override
   public int getAttackPower() {
      return BASIC_ATTACK_POWER;
   }
}
