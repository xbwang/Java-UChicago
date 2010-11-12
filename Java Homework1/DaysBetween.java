import java.util.StringTokenizer;

class DaysBetween{
	public static void main(String[] args){
		if(args.length != 2)
			ErrorMsg("- too many/few input values");
		//error checking
		for(int i = 0; i < 2; i++){
			if(!args[i].matches("\\d{2}/\\d{2}/\\d{4}"))
				ErrorMsg("- the date strings are not in the proper formate[mm/dd/yyyy]");
		}
		String[] stringDate;
		int[] startDate = new int[3];
		stringDate = args[0].split("/");
		for(int i = 0; i < 3; i++){
			startDate[i] = Integer.parseInt(stringDate[i]);
		}
		int[] endDate = new int[3];
		stringDate = args[1].split("/");
		for(int i = 0; i < 3; i++){
			endDate[i] = Integer.parseInt(stringDate[i]);
		}
		if(startDate[0]>12 || startDate[0]<1 || endDate[0]>12 || endDate[0]<1 
			|| startDate[1]<1 || endDate[1]<1 || startDate[1]>31 || endDate[1]>31)
			ErrorMsg("- invalid dates");
		if((startDate[2]*1000+startDate[0]*100+startDate[1]) > 
			endDate[2]*1000+endDate[0]*100+endDate[1]){
				ErrorMsg("- start-date is later than end-date");
			}
		//calculate
		int numOfLeap = CountLeap(startDate[2], endDate[2]);
		int wholeYearDays = 365*(endDate[2]-startDate[2]-1)+numOfLeap;
		//System.out.print("***"+ wholeYearDays+"\n");
		int complementDays = 0;
		if(startDate[1] <= 2 && CheckLeap(startDate[2]))
			complementDays++;
		if(endDate[1] > 2 && CheckLeap(endDate[2]))
			complementDays++;
		//System.out.print("***"+ complementDays+"\n");
		int startYearDays = 365 - CountDays(startDate);
		//System.out.print("***"+ startYearDays+"\n");
		int endYearDays = CountDays(endDate);
		//System.out.print("***"+ endYearDays+"\n");
		
		int result = wholeYearDays+complementDays+startYearDays+endYearDays;
		System.out.print(result + " Days\n");
	}
	
	private static int CountLeap(int startYear, int endYear){	
		int result;
		int startLeap = startYear/4 - startYear/100 + startYear/400;
		int endLeap = endYear/4 - endYear/100 + endYear/400;
		result = endLeap - startLeap;
		return result;
	}
	private static boolean CheckLeap(int year){
		if(year%4 == 0 && year%100 !=0){
			return true;
		}
		else if(year%4 == 0 && year%100 ==0 &&year%400 == 0){
			return true;
		}else{return false;}
	}
	
	private static void ErrorMsg(String msg){
		System.out.println(msg);
		System.exit(0);
	}
	
	private static int CountDays(int[] date){
		int result = 0, months, days;
		months = date[0];
		days = date[1];
		if(months == 1){
			result = days;
		}
		if(months == 2){
			result = 31+days;
		}
		if(months == 3){
			result = 31+28+days;
		}
		if(months > 3 && months <= 8){
			if(months%2 != 0){
				result = 31*((months-1)/2 + 1) + 28 + 30*((months-1)/2 - 1) + days;
			}else{
				result = 31*((months-1)/2) + 28 + 30*((months-1)/2 -1) + days;
			}
		}
		if(months > 8 && months <= 12){
			result = 31*((months-1)/2) + 28 + 30*((months-1)/2 - 1) + days;
		}
		return result;
	}
}