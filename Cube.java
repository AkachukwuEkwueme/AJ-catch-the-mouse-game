import javax.swing.JButton;
import javax.swing.ImageIcon;

/**
 * The Cube class represents a cube in the game. It extends JButton.
 */
public class Cube extends JButton {

    private int row;
    private int column;
    private int type;

    /**
     * Constructor for the Cube class.
     *
     * @param row    The row position of the cube.
     * @param column The column position of the cube.
     * @param type   The type of the cube.
     */
    public Cube(int row, int column, int type) {
        this.row = row;
        this.column = column;
        this.type = type;

        // Instantiate variables and set the row position of the cubes
        // YOUR CODE HERE
    }

    /**
     * Sets the type of the cube and sets its icon accordingly.
     *
     * @param type The type of the cube.
     */
    public void setType(int type) {
        if (type == 0) {
            ImageIcon i1 = new ImageIcon("square-0.png");
            this.setIcon(i1);
            // If type is 0, set the icon to an image of a grey cube
        } else if (type == 1) {
            ImageIcon i2 = new ImageIcon("square-1.png");
            this.setIcon(i2);
            // If type is 1, set the icon to an image of a green snake
        } else if (type == 2) {
            ImageIcon i3 = new ImageIcon("square-2.png");
            this.setIcon(i3);
            // If type is 2, set the icon to an image of a red mouse
        }
    }

    /**
     * Getter method for the row attribute.
     *
     * @return The row position of the cube.
     */
    public int getRow() {
        return row;
    }

    /**
     * Getter method for the column attribute.
     *
     * @return The column position of the cube.
     */
    public int getColumn() {
        return column;
    }
}
