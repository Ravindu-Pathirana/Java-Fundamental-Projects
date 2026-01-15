import java.io.*;
class CustomerController{
    public static void addCustomer(String customer)throws IOException{
        FileWriter fr=new FileWriter("Customer.txt");
        fr.write(customer);
        fr.flush();
    }
}
class Demo12{
    public static void main(String args[]){
        try{
            CustomerController.addCustomer("C001-Ravindu");
        }catch(IOException ex){
        }
    }
}