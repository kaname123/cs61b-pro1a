
public class ArrayDeque<T>{
	private T[] items;
	private int size;
	private int first;
	private int last;
	private int Rfactor=2;
	public ArrayDeque(){
		 size=0;
		 items=(T[])new Object[8];
		 first=0;last=1;
	}
	public void addFirst(T x){
		if(size==items.length){
			Resize(Rfactor*size);
		}
		first=MinusOne(first);
		items[first]=x;
		size++;
		 
		}
	
	private int MinusOne(int x){
		x--;
		if(x<0)
			x=x+items.length;
		return x;
		 
	}
public void addLast(T x){
	if(size==items.length){
		Resize(Rfactor*size);
	}
	last=PlusOne(last);
	items[last]=x;
	size++;
	 
}
private int PlusOne(int x){
	x++;
	if(x>items.length-1)
		x=x-items.length;
	return x;
	 
}
public boolean isEmpty(){
	 if(size==0)
		 return true;
	 return false;
}
public int size(){
	return size;
}

public void printDeque(){
	 for(int i=first;i!=last;i=PlusOne(i)){
		 System.out.println(items[i]);
	 }
		
}
public T removeFirst(){
	 if(first==last){
		 return null;
	}
    T q=items[first];
    items[first]=null;
    first=PlusOne(first);
    size--;
    return q;
}
public T removeLast(){
	if(first==last){
		 return null;
	}
    T q=items[last];
    items[last]=null;
    last=MinusOne(last);
    size--;
    return q;

}

public T get(int index){
	 return items[index];
}
private int HelpGet(int x){
	 if(PlusOne(first)+x>items.length-1)
		 return PlusOne(first)+x-items.length;
	 return PlusOne(first)+x;
}
private void downsize(double Ufactor){
	 
}
public void Resize(int cp){
	T[] A=(T[]) new Object[cp];
	System.arraycopy(items, PlusOne(first), A, PlusOne(first), size);
	items=A;
}
}
