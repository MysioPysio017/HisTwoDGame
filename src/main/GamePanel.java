package src.main;

import src.inputs.KeyboardInputs;
import src.inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class GamePanel extends JPanel {
    private float xDelta = 100, yDelta = 100;

    private MouseInputs mouseInputs;

    private BufferedImage img, subImg;
    private BufferedImage[] idleAni;
    private int aniTick, aniIndex, aniSpeed = 15;
    public GamePanel(){
        mouseInputs = new MouseInputs(this);

        importImg();
        loadAnimations();

        setPanelSize();
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        idleAni = new BufferedImage[5];

        for (int i = 0; i< idleAni.length; i++){
            idleAni[i] = img.getSubimage(i*64, 0, 64, 40);
        }
    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/res/player_sprites.png");

        try {
            img = ImageIO.read(is);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                is.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void setPanelSize() {
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
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
    private void updateAnimationTick() {
        aniTick++;
        if (aniTick>=aniSpeed){
            aniTick = 0;
            aniIndex ++;
            if (aniIndex >= idleAni.length){
                aniIndex = 0;
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateAnimationTick();

        g.drawImage(idleAni[aniIndex], (int)xDelta, (int)yDelta, 128, 80, null);
    }

}
