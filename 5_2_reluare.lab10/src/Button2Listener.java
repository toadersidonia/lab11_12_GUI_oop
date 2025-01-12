
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Button2Listener implements ActionListener{
   JTextField text;
   JLabel label;
    public void actionPerformed(ActionEvent e){
        label.setText(text.getText());
    }
    public Button2Listener(JTextField text, JLabel label){
        this.text = text;
        this.label = label;
    }
}
