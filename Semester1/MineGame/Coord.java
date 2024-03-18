package Semester1.MineGame;

import javax.swing.*;
import java.awt.*;

public class Coord extends JButton {
    private boolean isMine = false;
    private boolean isPlayer = false;
    private int x;
    private int y;

    public Coord(int x, int y){
        super();
        setSize(10,10);
        this.x = x;
        this.y=y;
        setText("X");
        setBackground(Color.white);
        setEnabled(false);
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public boolean isPlayer() {
        return isPlayer;
    }

    public void setPlayer(boolean player) {
        if (player){
            setText("P");
            setBackground(Color.blue);
        } else {
            setText("X");
            setBackground(Color.white);
        }
        isPlayer = player;
    }
    public int getCoordX() {
        return x;
    }

    public int getCoordY(){
        return y;
    }
}