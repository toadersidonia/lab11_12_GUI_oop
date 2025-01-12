/** DragBallPanel.java - Panel that allows dragging a ball around.
 @author Fred Swartz
 @version 2004-04-15
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//temaa 3.4!!!!!!!!!!!!!!!! incrementam x si y folosinf timer ul
//sortare lista in interfata, sa apasam pe un buton si sa ne arate lista sortata GUI]
//MINI PROIECT - MINIM 5 CLASE, CU O INTERFATA GRAFICA!!!!!! CEVA INTERACTIV
//PUTEM SA NE FOLOSIM DE TEMA CU SAHUL

/////////////////////////////////////////////////////////// class DragBallPanel
/** When the mousePressed listener is called to position is tested
 to see if it's in the area of the ball.  If it is,
 (1) _canDrag is set true meaning pay attention to the MouseDragged events.
 (2) Record where in the ball (relative to the upper left coordinates)
 the mouse was clicked, because it looks best if we drag from there.
 */
public class DragBallPanel extends JPanel implements MouseListener, MouseMotionListener {

    private static final int BALL_DIAMETER = 40; // Diameter of ball
    //--- instance variables
    /** Ball coords.  Changed by mouse listeners.  Used by paintComponent. */
    private int _ballX     = 50;   // x coord - set from drag
    private int _ballY     = 50;   // y coord - set from drag

    /** Position in ball of mouse press to make dragging look better. */
    private int _dragFromX = 0;    // pressed this far inside ball's
    private int _dragFromY = 0;    // bounding box.

    /** true means mouse was pressed in ball and still in panel.*/
    private boolean _canDrag  = false;
    private boolean _isMoving = false;
    private int _dx = 5, _dy = 5;

    private Color _ballColor = Color.YELLOW;

    private Timer movementTimer;

    //============================================================= constructor
    /** Constructor sets size, colors, and adds mouse listeners.*/
    public DragBallPanel() {
        setPreferredSize(new Dimension(300, 300));
        setBackground(Color.blue);
        setForeground(Color.yellow);
        //--- Add the mouse listeners.
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        movementTimer = new Timer(50, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (_isMoving) {
                    moveBall();
                    repaint();
                }
            }
        });
    }//endconstructor

    //=================================================== method paintComponent
    /** Ball is drawn at the last recorded mouse listener coordinates. */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);   // Required for background.
        g.setColor(_ballColor); // Set the ball's color
        g.fillOval(_ballX, _ballY, BALL_DIAMETER, BALL_DIAMETER);
        g.drawString("(" + _ballX + ", " + _ballY + ")", 0, 10);
    }//end paintComponent

    //===================================================== method mousePressed
    /** Set _canDrag if the click is in the ball (or in the bounding
     box, which is lazy, but close enuf for this program).
     Remember displacement (dragFromX and Y) in the ball
     to use as relative point to display while dragging.
     */
    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (SwingUtilities.isLeftMouseButton(e)) {
            if (x >= _ballX && x <= (_ballX + BALL_DIAMETER - 3.14)
                    && y >= _ballY && y <= (_ballY + BALL_DIAMETER - 3.14)) {
                _isMoving = !_isMoving;

                if (_isMoving) {
                    _dx = (Math.random() > 0.5) ? 5 : -5;
                    _dy = (Math.random() > 0.5) ? 5 : -5;
                    movementTimer.start();
                } else {
                    movementTimer.stop();
                }
            } else {
                _canDrag = true;
                _dragFromX = x - _ballX;
                _dragFromY = y - _ballY;
            }
        }
        if (SwingUtilities.isRightMouseButton(e)) {
            _ballColor = new Color((int) (Math.random() * 256),
                    (int) (Math.random() * 256),
                    (int) (Math.random() * 256));
            repaint();
        }
    }

    private void moveBall () {
        _ballX += _dx;
        _ballY += _dy;
        if (_ballX <= 0 || _ballX >= getWidth() - BALL_DIAMETER) {
            _dx = -_dx;
        }
        if (_ballY <= 0 || _ballY >= getHeight() - BALL_DIAMETER) {
            _dy = -_dy;
        }
    }


    //============================================================ mouseDragged
    /** Set x,y  to mouse position and repaint. */
    public void mouseDragged(MouseEvent e) {
        if (_canDrag) {   // True only if button was pressed inside ball.
            //--- Ball pos from mouse and original click displacement
            _ballX = e.getX() - _dragFromX;
            _ballY = e.getY() - _dragFromY;

            //--- Don't move the ball off the screen sides
            _ballX = Math.max(_ballX, 0);
            _ballX = Math.min(_ballX, getWidth() - BALL_DIAMETER);

            //--- Don't move the ball off top or bottom
            _ballY = Math.max(_ballY, 0);
            _ballY = Math.min(_ballY, getHeight() - BALL_DIAMETER);

            this.repaint(); // Repaint because position changed.
        }
    }//end mouseDragged

    //====================================================== method mouseExited
    /** Turn off dragging if mouse exits panel. */
    public void mouseExited(MouseEvent e) {
        _canDrag = false;
    }//end mouseExited

    //=============================================== Ignore other mouse events.
    public void mouseMoved   (MouseEvent e) {}  // ignore these events
    public void mouseEntered (MouseEvent e) {}  // ignore these events
    public void mouseClicked (MouseEvent e) {}  // ignore these events
    public void mouseReleased(MouseEvent e) {}  // ignore these events
}//endclass DragBallPanel
