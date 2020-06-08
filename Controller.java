import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
//import java.awt.event.KeyAdapter;

class Controller implements MouseListener, KeyListener
{
    @Override
    public void keyPressed(KeyEvent e)
    {
        
    }
    
    @Override
    public void keyReleased(KeyEvent e)
    {
        
    }
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        //when 'h' is pressed, print "hello, world" to console
        if(e.getKeyChar() == 'h')
            System.out.println("hello, world :)");
        
        if(e.getKeyChar() == 'n')
        {
            System.out.println("Escaped:  " + model.getEscapedNum());
            System.out.println("Captured: " + model.getCapturedNum());
        }
        
        if(e.getKeyChar() == 'r')
        {
            model.initialize();
            view.repaint();
        }
        
        if(e.getKeyChar() == 's')
        {
            SpriteMover spritemover = new SpriteMover(model, view);
            Thread thread = new Thread(spritemover);
            thread.start();
        }
    }
    
    
    Model model;
    View view;
    
    Controller() throws IOException, Exception 
    {
        model = new Model();
        view = new View(this);
    }

    public void update(Graphics g) 
    {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) 
    {
        if (SwingUtilities.isLeftMouseButton(e)) 
        {
            model.newSprite(e.getXOnScreen(), e.getYOnScreen());
            view.repaint();
        } 
        else if (SwingUtilities.isRightMouseButton(e))  
        {
            model.updateScene(view.getWidth(), view.getHeight());
            view.repaint();
        }
    }

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e)  {    }
    public void mouseExited(MouseEvent e)   {    }
    public void mouseClicked(MouseEvent e)  {    }

    public static void main(String[] args) throws Exception 
    {
        new Controller();
    }
}

