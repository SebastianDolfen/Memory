package quantum.java.memory;

import java.awt.Graphics;

import quantum.java.memory.resources.Images;

import java.awt.Color;

public abstract class GameState {
    
    protected GameStateManager gsm;
    protected Color green = new Color(22, 160, 133);

    protected GameState(GameStateManager gsm) {
        this.gsm = gsm;
        init();
    }

    public abstract void init();
    public abstract void tick(); 
    public abstract void draw(Graphics g);
    public abstract void keyPressed(int k);
    public abstract void keyReleased(int k);

    public int Resize(int size){
        double screen = GamePanel.screenSize.width;
		return (int) (size*(screen/2560));
		
	}

}