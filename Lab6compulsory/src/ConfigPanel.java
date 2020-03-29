import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ConfigPanel extends JPanel {

    final Main frame;
    public JLabel jLabel;
    public JSpinner jSpinner;
    public JComboBox jComboBox;

    public ConfigPanel(Main frame) {

        this.frame = frame;
        init();
    }

    private void init () {
        jLabel = new JLabel("Number of sides");
        jSpinner = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        jSpinner.setValue(4);

        String color [] = {"Random" , "Black"};
        jComboBox = new JComboBox(color);


        JButton button = new JButton("Make changing");
        button.addActionListener(this::Change);
        add(button);
        add(jLabel);
        add(jSpinner);
        add(jComboBox);
    }
    private void Change (ActionEvent event){
        frame.drawingPanel.setSides((int)jSpinner.getValue());

        Random random = new Random();
        int rad = random.nextInt(10);
        System.out.println(frame.configPanel.jComboBox.getName());
        frame.drawingPanel.setColor(rad ,frame.configPanel.jComboBox.getSelectedItem().toString());


    }
}