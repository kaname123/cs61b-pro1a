
public class LinkedListDeque<T> {
	private node se;
	private int size;
	
	public class node{
		public T Item;
		public node next;
		public node pre;
		public node(T Item,node next,node pre){
			this.Item=Item;
			this.next=next;
			this.pre=pre;
		}
	}
	public LinkedListDeque(){
		
		se=new node(null,null,null);
		se.next=se;
		se.pre=se;
		size=0;
		
	}
/*	public LinkedListDeque(T Item){
		
		se=new node(Item,null,null);
		node f=new node(Item,se,se);
		se.next=f;
		se.pre=f;
		size=1;
	} */
	
	public void addFirst(T Item){
		
		if(size==0){
			node f=new node(Item,se,se);
			se.next=f;
			se.pre=f;
			size=1;
		}

		else{node f=new node(Item,se.next,se);
		se.next=f;
		
		f.next.pre=f;
		size++;}
	}
	
	
	public void addLast(T Item){
		node f=new node(Item,se,se.pre);
		se.pre.next=f;
		se.pre=f;
		size++;
		
		//Adds an Item to the back of the Deque.
	}
	public boolean isEmpty(){
		if(size==0)
			return true;
		else
			return false;
		
		//Returns true if deque is empty, false otherwise.
	}
	public int size(){
		
		return size;
		//Returns the number of Items in the Deque.
	}
	public void printDeque(){
		
		node f=se.next;
		while(f!=se){
			System.out.println(f.Item+" ");
			f=f.next;
			
		}
		//Prints the Items in the Deque from first to last, separated by a space.
	}
	public T removeFirst(){
		if(size==0)
			return null;
		node f=se.next;
		T d=f.Item;
		se.next=f.next;
		f.next.pre=se;
		f.next=null;
		f.pre=null;
		size--;
		return d;
		//Removes and returns the Item at the front of the Deque. If no such Item exists, returns null.
	}
	public T removeLast(){
		if(size==0)
			return null;
		node f=se.pre;
		T d=f.Item;
		f.pre.next=se;
		se.pre=f.pre;
		f.pre=null;f.next=null;
		size--;
		return d;
		
		
		//Removes and returns the Item at the back of the Deque. If no such Item exists, returns null.
	}
	public T get(int index){
		if(index<0||index>size-1)
			return null;
		node f=se.next;
		while(index!=0){
			f=f.next;
			index--;
			
		}
		return f.Item;
		//Gets the Item at the given index, where 0 is the front, 1 is the next Item, and so forth. If no such ite	
	}
	
	public T getRecursive(int index){
		if(index<0||index>size-1)
			return null;
		node f=se.next;
		if(index==0)
			return f.Item;
	
			f=f.next;
			return getRecursive(index--);
			
			
	}
	
}
