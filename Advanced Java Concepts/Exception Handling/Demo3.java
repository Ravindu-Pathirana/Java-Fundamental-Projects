class Demo3{
    public static void main(String args[]){
        System.out.println("Start");
        int[] ar={10,20,30};
        try{
            ar[3]=100;
            System.out.println("Inside try");
        }catch(Object ex){ //Illegal
            ex.printStackTrace();
        }
        System.out.println("End");
    }
}