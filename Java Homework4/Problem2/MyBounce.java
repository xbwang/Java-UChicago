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
	boolean pause = false;
	JButton startButton;
	JButton pauseButton;
	
	public BounceFrame(){
		setSize(300, 200);
		setTitle("MyBounce");
	
		Container contentPane = getContentPane();
		canvas = new JPanel();
		contentPane.add(canvas, "Center");
		JPanel p = new JPanel();
		startButton = new JButton("Start");
		pauseButton = new JButton("Pause");
		JButton resumeButton = new JButton("Resume");
		JButton closeButton = new JButton("Close");
		p.add(startButton);
		p.add(pauseButton);
		p.add(resumeButton);
		p.add(closeButton);
		pauseButton.setVisible(false);
		ActionListener ballListener = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				pause = false;
				startButton.setVisible(false);
				pauseButton.setVisible(true);
				new Thread(){
					public void run(){
						Ball[] ballArray = new Ball[2];
						ballArray[0] = new Ball(canvas, 0, 0);
						ballArray[1] = new Ball(canvas, 300, 0);
						ballArray[0].draw();
						ballArray[1].draw();
						while(true){
							//collision detection
							int[] directionA = new int[2];
							int[] directionB = new int[2];
							int[] positionA = new int[2];
							int[] positionB = new int[2];
							positionA = ballArray[0].getPosition();
							positionB = ballArray[1].getPosition();
							directionA = ballArray[0].getDirection();
							directionB = ballArray[1].getDirection();
							if((Math.pow(positionA[0]-positionB[0],2) + Math.pow(positionA[1]-positionB[1],2)) <= 100){
								if(directionA[0] == directionB[0]){
									ballArray[0].setDirection(1, -1);
									ballArray[1].setDirection(1, -1);
								}
								if(directionA[1] == directionB[1]){
									ballArray[0].setDirection(-1, 1);
									ballArray[1].setDirection(-1, 1);
								}
								if(directionA[1] != directionB[1] && directionA[0] != directionB[0]){
									ballArray[0].setDirection(-1, -1);
									ballArray[1].setDirection(-1, -1);
								}
							}
							//pause
							while(pause){
								try{
									Thread.sleep(1);
								}catch(InterruptedException e){}
							}
							//balls move
							for(int i = 0;i < 2;i++){
								ballArray[i].move();
								try{
									Thread.sleep(5);
								}catch(InterruptedException e){}
							}
						}
					}
				}.start();
			}
		};
		ActionListener closeListener = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		};
		ActionListener pauseListener = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				pause = true;
			}
		};
		ActionListener resumeListener = new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				pause = false;
			}
		};
		startButton.addActionListener(ballListener);
		pauseButton.addActionListener(pauseListener);
		resumeButton.addActionListener(resumeListener);
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
	private int[] direction = new int[2];
	
	public Ball(JPanel box, int x, int y){
		this.box = box;
		this.x = x;
		this.y = y;
		if(dx > 0){
			this.direction[0] = 1;
		}else{
			this.direction[0] = -1;
		}
		
		if(dy > 0){
			this.direction[1] = 1;
		}else{
			this.direction[1] = -1;
		}
	}
	
	public void draw(){
		Graphics g = box.getGraphics();
		g.fillOval(x, y, XSIZE, YSIZE);
		g.dispose();
	}
	
	public int[] getPosition(){
		int[] position = new int[2];
		position[0] = x+5;
		position[1] = y+5;
		return position;
	}
	
	public int[] getDirection(){
		if(dx > 0){
			this.direction[0] = 1;
		}else{
			this.direction[0] = -1;
		}
		
		if(dy > 0){
			this.direction[1] = 1;
		}else{
			this.direction[1] = -1;
		}
		
		return this.direction;
	}
	
	public void setDirection(int x, int y){
		this.dx = x*this.dx;
		this.dy = y*this.dy;
	}
	
	public boolean move(){
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
		
		return false;
	}
}