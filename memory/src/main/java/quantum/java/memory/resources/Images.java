package quantum.java.memory.resources;



import java.awt.image.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Images {
    
    public Map<String,BufferedImage> images = new HashMap<String,BufferedImage>();
    
    public Images(){
        addImage("BlauerEngelSiegel", "BlauerEngelSiegel.png");
        addImage("BlauerEngelText", "BlauerEngelText.png");
        addImage("EuBioSiegel", "EuBioSiegel.png");
        
    }

    private void addImage(String name,String data){
        try {
            BufferedImage image = ImageIO.read(this.getClass().getResourceAsStream(data));
            images.put(name,image);
		} catch (IOException e) {
			e.printStackTrace();
        }
    }
}
