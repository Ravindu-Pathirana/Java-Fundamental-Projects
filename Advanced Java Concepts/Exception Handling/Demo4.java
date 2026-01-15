class Demo4{
    public static void main(String args[]){
        System.out.println("Start");
        int[] ar={10,20,30};
        String s= "abcd";
        int x=5,a=0;
        try{
            ar[x]=s.charAt(4)/a;
        }catch(RuntimeException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("End.");
    }
}