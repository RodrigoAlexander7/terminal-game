// abstract class to shepe all the players (heros)
package com.zaund.entity.character;

import com.zaund.entity.character.enemies.Enemy;

public class Ekko extends Player{
   public static final int POWER_LEVEL = 8500;  // the power capacity
   public static final int LIFE_POINTS = 8500;  // the life capacity
   public static final int BASIC_ATACK_POWER = 500;
   public static final int MIDDLE_ATACK_POWER = 1000;
   public static final int MAX_ATACK_POWER = 2000;
   public static final String RENDER_SYMBOL = "⌛";

   public Ekko(int x, int y){
      super(x, y);
      renderSymbol = RENDER_SYMBOL;
      this.powerStatus = POWER_LEVEL;
      this.lifeStatus = LIFE_POINTS;
   }

   public void basicAtack(Enemy enemy){
      System.out.println("Direct hit");
      enemy.receiveAttack(BASIC_ATACK_POWER);
      this.powerStatus -= BASIC_ATACK_POWER / 2;
   }
   public void middleAtack(Enemy enemy){

   }
   public void maxAtack(Enemy enemy){

   }
   public void protect(){

   }
   public void dodgeAtack(){

   }

 
}