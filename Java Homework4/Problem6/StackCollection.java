import com.sun.org.apache.bcel.internal.classfile.JavaClass;
import java.util.Collection;
import java.util.*;

public class StackCollection<T> implements Collection<T>{
    private int N;	//length
    private Node node;
    private class Node{
    private T item;
    private Node last;
    }
    
    public StackCollection() {
        N = 0;
    }
    public StackCollection(T item){
    	node.item = item;
    }
    
    public T peak (){
        return node.item;
    }
    
    public T pop(){
        if (N == 0)
            throw new NullPointerException("Stack is empty.");
        N--;
        T tmp;
        tmp = node.item;
        node = node.last;
        return tmp;
    }
    
    public T push(T item){
        this.add(item);
        return item;
    }
    
    public int size(){
        return N;
    }
    
    public boolean isEmpty(){
        if (N > 0)
            return false;
        else 
            return true;
    }
    
    public int search(T item){
        if(N == 0)
            throw new NullPointerException("Stack is empty.");
        int distance = 0;
        Node tmp = this.node;
        while(true){
        	if(tmp.item == item)
            	break;
        	else{
            	if(tmp.last == null){
            		distance = -1;
            		break;
            	}
            	else{
            		tmp = tmp.last;
            		distance++;
            	}
        	}
    	}
        return distance;
    }


	public boolean  retainAll(Collection c){
    	throw new java.lang.UnsupportedOperationException("#retainAll# method is not supported.");
    }

    public void clear(){
        throw new java.lang.UnsupportedOperationException("#clear# method is not supported.");   
    }

   	public boolean removeAll(Collection  c){
    	throw new java.lang.UnsupportedOperationException("#removeAll# method is not supported.");
    }

   	public boolean addAll(Collection  c){
    	throw new java.lang.UnsupportedOperationException("#addAll# method is not supported.");
    }     

   	public boolean containsAll(Collection  c){
    	throw new java.lang.UnsupportedOperationException("#containsAll# method is not supported.");
    } 
   
   	public boolean remove(Object o){
    	throw new java.lang.UnsupportedOperationException("#remove# method is not supported.");
    }   

   	public boolean add(T item){
		if(search(item) == -1){
			Node next = new Node();
	        next.item = item;
	        next.last = this.node;
	        this.node = next;
	        N++;
			return true;
		}else{
			return false;
		}
	}

   	public Object[] toArray(Object[] item){
    	throw new java.lang.UnsupportedOperationException("#toArray# method is not supported.");
	}
	
   	public Object[] toArray(){
    	throw new java.lang.UnsupportedOperationException("#toArray# method is not supported.");
	}
	
   	public Iterator iterator(){
    	throw new java.lang.UnsupportedOperationException("#iterator# method is not supported.");
	}
	
   	public boolean contains (Object item){
       	throw new java.lang.UnsupportedOperationException("#contains# method is not supported.");
   	}
 }
    
