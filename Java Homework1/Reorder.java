import java.util.*;

import com.sun.tools.javac.code.Attribute.Array;

class Reorder{
	public static void main(String[] args){
		if(args.length == 0){
			System.out.println("- no input value");
			System.exit(0);
		}
		if(!args[0].matches("\\d+")){
			System.out.println("- invalid input, no value before operator");
			System.exit(0);
		}
		int i = 0, length = (args.length-1)/2;
		int[] arr = new int[length];
		int[] perm = new int[length];
		//array in
		while(i < length && args[i].matches("\\d+")){
			arr[i] = Integer.parseInt(args[i]);
			i++;
		}
		//check operator
		if(i >= args.length){
			System.out.println("- invalid input, no operator/arr's length and perm's length don't match");
			System.exit(0);
		}
		if(!args[i].equals("&")){
			System.out.println("- invalid input, no operator/arr's length and perm's length don't match");
			System.exit(0);
		}
		if((args.length - 1)/2 != i){
			System.out.println("- invalid input, no operator/arr's length and perm's length don't match");
			System.exit(0);
		}
		int j = 0;
		i++;
		while(i < args.length){
			if(!args[i].matches("\\d+")){
				System.out.println("- invalid peremeters, only digits accepted");
				System.exit(0);
			}
			perm[j] = Integer.parseInt(args[i]);
			if(perm[j] >= length){
				System.out.println("- invalid peremeters, some peremeters are larger then the length");
				System.exit(0);
			}
			for(int k = 0; k < j; k ++){
				if(perm[k] == perm[j]){
					System.out.println("- repeated peremeter");
					System.exit(0);
				}
			}
			j++;
			i++;
		}
		int count = length;
		int tempKey1, tempKey2;
		int swapNum = 0;
		tempKey2 = arr[perm[swapNum]];
		for(i = 0; i < j; i++){
			int key = 0;
			key = perm[i];
			perm[i] = arr[key];
			arr[key] = i;
		}
		arr = perm;
		for(int k=0;k<length;k++){
			System.out.print(arr[k]+" ");
		}
		System.out.print("\n");
		//System.out.println(Arrays.toString(arr));
	}
}