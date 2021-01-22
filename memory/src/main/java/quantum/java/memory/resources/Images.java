package quantum.java.memory.resources;



import java.awt.image.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Images {
    
    public Map<String,BufferedImage> images = new HashMap<String,BufferedImage>();
    
    public Images(){
        try {
            BufferedImage image = ImageIO.read(this.getClass().getResourceAsStream("BlauerEngelSiegel.png"));
            images.put("BlauerEngelSiegel",image);
            image = ImageIO.read(this.getClass().getResourceAsStream("BlauerEngelText.png"));
            images.put("BlauerEngelText",image);
		} catch (IOException e) {
			e.printStackTrace();
        }
        try {
            BufferedImage image = ImageIO.read(this.getClass().getResourceAsStream("EuBioSiegel.png"));
            images.put("EuBioSiegel",image);
            image = ImageIO.read(this.getClass().getResourceAsStream("EuBioText.png"));
            images.put("EuBioText",image);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
