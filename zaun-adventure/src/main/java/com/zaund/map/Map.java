package com.zaund.map;

public class Map{
   private Tile[][] grid;
   private int numR; //number of rows
   private int numC; //number of columns

   public Map(int numR, int numC){
      this.grid = new Tile[numR][numC];
      this.numR = numR;
      this.numC = numC;
   }

   public int getNumR(){ return numR; }

   public int getNumC(){ return numC; }

   public boolean isPositionTransitable(int row, int col){
      return grid[row][col].getTransitable();
   }

   public Tile getTile(int row, int col){
      return grid[row][col];
   }

   public Tile getTile(Position position){
      return grid[position.getX()][position.getY()];
   }

   public void setTile(int row, int col, Tile tile){
      grid[row][col] = tile;
   }
}