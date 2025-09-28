// the general abstract class for all (characters -> playable -  and enemys -> no playables)
package com.zaund.entity;

import com.zaund.map.*;;

public abstract class Entity {
   protected int life;
   protected Position position;
   protected String renderSymbol;
   // atack and defence are just for enemys, the characters has especiall habiliities

   public Entity(int life){
      this.life = life;
   }

   public Position getPosition() {
      return position;
   }

   public boolean isInsideMap(Map map){
      if (position.getX() < map.getNumR() - 1) return true;
      return false;
   }

   public String getRenderSymbol(){
      return renderSymbol;
   } 

   //  the @Override inside every kind of character
   // public string toString(){
   //    retur()
   // }
}