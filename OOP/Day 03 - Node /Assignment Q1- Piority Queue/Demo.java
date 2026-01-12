class PriorityQueue{
	private Node front;
	PriorityQueue(){
		this.front=null;
	}

	public void enQueue(int data){
		Node newNode=new Node(data);

		if(isEmpty()){
			front=newNode;
			return;
		}else{
			if(data>front.data){
				newNode.next=front;
				front=newNode;
				return;
			}
			Node temp=front;
			while(temp.next!=null && temp.next.data>=data){
				temp=temp.next;
			}
			newNode.next=temp.next;
			temp.next=newNode;
			return;
		}

	}

	public void deQueue(){
		if(front==null){
			System.out.println("Queue is empty");
			return;
		}else{
			front=front.next;
			return;
		}
		
	}

	public void printQueue(){
		Node temp=front;
		System.out.print("[");
		while(temp!=null){
			System.out.print(temp.data+", ");
			temp=temp.next;
		}
		System.out.println("\b\b]");
	}

	public boolean isEmpty(){
		return front==null;
	}

}

class Node {
	int data;
	Node next;
	Node(int data){
		this.data=data;
		next=null;
	}
}
class Demo{
	public static void main(String args[]){
		PriorityQueue pq=new PriorityQueue();
		pq.enQueue(12);
		pq.enQueue(90);
		pq.enQueue(16);
		pq.enQueue(45);
		pq.enQueue(96);
		pq.enQueue(23);
		pq.printQueue(); //[96, 16, 12, 90, 45, 23]
		pq.deQueue();
		pq.printQueue(); //[90, 16, 23, 45, 12]
		pq.deQueue();
		pq.printQueue(); //[45, 16, 23, 12]
	}
}