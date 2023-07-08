import javax.swing.*;

public class MousePositionTracker {

    private JLabel positionLabel;

    public MousePositionTracker() {
        positionLabel = new JLabel("Mouse Position: -");
    }

    public JLabel getPositionLabel() {
        return positionLabel;
    }

    public void updatePosition(int x, int y) {
        positionLabel.setText("User Current Position: " + "x:" + x + ", " + "y:"+ y);
    }
}