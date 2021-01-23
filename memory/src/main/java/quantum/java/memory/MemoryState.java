package quantum.java.memory;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


import quantum.java.memory.resources.Images;

public class MemoryState extends GameState{

	List<Integer> widthpos;
	List<Integer> heightpos;

	Images images;
	List<Karte> karten;

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
				karten.add(new Karte(images.images.get(names.get((4*(i))+(j))),Resize(300),(GamePanel.screenSize.width/2)+widthpos.get(i),(GamePanel.screenSize.height/2)+heightpos.get(j),images.images.get("Rückseite")));
			}
		}
		
		
	}

	@Override
	public void tick() {
		
		
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(new Color(64, 64, 80));
        g.fillRect(0, 0, GamePanel.screenSize.width, GamePanel.screenSize.height);
        for (int i = 0; i < karten.size(); i++) {
			karten.get(i).draw(g);
		}
	}

	@Override
	public void keyPressed(int k) {
		
		
	}

	@Override
	public void keyReleased(int k) {
		
		
	}
    
}
