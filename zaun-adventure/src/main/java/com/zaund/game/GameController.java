package com.zaund.game;

import java.util.ArrayList;

import com.zaund.entity.Entity;
import com.zaund.entity.character.Ekko;
import com.zaund.entity.character.Player;
import com.zaund.io.Command;
import com.zaund.io.ConsoleRenderer;
import com.zaund.io.InputHandler;
import com.zaund.map.Map;
import com.zaund.map.MapGenerator;

public class GameController{
   protected MapGenerator mapGenerator;
   protected Map map;
   protected Player player;
   protected GameState state;
   protected ConsoleRenderer render;
   protected ArrayList<Entity> enemies;
   protected InputHandler inputHandler;

   public GameController(){
      mapGenerator = new MapGenerator();
      map = mapGenerator.basicMap();
      player = new Ekko(0,0);
      state = GameState.EXPLORING;
      enemies = new ArrayList<>();
   }

   public void startGame(){
      boolean running = true;
      while(running){
         ConsoleRenderer.render(map, player, enemies);
         Command c = InputHandler.getInput();
         
         switch (c) {
            case MOVE_UP : player.moveUp(); break;
            case MOVE_DOWN : player.moveDown(); break;
            case MOVE_RIGHT : player.moveRight(); break;
            case MOVE_LEFT : player.moveLeft(); break;
            case EXIT : running = false; break;          
            default: System.out.println("Invalid input");
         }
      }
   }


}