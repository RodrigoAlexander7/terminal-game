package com.zaund.io;

import com.zaund.map.*;
import java.util.List;
import com.zaund.entity.*;
import com.zaund.entity.character.enemies.Enemy;

public class ConsoleRenderer {
   public static void render(Map map, Entity player, List<? extends Enemy> enemies) {
      int numR = map.getNumR();
      int numC = map.getNumC();
      
      // verify that the player is inside the Map
      if (!player.isInsideMap(map)) {
         System.out.println("Player out bounded map");
         return;
      }
      
      // verify that the enemies are on the map
      for (Entity enemy : enemies) {
         if (!enemy.isInsideMap(map)) {
            System.out.println("Enemy out bounded map: " + enemy);
            return;
         }
      }

      // draw the map with player and enemies
      for (int i = 0; i < numR; i++) {
         for (int j = 0; j < numC; j++) {
            Position current = new Position(i, j);
            if (player.getPosition().equals(current)) {
               System.out.print(player.getRenderSymbol());
            } else {
               System.out.print(map.getTile(i, j).getSymbol());
            }
         }
         System.out.println();
      }
   }
}
