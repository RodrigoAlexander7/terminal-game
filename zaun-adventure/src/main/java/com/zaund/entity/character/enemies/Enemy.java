// abstract class to shepe all the enemies
package com.zaund.entity.character.enemies;

import com.zaund.entity.Entity;
import com.zaund.entity.character.Player;

public abstract class Enemy extends Entity{
   protected String type;
   protected int life;
   protected boolean isLive;

   public Enemy(int life){
      this.life = life; 
      isLive = true;
   }

   public abstract void basicAtack(Player player);

   public String getType(){ 
      return this.type;
   }

   public void receiveAttack(int attackStat){
      life = life - attackStat;
      if(life <= 0){
         isLive = false;
         System.out.println("You finish the enemy!");
      }
   }

}