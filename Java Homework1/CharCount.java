class CharCount{
	public static void main(String[] args){
		int num = 0;
		if(args.length != 2){
			System.out.println("- error: too many/few input values");
		}
		else if(args[0].length() != 1){
			System.out.println("- error: single character not input");
		}else{
			String filename = args[1];
			char[] fileContents = TextManipTools.readFile(filename).toCharArray();
			char[] charToLook = args[0].toCharArray();
			for(int i = 0; i < fileContents.length; i++){
				if(fileContents[i] == charToLook[0]){
					num++;
				}
			}
			System.out.println(num + " occurrences of " + args[0] + " found.");
		}
	}
}