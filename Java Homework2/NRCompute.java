class NRCompute{
	public static double getDervative(double[] co_in, int[] power_in, double x_in){
		double[] newCoArray = new double[co_in.length - 1];
		for(int i = 0; i < newCoArray.length; i++){
			newCoArray[i] = co_in[i]*power_in[i];
		}
		int[] newPowArray = new int[power_in.length - 1];
		for(int i = 0; i < newPowArray.length; i++){
			newPowArray[i] = power_in[i] - 1;
		}
		
		return getYValue(newCoArray, newPowArray, x_in);
	}
	
	public static double getYValue(double[] co_in, int[] power_in, double x_in){
		double result = 0.00;
		for(int i = 0; i < co_in.length; i++){
			result += co_in[i]*Math.pow(x_in, power_in[i]*1.00);
		}
		return result;
	}
	
	public static double getResult(double[] coArray){
		int power = coArray.length - 1;
		int[] powArray = new int[coArray.length];
		for(int i = 0; i < coArray.length; i++){
			powArray[i] = power - i;
		}
		double x = 3.00;
		double y, g, b;
		while(getYValue(coArray, powArray, x) != 0.00){
			y = getYValue(coArray, powArray, x);
			g = getDervative(coArray, powArray, x);
			b = y - g*x;
			x = (-b)/g;
		}
		return x;
	}
	public static void main(String[] args){
		double coArray[] = new double[args.length];
		for(int i = 0; i < args.length; i ++){
			coArray[i] = Double.parseDouble(args[i]);
		}
		double result = getResult(coArray);
		System.out.println("Root: "+result);
	}
}