import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BoardUserInterface extends JPanel {

    private Cube[][] cubes;
    private GameState gameState;
    private GameLogic gameLogic;
    private MousePositionTracker positionTracker;

    public BoardUserInterface(GameState gameState, GameLogic gameLogic) {
        this.gameState = gameState;
        this.gameLogic = gameLogic;
        positionTracker = new MousePositionTracker();
        setLayout(new GridLayout(gameState.getSize() + 1, 1));
        cubes = new Cube[gameState.getSize()][gameState.getSize()];

        for (int i = 0; i < gameState.getSize(); i++) {
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());

            for (int j = 0; j < gameState.getSize(); j++) {
                Cube cube = new Cube(i, j, 0);
                cube.addActionListener(gameLogic);
                cubes[i][j] = cube;
                panel.add(cube);
            }

            // Add borders to the panels for visual separation
            panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, i % 2 == 0 ? 50 : 0));
            add(panel);
        }

        // Add the position label to the layout
        add(positionTracker.getPositionLabel());

        // Add mouse movement listener to track mouse position
        addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                int x = e.getX() - getX();
                int y = e.getY() - getY();
                positionTracker.updatePosition(x, y);
            }
        });

        update();
    }

    public MousePositionTracker getPositionTracker() {
        return positionTracker;
    }

    public void update() {
        for (int i = 0; i < gameState.getSize(); i++) {
            for (int j = 0; j < gameState.getSize(); j++) {
                int status = gameState.getCurrentStatus(i, j);
                cubes[i][j].setType(status);
            }
        }
    }
}
