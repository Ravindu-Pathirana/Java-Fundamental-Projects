/*class Demo{
    public static void main(String args[]){
        System.out.println("Start");
        int[] ar={10,20,30};
        String s= "abcd";
        int x=5,a=2;
        try{
            ar[x]=s.charAt(0)/a;
        }catch(ArithmeticException ex){
            System.out.println("Arithmetic : "+ex.getMessage());
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Array Index : "+ex.getMessage());
        }catch(IndexOutOfBoundsException ex){
            System.out.println("Any Index : "+ex.getMessage());
        }catch(StringIndexOutOfBoundsException ex){ //
            System.out.println("String Index : "+ex.getMessage());
        }
        System.out.println("End. ");
    }
}*/
class Demo8{
    public static void main(String args[]){
        System.out.println("Start");
        int[] ar={10,20,30};
        String s= "abcd";
        int x=5,a=2;
        try{
            ar[x]=s.charAt(0)/a;
        }catch(ArithmeticException ex){
            System.out.println("Arithmetic : "+ex.getMessage());
        }catch(ArrayIndexOutOfBoundsException ex){
            System.out.println("Array Index : "+ex.getMessage());
        }catch(StringIndexOutOfBoundsException ex){
            System.out.println("String Index : "+ex.getMessage());
        }catch(IndexOutOfBoundsException ex) {
            System.out.println("Any Index : " + ex.getMessage());
        }
        System.out.println("End. ");
    }
}