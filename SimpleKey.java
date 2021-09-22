import java.awt.*;
import java.awt.event.*;

public class SimpleKey extends Frame implements KeyListener {
    String msg = "";
    String keyState = "";

    public SimpleKey(){
        addKeyListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    public void keyPressed(KeyEvent ke){
        keyState = "Key down.";
        
        int key = ke.getKeyCode();
        switch (key) {
            case KeyEvent.VK_F1:
                msg +="<F1>";
                break;
            case KeyEvent.VK_F2:
                msg +="<F2>";
                break;
            case KeyEvent.VK_F3:
                msg +="<F3>";
                break;
            case KeyEvent.VK_PAGE_DOWN:
                msg += "<PgDn>";
                break;
            case KeyEvent.VK_PAGE_UP:
                msg += "<PgUp>";
                break;
            case KeyEvent.VK_LEFT:
                msg += "<Left Arrow>";
                break;
            case KeyEvent.VK_RIGHT:
                msg += "<Right Arrow>";
                break;
        }
        repaint();
    }

    public void keyReleased(KeyEvent ke){
        keyState = "Key up.";
        repaint();
    }

    public void keyTyped(KeyEvent ke){
        msg += ke.getKeyChar();
        repaint();
    }

    public void paint(Graphics g){
        g.drawString(msg, 20, 100);
        g.drawString(keyState, 20, 50);
    }

    public static void main(String[] args){
        SimpleKey appwin = new SimpleKey();

        appwin.setSize(200, 150);
        appwin.setTitle("SimpleKey");
        appwin.setVisible(true);
    }
}

class MyWindowAdapter extends WindowAdapter{
    public void windowClosing(WindowEvent we){
        System.exit(0);
    }
}
