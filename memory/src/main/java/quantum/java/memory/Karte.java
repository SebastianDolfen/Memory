package quantum.java.memory;

import java.awt.*;

public class Karte {
    Image karte; 
    Image rückseite;
    int x;
    int y;
    boolean flipped;
    int widthpos;
    int heightpos;
    String name;
    
    public Karte(Image karte, int size,int x,int y,Image rückseite,int widthpos,int heightpos,String name){
        this.karte = karte.getScaledInstance(size, size, 4);
        this.x = x;
        this.y = y;
        this.flipped = false;
        this.widthpos = widthpos;
        this.name = name;
        this.heightpos = heightpos;
        this.rückseite = rückseite.getScaledInstance(size, size, 4);
    }
    public void draw(Graphics g){
        if (flipped) {
            g.drawImage(karte,x,y, null);
        }
        else{
            g.drawImage(rückseite,x,y, null);
        }
    }
}
