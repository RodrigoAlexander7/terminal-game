package com.zaund.map;

public class Position{
   private int x;
   private int y;

   public Position(int x, int y){
      this.x = x;
      this.y = y;
   }

   public int getX(){ return x; }
   public int getY(){ return y; }

   public void moveLeft(){ x -= 1; }
   public void moveRight(){ x += 1; }
   public void moveUp(){ y += 1; }
   public void moveDown(){ y -= 1; }

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