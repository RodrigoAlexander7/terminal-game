package com.zaund.map;

public class MapGenerator{
   public Map basicMap(){
      Map basic = new Map(15,45);
      int numR = basic.getNumR();
      int numC = basic.getNumC();
      for(int i = 0; i < numR; i++){
         for(int j = 0 ; i < numC ; j++){
            if(i == 0 || i == numR - 1 || j == 0 || j == numC -1){
               basic.setTile(i, j, Tile.WALL);
            }
         }
      }
      return basic;
   }

}