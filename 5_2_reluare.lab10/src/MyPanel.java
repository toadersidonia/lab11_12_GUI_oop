import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class MyPanel extends JPanel{
    public static void main(String[] args){
        JFrame frame = new JFrame("Simple frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 120);

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JLabel label1 = new JLabel("Label 1");
        JLabel label2 = new JLabel("Label 2");
        JTextField tf = new JTextField("TextField 1");
        panel1.add(label1);
        panel1.add(label2);
        panel1.add(tf);
        panel1.setLayout(new FlowLayout());

        JButton btn1 = new JButton("Button 1");
        btn1.addActionListener(new Button1Listener(label1));
        JButton btn2 = new JButton("Button 2");
        btn2.addActionListener(new Button2Listener(tf, label2));
        JButton btn3 = new JButton("Button 3");
        btn3.addActionListener(new Button3Listener(panel1, panel2));
        panel2.add(btn1);
        panel2.add(btn2);
        panel2.add(btn3);
        panel2.setLayout(new FlowLayout());

        JPanel p = new JPanel();
        p.add(panel1);
        p.add(panel2);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        frame.setContentPane(p);
        frame.setVisible(true);
    }

}
