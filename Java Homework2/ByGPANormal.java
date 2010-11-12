import java.util.Comparator;

class ByGPANormal implements Comparator{
	public final int compare(Object a, Object b){
		double aGPA = ((Student)a).getGPA();
		double bGPA = ((Student)b).getGPA();
		if(aGPA > bGPA)
			return 1;
		if(aGPA < bGPA)
			return -1;
		else
			return 0;			
	}
}