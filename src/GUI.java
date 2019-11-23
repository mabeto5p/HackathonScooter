import javax.swing.*;
import java.awt.*;

public class GUI implements Observer {
    JFrame frame;
    JLabel label;
    Object object;

    SquareMap squareMap;

    public GUI(SquareMap squareMap){
        object = new Object(1);
        this.squareMap = squareMap;
        initializeGUI();
    }

    public void initializeGUI(){
        frame = new JFrame("is it contained?");
        frame.setSize(400,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        label = new JLabel();
        label.setOpaque(true);
        label.setBackground(new Color( 255,0,0));
        label.setPreferredSize(new Dimension(400, 400));
        frame.getContentPane().add(label, BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void update (Coordinate coordinate) {
        boolean isContained = checkIfCoordinateIsContained(coordinate);
        if (isContained) {
            label.setBackground(new Color(0, 255, 0));
        } else {
            label.setBackground(new Color(255, 0, 0));
        }
        System.out.println(coordinate);
    }

    private boolean checkIfCoordinateIsContained (Coordinate coordinate) {
        return squareMap.isObjectContained(object, coordinate);
    }
}
