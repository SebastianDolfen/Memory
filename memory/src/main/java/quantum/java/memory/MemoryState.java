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
        
		
		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[1], GamePanel.screenSize.height/2+heightpos[0], null);
		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[2], GamePanel.screenSize.height/2+heightpos[0], null);
		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[3], GamePanel.screenSize.height/2+heightpos[0], null);

		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[0], GamePanel.screenSize.height/2+heightpos[1], null);
		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[1], GamePanel.screenSize.height/2+heightpos[1], null);
		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[2], GamePanel.screenSize.height/2+heightpos[1], null);
		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[3], GamePanel.screenSize.height/2+heightpos[1], null);

		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[0], GamePanel.screenSize.height/2+heightpos[2], null);
		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[1], GamePanel.screenSize.height/2+heightpos[2], null);
		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[2], GamePanel.screenSize.height/2+heightpos[2], null);
		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[3], GamePanel.screenSize.height/2+heightpos[2], null);

		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[0], GamePanel.screenSize.height/2+heightpos[3], null);
		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[1], GamePanel.screenSize.height/2+heightpos[3], null);
		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[2], GamePanel.screenSize.height/2+heightpos[3], null);
		g.drawImage(images.images.get("BlauerEngelSiegel").getScaledInstance(Resize(300), Resize(300), 4), GamePanel.screenSize.width/2+widthpos[3], GamePanel.screenSize.height/2+heightpos[3], null);
	}

	@Override
	public void keyPressed(int k) {
		
		
	}

	@Override
	public void keyReleased(int k) {
		
		
	}
    
}
