import javax.swing.*;
import java.awt.*;

public class Main extends JFrame {

    public ConfigPanel configPanel;
    public ControlPanel controlPanel;
    public DrawingPanel drawingPanel;

    public Main () {
        super("My Draw Window");
        init();
    }

    private void init ()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        configPanel = new ConfigPanel(this);
        controlPanel = new ControlPanel(this);
        drawingPanel = new DrawingPanel(this);
        add(configPanel, BorderLayout.NORTH);
        add(controlPanel,BorderLayout.SOUTH);
        add(drawingPanel,BorderLayout.CENTER);
        pack();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.setVisible(true);
    }

}