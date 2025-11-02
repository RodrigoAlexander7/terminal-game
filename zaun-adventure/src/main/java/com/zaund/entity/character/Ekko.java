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
   public static final String TYPE = "Ekko";

   public Ekko(int x, int y){
      super(x, y, TYPE, LIFE_POINTS, POWER_LEVEL);
      renderSymbol = RENDER_SYMBOL;
   }

   @Override
   public void basicAttack(Entity entity){
      System.out.println("Direct hit");
      entity.receiveAttack(BASIC_ATTACK_POWER);
      setPowerStatus(getPowerStatus() - BASIC_ATTACK_POWER / 2);
   }
   
   @Override
   public void middleAttack(Entity entity){
      System.out.println("Strong hit");
      entity.receiveAttack(MIDDLE_ATTACK_POWER);
      setPowerStatus(getPowerStatus() - MIDDLE_ATTACK_POWER / 2);
   }
   
   @Override
   public void maxAttack(Entity entity){
      System.out.println("Maximum hit");
      entity.receiveAttack(MAX_ATTACK_POWER);
      setPowerStatus(getPowerStatus() - MAX_ATTACK_POWER / 2);
   }
   
   @Override
   public void protect(){

   }
   
   @Override
   public void dodgeAttack(){

   }

   @Override
   public int getAttackPower() {
      return BASIC_ATTACK_POWER;
   }
}