import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.*;

public class StackAbstract<T> extends AbstractCollection <T> {
    private ArrayList<T> stack;
    /** Creates a new instance of StackAbstract */
    public StackAbstract(){
        stack = new ArrayList<T>();
    }
    
    public int size(){
        return this.stack.size();
    }
    
    public boolean isEmpty(){
        return this.stack.isEmpty();
    }
    
    public T peek(){
        return stack.get(this.size()-1);

    }
    
    public T pop(){
        T tmp =  stack.get(this.size()-1);
        stack.remove(this.size()-1);
        return tmp;
    }
    
    public T push(T item){
		stack.add(item);
        return item;
    }
    
	public Iterator<T> iterator(){
        return this.stack.iterator();
	}
	
	public int search(T item){
		return this.stack.indexOf(item);
	}
   
	public boolean add(T item){
		push(item);
		return true;
	}
	
	//not supported by stack, it's not proper to remove a object of stack from the middle
	public boolean remove(Object o){
		throw new UnsupportedOperationException("#remove# method is not supported.");
	}
	
	public boolean removeAll(Collection<?> c){
		throw new UnsupportedOperationException("#removeAll# method is not supported.");
	}
	
}
