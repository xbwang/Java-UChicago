class Adder{
	public static void main(String[] args){
		int num1 = 0, num2 = 0, result = 0;
		String opt, input;
		String[] inputToken;
		while(true){
			System.out.print("Adder (\"exit\" to end)>> ");
			input = ParserUtils.getKeyInput();
			inputToken = ParserUtils.getTokens(input);
			if(inputToken[0].equals("exit")){
				System.exit(0);
			}
			else if(inputToken.length != 3){
				System.out.println("- too many/few input values");
			}
			else if(!inputToken[0].matches("\\d+")){
				System.out.println("- no such symbol " + inputToken[0]);
			}
			else if(!inputToken[2].matches("\\d+")){
				System.out.println("- no such symbol " + inputToken[2]);
			}
			else{
				num1 = Integer.parseInt(inputToken[0]);
				num2 = Integer.parseInt(inputToken[2]);
				opt = inputToken[1];
				if(opt.equals("+")){
					result = num1 + num2;
					System.out.println("  Result: " + result);
				}
				else if(opt.equals("-")){
					result = num1 - num2;
					System.out.println("  Result: " + result);
				}
				else if(opt.equals("*")){
					result = num1 * num2;
					System.out.println("  Result: " + result);
				}
				else if(opt.equals("/")){
					result = num1 / num2;
					System.out.println("  Result: " + result);
				}
				else if(opt.equals("%")){
					result = num1 - ((int)(num1/num2))*num2;
					System.out.println("  Result: " + result);
				}else{
					System.out.println("- no such operator \"" + opt + "\"");
				}
				
			}
		}
	}
}