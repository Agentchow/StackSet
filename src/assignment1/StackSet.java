package assignment1;

public class StackSet implements StackSet_Interface {
	private Node head; 
	private final int limit;  
	private int size;   
	  
	public StackSet( int maxNumElts ){ 
		head = null;                 
		limit = maxNumElts;          
		size = 0;
	}
	  
	public Node getRoot() {return head;}
	
	public boolean push(double elt) {
		//Check to see if have node
		if(contains(elt)) {
			//Check to see if its already up top
			if(peek() == elt) {return true;}
			//If not, move the nodes
			//h to iterate through stack/list
			Node h = head;
			//prev to keep track of node that needs to be added 
			//Fast(head) and slow/lagging(prev) pointer not Floyds
			Node prev = null;
			while(h != null) {
				if(h.getValue() == elt) {
					//Set slow pointer to heads next
					prev.setNext(h.getNext());
					size--;
					return push(elt);
				}
				prev = h;
				//Iterate through
				h = h.getNext();
			}
			return false;
		}//Doesn't have the node	
			//Check to see if full
			if(isFull()) {return false;}
			//Else create a newHead 
			Node newHead = new NodeImpl(elt, head);
			head = newHead;
			size++;
			return true;
	}
	
	public boolean pop() {
		if(!isEmpty()) {
			head = head.getNext();
			size--; 
			return true;
		}	
		return false;
	}
	
	public double peek() {
		if(isEmpty()) {return Double.NaN;} 			
		return head.getValue();
	}
	
	public boolean contains(double elt) {
		Node h = head;
		while(h != null) {
			if(h.getValue()==elt) return true;
			h = h.getNext();
		}
		return false;
	}
	
	public int size() {
//		int s = 0;
//		Node temp = head;
//		while(temp != null) {
//			s++;
//			temp = temp.getNext();
//		}
//		return s;
		return size;
	}
	
	public int limit() {return limit;}
	
	public boolean isEmpty() {
		if(size()==0) {return true;}
		return false;
	}
	
	public boolean isFull() {
		if(size()==limit()) {return true;}
		return false;
	}
	
}