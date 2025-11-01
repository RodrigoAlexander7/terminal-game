// Ekko character class - implements the time manipulator hero
package com.zaund.entity.character;

import com.zaund.entity.Entity;

public class Ekko extends Player{
   public static final int POWER_LEVEL = 8500;  // The power capacity
   public static final int LIFE_POINTS = 8500;  // The life capacity
   public static final int BASIC_ATTACK_POWER = 500;
   public static final int MIDDLE_ATTACK_POWER = 1000;
   public static final int MAX_ATTACK_POWER = 2000;
   public static final String RENDER_SYMBOL = "⌛";

   public Ekko(int x, int y){
      super(x, y);
      renderSymbol = RENDER_SYMBOL;
      this.powerStatus = POWER_LEVEL;
      this.lifeStatus = LIFE_POINTS;
   }

   @Override
   public void basicAttack(Entity entity){
      System.out.println("Direct hit");
      entity.receiveAttack(BASIC_ATTACK_POWER);
      this.powerStatus -= BASIC_ATTACK_POWER / 2;
   }
   
   @Override
   public void middleAttack(Entity entity){
      System.out.println("Strong hit");
      entity.receiveAttack(MIDDLE_ATTACK_POWER);
      this.powerStatus -= MIDDLE_ATTACK_POWER / 2;

   }
   
   @Override
   public void maxAttack(Entity entity){
      System.out.println("Maximum hit");
      entity.receiveAttack(MAX_ATTACK_POWER);
      this.powerStatus -= MAX_ATTACK_POWER / 2;  
   }
   
   @Override
   public void protect(){

   }
   
   @Override
   public void dodgeAttack(){

   }
   public String getType(){
      return "Ekko";
   }
}