class Demo4{
    public static void main(String args[]){
        System.out.println("Start");
        int[] ar={10,20,30};
        final int x=10;
        try{
            //
            x=100;
        }catch(RuntimeException ex){
            x=100;
        }
        System.out.println(x);
    }
}