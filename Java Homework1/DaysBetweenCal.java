import java.util.Calendar;

class DaysBetweenCal{
	public static void main(String[] args){
		if(args.length != 2){
			ErrorMsg("- too many/few input values");
		}
		for(int i = 0; i < 2; i++){
			if(!args[i].matches("\\d{2}/\\d{2}/\\d{4}"))
				ErrorMsg("- the date strings are not in the proper formate[mm/dd/yyyy]");
		}
		
		String[] stringDate;
		stringDate = args[0].split("/");
		Calendar startDate = Calendar.getInstance();
		startDate.clear();
		startDate.set(Integer.parseInt(stringDate[2]), Integer.parseInt(stringDate[0]), Integer.parseInt(stringDate[1]));
		
		Calendar endDate = Calendar.getInstance();
		endDate.clear();
		stringDate = args[1].split("/");
		endDate.set(Integer.parseInt(stringDate[2]), Integer.parseInt(stringDate[0]), Integer.parseInt(stringDate[1]));
		
		if(startDate.after(endDate)){
			ErrorMsg("- start-date is later than end-date");
		}
		
		long result;
		result = (endDate.getTimeInMillis() - startDate.getTimeInMillis())/(24*60*60*1000);
		System.out.print(result+" Days\n");		
	}
	
	private static void ErrorMsg(String msg){
		System.out.println(msg);
		System.exit(0);
	}
}