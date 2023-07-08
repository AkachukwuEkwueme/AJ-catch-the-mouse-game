public class Main {
    public static void main(String[] args) {
        GameState gameState = new GameState(8); // Set the size of the game board
        GameLogic gameLogic = new GameLogic(gameState.getSize());
        gameLogic.start();
    }
}