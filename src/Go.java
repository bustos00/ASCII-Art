import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

 
public class Go { 
 
    /**
     *Method to make ASCII art.
     * @param str Characters you want to make ASCII art
     * @return StringBuilder Characters that became ASCII art
     */
    public static StringBuilder createAscii(String str) {
 
        //The size of the graphic to generate
        int height =30;
        int width = 200;
        //Drawing start position
        int startX = 2;
        int stratY = 20;
        //Set font
        Font font = new Font("Arial", Font.BOLD, 14);
        StringBuilder sysout = new StringBuilder("\n");
         
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bufferedImage.getGraphics();
         
        //Convert text to graphic
        Graphics2D g = (Graphics2D) graphics;
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(font);
        g.drawString(str, startX, stratY);
         
        //Transcription into ASCII art based on graphic
        for (int y = 0; y < height; y++) {
            StringBuilder stringBuilder = new StringBuilder();
          
            for (int x = 0; x < width; x++) {
                stringBuilder.append(bufferedImage.getRGB(x, y) == -16777216 ? " " : "#");
            }
            if (stringBuilder.toString().trim().isEmpty()) {
                continue;
            }
            sysout.append("\n" + stringBuilder);
        }
        sysout.append("\n");
        return sysout;
    }
    public static void main(String[] args) {
        //Run
        System.out.println(createAscii(" L "));
        System.out.println(createAscii(" H "));
        System.out.println(createAscii(" E "));
        System.out.println(createAscii(" ABCDEFGHIJKLMNOPQRSTUVWXYZ "));
    }
}