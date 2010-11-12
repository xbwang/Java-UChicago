class Summation{
	public static void main(String[] args){
		if(args.length <= 1 || args.length > 2){
			System.out.println("- error: too many/few inputs");
		}else{
			int min = Integer.parseInt(args[0]);
			int max = Integer.parseInt(args[1]);	
			if(min > max){
				System.out.println("- error: minimum value is larger than maximun value");
			}else{
				int sum = (min + max)*(max - min + 1)/2;
				System.out.println("Sum: " + sum);
			}
		}
	}
}