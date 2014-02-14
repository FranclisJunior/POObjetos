package com.jeco.ui.auxilares;



import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
  
public  abstract class FullResizibleFrame extends JFrame implements MouseMotionListener, MouseListener        
{           
    private static final long serialVersionUID = 1L;          
    private Point start_drag;        
    private  Point start_loc;   
    private Toolkit toolkit =  Toolkit.getDefaultToolkit ();   
    private int minWidth;        
    private int minHeight;   
    private Point initialLocation;  
    private int DIFF_MIN_WIDTH = 30;  
    private int DIFF_MIN_HEIGHT = 30;  
      
    public FullResizibleFrame(Dimension initialDimension, Point initialLocation)        
    {        
       this.initialLocation = initialLocation;  
       minWidth = (int)initialDimension.getWidth();  
       minHeight = (int)initialDimension.getHeight();  
        Init();        
    }        
        
    public FullResizibleFrame() {
		// TODO Auto-generated constructor stub
	}
    private void Init()         
    {        
        addMouseMotionListener(this);        
        addMouseListener(this);        
        this.setSize(minWidth, minHeight);      
          
        minWidth -= DIFF_MIN_WIDTH;  
       minHeight -= DIFF_MIN_HEIGHT;  
          
        setLocation(initialLocation);  
        setUndecorated(true);               
    }    
  
   public  Point getScreenLocation(MouseEvent e, JFrame frame)   
   {  
      Point cursor = e.getPoint();  
        Point view_location = frame.getLocationOnScreen();  
        return new Point((int) (view_location.getX() + cursor.getX()),  
                (int) (view_location.getY() + cursor.getY()));  
   }  
      
    @Override       
    public void mouseDragged(MouseEvent e)         
    {        
        moveOrFullResizeFrame(e);        
    }        
       
    @Override       
    public void mouseMoved(MouseEvent e)         
    {        

    }          
            
    @Override       
    public void mouseClicked(MouseEvent e)         
    {        
     
    }       
            
    private void moveOrFullResizeFrame(MouseEvent e)         
    {        
        Object sourceObject=e.getSource();     
        Point current = getScreenLocation(e, this);     
        Point offset = new Point((int)current.getX()- (int)start_drag.getX(), (int)current.getY()- (int)start_drag.getY());     
             
        if(sourceObject instanceof JPanel      
                && getCursor().equals(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)))      
            setLocation((int) (start_loc.getX() + offset.getX()), (int) (start_loc.getY() + offset.getY()));         
        else if(!getCursor().equals(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR)))        
        {           
            int oldLocationX = (int)getLocation().getX();        
            int oldLocationY = (int)getLocation().getY();        
            int newLocationX = (int) (this.start_loc.getX() + offset.getX());        
            int newLocationY = (int) (this.start_loc.getY() + offset.getY());           
            boolean N_Resize = getCursor().equals(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));        
            boolean NE_Resize = getCursor().equals(Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR));        
            boolean NW_Resize = getCursor().equals(Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR));        
            boolean E_Resize = getCursor().equals(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));        
            boolean W_Resize = getCursor().equals(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));        
            boolean S_Resize = getCursor().equals(Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR));        
            boolean SW_Resize = getCursor().equals(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));        
            boolean setLocation = false;        
            int newWidth = e.getX();        
            int newHeight = e.getY();        
                    
            if(NE_Resize)           
            {             
                newHeight = getHeight() - (newLocationY - oldLocationY);         
                newLocationX = (int)getLocation().getX();        
                setLocation = true;        
            }        
            else if(E_Resize)        
                newHeight = getHeight();         
            else if(S_Resize)        
                newWidth = getWidth();                      
            else if(N_Resize)        
            {           
                newLocationX = (int)getLocation().getX();        
                newWidth = getWidth();        
                newHeight = getHeight() - (newLocationY - oldLocationY);        
                setLocation = true;        
            }        
            else if(NW_Resize)        
            {        
                newWidth = getWidth() - (newLocationX - oldLocationX);        
                newHeight = getHeight() - (newLocationY - oldLocationY);        
                setLocation =true;        
            }           
            else if(NE_Resize)          
            {             
                newHeight = getHeight() - (newLocationY - oldLocationY);        
                newLocationX = (int)getLocation().getX();          
            }        
            else if(SW_Resize)        
            {           
                newWidth = getWidth() - (newLocationX - oldLocationX);        
                newLocationY = (int)getLocation().getY();                       
                setLocation =true;        
            }        
            if(W_Resize)        
            {           
                newWidth = getWidth() - (newLocationX - oldLocationX);        
                newLocationY = (int)getLocation().getY();           
                newHeight = getHeight();        
                setLocation =true;        
            }        
                                    
            if(newWidth >= (int)toolkit.getScreenSize().getWidth() || newWidth <= minWidth)        
            {        
                newLocationX = oldLocationX;        
                newWidth = getWidth();        
            }        
                    
            if(newHeight >= (int)toolkit.getScreenSize().getHeight() - 30 || newHeight <= minHeight)        
            {        
                newLocationY = oldLocationY;        
                newHeight = getHeight();        
            }        
                    
            if(newWidth != getWidth() || newHeight != getHeight())        
            {        
                this.setSize(newWidth, newHeight);        
                            
                if(setLocation)        
                    this.setLocation(newLocationX, newLocationY);                 
            }        
        }        
    }        
             
         
    @Override       
    public void mousePressed(MouseEvent e)         
    {        
        this.start_drag = getScreenLocation(e, this);        
        this.start_loc = this.getLocation();       
                       
    }        
            
    @Override       
    public void mouseEntered(MouseEvent e) {}        
       
    @Override       
    public void mouseExited(MouseEvent e) {
    	
    }        
            
    @Override       
    public void mouseReleased(MouseEvent e) {}    
      
}   

