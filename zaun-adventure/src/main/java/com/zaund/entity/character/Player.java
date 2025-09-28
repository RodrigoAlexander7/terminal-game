// abstract class to shepe all the players (heros)
package com.zaund.entity.character;

import com.zaund.entity.Entity;

public abstract class Player extends Entity{
   public int powerStatus;  // the power level capacity status | based on every kind of player (eg:ekko)
   public int lifeStatus;   // the live capacity status
   public boolean isProtected; // if is protected avoid enemy atacs
   public boolean isDodgeAtack; // if is dodge there are probabilities that not take damage

   public abstract void basicAtack(Enemy enemy);
   public abstract void middleAtack(Enemy enemy);
   public abstract void maxAtack(Enemy enemy);
   public abstract void protect();
   public abstract void dodgeAtack();
}