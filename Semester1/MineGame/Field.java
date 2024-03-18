package Semester1.MineGame;

import javax.swing.*;
import java.awt.*;
enum PlayerMoveDirection{
    UP,RIGHT,LEFT,DOWN
}
/**
 * Manages the minefield grid and player interactions with the field.
 */
public class Field extends JPanel {
  private Coord[][] grid;
  private int fieldSize;
  private Coord player;
  public Field(int fieldSize){
      super(new GridLayout(fieldSize,fieldSize));
      this.fieldSize = fieldSize;

      grid = new Coord[fieldSize][fieldSize];

      for (int y = this.fieldSize-1; y >=0 ; y--) {
          for (int x = 0; x < this.fieldSize; x++) {
              Coord coord = new Coord(x,y);
              grid[x][y] = coord;
              add(coord);
          }
      }
      revalidate();
      repaint();
      player= grid[1][1];
      player.setPlayer(true);
  }

  public void movePlayer( PlayerMoveDirection playerMoveDirection){

      switch (playerMoveDirection){

          case UP:
              assignPlayer(player.getCoordX(),player.getCoordY()+1);
              break;
          case DOWN:
              assignPlayer(player.getCoordX(), player.getCoordY()-1);
              break;
          case LEFT:
              assignPlayer(player.getCoordX()-1, player.getCoordY());
              break;
          case RIGHT:
              assignPlayer(player.getCoordX()+1, player.getCoordY());
              break;
      }
  }

  public void assignPlayer(int px, int py){
      player.setPlayer(false);
      player =grid[px][py];
      player.setPlayer(true);
  }

}
