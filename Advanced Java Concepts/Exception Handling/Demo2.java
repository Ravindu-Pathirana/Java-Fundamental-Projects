public class Demo2 {
    public static void main(String[] args) {
        System.out.println("Start");
        int x,a=12,b=0;
        try{
            x=a/b; //
        }catch(ArithmeticException ex){
            x=-1;
            System.out.println("ArithmeticException caught: " + ex.getMessage());
        }
        System.out.println("x : "+x);
        System.out.println("End");
        
    }
}