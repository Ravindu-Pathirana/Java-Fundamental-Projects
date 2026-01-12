class Stack{
	private Node top;
	
	public void push(int data){
		Node n1=new Node(data);
		n1.next=top;
		top=n1;
	}

    public void pop(){
        if(top==null){
            System.out.println("Stack is empty");
            return;
        }
        top=top.next;
    }

	public void printStack(){
        Node temp=top;
		System.out.print("[");
        while (temp!=null){
            System.out.print(temp.data+",");
            temp=temp.next;
        }
        System.out.println("\b]");
	}
}
class Node{
	int data;
	Node next;
	Node(int data){
		this.data=data;
	}
}
class Demo{
	public static void main(String args[]){
		Stack s1=new Stack();
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
		s1.push(50);
		s1.printStack(); //[50,40,30,20,10]
	}
}
