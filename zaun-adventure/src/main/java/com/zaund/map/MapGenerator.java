package com.zaund.map;

public class MapGenerator{
   public Map basicMap(){
      Map basic = new Map(15,45);
      int numR = basic.getNumR();
      int numC = basic.getNumC();
      for(int i = 0; i < numR; i++){
         for(int j = 0 ; j < numC ; j++){
            if(i == 0 || i == numR - 1 || j == 0 || j == numC -1){
               basic.setTile(i, j, Tile.WALL);
            }else{
               basic.setTile(i, j, Tile.FLOOR);
            }
         }
      }
      return basic;
   }

   public Map complexMap(){
      Map complex = new Map(25, 60);
      int numR = complex.getNumR();
      int numC = complex.getNumC();
      
      // Llenar todo con paredes primero
      for(int i = 0; i < numR; i++){
         for(int j = 0; j < numC; j++){
            complex.setTile(i, j, Tile.WALL);
         }
      }
      
      // Crear habitaciones y pasillos
      
      // Habitación superior izquierda
      for(int i = 2; i < 8; i++){
         for(int j = 2; j < 15; j++){
            complex.setTile(i, j, Tile.FLOOR);
         }
      }
      
      // Habitación superior derecha
      for(int i = 2; i < 9; i++){
         for(int j = 45; j < 57; j++){
            complex.setTile(i, j, Tile.FLOOR);
         }
      }
      
      // Habitación inferior izquierda
      for(int i = 15; i < 22; i++){
         for(int j = 3; j < 18; j++){
            complex.setTile(i, j, Tile.FLOOR);
         }
      }
      
      // Habitación inferior derecha
      for(int i = 16; i < 22; i++){
         for(int j = 42; j < 57; j++){
            complex.setTile(i, j, Tile.FLOOR);
         }
      }
      
      // Habitación central
      for(int i = 10; i < 16; i++){
         for(int j = 25; j < 35; j++){
            complex.setTile(i, j, Tile.FLOOR);
         }
      }
      
      // Pasillo horizontal superior
      for(int i = 5; i < 7; i++){
         for(int j = 15; j < 45; j++){
            complex.setTile(i, j, Tile.FLOOR);
         }
      }
      
      // Pasillo vertical izquierdo
      for(int i = 8; i < 15; i++){
         for(int j = 8; j < 11; j++){
            complex.setTile(i, j, Tile.FLOOR);
         }
      }
      
      // Pasillo vertical derecho
      for(int i = 9; i < 16; i++){
         for(int j = 48; j < 51; j++){
            complex.setTile(i, j, Tile.FLOOR);
         }
      }
      
      // Pasillo horizontal inferior
      for(int i = 18; i < 20; i++){
         for(int j = 18; j < 42; j++){
            complex.setTile(i, j, Tile.FLOOR);
         }
      }
      
      // Conectar habitación central con pasillos
      for(int i = 12; i < 14; i++){
         for(int j = 11; j < 25; j++){
            complex.setTile(i, j, Tile.FLOOR);
         }
      }
      
      for(int i = 12; i < 14; i++){
         for(int j = 35; j < 48; j++){
            complex.setTile(i, j, Tile.FLOOR);
         }
      }
      
      // Añadir algunos obstáculos dentro de las habitaciones
      
      // Obstáculos en habitación superior izquierda
      complex.setTile(4, 5, Tile.WALL);
      complex.setTile(4, 6, Tile.WALL);
      complex.setTile(5, 11, Tile.WALL);
      complex.setTile(6, 11, Tile.WALL);
      
      // Obstáculos en habitación superior derecha
      complex.setTile(5, 50, Tile.WALL);
      complex.setTile(5, 51, Tile.WALL);
      complex.setTile(6, 50, Tile.WALL);
      
      // Obstáculos en habitación central
      complex.setTile(12, 28, Tile.WALL);
      complex.setTile(12, 29, Tile.WALL);
      complex.setTile(13, 31, Tile.WALL);
      complex.setTile(13, 32, Tile.WALL);
      
      // Obstáculos en habitación inferior izquierda
      complex.setTile(17, 7, Tile.WALL);
      complex.setTile(18, 7, Tile.WALL);
      complex.setTile(19, 13, Tile.WALL);
      complex.setTile(20, 13, Tile.WALL);
      
      // Obstáculos en habitación inferior derecha
      complex.setTile(18, 47, Tile.WALL);
      complex.setTile(19, 47, Tile.WALL);
      complex.setTile(19, 52, Tile.WALL);
      complex.setTile(20, 52, Tile.WALL);
      
      return complex;
   }
}