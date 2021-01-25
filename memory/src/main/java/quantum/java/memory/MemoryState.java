package quantum.java.memory;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import quantum.java.memory.resources.Images;

public class MemoryState extends GameState{

	List<Integer> widthpos;
	List<Integer> heightpos;

	int currentWidthPos = 0;
	int currentHeightPos = 0;

	Images images;
	List<Karte> karten;
	List<Karte> foundCards = new ArrayList<Karte>();

	int activeCards = 0;
	Karte card1;
	Karte card2;
	int wait = 0;
	int errorwait = 0;

	boolean error = false;
	boolean win = false;
	boolean pause = false;

	String[] pauseOptions = {"Fortfahren","Beenden"};
	int currentPauseSelection = 0;

	int restCards = 16;

	int match = 0;

	protected MemoryState(GameStateManager gsm) {
		super(gsm);
		
	}

	@Override
	public void init() {
		images = new Images();
		List<String> names = new ArrayList<String>();
		names.add("BlauerEngelSiegel");
		names.add("BlauerEngelText");
		names.add("EuBioSiegel");
		names.add("EuBioText");
		names.add("FairtradeSiegel");
		names.add("FairtradeText");
		names.add("FairwearSiegel");
		names.add("FairwearText");
		names.add("FscSiegel");
		names.add("FscText");
		names.add("MscSiegel");
		names.add("MscText");
		names.add("NaturlandSiegel");
		names.add("NaturlandText");
		names.add("PefcSiegel");
		names.add("PefcText");

		Collections.shuffle(names);

		//{Resize(-400),Resize(0),Resize(400),Resize(800)};
		//{Resize(-675),Resize(-325),Resize(25),Resize(375)};

		karten = new ArrayList<Karte>();

		widthpos = new ArrayList<Integer>();
		heightpos = new ArrayList<Integer>();

		

		widthpos.add(Resize(-400));
		widthpos.add(Resize(0));
		widthpos.add(Resize(400));
		widthpos.add(Resize(800));

		heightpos.add(Resize(-675));
		heightpos.add(Resize(-325));
		heightpos.add(Resize(25));
		heightpos.add(Resize(375));

		for (int i = 0; i < widthpos.size(); i++) {
			for (int j = 0; j < heightpos.size(); j++) {
				karten.add(new Karte(images.images.get(names.get((4*(i))+(j))),Resize(300),(GamePanel.screenSize.width/2)+widthpos.get(i),(GamePanel.screenSize.height/2)+heightpos.get(j),images.images.get("Rückseite"),i,j,names.get((4*(i))+(j))));
			}
		}
		
		
	}

