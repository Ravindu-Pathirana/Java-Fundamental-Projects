class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
	}
}
class Demo{
	public static void main(String args[]){
		Node n1=new Node(100);
		n1.next=new Node(200);
		n1.next.next=new Node(300);
		n1.next.next.next=n1;
        System.out.println("Circular linked list created.");
        System.out.println("Node 1 data: " + n1.data);
        System.out.println("Node 2 data: " + n1.next.data);
        System.out.println("Node 3 data: " + n1.next.next.data);	
	}
}
// This code creates a circular linked list with three nodes.