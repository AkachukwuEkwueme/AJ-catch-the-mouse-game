import java.util.Random;

/**
 * The GameState class represents the state of the game.
 */
public class GameState {
    public static final int FREE_CUBE = 0;
    public static final int SELECTED = 1;
    public static final int RED_CUBE = 2;

    private int boardSize;
    private int[][] cubeCube;
    private Point redCube;

    public GameState(int size) {
        boardSize = size;
        cubeCube = new int[size][size];
        initializeCubes();
        randomizeGreenCubes();
        randomizeRedCube();
    }

    public int getSize() {
        return boardSize;
    }

    public int getCurrentStatus(int i, int j) {
        return cubeCube[i][j];
    }

    public void select(int i, int j) {
        cubeCube[i][j] = SELECTED;
    }

    public void setCube(int i, int j) {
        cubeCube[i][j] = RED_CUBE;
        cubeCube[redCube.getX()][redCube.getY()] = FREE_CUBE;
        redCube.reset(i, j);
    }

    public int mouseRandom() {
        Random random = new Random();
        boolean flag = true;

        while (flag) {
            int x = random.nextInt(boardSize);
            int y = random.nextInt(boardSize);

            if (cubeCube[x][y] != SELECTED) {
                flag = false;
                cubeCube[x][y] = RED_CUBE;
                cubeCube[redCube.getX()][redCube.getY()] = FREE_CUBE;
                redCube.reset(x, y);
            }
        }

        return cubeCube[redCube.getX()][redCube.getY()];
    }

    public Point getCurrentCube() {
        return redCube;
    }

    private void initializeCubes() {
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                cubeCube[i][j] = FREE_CUBE;
            }
        }
    }

    private void randomizeGreenCubes() {
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            int x = random.nextInt(boardSize);
            int y = random.nextInt(boardSize);
            cubeCube[x][y] = SELECTED;
        }
    }

    private void randomizeRedCube() {
        Random random = new Random();
        int x, y;

        if (boardSize % 2 == 0) {
            x = random.nextInt(boardSize / 2) + boardSize / 2 - 1;
            y = random.nextInt(boardSize / 2) + boardSize / 2 - 1;
        } else {
            x = random.nextInt(boardSize / 2 + 1) + boardSize / 2 - 1;
            y = random.nextInt(boardSize / 2 + 1) + boardSize / 2 - 1;
        }

        cubeCube[x][y] = RED_CUBE;
        redCube = new Point(x, y);
    }
}
