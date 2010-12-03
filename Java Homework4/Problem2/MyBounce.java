import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyBounce{
	public static void main(String[] args){
		JFrame frame = new BounceFrame();
		frame.show();
	}
}

class BounceFrame extends JFrame{
	private JPanel canvas;
	
	public void addButton(Container c, String title, ActionListener a){
		JButton b = new JButton(title);
		c.add(b);
		b.addActionListener(a);
	}
	
	public BounceFrame(){
		setSize(300, 200);
		setTitle("MyBounce");
		
		Container contentPane = getContentPane();
		canvas = new JPanel();
		contentPane.add(canvas, "Center");
		JPanel p = new JPanel();
		addButton(p, "Add Ball",
				new ActionListener(){
					public void actionPerformed(ActionEvent evt){
						final Ball b = new Ball(canvas, 0, 0);
						new Thread(){
							public void run(){
							     b.bounce();
							}
						}.start();
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
}

class Ball{
	private JPanel box;
	private static final int XSIZE = 10;
	private static final int YSIZE = 10;
	private int x;
	private int y;
	private int dx = 2;
	private int dy = 2;
	
	public Ball(JPanel box, int x, int y){
		this.box = box;
		this.x = x;
		this.y = y;
	}
	
	public void draw(){
		Graphics g = box.getGraphics();
		g.fillOval(x, y, XSIZE, YSIZE);
		g.dispose();
	}
	public void move(){
		Graphics g = box.getGraphics();
		g.setXORMode(box.getBackground());
		g.fillOval(x, y, XSIZE, YSIZE);
		x += dx;
		y += dy;
		Dimension d = box.getSize();
		if(x < 0){
			x = 0;
			dx = -dx;
		}
		if(x + XSIZE >= d.width){
			x = d.width - XSIZE;
			dx = -dx;
		}
		if(y < 0){
			y = 0;
			dy = -dy;
		}
		if(y + YSIZE >= d.height){
			y = d.height - YSIZE;
			dy = -dy;
		}
		g.fillOval(x, y, XSIZE, YSIZE);
		g.dispose();
	}
	
	public void bounce(){
		draw();
		while(true){
			move();
			try{
				Thread.sleep(5);
			}catch(InterruptedException e){}
		}
	}
	
}