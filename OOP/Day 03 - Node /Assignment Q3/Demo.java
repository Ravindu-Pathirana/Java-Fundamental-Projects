class Student {
    private int code;
    private String name;
    Student next;

    public Student(int code, String name){
        this.code = code;
        this.name = name;
        this.next = null;
    }
    public String getStudentDetail(){
        return  this.code + "-" + this.name ;
    }
}

class StudentList{
    Student head;
    public StudentList(){
        this.head = null;
    }
    public void add(Student s){
        if(this.head == null){
            this.head = s;
        }else{
            Student temp = this.head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = s;
        }
    }
    public void add(int index, Student s){
        if(index == 0){
            s.next = this.head;
            this.head =s;
        }else{
            Student temp = this.head;
            for(int i=0; i<index-1 && temp != null; i++){
                temp = temp.next;
            }
            s.next = temp.next;
            temp.next =s;
        }
    }

    public Student get(int index){
        Student temp = this.head;
        for(int i=0; i<index && temp != null; i++){
            temp = temp.next;
        }
        return temp;
    }

    public Student remove(int index){
        Student removed = null;
        if(index == 0 && this.head != null){
            removed = this.head;
            this.head = this.head.next;
        }else{
            Student temp = this.head;
            for(int i=0; i<index-1 && temp != null; i++){
                temp = temp.next;
            }
            removed = temp.next;
            temp.next = temp.next.next;
        }
        return removed;
    }

    public Student remove(Student s){
        Student removed = null;
        if(this.head != null && this.head.getStudentDetail().equals(s.getStudentDetail())){
            removed = this.head;
            this.head = this.head.next;
        }else{
            Student temp = this.head;
            while(temp.next != null && !temp.next.getStudentDetail().equals(s.getStudentDetail())){
                temp = temp.next;
            }
            removed = temp.next;
            temp.next = temp.next.next;
            
        }
        return removed;
    }

    public int search(Student s){
        Student temp = this.head;
        int index =0;
        while(temp != null){
            if(temp.getStudentDetail().equals(s.getStudentDetail())){
                return index;
            }
            temp =temp.next;
            index++;
        }
        return -1;
    }

    public void printList(){
        if(this.head == null){
            System.out.println("[Empty]");
        }else{
            Student temp = this.head;
            System.out.print("[");
            while(temp != null){
                System.out.print(temp.getStudentDetail()+", ");
                temp = temp.next;
            }
            System.out.println("\b\b]");
        }
    }
}
class Demo {
    public static void main(String args[]){
        StudentList stList = new StudentList();
        stList.add(new Student(1001,"Danapala"));
        stList.add(new Student(1002,"Gunapala"));
        stList.add(new Student(1003,"Somapala"));
        stList.add(new Student(1004,"Amarapala"));
        stList.add(new Student(1005,"Siripala"));

        stList.printList(); // [1001-Danapala, 1002-Gunapala, 1003-Somapala, 1004-Amarapala, 1005-Siripala]

        Student s1 = stList.get(2);
        System.out.println("Student at index 2: " + s1.getStudentDetail()); // Student at index 2: [1003-Somapala]
        
        Student s2 = stList.remove(1);
        System.out.println("Removed Student: " + s2.getStudentDetail()); // Removed Student
        stList.printList(); // [1001-Danapala, 1003-Somapala, 1004-Amarapala, 1005-Siripala]

        stList.add(1, new Student(1000,"Gananapala"));
        stList.printList(); // [1001-Danapala, 1000-Gananapala, 1003-Somapala, 1004-Amarapala, 1005-S

        int index = stList.search(new Student(1111,"Somasiri"));
        System.out.println("Index of Somasiri: " + index); // Index of Somasiri: -1

        Student s3 = stList.remove(new Student(1000,"Gananapala"));
        System.out.println("Removed Student: " + s3.getStudentDetail()); // Removed Student
        stList.printList(); // [1001-Danapala, 1003-Somapala, 1004-Amarapala, 1005-Siripala]
    }
}
