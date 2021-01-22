package quantum.java.memory;

import java.awt.Color;
import java.awt.Graphics;

import quantum.java.memory.resources.Images;

public class MemoryState extends GameState{

	int[] widthpos = {Resize(-400),Resize(0),Resize(400),Resize(800)};
	int[] heightpos = {Resize(-675),Resize(-325),Resize(25),Resize(375)};

    Images images;

	protected MemoryState(GameStateManager gsm) {
		super(gsm);
		
	}

	@Override
	public void init() {
		images = new Images();
		
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(64, 64, 80));
        g.fillRect(0, 0, GamePanel.screenSize.width, GamePanel.screenSize.height);
        
		g.setColor(green);
		g.drawRect(0, 0, 300, 300);
	}

	@Override
	public void keyPressed(int k) {
		
		
	}

	@Override
	public void keyReleased(int k) {
		
		
	}
    
}
