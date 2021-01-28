package quantum.java.memory;

import java.awt.event.KeyEvent;

import quantum.java.memory.resources.Images;

import java.awt.*;

public class MenuState extends GameState {

	private String[] options = {"Spielen","Beenden"};
	private int currentSelection = 0;
	private int fontSize = Resize(30);
	Images images;
	Image controls;

	protected MenuState(GameStateManager gsm) {
		super(gsm);
	}

	@Override
	public void init() {
		images = new Images();

		controls = images.images.get("Pfeiltasten").getScaledInstance((int)Resize(325), (int)Resize(178), 4);

	}

	@Override
	public void tick() {
		
	}

	@Override
	public void draw(Graphics g) {
        g.setColor(new Color(37, 42, 51));
		g.fillRect(0, 0, GamePanel.screenSize.width, GamePanel.screenSize.height);
		g.setColor(Color.WHITE);
		g.setFont(new Font("TimesRoman", Font.PLAIN, 150));
		g.drawImage(controls,(GamePanel.screenSize.width-controls.getWidth(null))-50,(GamePanel.screenSize.height-controls.getHeight(null))-50,null);
		g.drawString("Memory", GamePanel.screenSize.width/2-(g.getFontMetrics().stringWidth("Memory")/2), GamePanel.screenSize.height/4-(Resize(100)));
		for (int i = 0; i < options.length; i++) {
			if (i==currentSelection) {
				g.setColor(green);
			}
			else{
				g.setColor(Color.WHITE);
			}
			g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
			g.drawString(options[i], GamePanel.screenSize.width/2-(g.getFontMetrics().stringWidth(options[i])/2), GamePanel.screenSize.height/3+(Resize(150))+(i*(GamePanel.screenSize.height/10)));

		}
	}

	@Override
	public void keyPressed(int k) {
		if (k==KeyEvent.VK_DOWN||k==KeyEvent.VK_S) {
			if (currentSelection>=1) {
				currentSelection=0;
			} else {
				currentSelection++;
			}
		}
		else if (k==KeyEvent.VK_UP||k==KeyEvent.VK_W) {
			if (currentSelection<=0) {
				currentSelection=1;
			} else {
				currentSelection--;
			}
		}
		else if(k==KeyEvent.VK_ENTER||k==KeyEvent.VK_SPACE){
			if (currentSelection==1) {
				System.exit(0);
			}
			else if(currentSelection == 0){
				gsm.states.push(new MemoryState(gsm));
			}
		}
		
		
		
	}

	@Override
	public void keyReleased(int k) {
	
		
	}

	
    
}
