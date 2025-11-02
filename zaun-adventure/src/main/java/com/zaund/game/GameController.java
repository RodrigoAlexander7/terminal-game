package com.zaund.game;

import java.util.List;
import java.util.ArrayList;

import com.zaund.entity.Entity;
import com.zaund.entity.character.Ekko;
import com.zaund.entity.character.Player;
import com.zaund.entity.character.enemies.Enemy;
import com.zaund.io.Command;
import com.zaund.io.*;
import com.zaund.map.Map;
import com.zaund.map.MapGenerator;
import com.zaund.system.MenuSystem;
import com.zaund.system.MovementSystem;

public class GameController{
   protected MapGenerator mapGenerator;
   protected Map map;
   protected Player player;
   protected GameState state;
   protected ConsoleRenderer render;
   protected List<Enemy> enemies;
   protected InputHandler inputHandler;

   public GameController(){
      mapGenerator = new MapGenerator();
      map = mapGenerator.complexMap();
      player = new Ekko(2,2);
      state = GameState.MENU;
      enemies = new ArrayList<Enemy>();
   }

   public void startGame(){
      boolean running = true;
      try {
         while(running){
            switch (state) {
               case MENU: 
                  Menu.printMenu();
                  Command menuCommand = InputHandler.getMenuInput();
                  state = MenuSystem.menuHandler(menuCommand);
                  if (state == GameState.EXIT) {
                     running = false;
                  }
                  break;
               case EXPLORING: 
                  ConsoleRenderer.render(map, player, enemies);
                  Command command = InputHandler.getExploringInput();
                  
                  if (command == Command.EXIT) {
                     running = false;
                     break;
                  }
                  
                  MovementSystem.movePlayer(map, player, enemies, command);
                  break; 
               default : 
                  running = false;
                  break;           
            }
         }
      } finally {
         // Clean up and close terminal
         ConsoleRenderer.clearScreen();
         ConsoleRenderer.close();
         System.out.println("Game closed. Thanks for playing!");
      }
   }
}