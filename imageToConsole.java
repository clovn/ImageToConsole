import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

import javax.imageio.ImageIO;

public class imageToConsole  {
    public static void main(String[] args) throws IOException {
        BufferedImage image = ImageIO.read(new File("image.jpg"));

        int width = image.getWidth();
        int height = image.getHeight();
        ArrayList<String> arr = new ArrayList<>(height+width);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int color = image.getRGB(x, y);
                String colors = ((color & 0xff0000) >> 16) + ";" + ((color & 0xff00) >> 8) + ";" + (color & 0xff);
                arr.add(colors);
            }
        }

        Iterator<String> iter = arr.iterator();

        for(int y = 0; y < height; y++){
            for(int x = 0; x < width; x++){
                String[] strColors = iter.next().split(";");
                System.out.print("\u001B[48;2;" + Integer.valueOf(strColors[0]) + ";" + Integer.valueOf(strColors[1]) + ";" + Integer.valueOf(strColors[2]) + "m  ");
            }
            System.out.println("\u001B[0m");
        }
    }
}