package quantum.java.memory;

import java.awt.*;

public class Karte {
    Image karte; 
    int size;
    int x;
    int y;
    
    public Karte(Image karte, int size,int x,int y){
        this.karte = karte;
        this.size = size;
        this.x = x;
        this.y = y;
    }
    public void draw(Graphics g){
        g.drawImage(karte.getScaledInstance(size, size, 4),x,y, null);
    }
}
