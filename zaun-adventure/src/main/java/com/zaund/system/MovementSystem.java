package com.zaund.system;

import java.util.ArrayList;

import com.zaund.entity.character.Player;
import com.zaund.entity.character.enemies.Enemy;
import com.zaund.io.Command;
import com.zaund.map.Map;
import com.zaund.map.Position;

public class MovementSystem {
   public static boolean movePlayer(Map map, Player player, ArrayList<Enemy> enemies, Command direction){
      Position current = player.getPosition();
      Position newPosition = new Position(current);
      
      // Apply movement
      switch (direction) {
         case MOVE_UP: newPosition.moveUp(); break;
         case MOVE_DOWN: newPosition.moveDown(); break;
         case MOVE_RIGHT: newPosition.moveRight(); break;
         case MOVE_LEFT: newPosition.moveLeft(); break;
         default: 
            System.out.println("Invalid move");
            return false;
      }
      
      // Validate map boundaries
      if (newPosition.getX() < 0 || newPosition.getX() >= map.getNumR() ||
          newPosition.getY() < 0 || newPosition.getY() >= map.getNumC()) {
         System.out.println("Cannot move outside the map");
         return false;
      }
      
      // Validate if tile is transitable
      if (!map.getTile(newPosition).getTransitable()) {
         System.out.println("Cannot walk here - obstacle in the way");
         return false;
      }
      
      // Validate collision with enemies
      for (Enemy enemy : enemies) {
         if (enemy.getPosition().equals(newPosition)) {
            System.out.println("An enemy blocks your path!");
            return false;
         }
      }
      
      // Move is valid
      player.setPosition(newPosition);
      return true;
   }
}
