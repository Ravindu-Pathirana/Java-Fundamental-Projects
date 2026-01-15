/*class Demo10{
    public static int toInt(String sNum){
        char[] chArray = sNum.toCharArray();
        int num = 0;
        for (int i=0;i<chArray.length;i++){
            num*=10;
            switch(chArray[i]){
                case '0' : num+=0;break;
                case '1' : num+=1;break;
                case '2' : num+=2;break;
                case '3' : num+=3;break;
                case '4' : num+=4;break;
                case '5' : num+=5;break;
                case '6' : num+=6;break;
                case '7' : num+=7;break;
                case '8' : num+=8;break;
                case '9' : num+=9;break;
            }
        }
        return num;
    }

    public static void main(String args[]){
        String sNum=
                "100";
        int num=toInt(sNum);
        System.out.println(++num); //101
    }
}*/

class Demo11{
    public static int toInt(String sNum)throws NumberFormatException{
        return Integer.parseInt(sNum);
    }
    public static void main(String args[]){
        String sNum=
                "100";
        int num=toInt(sNum);
        System.out.println(++num); //101
        System.out.println(toInt("12345"));
        System.out.println(toInt("12000"));
        System.out.println(toInt("a"));
    }
}