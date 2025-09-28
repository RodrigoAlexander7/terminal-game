package com.zaund.io;

import java.util.Scanner;

public class InputHandler{
   private static final Scanner scanner = new Scanner(System.in);

   public static Command getInput(){
      System.out.println("> ");
      String input = scanner.nextLine().trim().toLowerCase();

      switch (input) {
         case "w": return Command.MOVE_UP;
         case "s": return Command.MOVE_DOWN;
         case "a": return Command.MOVE_LEFT;
         case "d": return Command.MOVE_RIGHT;
         case "start": return Command.START;
         case "exit": return Command.EXIT;    
         default: return Command.INVALID;
      }
   }
}