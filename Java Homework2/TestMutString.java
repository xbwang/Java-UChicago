class TestMutString{
	public static void main(String[] args){
		//initialize
		MutableString testMutString = new MutableString("I am testing now!");
		System.out.println("Initialization: "+testMutString.getValue());
		//test setValue
		testMutString.setValue("I am testing setValue method!");
		System.out.println("setValue: " + testMutString.getValue());
		//test charAt()
		char c = testMutString.charAt(0);
		System.out.println("charAt(0): " + c);
		//test concat
		MutableString concatMutString = new MutableString("And concat method!");
		MutableString rstMutString = testMutString.concat(concatMutString);
		System.out.println("concat: " + rstMutString.getValue());
		//test isEmpty();
		MutableString eptMutString = new MutableString();
		if(eptMutString.isEmpty())
			System.out.println("isEmpty: Empty case!");
		if(!testMutString.isEmpty())
			System.out.println("isEmpty: Not empty case!");
		//test equals
		if(!testMutString.equals(eptMutString))
			System.out.println("equals: Not equal case!");
		if(testMutString.equals(testMutString))
			System.out.println("equals: Equal case!");
		//test replace
		MutableString replaceMutString = testMutString.replace('a', 'b');
		System.out.println("replace [a to b]: " + replaceMutString.getValue());
	}
}