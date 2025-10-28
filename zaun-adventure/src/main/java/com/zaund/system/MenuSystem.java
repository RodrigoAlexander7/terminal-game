package com.zaund.system;

import com.zaund.game.GameState;
import com.zaund.io.Command;

public class MenuSystem {
   public static GameState menuHandler(Command menuInput){
      switch (menuInput) {
         case START: return GameState.EXPLORING;
         case EXIT: return GameState.EXIT;
         default: return GameState.MENU;
      }
   }
}
