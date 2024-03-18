package Semester1.MineGame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class MineGame {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame();
            frame.setFocusable(true);
            frame.requestFocusInWindow();
            Field panel = new Field(11);
            frame.add(panel);
            frame.setSize(800,800);
            frame.setVisible(true);
            // Define actions for each direction
            PlayerMoveDirection[] directions = {PlayerMoveDirection.UP, PlayerMoveDirection.LEFT, PlayerMoveDirection.DOWN, PlayerMoveDirection.RIGHT};
            int[] keyEvents = {KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D};

            for (int i = 0; i < directions.length; i++) {
                PlayerMoveDirection direction = directions[i];
                KeyStroke keyStroke = KeyStroke.getKeyStroke(keyEvents[i], 0);
                Action moveAction = new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.movePlayer(direction);
                    }
                };


                panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, direction);
                panel.getActionMap().put(direction, moveAction);
            }
            panel.repaint();
        });


    }
}
