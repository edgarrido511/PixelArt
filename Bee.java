import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class Bee {
	
	// Definimos el tamaÃ±o de la imagen en ancho y alto
	private static int width = 800;
    private static int height = 800;
    
    // Definimos el tamaÃƒÂ±o del pixel
    private static int PIXEL_SIZE = 40;
    private static Graphics2D g;
    
    // Definimos los colores a usar
    static Color white 		= Color.white;
    static Color blue  		= Color.blue;
    static Color red = new Color(218,47,91);

    
   
    static BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    
    // Definimos la matriz de colores    
    private final static Color[][] PIXELS = {
        {white, white, 	white, 	white, 	white},
        {white, blue, 	blue, 	blue, 	white},
        {white, blue,	red,	blue, 	white},
        {white, blue, 	blue, 	blue, 	white},
        {white, white, 	white, 	white, 	white}
    };
    
    public static void paint() {
    	drawBackground(PIXEL_SIZE, Color.white);     
        fillRect(3, 5, 9, 5, Color.black);
        drawVerticalLine(6, 8, 2, Color.black);
        putPixel(1,7, Color.black);
        drawVerticalLine(6, 8, 3, Color.yellow);
        drawVerticalLine(5, 9, 5, Color.yellow);
        drawVerticalLine(5, 9, 7, Color.yellow);
        drawVerticalLine(5, 9, 8, Color.yellow);
        drawVerticalLine(5, 9, 9, Color.yellow);
        drawVerticalLine(6, 8, 10, Color.yellow);
        drawHorizontalLine(4, 9, 4, Color.black);
        drawHorizontalLine(4, 9, 10, Color.black);
        putPixel(11,5, Color.white);
        putPixel(11,9, Color.white);
        drawHorizontalLine(3, 9, 3, Color.black);
        drawHorizontalLine(3, 9, 2, Color.black);
        drawHorizontalLine(4, 5, 1, Color.black);
        drawHorizontalLine(7, 8, 1, Color.black);
        drawHorizontalLine(4, 5, 2, Color.gray);
        drawHorizontalLine(7, 8, 2, Color.gray);
        drawHorizontalLine(4, 6, 3, Color.gray);
        putPixel(8, 3, Color.gray);
        putPixel(9, 7, Color.black);
        drawSquareGrid(PIXEL_SIZE, Color.black);
       

        
        // Guardamos la imagen en formato JPG
        try {       
            ImageIO.write(image, "jpg", new File("pixel_art_Bee.jpg"));
            System.out.println("EXITO !!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static void drawVerticalLine(int a, int b, int x, Color c){
   	    g.setColor(c);
    	for(int i=a;i<=b;i++){
    		 putPixel(x, i, c);
        }
    }
    
    private static void drawHorizontalLine(int a, int b, int y, Color c){
    	g.setColor(c);
        for(int i=a;i<=b;i++){
        	 putPixel(i, y, c);
        }
    }
    
    private static void putPixel(int x, int y, Color c){       
	   g.setColor(c);
	   g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);    
    }
    
    private static void fillRect(int x, int y, int width, int height, Color c){
    	g.setColor(c);
    	g.fillRect(x * PIXEL_SIZE, y * PIXEL_SIZE, width*PIXEL_SIZE, height*PIXEL_SIZE);
    }
    
    private static void drawSquareGrid(int size, Color c) {
    	g.setColor(c);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) { 
                g.drawRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);
            }
        }
    }
    private static void drawBackground(int size, Color c) {
    	g.setColor(c);
    	for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                g.fillRect(i * PIXEL_SIZE, j * PIXEL_SIZE, PIXEL_SIZE, PIXEL_SIZE);                
            }
        }
    }    
    
    public static void main(String[] args) {
        g = image.createGraphics();        
        paint();
    }
}
