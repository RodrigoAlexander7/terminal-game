// the general abstract class for all (characters -> playable -  and enemys -> no playables)
package com.zaund.entity;

import com.zaund.map.*;;

public abstract class Entity implements Renderable, Movable {
   protected Position position;
   protected String renderSymbol;
   protected final String type;
   protected int life;
   protected int maxLife;
   protected boolean isAlive;

   public Entity(int x, int y, String type, int maxLife){
      if (maxLife <= 0) {
         throw new IllegalArgumentException("Max life must be positive");
      }
      this.position = new Position(x, y);
      this.type = type;
      this.maxLife = maxLife;
      this.life = maxLife;
      this.isAlive = true;
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

   // Getters for common attributes
   public String getType() {
      return this.type;
   }

   public int getLife() {
      return this.life;
   }

   public int getMaxLife() {
      return this.maxLife;
   }

   public boolean isAlive() {
      return this.isAlive;
   }

   // Protected setter for life - only subclasses can modify
   protected void setLife(int life) {
      this.life = Math.max(0, life); // Ensure life never goes negative
      if (this.life <= 0 && this.isAlive) {
         this.isAlive = false;
         onDeath();
      }
   }

   // Hook method for death behavior - subclasses can override
   protected void onDeath() {
      System.out.println(getType() + " has been defeated!");
   }

   public abstract void receiveAttack(int damage);
   

   //  the @Override inside every kind of character
   // public string toString(){
   //    retur()
   // }
}