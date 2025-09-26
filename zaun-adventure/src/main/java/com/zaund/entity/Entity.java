// the general abstract class for all (characters -> playable -  and enemys -> no playables)
package com.zaund.entity;

import com.zaund.map.*;;

public abstract class Entity {
   protected int life;
   protected Position position;
   // atack and defence are just for enemys, the characters has especiall habiliities

   public Entity(int life){
      this.life = life;
   }
}