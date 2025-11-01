// the general abstract class for all (characters -> playable -  and enemys -> no playables)
package com.zaund.entity;

import com.zaund.map.*;;

public abstract class Entity implements Renderable, Movable {
   protected Position position;
   protected String renderSymbol;
   // Attack and defence are just for enemies, characters have special abilities

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

   // type is the name of the class
   public abstract String getType();
   public abstract void receiveAttack(int damage);
   

   //  the @Override inside every kind of character
   // public string toString(){
   //    retur()
   // }
}