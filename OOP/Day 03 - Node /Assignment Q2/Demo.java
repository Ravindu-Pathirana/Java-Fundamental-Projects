class PatientQueue{
    private Patient front;

    PatientQueue(){
        this.front=null;
    }

    public void enQueue(Patient p){
        if(this.front==null){
            this.front=p;
        }else{
            Patient temp=this.front;
            while(temp.next!=null){
                temp=temp.next;
            }
            temp.next=p;
        }

    }

    public Patient deQueue(){
        if(this.front==null){
            return null;
        }else{
            Patient temp=this.front;
            this.front=this.front.next;
            //temp.next=null;
            return temp;
        }
    }

    public int size(){
        int count=0;
        Patient temp=this.front;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    public void clear(){
        this.front=null;
    }

    public void printQueue(){
        if(this.front==null){
            System.out.println("{Empty}");
        }else{
            Patient temp=this.front;
            System.out.print("{");
            while(temp!=null){
                System.out.print(temp.getPatientDetail());
                if(temp.next!=null){
                    System.out.print(", ");
                }
                temp=temp.next;
            }
            System.out.println("}");
        }
    }
}

class Patient{
    private int patientId;
    private String patientName;
    public Patient next;

    public Patient(int id, String name){
        this.patientId=id;
        this.patientName=name;
        this.next=null;
    }

    public String getPatientDetail(){
        return "["+this.patientId+"-"+this.patientName+"]";
    }
}


class Demo{
    public static void main(String args[]){
        PatientQueue queue=new PatientQueue();

        queue.enQueue(new Patient(101,"Amal"));
        queue.enQueue(new Patient(102,"Nimal"));
        queue.enQueue(new Patient(103,"Ramal"));
        queue.enQueue(new Patient(104,"Bimal"));

        queue.printQueue(); //{[101-Amal], [102-Niaml], [103-Ramal], [104-Bimal]}

        Patient firstPatient= queue.deQueue();

        System.out.println(firstPatient.getPatientDetail()); //[1001-Amal]

        queue.printQueue(); //{[102-Niaml], [103-Ramal], [104-Bimal]}

        System.out.println("No of patient of the queue : "+queue.size()); //3

        queue.clear();

        queue.printQueue(); //{Empty}

        System.out.println("No of patient of the queue : "+queue.size()); //0
    }
}