package src.main;

import javax.swing.*;

public class GameWindow {
    JFrame jFrame;
    public GameWindow(GamePanel gamePanel){
        jFrame = new JFrame();

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.add(gamePanel);

        jFrame.setResizable(false);

        jFrame.pack();

        jFrame.setVisible(true);
    }
}
