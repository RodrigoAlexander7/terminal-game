package com.zaund.map;

public enum Tile{
   WALL('#', false),
   WATHER('~', true);

   private final char symbol;
   private final boolean transitable;
   
   Tile(char symbol, boolean transitable){
      this.symbol = symbol;
      this.transitable = transitable;
   }

   public char getSymbol(){ return this.symbol; }
   public boolean getTransitable(){ return this.transitable; }

}
