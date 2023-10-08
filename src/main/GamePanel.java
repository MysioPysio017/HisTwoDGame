package src.main;

import src.inputs.KeyboardInputs;
import src.inputs.MouseInputs;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class GamePanel extends JPanel {
    private float xDelta = 100, yDelta = 100;

    private float xDir = 0.03f, yDir = 0.03f;

    private int frames = 0;
    private long lastCheck = 0;
    private Color color = new Color(20, 50, 80);
    private Random random;

    private MouseInputs mouseInputs;
    public GamePanel(){
        random = new Random();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changexDelta(int value){
        this.xDelta += value;

    }

    public void changeyDelta(int value){
        this.yDelta += value;

    }

    public void setRectPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        updateRecktangle();
        g.setColor(color);
        g.fillRect((int)xDelta, (int)yDelta, 200, 50);

        frames ++;
        if(System.currentTimeMillis() - lastCheck >= 1000){
            lastCheck = System.currentTimeMillis();
            System.out.println("FPS: " + frames);
            frames = 0;
        }
        repaint();
    }
    private  void updateRecktangle(){
        xDelta += xDir;
        if (xDelta > 400 || xDelta < 0) {
            xDir *= -1;
            color = newRandColor();
        }

        yDelta += yDir;
        if (yDelta > 400 || yDelta < 0) {
            yDir *= -1;
            color = newRandColor();
        }
    }

    private Color newRandColor() {
        int r = random.nextInt(255);
        int g = random.nextInt(255);
        int b = random.nextInt(255);

        return new Color(r,g,b);
    }
}
