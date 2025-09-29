package com.zaund.game;

import java.util.ArrayList;

import com.zaund.entity.Entity;
import com.zaund.entity.character.Ekko;
import com.zaund.entity.character.Enemy;
import com.zaund.entity.character.Player;
import com.zaund.io.Command;
import com.zaund.io.ConsoleRenderer;
import com.zaund.io.InputHandler;
import com.zaund.map.Map;
import com.zaund.map.MapGenerator;
import com.zaund.system.MovementSystem;

public class GameController{
   protected MapGenerator mapGenerator;
   protected Map map;
   protected Player player;
   protected GameState state;
   protected ConsoleRenderer render;
   protected ArrayList<Enemy> enemies;
   protected InputHandler inputHandler;

   public GameController(){
      mapGenerator = new MapGenerator();
      map = mapGenerator.basicMap();
      player = new Ekko(1,1);
      state = GameState.EXPLORING;
      enemies = new ArrayList<Enemy>();
   }

   public void startGame(){
      boolean running = true;
      while(running){
         ConsoleRenderer.render(map, player, enemies);
         Command command = InputHandler.getExploringInput();
         MovementSystem.movePlayer(map, player, enemies, command);
      }
   }
}