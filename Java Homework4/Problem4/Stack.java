public class Stack<T>{
    private int length;
    private Node node;
    private class Node{
    	private T item = null;
    	private Node last = null;
    }
    
    public Stack(){
        length = 0;
    }

    public Stack(T item){
    	node.item = item;
    }
    
    public T peek(){
        return node.item;
    }
    
    public T pop(){
        if(length == 0){
			throw new NullPointerException("Stack is empty.");
		}else{
			length--;
	        T tmp;
	        tmp = node.item;
	        node = node.last;
	        return tmp;
		}
    }
    
    public boolean push(T item){
		if(search(item) == -1){
			Node next = new Node();
	        next.item = item;
	        next.last = this.node;
	        this.node = next;
	        length++;
			
			return true;
		}

        return false;
    }
    
    public boolean empty(){
        if (length > 0){
			return false;
		}
        else{
			return true;
		}
    }
    
    public int search(T item){
        int distance = 1;
        Node tmp = this.node;
        while(true){
        	if(tmp.item == item)
            	break;
        	else{
            	if(tmp.last == null){
            		distance = -1;
            		break;
            	}else{
            		tmp = tmp.last;
            		distance++;
            	}
        	}
        }
        return distance;
    }
}