import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {

    final Main frame;
    BufferedImage image;
    Graphics2D graphics2D;
    DrawingPanel drawingPanel;

    JButton saveBtn = new JButton("Save");
    JButton load = new JButton("Load");
    JButton reset = new JButton("Reset");
    JButton exit = new JButton("Exit");

    public ControlPanel (Main frame) {
        this.frame = frame;
        init();
    }

    private void init ()
    {
        setLayout(new FlowLayout());
        add(saveBtn); add(load) ; add(reset); add(exit);

        exit.addActionListener((ActionEvent e ) -> {
            frame.dispose();
        });
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ImageIO.write(frame.drawingPanel.image, "PNG", new File("d:/test.png"));

                } catch (IOException ex) {
                    System.err.println(ex);
                }
            }
        });
        reset.addActionListener(this::reset);
        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.drawingPanel.load();

            }
        });
    }
    private void reset (ActionEvent event) {
        frame.drawingPanel.update(this.getGraphics());
    }
}