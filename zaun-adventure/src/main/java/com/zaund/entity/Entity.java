// the general abstract class for all (characters -> playable -  and enemys -> no playables)
package com.zaund.entity;

import com.zaund.map.*;;

public abstract class Entity {
   protected Position position;
   protected String renderSymbol;
   // atack and defence are just for enemys, the characters has especiall habiliities

   public Entity(){
      this.position = new Position(0, 0);
   }

   public Entity(int x, int y){
      this.position = new Position(x, y);
   }

   public Position getPosition() {
      return position;
   }

   public void setPosition(int x, int y) {
      this.position = new Position(x, y);
   }
   public void setPosition(Position position) {
      this.position = position;
   }

   public boolean isInsideMap(Map map){
      // Y -> horizontal movement
      if (position.getY() < map.getNumC() - 1 && position.getY() >=0) return true;
      // X -> vertical movement
      if (position.getX() < map.getNumR() - 1 && position.getX()>= 0) return true;
      return false;
   }

   public String getRenderSymbol(){
      return renderSymbol;
   } 

   public void moveUp(){ this.position.moveUp(); }
   public void moveDown(){ this.position.moveDown(); }
   public void moveRight(){ this.position.moveRight(); }
   public void moveLeft(){ this.position.moveLeft(); }

   //  the @Override inside every kind of character
   // public string toString(){
   //    retur()
   // }
}