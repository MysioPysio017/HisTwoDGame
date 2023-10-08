package src.inputs;

import src.main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                gamePanel.changeyDelta(-5);
                break;
            case KeyEvent.VK_S:
                gamePanel.changeyDelta(5);
                break;
            case KeyEvent.VK_A:
                gamePanel.changexDelta(-5);
                break;
            case KeyEvent.VK_D:
                gamePanel.changexDelta(5);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
