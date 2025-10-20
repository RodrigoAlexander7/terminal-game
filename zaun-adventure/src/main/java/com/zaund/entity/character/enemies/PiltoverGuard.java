package com.zaund.entity.character.enemies;

import com.zaund.entity.character.Player;

public class PiltoverGuard extends Enemy {
   public static final int LIFE_POINTS = 1000;
   public static final int BASIC_ATACK_POWER = 300;
   public static final String RENDER_SYMBOL = "🛡️";


   public PiltoverGuard(int x, int y) {
      super(LIFE_POINTS);
      setPosition(x, y);
   }

   @Override
   public void basicAtack(Player player) {
      System.out.println("Piltover Guard attacks!");
      player.receiveAttack(BASIC_ATACK_POWER);
   }
}
