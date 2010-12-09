import java.util.HashSet;

public class myHashSet{
	public static void main(String[] args){
		if(args.length < 1){
			System.out.println("- error: no input value");
			System.exit(0);
		}
		HashSet<String> mySet = new HashSet<String>();
		boolean isNewWord;
		System.out.print("- duplicate words: ");
		for(int i = 0; i < args.length; i++){
			isNewWord = mySet.add(args[i]);
			if(isNewWord == false){
				System.out.print(args[i]+" ");
			}
		}
		System.out.println();
	}
}