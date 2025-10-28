package com.zaund.io;

import java.util.Scanner;

import org.jline.terminal.Terminal;

public class InputHandler {

    public static Command getExploringInput() {
        try {
            Terminal terminal = ConsoleRenderer.getTerminal();
            if (terminal == null) {
                return Command.INVALID;
            }
            
            // the int is the code on ascii of the char
            int ch = terminal.reader().read(); // read without enter
            switch (ch) {
                case 'w':
                case 'W': return Command.MOVE_UP;
                case 's':
                case 'S': return Command.MOVE_DOWN;
                case 'a':
                case 'A': return Command.MOVE_LEFT;
                case 'd':
                case 'D': return Command.MOVE_RIGHT;
                case 'q':
                case 'Q': return Command.EXIT;
                case 27:  // ESC key
                    return Command.EXIT;
                default:  return Command.INVALID;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Command.INVALID;
        }
    }
    
    public static Command getMenuInput(){
        System.out.println(">");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine().trim().toLowerCase();
        
        switch (input) {
            case "exit": return Command.EXIT;                
            case "start": return Command.START;                
            default: return Command.INVALID;
        }
    }
}
