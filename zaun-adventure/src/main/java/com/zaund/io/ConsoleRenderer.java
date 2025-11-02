package com.zaund.io;

import com.zaund.map.*;
import java.util.List;
import com.zaund.entity.*;
import com.zaund.entity.character.enemies.Enemy;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;
import java.io.IOException;

public class ConsoleRenderer {
   private static Terminal terminal;
   
   static {
      try {
         terminal = TerminalBuilder.builder()
            .system(true)
            .build();
         terminal.enterRawMode();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
   
   public static Terminal getTerminal() {
      return terminal;
   }
   
   public static void clearScreen() {
      if (terminal != null) {
         terminal.puts(InfoCmp.Capability.clear_screen);
         terminal.flush();
      }
   }
   
   public static void moveCursor(int row, int col) {
      if (terminal != null) {
         terminal.puts(InfoCmp.Capability.cursor_address, row, col);
         terminal.flush();
      }
   }
   
   public static void render(Map map, Entity player, List<? extends Enemy> enemies) {
      if (terminal == null) {
         System.out.println("Terminal not initialized!");
         return;
      }
      
      int numR = map.getNumR();
      int numC = map.getNumC();
      
      // verify that the player is inside the Map
      if (!player.isInsideMap(map)) {
         clearScreen();
         terminal.writer().println("Player out bounded map");
         terminal.flush();
         return;
      }
      
      // verify that the enemies are on the map
      for (Entity enemy : enemies) {
         if (!enemy.isInsideMap(map)) {
            clearScreen();
            terminal.writer().println("Enemy out bounded map: " + enemy);
            terminal.flush();
            return;
         }
      }

      // Clear screen and move to top
      clearScreen();
      moveCursor(0, 0);
      
      StringBuilder frame = new StringBuilder();
      
      // draw the map with player and enemies
      for (int i = 0; i < numR; i++) {
         for (int j = 0; j < numC; j++) {
            Position current = new Position(i, j);
            if (player.getPosition().equals(current)) {
               frame.append(player.getRenderSymbol());
            } else {
               // Check if there's an enemy at this position
               boolean enemyFound = false;
               for (Enemy enemy : enemies) {
                  if (enemy.getPosition().equals(current)) {
                     frame.append(enemy.getRenderSymbol());
                     enemyFound = true;
                     break;
                  }
               }
               if (!enemyFound) {
                  frame.append(map.getTile(i, j).getSymbol());
               }
            }
         }
         frame.append("\r\n");
      }
      
      // Add player stats
      frame.append("\r\n");
      frame.append("=== Player Stats ===\r\n");
      frame.append("Position: (").append(player.getPosition().getX())
           .append(", ").append(player.getPosition().getY()).append(")\r\n");
      
      // Show stats if player is a Player type
      if (player instanceof com.zaund.entity.character.Player) {
         com.zaund.entity.character.Player p = (com.zaund.entity.character.Player) player;
         frame.append("Life: ").append(p.getLife()).append("/").append(p.getMaxLife()).append("\r\n");
         frame.append("Power: ").append(p.getPowerStatus()).append("/").append(p.getMaxPower()).append("\r\n");
      }
      
      frame.append("\r\n");
      frame.append("Use WASD to move, Q to quit\r\n");
      
      // Write the entire frame at once
      terminal.writer().print(frame.toString());
      terminal.flush();
   }
   
   public static void close() {
      if (terminal != null) {
         try {
            terminal.close();
         } catch (IOException e) {
            e.printStackTrace();
         }
      }
   }
}
