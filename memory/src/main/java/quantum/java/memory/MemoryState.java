package quantum.java.memory;

import java.awt.Color;
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
			gsm.states.pop();
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(64, 64, 80));
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
	}

	@Override
	public void keyPressed(int k) {
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
		
	}

	@Override
	public void keyReleased(int k) {
		
		
	}
    
}
