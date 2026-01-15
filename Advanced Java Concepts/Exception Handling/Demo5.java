class Demo5{
    public static void main(String args[]){
        System.out.println("Start");
        int[] ar={10,20,30};
        int x,a=4,b=0;
        try{
            try{
                ar[3]=100;
            }catch(ArithmeticException ex){
                System.out.println("Inner Catch : "+ex.getMessage());
            }
        }catch(RuntimeException ex){
            System.out.println("Outer Catch : "+ex.getMessage());
        }
        System.out.println("End.");
    }
}