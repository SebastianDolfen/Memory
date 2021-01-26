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
        addImage("EuBioText", "EuBioText.png");
        addImage("FairtradeSiegel", "FairtradeSiegel.png");
        addImage("FairtradeText","FairtradeText.png");
        addImage("FairwearSiegel", "FairwearSiegel.png");
        addImage("FairwearText", "FairwearText.png");
        addImage("FscSiegel", "FscSiegel.png");
        addImage("FscText","FscText.png");
        addImage("MscSiegel", "MscSiegel.png");
        addImage("MscText","MscText.png");
        addImage("NaturlandSiegel", "NaturlandSiegel.png");
        addImage("NaturlandText", "NaturlandText.png");
        addImage("PefcSiegel", "PefcSiegel.png");
        addImage("PefcText", "PefcText.png");
        addImage("Rückseite","Rueckseite.png");
        addImage("Pfeiltasten","Pfeiltasten.png");
        addImage("ESC","ESC.png");
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
