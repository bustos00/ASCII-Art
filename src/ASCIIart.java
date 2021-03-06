import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

public class ASCIIart {

	public static void main(String[] args) {
		
		int width = 100; 
		int height = 30;
		
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

		Graphics g = image.getGraphics();
		g.setFont (new Font("SansSerif", Font.BOLD, 14));

		Graphics2D graphics = (Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, 
				RenderingHints.VALUE_TEXT_ANTIALIAS_ON); 
		
		graphics.drawString("JAVA", 10, 20); 
		
		for(int y =0; y< height; y++) {
			StringBuilder tb = new StringBuilder();
			for(int x = 0; x< width; x++) {
				
				tb.append(image.getRGB(x, y) == -16777216 ? " " : "#");
			} 
			if(tb.toString().trim().isEmpty()) {
				continue;	
			}

			System.out.println(tb);

		} 

	}

}
