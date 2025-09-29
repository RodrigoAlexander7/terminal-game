package com.zaund.io;

import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

public class InputHandler {
    private static Terminal terminal;

    static {
        try {
            terminal = TerminalBuilder.terminal();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Command getExploringInput() {
        try {
            int ch = terminal.reader().read(); // read without enter
            switch (ch) {
                case 'w': return Command.MOVE_UP;
                case 's': return Command.MOVE_DOWN;
                case 'a': return Command.MOVE_LEFT;
                case 'd': return Command.MOVE_RIGHT;
                default:  return Command.INVALID;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Command.INVALID;
        }
    }
}
