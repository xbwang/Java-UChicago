class Uppercase{
	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("- too many/few input values");
		}else{
			String fileContents = TextManipTools.readFile(args[0]);
			char[] fileCharArray = fileContents.toCharArray();
			for(int i = 0; i < fileContents.length(); i++){
				if(fileCharArray[i] == '.'){
					System.out.print(fileCharArray[i]);
					while(fileCharArray[i+1] == ' '){
						i++;
						System.out.print(fileCharArray[i]);
					}
					if(Character.isLowerCase(fileCharArray[i+1])){
						fileCharArray[i+1] = Character.toUpperCase(fileCharArray[i+1]);
					}
				}else{
					System.out.print(fileCharArray[i]);
				}
			}
		}
	}
}