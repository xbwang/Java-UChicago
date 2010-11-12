import java.util.Random;

class StudentSorter{
	public static void main(String[] args){
		String[] fileContents;
		int i = 0;
		String[][] line;
		
		if(args.length != 1){
			System.out.println("- too many/few input values");
			System.exit(0);
		}
		
		fileContents = TextManipTools.readFileByLine(args[0]);
		line = new String[fileContents.length][];
		for(i = 0; i < fileContents.length; i++){
			line[i] = ParserUtils.getTokens(fileContents[i]);
		}	
		line = SortFile(line, 0, (i - 1), 2);
		for(int k = 0; k < (i-1); k++){
			int sortLength = 1;
			while((k < (i-1)) && line[k][2].equals(line[k+1][2])){
				k++;
				sortLength++;
			}
			line = SortFile(line, k-sortLength+1, k, 3);
		}
		for(int k = 0; k < (i-1); k++){
			if(line[k][2].equals(line[k+1][2]) && line[k][3].equals(line[k+1][3])){
				Random randomGenerator = new Random();
				int randomInt = randomGenerator.nextInt(100);
				if(randomInt >49){
					String[] temp = line[k];
					line[k] = line[k+1];
					line[k+1] = temp;
				}
			}
		}
		for(int j = 0; j < i; j++){
			System.out.println(line[j][0] + " " + line[j][1] + " " + line[j][2] + " " + line[j][3]);
		}
	}
	
	private static String[][] SortFile(String[][] line, int startPoint, int endPoint, int num){
		int i;
		String[] key;
		for(int j = startPoint + 1; j < (endPoint+1); j++){
			key = line[j];
			i = j - 1;
			while((i >= startPoint) && (Integer.parseInt(line[i][num]) > Integer.parseInt(key[num]))){
				line[i+1] = line[i];
				i = i - 1;
			}
			line[i+1] = key;
		}
		return line;
	}
}