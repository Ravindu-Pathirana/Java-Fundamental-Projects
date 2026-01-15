class Demo10{
    public static void main(String args[]){
        System.out.println("Start");
        int[] ar={10,20,30};
        String s= "abcd";
        int x=5,a=2;
        try{
            x=45/0;
        }catch(ArrayIndexOutOfBoundsException | StringIndexOutOfBoundsException ex){
            System.out.println("Index : "+ex.getMessage());
        }catch(IndexOutOfBoundsException ex){
            System.out.println("Any Index : "+ex.getMessage());
        }finally{
            System.out.println("finally block.. ");
        }
        System.out.println("End. ");
    }
}