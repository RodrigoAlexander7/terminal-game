// abstract class to shepe all the players (heros)
package com.zaund.entity.character;

import com.zaund.entity.Entity;

public abstract class Enemy extends Entity{
   protected int life;
   protected boolean isLive;

   public Enemy(int life){
      this.life = life; 
      isLive = true;
   }

   public abstract void basicAtack(Player player);
   
   public void receiveAttack(int attackStat){
      life = life - attackStat;
      if(life <= 0){
         isLive = false;
         System.out.println("You finish the enemy!");
      }
   }

}