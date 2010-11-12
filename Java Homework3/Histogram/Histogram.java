import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.Random;
import java.io.*;

class Histogram extends JFrame{
	private double dalta;
	private int num_bins;
	private double[] data;
	private int[] xcor;
	private int[] ycor;
	private int[] height;
	//constructor
	Histogram(double[] data, int num_bins){
		this.data = data;
		this.num_bins = num_bins;
	}

	public void drawGraph(){
	    //get dalta
	    if(this.data.length == 0 || this.num_bins <= 0)
            errorMsg("invalid numOfdata/numOfbins");
        double max, min;
        max = this.data[0];
        min = this.data[0];
        for(int i = 1; i < this.data.length; i++){
            if(this.data[i] > max)
                max = data[i];
            if(this.data[i] < min)
                min = data[i];
        }
        this.dalta = (max - min)/this.num_bins;
        //get height
        this.height = new int[this.num_bins];
		for(int i = 0;i < this.num_bins; i++){
		    height[i] = 0;
		}
		int num, highest;
		highest = 0;
		for(int i = 0;i < this.data.length; i++){
			if(data[i] == max){
				num = (int)((data[i]-min)/this.dalta) - 1;
			}else{
				num = (int)((data[i]-min)/this.dalta);
			}
		    height[num]++;
		    if(height[num] > highest)
		    	highest = height[num];
		}
		//get xcor
		xcor = new int[this.num_bins];
	    for(int i = 0;i < this.num_bins; i++){
	        xcor[i] = (i+1)*6;
	    }
	    int xsize = this.num_bins*6+20;
	    int ysize = highest+50;
	    //get ycor
	    ycor = new int[this.num_bins];
	    for(int i = 0;i < this.num_bins; i++){
	    	ycor[i] = ysize - height[i] - 10;
	    }
		setSize(xsize,ysize);
		setVisible(true);
	}
	
	public void paint(Graphics g){
	    Graphics2D g2 = (Graphics2D)g;
	    for(int i = 0; i < this.num_bins; i++){
	        Rectangle2D.Double perm = new Rectangle2D.Double(xcor[i],ycor[i], 3, height[i]);
	        g2.draw(perm);
	        g2.fill(perm);
	    }
	}
	
	public static void errorMsg(String msg){
		System.out.println("- error: "+msg);
		System.exit(0);
	}
	
	public static void main(String[] args){
		if(args.length != 2)
			errorMsg("too many/few input value");
		if(!args[0].matches("\\d+") || !args[1].matches("\\d+"))
			errorMsg("invalid input value");
		
		int data_num = Integer.parseInt(args[0]);
		int bin_num = Integer.parseInt(args[1]);
		Random ranGen = new Random();
	    double[] data = new double[data_num];
	    for(int i = 0; i < data_num; i++){
	        data[i] = ranGen.nextGaussian();
	    }
	    Histogram graph = new Histogram(data,bin_num);
	    graph.drawGraph();
	    //exit
	    String input = null;
	    while(true){
	    	try{
			    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			    System.out.print("- type \"exit\" to quit>>");
			    input = in.readLine();
			    if(input.equals("exit"))
			    	System.exit(0);
			}
			catch (IOException ioe){
			    errorMsg("- input error");
			}
	    }
	}
}