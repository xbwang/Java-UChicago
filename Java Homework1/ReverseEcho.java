class ReverseEcho{
	public static void main(String[] args){
		if(args.length <= 0){
			System.out.println("- error: no input");
		}else{
			for(int i = 0; i < args.length; i++){
				System.out.print(args[(args.length - 1) - i] + " ");
			}
			System.out.println();
		}
	}
}