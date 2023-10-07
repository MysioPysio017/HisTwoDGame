package src.main;

import src.inputs.KeyboardInputs;
import src.inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    private int xDelta = 0, yDelta = 0;
    private MouseInputs mouseInputs;
    public GamePanel(){
        mouseInputs = new MouseInputs();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changexDelta(int value){
        xDelta += value;
        repaint();
    }

    public void changeyDelta(int value){
        yDelta += value;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillRect(100 + xDelta, 100 + yDelta, 200, 50);
    }
}
