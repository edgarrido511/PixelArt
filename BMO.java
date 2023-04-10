import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class BMO {
	
	// Definimos el tamaÃ±o de la imagen en ancho y alto
	private static int width = 800;
    private static int height = 800;
    
    // Definimos el tamaÃƒÂ±o del pixel
    private static int PIXEL_SIZE = 40;
    private static Graphics2D g;
    
    // Definimos los colores a usar
    static Color white 		= Color.white;
    static Color blue  		= Color.blue;
    static Color greenAcqua 	= new Color(113,165,152); 
    static Color softGreen 	= new Color(206,253,209);
    static Color darkGreen = new Color(38,55,49);
    static Color darkBlue = new Color(29,6,158);
    static Color yellow = new Color(230,203,79);
    static Color green = new Color(105,229,83);
    static Color red = new Color(218,47,91);
    static Color softBlue = new Color(93,196,211);
    
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
        drawHorizontalLine(4, 14, 1, Color.black);
        for(int i = 2; i <= 15;i++) {
        	drawHorizontalLine(3, 15, i, Color.black);
        }
        drawHorizontalLine(4, 14, 16, Color.black);
        
        for(int i = 2; i <= 15;i++) {
        	drawHorizontalLine(4, 14, i, greenAcqua);
        }
        for(int i = 3; i <= 8;i++) {
        	drawHorizontalLine(5, 13, i, softGreen);
        }
        drawHorizontalLine(5, 9, 10, darkGreen);
        putPixel(12, 10, darkBlue);
        drawHorizontalLine(5, 7, 13, yellow);
        drawVerticalLine(12, 14, 6, yellow);
        putPixel(12, 13, green);
        putPixel(10, 13, softBlue);
        putPixel(11, 14, red);
        putPixel(6, 5, Color.black);
        putPixel(12, 5, Color.black);
        drawHorizontalLine(8, 10, 6, Color.black);
        drawSquareGrid(PIXEL_SIZE, Color.black);

        
        // Guardamos la imagen en formato JPG
        try {       
            ImageIO.write(image, "jpg", new File("pixel_art_BMO.jpg"));
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
