import java.io.ObjectInputStream.GetField;

public class CustomHashMap {

	enum State 
	{ 
	    EMPTY, OCCUPIED, DELETED; 
	} 
	int occupiedCount;
	final int MAX_CAPACITY = 10;
	ValueObject[] vo;
	int calculateHash(int x,int m)
	{
		return x%m;
	}
	class ValueObject{
		int data;		  
		int count;
		State state;
		ValueObject()
		{
			this.data = 0;
			this.state = State.EMPTY;
			this.count = 0;
		}
		public int getData() {
			return data;
		}
		public void setData(int data) {
			this.data = data;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public State getState() {
			return state;
		}
		public void setState(State state) {
			this.state = state;
		}
	}
	CustomHashMap()
	{
		this.vo = new ValueObject[MAX_CAPACITY];
		for(int i=0;i<MAX_CAPACITY;i++)
		{
			this.vo[i] = new ValueObject();
		}
		this.occupiedCount = 0;
	}
	
	public int getOccupiedCount() {
		return occupiedCount;
	}

	public void setOccupiedCount(int occupiedCount) {
		this.occupiedCount = occupiedCount;
	}

	boolean insert(int key,int value){
		if(getOccupiedCount()==MAX_CAPACITY)
			return false;
		else
		{
			int index = calculateHash(key,MAX_CAPACITY);
			int counter=1;
			while(this.vo[index].state!=State.EMPTY && this.vo[index].data!=value)
				index = calculateHash(key+counter++,MAX_CAPACITY);
			// Existing increment counter
			if(this.vo[index].data==value)
			{
				System.out.println("Storing "+value+" at "+index);
				this.vo[index].count+=1;
			}
				
			// New entry
			if(this.vo[index].state==State.EMPTY)
			{
				System.out.println("Storing "+value+" at "+index);
				this.vo[index].count = 1;
				this.vo[index].state = State.OCCUPIED;
				this.vo[index].data = value;
			}
			setOccupiedCount(getOccupiedCount()+1);
			return true;
		}

	}
	boolean insert(int key){
		if(getOccupiedCount()==MAX_CAPACITY)
		{
			System.out.println("Have reached max capacity "+MAX_CAPACITY);
			return false;
		}

		else
		{
			int index = calculateHash(key,MAX_CAPACITY);
			int counter=1;
			System.out.println(this.vo[index].state!=State.EMPTY || this.vo[index].state!=State.DELETED);
			while(this.vo[index].state==State.OCCUPIED && this.vo[index].data!=key)
				index = calculateHash(key+counter++,MAX_CAPACITY);
			// Existing increment counter
			if(this.vo[index].data==key)
			{
				System.out.println("[Storing "+key+" at "+index+"]");
				this.vo[index].count+=1;
			}
				
			// New entry
			if(this.vo[index].state!=State.OCCUPIED)
			{
				System.out.println("[Storing "+key+" at "+index+"]");
				this.vo[index].count = 1;
				this.vo[index].state = State.OCCUPIED;
				this.vo[index].data = key;
			}
			setOccupiedCount(getOccupiedCount()+1);
			return true;
		}

	}
	boolean search(int key){
		if(getOccupiedCount()==0)
			return false;
		else
		{
			int index = calculateHash(key,MAX_CAPACITY);
			int counter=1;
			while((this.vo[index].state==State.OCCUPIED) && this.vo[index].data!=key)
				index = calculateHash(key+counter++,MAX_CAPACITY);
			if(this.vo[index].state == State.EMPTY || this.vo[index].state == State.DELETED)
				return false;
			else
			{
				System.out.println("Found : "+key+" at "+index+" and count : "+this.vo[index].count);
				return true;				
			}
			
		}
	}
	
	boolean delete(int key){
		if(getOccupiedCount()==0)
			return false;
		else
		{
			int index = calculateHash(key,MAX_CAPACITY);
			int counter=1;
			while((this.vo[index].state==State.OCCUPIED) && this.vo[index].data!=key)
				index = calculateHash(key+counter++,MAX_CAPACITY);
			if(this.vo[index].state==State.EMPTY || this.vo[index].state==State.DELETED)
				return false;
			else
			{
				if(this.vo[index].count>1)
				{
					this.vo[index].count--;
					System.out.println("Decremented Count successfully");
				}
					
				else
				{
					setOccupiedCount(getOccupiedCount()-1);
					this.vo[index].state=State.DELETED;
					System.out.println("Deleted successfully");
				}
				
				return true;				
			}
			
		}
	}
	public static void main(String[] args) {
		CustomHashMap hm = new CustomHashMap();
		hm.insert(10);
		System.out.println("Occupied Count : "+hm.getOccupiedCount());
		hm.insert(45);
		System.out.println("Occupied Count : "+hm.getOccupiedCount());
		hm.insert(55);
		System.out.println("Occupied Count : "+hm.getOccupiedCount());	
		hm.insert(55);
		System.out.println("Occupied Count : "+hm.getOccupiedCount());	
		hm.search(10);
		hm.search(55);
		hm.search(103);
		hm.delete(55);
		hm.delete(55);
		System.out.println("Occupied Count : "+hm.getOccupiedCount());	
	}
}
