import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bounce{  
    public static void main(String[] args){  
	JFrame frame = new BounceFrame();
	frame.show();
    }
}

class BounceFrame extends JFrame{  
    private JPanel canvas;

    public BounceFrame(){  
	setSize(300, 200);
	setTitle("Bounce");
	
	//Container by default has border layout
	Container contentPane = getContentPane();
	canvas = new JPanel();
	contentPane.add(canvas, "Center");
	JPanel p = new JPanel();
	//for clarity, I create a method (addButton) which
	//creates, adds, and registers the buttons all in one
	//For confusion, anonymous inner classes are used to
	//define the event-handling object.

	//for anonymous inner class, just mentally substitute
	//an object of type classname where the "new classname" appears.
	addButton(p, "Start",
		  new ActionListener(){  
			  public void actionPerformed(ActionEvent evt){ 
			      Ball b = new Ball(canvas);
			      b.bounce();
			  }
			  public void actionPerformedB(ActionEvent evt){ 
			      Ball b = new Ball(canvas);
			      b.bounce();
			  }
		      });

	addButton(p, "Close",
		  new ActionListener(){
				public void actionPerformed(ActionEvent evt){  
				System.exit(0);
			  }
			});
	contentPane.add(p, "South");
    }
    
    public void addButton(Container c, String title,
			  ActionListener a){  
	JButton b = new JButton(title);
	c.add(b);
	b.addActionListener(a);
    }
    

}

class Ball{ 
    private JPanel box;
    private static final int XSIZE = 10;
    private static final int YSIZE = 10;
    private int x = 0;
    private int y = 0;
    private int dx = 2;
    private int dy = 2;

    public Ball(JPanel box) { 
	this.box = box; 
    }
    
    public void draw(){
	Graphics g = box.getGraphics();
	g.fillOval(x, y, XSIZE, YSIZE);
	g.dispose();//cleans up memory, probably not necessary
    }
    
    public void move(){
	Graphics g = box.getGraphics();
	g.setXORMode(box.getBackground());
	g.fillOval(x, y, XSIZE, YSIZE);
	x += dx;
	y += dy;
	Dimension d = box.getSize();
	if (x < 0)
	    { x = 0; dx = -dx; }
	if (x + XSIZE >= d.width)
	    { x = d.width - XSIZE; dx = -dx; }
	if (y < 0)
	    { y = 0; dy = -dy; }
	if (y + YSIZE >= d.height)
	    { y = d.height - YSIZE; dy = -dy; }
	g.fillOval(x, y, XSIZE, YSIZE);
	g.dispose();
    }
    
    public void bounce(){
	draw();
	while (true){
	    move();
	    try { Thread.sleep(5); }
	    catch(InterruptedException e) {}
	}
    }
    

}


