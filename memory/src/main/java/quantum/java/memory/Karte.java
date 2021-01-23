package quantum.java.memory;

import java.awt.*;

public class Karte {
    Image karte; 
    Image rückseite;
    int size;
    int x;
    int y;
    boolean flipped;
    
    public Karte(Image karte, int size,int x,int y,Image rückseite){
        this.karte = karte;
        this.size = size;
        this.x = x;
        this.y = y;
        this.flipped = false;
        this.rückseite = rückseite;
    }
    public void draw(Graphics g){
        if (flipped) {
            g.drawImage(karte.getScaledInstance(size, size, 4),x,y, null);
        }
        else{
            g.drawImage(rückseite.getScaledInstance(size, size, 4),x,y, null);
        }
    }
}
