package src.main;

public class Game {

    GameWindow gameWindow;
    GamePanel gamePanel;
    public Game(){
        gamePanel = new GamePanel();
        gameWindow = new GameWindow(gamePanel);
        gamePanel.setFocusable(true);
        //gamePanel.requestFocus();
    }
}
