package Semester1.MineGame;

// Import necessary libraries for GUI and event handling
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

// Main class for the MineGame
public class MineGame {
    public static void main(String[] args) {

        // Ensures that the GUI is created in the Event Dispatch Thread (EDT)
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame(); // Creates a new window
            frame.setFocusable(true); // Allows the frame to gain focus to receive key events
            frame.requestFocusInWindow(); // Requests focus for key event handling
            Field panel = new Field(11,10); // Creates the game panel with specified field size and amount of mines
            frame.add(panel); // Adds the game panel to the frame
            frame.setSize(800,800); // Sets the size of the frame
            frame.setVisible(true); // Makes the frame visible

            // Array to hold the direction of player movements
            PlayerMoveDirection[] directions = {PlayerMoveDirection.UP, PlayerMoveDirection.LEFT, PlayerMoveDirection.DOWN, PlayerMoveDirection.RIGHT};
            // Array to hold the keyboard keys associated with each direction
            int[] keyEvents = {KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D};

            // Loop through each direction
            for (int i = 0; i < directions.length; i++) {
                PlayerMoveDirection direction = directions[i]; // Get the direction
                KeyStroke keyStroke = KeyStroke.getKeyStroke(keyEvents[i], 0); // Create a keystroke for the corresponding key event

                // Create an action to move the player in the given direction when the key is pressed
                Action moveAction = new AbstractAction() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        panel.movePlayer(direction); // Moves the player in the specified direction
                    }
                };

                // Bind the keystroke to the action in the input map
                panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(keyStroke, direction);
                // Bind the direction to the move action in the action map
                panel.getActionMap().put(direction, moveAction);
            }
            panel.repaint(); // Refreshes the panel to update the player's position
        });


    }
}
