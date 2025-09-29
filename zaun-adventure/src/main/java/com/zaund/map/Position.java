package com.zaund.map;

public class Position{
   private int x;
   private int y;

   public Position(int x, int y){
      this.x = x;
      this.y = y;
   }
   // Constructor to create a copy of other position
   public Position(Position other){
      this.x = other.getX();
      this.y = other.getY();
   }

   public int getX(){ return x; }
   public int getY(){ return y; }

   public void moveLeft(){ y -= 1; }
   public void moveRight(){ y += 1; }
   public void moveUp(){ x -= 1; }
   public void moveDown(){ x += 1; }

   public void customMove(int dx, int dy) {
      x += dx;
      y += dy;
   }
   
   @Override
   public boolean equals(Object obj) {
      if (obj ==null || obj.getClass() != getClass())   return false;
      Position temp = (Position) obj;
      return temp.getX() == getX() && temp.getY() == getY();
   }

}