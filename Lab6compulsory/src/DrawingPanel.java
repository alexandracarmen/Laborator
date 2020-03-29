import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Random;

public class DrawingPanel extends JPanel {

    private Graphics2D graphics2D;
    String [] colours = {"red","yellow","green","blue","pink","red","yellow","green","blue","pink"};
    final Main frame;
    final static int W = 800, H = 600;
    int sides = 4;
    String color = "Black";
    int value = 3;

    BufferedImage image; //the offscreen image
    ControlPanel controlPanel;

    public DrawingPanel(Main frame) {
        this.frame = frame;
        createOffscreenImage();
        init();
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public void setColor( int value , String color) {
        this.color = color;
        this.value = value;
    }

    private  void createOffscreenImage ()
    {
        image = new BufferedImage(W , H , BufferedImage.TYPE_INT_ARGB);
        graphics2D = image.createGraphics();
        graphics2D.setColor(Color.white);
        graphics2D.fillRect(0, 0, W, H);
    }

    private void init () {

        setPreferredSize(new Dimension(W,H));
        setBorder(BorderFactory.createEtchedBorder());

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                drawShape(e.getX(), e.getY()); repaint();
            }
        });
    }
    private void drawShape (int x , int y) {
        int radius = 10 + new Random().nextInt(100);
        ConfigPanel configPanel = new ConfigPanel(this.frame);
        Color cul = new Color(255);
        if (new String("Random").equals(color)){
            switch (colours[value].toLowerCase()){
                case "red" : cul = Color.RED; break;
                case "yellow" : cul = Color.YELLOW; break;
                case "green" : cul = Color.GREEN; break;
                case "blue" : cul = Color.BLUE; break;
                case "pink" : cul = Color.pink; break;
            }
        }
        else {cul = Color.BLACK;}
        graphics2D.setColor(cul);
        graphics2D.fill(new RegularPolygon(x, y, radius, sides));
    }
    public void load() {
        try {
            image = ImageIO.read(new File("E:/Desktop/test.png"));
            repaint();
        }catch (Exception e) {
            System.err.println(e);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image ,0,0,this);
    }
    @Override
    public void update(Graphics g) {
        createOffscreenImage();
        repaint();
    }
}