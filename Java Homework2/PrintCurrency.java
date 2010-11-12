import java.util.Currency;
import java.util.Locale;
import java.io.*;

class PrintCurrency{
	public static void main(String[] args){
		if(args.length != 1){
			System.out.println("- error: too few/many input values");
			System.exit(0);
		}
		//get symbol
		Currency input = null;
		String output = null;
		Locale[] locale = Locale.getAvailableLocales();
		try{
			input = Currency.getInstance(args[0]);
			for(int i = 0; i < locale.length; i++){
				output = input.getSymbol(locale[i]);
				if(!output.equals(args[0]))
					break;
			}
		}catch(IllegalArgumentException e){
			System.out.println("- error: currencyCode is not a supported ISO 4217 code");
			System.exit(0);
		}catch(NullPointerException e){
			System.out.println("- error: currencyCode is null");
			System.exit(0);
		}
		//print symbol
		try{
			PrintStream out = new PrintStream(System.out, true, "UTF-8");
			out.println("The symbol of " + args[0] +" is: " + output);
		}catch(IOException e){
			System.out.println(e);
			System.exit(0);
		}
	}
}