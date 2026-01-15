class NoElementException extends RuntimeException{
    public String getMessage(){
        return "there is no second max here.";
    }
}


class Demo13{

    public static int secondMax(int[] ar) throws NoElementException{
        int max=Integer.MIN_VALUE;
        int secondmax=Integer.MIN_VALUE;
        for (int i=0;i<ar.length;i++){
            if(ar[i]>max){
                secondmax=max;
                max = ar[i];
            } else if (ar[i]>secondmax && ar[i] !=max) {
                secondmax=ar[i];
            }
        }
        if (secondmax == Integer.MIN_VALUE){
            throw new NoElementException();
        }else{
            return secondmax;
        }
    }



    public static void main(String args[]){
        int[] ar ={12,12,12,12};
        int[] br ={10,12,10,12,12};
        int[] cr ={10,20,30,40,50};

        try{
            System.out.println("Second max of br : "+secondMax(br));//10
            System.out.println("Second max of cr : "+secondMax(cr));//40
            System.out.println("Second max of ar : "+secondMax(ar));//throws an exception
        }catch(NoElementException ex){
            System.out.println(ex.getMessage());
        }


    }
}