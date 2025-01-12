import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Button1Listener implements ActionListener {
    JLabel l;
    private int count;
    public void actionPerformed(ActionEvent e) {
        ++count;
        l.setText(count + "");

    }
    public Button1Listener(JLabel l){
        this.l = l;
    }
}
