package quantum.java.memory;

import java.awt.Color;
import java.awt.Graphics;

import quantum.java.memory.resources.Images;

public class MemoryState extends GameState{

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
        
        g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), 0, 0, null);
		
	}

	@Override
	public void keyPressed(int k) {
		
		
	}

	@Override
	public void keyReleased(int k) {
		
		
	}
    
}
