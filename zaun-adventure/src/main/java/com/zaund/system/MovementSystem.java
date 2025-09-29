package com.zaund.system;

import java.util.ArrayList;

import com.zaund.entity.character.Enemy;
import com.zaund.entity.character.Player;
import com.zaund.io.Command;
import com.zaund.map.Map;
import com.zaund.map.Position;

public class MovementSystem {
   public static boolean movePlayer(Map map, Player player, ArrayList<Enemy> enemies, Command direction){
      Position current = player.getPosition();
      Position newPosition = new Position(current);
      // create the new position
      switch (direction) {
         case MOVE_UP: newPosition.moveUp(); break;
         case MOVE_DOWN: newPosition.moveDown(); break;
         case MOVE_RIGHT: newPosition.moveRight(); break;
         case MOVE_LEFT: newPosition.moveLeft(); break;
         default: System.out.println("Invalid move "); break;
      }
      // if the new position is not transitable do nothing
      if(!map.getTile(newPosition).getTransitable()){
         System.out.println("Is not posible walk here");
         // undo changes
         newPosition = new Position(current);
      } // else move the player
      else{
         player.setPosition(newPosition);
      }

      return false;
   }
}
