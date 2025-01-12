import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Button3Listener implements ActionListener{
    JPanel p1;
    JPanel p2;
    int a1 = 0, a2 = 3;
    public void actionPerformed(ActionEvent e){
        int v1[] = {32, 55, 22, 45, 67};
        int v2[] = {2, 11, 67, 90, 100};
        int v3[] = {200, 201, 202, 204, 209};

        a1 = (a1 + 1) % 5;
        a2 = (a2 + 1) % 5;

        p1.setBackground(new Color(v1[a1], v2[a1], v3[a1]));
        p2.setBackground(new Color(v1[a2], v2[a2], v3[a2]));

    }
    public Button3Listener(JPanel p1, JPanel p2) {
        this.p1 = p1;
        this.p2 = p2;
    }
}
