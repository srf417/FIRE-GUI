import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton button;
    JLabel label;
    private int count = 0;

    public GUI() {


        frame = new JFrame();
        panel = new JPanel();
        button = new JButton("Go away."); //declare

        button.addActionListener(this);
        label = new JLabel("Click count: 0");

        panel.setBorder(BorderFactory.createEmptyBorder(250, 250, 250, 250));
        panel.setLayout(new GridLayout(0, 1)); //set dimension
        panel.add(button);
        panel.add(label);

        frame.add(panel, BorderLayout.CENTER); //add panel to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //in event of closing frame
        frame.setTitle("Test"); //name of window
        frame.pack(); //match size
        frame.setVisible(true); //in focus

    }

    public static void main(String[] args) {
        new GUI();
    }

    public void actionPerformed(ActionEvent e) {
        count++;
        label.setText("Click count: " + count);
    }
}
