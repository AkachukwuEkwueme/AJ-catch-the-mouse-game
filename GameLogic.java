import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.util.*;
import java.awt.GridLayout;

/**
 * The GameLogic class implements the ActionListener interface to handle player moves and game logic.
 * It calculates the next step of the game and updates the state and user interface.
 */
public class GameLogic implements ActionListener {

    private int size;
    private GameUserInterface g;
    private GameState state;
    private BoardUserInterface boardInterface;

    public GameLogic(int size) {
        this.size = size;
        state = new GameState(size);
        g = new GameUserInterface(state, this);
        boardInterface = g.getBoardUserInterface();
        // Create game state and user interface instances
    }

    /**
     * Starts the game.
     */
    public void start() {
        boardInterface.update();
        // Update the board user interface
    }

    /**
     * Resets the game.
     */
    public void reset() {
        g.getFrme().dispose();
        state = new GameState(size);
        g = new GameUserInterface(state, this);
        g.getBoardUserInterface().update();
        // Dispose the game frame, create new game state and user interface, and update the board user interface
    }

    public void actionPerformed(ActionEvent e) {
        Cube click;

        if (e.getSource() == g.getQuit()) {
            System.exit(1);
        } else if (e.getSource() == g.getReset()) {
            reset();
        } else {
            if (e.getSource() instanceof Cube) {
                click = (Cube) e.getSource();

                int cubeX = click.getRow();
                int cubeY = click.getColumn();

                if (state.getCurrentStatus(cubeX, cubeY) == GameState.FREE_CUBE) {
                    if ((cubeX + 1 < state.getSize() && (state.getCurrentStatus(cubeX + 1, cubeY) == GameState.SELECTED) ||
                            (cubeX > 0) && (state.getCurrentStatus(cubeX - 1, cubeY) == GameState.SELECTED) ||
                            (cubeY > 0) && (state.getCurrentStatus(cubeX, cubeY - 1) == GameState.SELECTED) ||
                            (cubeY + 1 < state.getSize()) && (state.getCurrentStatus(cubeX, cubeY + 1) == GameState.SELECTED) ||
                            (cubeY + 1 < state.getSize()) && (state.getCurrentStatus(cubeX + 1, cubeY + 1) == GameState.SELECTED) ||
                            (cubeX > 0) && (state.getCurrentStatus(cubeX - 1, cubeY - 1) == GameState.SELECTED) ||
                            (cubeY > 0) && (state.getCurrentStatus(cubeX + 1, cubeY - 1) == GameState.SELECTED) ||
                            (cubeY + 1 < state.getSize()) && (state.getCurrentStatus(cubeX - 1, cubeY + 1) == GameState.SELECTED))) {

                        state.select(cubeX, cubeY);
                        click.setType(GameState.SELECTED);
                        state.mouseRandom();
                    }
                } else if (state.getCurrentStatus(cubeX, cubeY) == GameState.RED_CUBE) {
                    if ((cubeX + 1 < state.getSize()) && (state.getCurrentStatus(cubeX + 1, cubeY) == GameState.SELECTED) ||
                            (cubeX > 0) && (state.getCurrentStatus(cubeX - 1, cubeY) == GameState.SELECTED) ||
                            (cubeY > 0) && (state.getCurrentStatus(cubeX, cubeY - 1) == GameState.SELECTED) ||
                            (cubeY + 1 < state.getSize()) && (state.getCurrentStatus(cubeX, cubeY + 1) == GameState.SELECTED) ||
                            (cubeY + 1 < state.getSize()) && (state.getCurrentStatus(cubeX + 1, cubeY + 1) == GameState.SELECTED) ||
                            (cubeX > 0) && (state.getCurrentStatus(cubeX - 1, cubeY - 1) == GameState.SELECTED) ||
                            (cubeY > 0) && (state.getCurrentStatus(cubeX + 1, cubeY - 1) == GameState.SELECTED) ||
                            (cubeY + 1 < state.getSize()) && (state.getCurrentStatus(cubeX - 1, cubeY + 1) == GameState.SELECTED)) {
                        JOptionPane.showMessageDialog(null, "You WIN!! Press OK to restart or press Quit!");
                        reset();
                        return;
                    }
                }
            }

            g.getBoardUserInterface().update();
            g.repaint();

            Point redCube = state.getCurrentCube();
            int redCubeX = redCube.getX();
            int redCubeY = redCube.getY();

            g.getBoardUserInterface().update();
            boardInterface.repaint();

            if (redCubeX == 0 || redCubeX == size - 1 || redCubeY == 0 || redCubeY == size - 1) {
                JOptionPane.showMessageDialog(null, "You have Lost!");
                reset();
                return;
            }
        }
    }
}