	@Override
	public void tick() {
		if (match==2) {
				

			if (wait < 120) {
				wait++;
			}
			else{
				card1.flipped=false;
				card2.flipped=false;
				match = 0;
				wait = 0;
				activeCards=0;
			}
				
		}
		else if(match==1){
			restCards = restCards-2;
			foundCards.add(card1);
			foundCards.add(card2);
			match = 0;
			activeCards=0;
		}
			
		if (error) {
			if (errorwait < 60) {
				errorwait++;
			}
			else{
				error = false;
				errorwait = 0;
			}
		}
		if (restCards==0) {
			win = true;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(37, 42, 51));
		g.fillRect(0, 0, GamePanel.screenSize.width, GamePanel.screenSize.height);
		if (error) {
			g.setColor(new Color(191,97,106));
		}
		else{
			g.setColor(green);
		}
		g.fillRect((((GamePanel.screenSize.width/2)+widthpos.get(currentWidthPos))-Resize(25)), (((GamePanel.screenSize.height/2)+heightpos.get(currentHeightPos))-Resize(25)), Resize(350), Resize(350));
        for (int i = 0; i < karten.size(); i++) {
			karten.get(i).draw(g);
		}
		if(pause){
			g.setColor(new Color(0,0,0,150));
			g.fillRect(0, 0, GamePanel.screenSize.width, GamePanel.screenSize.height);
			
			g.setColor(new Color(50,56,68));
			g.fillRect(0, (GamePanel.screenSize.height/2)-Resize(400), GamePanel.screenSize.width, Resize(800));
			for (int i = 0; i < pauseOptions.length; i++) {
				if (i==currentPauseSelection) {
					g.setColor(green);
				}
				else{
					g.setColor(Color.WHITE);
				}
				g.setFont(new Font("TimesRoman", Font.PLAIN, Resize(30)));
				g.drawString(pauseOptions[i], GamePanel.screenSize.width/2-(g.getFontMetrics().stringWidth(pauseOptions[i])/2), (GamePanel.screenSize.height/2)-(Resize(50))+(i*(GamePanel.screenSize.height/10)));
	
			}
			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.PLAIN, Resize(100)));
			g.drawString("Pause", GamePanel.screenSize.width/2-(g.getFontMetrics().stringWidth("Pause")/2), (GamePanel.screenSize.height/2)-(Resize(250)));
		}
		if(win){
			g.setColor(new Color(0,0,0,150));
			g.fillRect(0, 0, GamePanel.screenSize.width, GamePanel.screenSize.height);
			
			g.setColor(new Color(50,56,68));
			g.fillRect(0, (GamePanel.screenSize.height/2)-Resize(400), GamePanel.screenSize.width, Resize(800));

			g.setColor(Color.WHITE);
			g.setFont(new Font("TimesRoman", Font.PLAIN, Resize(100)));
			g.drawString("Gewonnen", GamePanel.screenSize.width/2-(g.getFontMetrics().stringWidth("Gewonnen")/2), (GamePanel.screenSize.height/2)-(Resize(250)));
			g.setFont(new Font("TimesRoman", Font.PLAIN, Resize(30)));
			g.drawString("Drücke irgendeine Taste zum fortfahren", GamePanel.screenSize.width/2-(g.getFontMetrics().stringWidth("Drücke irgendeine Taste zum fortfahren")/2), (GamePanel.screenSize.height/2));
		}
	}

	@Override
	public void keyPressed(int k) {
		if (!pause) {
			if (k==KeyEvent.VK_UP||k==KeyEvent.VK_W) {
				if (currentHeightPos==0) {
					currentHeightPos=3;
				}
				else{
					currentHeightPos--;
				}
			}
			else if(k==KeyEvent.VK_DOWN||k==KeyEvent.VK_S){
				if (currentHeightPos==3) {
					currentHeightPos=0;
				}
				else{
					currentHeightPos++;
				}
			}
			else if(k==KeyEvent.VK_LEFT||k==KeyEvent.VK_A){
				if (currentWidthPos==0) {
					currentWidthPos=3;
				}
				else{
					currentWidthPos--;
				}
			}
			else if(k==KeyEvent.VK_RIGHT||k==KeyEvent.VK_D){
				if (currentWidthPos==3) {
					currentWidthPos=0;
				}
				else{
					currentWidthPos++;
				}
			}
			else if(k==KeyEvent.VK_ENTER||k==KeyEvent.VK_SPACE){
				for (int i = 0; i < karten.size(); i++) {
					if (karten.get(i).heightpos==currentHeightPos&&karten.get(i).widthpos==currentWidthPos) {
						if (karten.get(i).flipped==true) {
							error = true;
						}
						else{
							if (activeCards==0) {
								karten.get(i).flipped=true;
								card1 = karten.get(i);
								activeCards++;
							}
							else if(activeCards==1){
								karten.get(i).flipped=true;
								activeCards++;
								if (card1.name.replace("Text", "").replace("Siegel", "").equals(karten.get(i).name.replace("Text", "").replace("Siegel", ""))) {
									match = 1;
									card2 = karten.get(i);
								}
								else{
									match = 2;
									card2 = karten.get(i);
								
								}
								
							}
							else{
								error = true;
							}
						}
						
					}
				}
			}
			if(win){
				gsm.states.pop();
			}
			if(k==KeyEvent.VK_ESCAPE){
				pause = true;
			}
		}
		else if(pause){
			if (k==KeyEvent.VK_UP||k==KeyEvent.VK_W) {
				if (currentPauseSelection==0) {
					currentPauseSelection=1;
				}
				else{
					currentPauseSelection--;
				}
			}
			else if(k==KeyEvent.VK_DOWN||k==KeyEvent.VK_S){
				if (currentPauseSelection==1) {
					currentPauseSelection=0;
				}
				else{
					currentPauseSelection++;
				}
			}
			else if(k==KeyEvent.VK_ENTER){
				if (currentPauseSelection==0) {
					pause=false;
				}
				else{
					gsm.states.pop();
				}
			}
			else if(k==KeyEvent.VK_ESCAPE){
				pause = false;
			}
		}
		
		
		
	}

	@Override
	public void keyReleased(int k) {
		
		
	}
    
}
