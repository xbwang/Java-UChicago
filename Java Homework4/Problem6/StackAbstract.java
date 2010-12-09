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
    
    public T peak(){
        return stack.get(this.size()-1);

    }
    
    public T pop(){
        T tmp =  stack.get(this.size()-1);
        stack.remove(this.size()-1);
        return tmp;
    }
    
    public boolean push(T item){
        if(search(item) == -1){
			stack.add(item);
			return true;
		}else{
			return false;
		}
    }
    
	public Iterator<T> iterator(){
        return this.stack.iterator();
	}
	
	public int search(T item){
       return this.stack.indexOf(item);
	}
   
	public boolean add(T item){
		return push(item);
	}
	
	public boolean addAll(Collection<? extends T> c){
		throw new UnsupportedOperationException("#addAll# method is not supported.");
	}
	
	public void clear(){
		stack = new ArrayList<T>();
	}
	//not supported by stack
	public boolean contains(Object o){
		throw new UnsupportedOperationException("#contains# method is not supported.");
	}
	
	public boolean containsAll(Collection<?> c){
		throw new UnsupportedOperationException("#containsAll# method is not supported.");
	}
	
	public boolean remove(Object o){
		throw new UnsupportedOperationException("#remove# method is not supported.");
	}
	
	public boolean removeAll(Collection<?> c){
		throw new UnsupportedOperationException("#removeAll# method is not supported.");
	}
	
	public boolean retainAll(Collection<?> c){
		throw new UnsupportedOperationException("#retainAll# method is not supported.");
	}
	
	public Object[] toArray(){
		throw new UnsupportedOperationException("#toArray# method is not supported.");
	}
	
	public <T> T[] toArray(T[] a){
		throw new UnsupportedOperationException("#<T>toArray# method is not supported.");
	}
	
	public String toString(){
		throw new UnsupportedOperationException("#toString# method is not supported.");
	}
	
}
