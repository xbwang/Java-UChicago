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
	
	public BounceFrame(){
		setSize(300, 200);
		setTitle("MyBounce");
	
		Container contentPane = getContentPane();
		canvas = new JPanel();
		contentPane.add(canvas, "Center");
		JPanel p = new JPanel();
	
		JButton startButton = new JButton("Start");
		JButton closeButton = new JButton("Close");
		p.add(startButton);
		p.add(closeButton);
		ActionListener ballListener = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				boolean collision = false;
				Ball[] ballArray = new Ball[2];
				//for(int i = 0;i < 2;i++){
					ballArray[0] = new Ball(canvas, 0, 0);
					ballArray[1] = new Ball(canvas, 300, 200);
				//}
				int[] direction = new int[2];
				while(true){
					for(int i = 0;i < 2;i++){
						direction = ballArray[i].getDirection();
						ballArray[i].draw();
						ballArray[i].move(direction, collision);
						try{
							Thread.sleep(5);
						}catch(InterruptedException e){}
					}
				}
			}
		};
		ActionListener closeListener = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		};
		startButton.addActionListener(ballListener);
		closeButton.addActionListener(closeListener);
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
	
	public int[] getDirection(){
		int[] direction = new int[2];
		if(dx > 0){
			direction[0] = 1;
		}
		else{
			direction[0] = -1;
		}
		if(dy > 0){
			direction[1] = 1;
		}
		else{
			direction[1] = -1;
		}
		return direction;
	}
	
	public void move(int[] direction, boolean collision){
		Graphics g = box.getGraphics();
		g.setXORMode(box.getBackground());
		g.fillOval(x, y, XSIZE, YSIZE);
		
		if(collision == true){
			x += dx*direction[0];
			y += dy*direction[1];
		}
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
}