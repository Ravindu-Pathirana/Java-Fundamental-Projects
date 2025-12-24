import java.util.*;
class Example{
    public static Scanner input=new Scanner(System.in);

    public static String[] orderid=new String[0];
	public static String[] phonenumber=new String[0];
	public static String[] Size=new String[0];
	public static int[] Quantity=new int[0];
	public static double[] Amountorder=new double[0];
	public static String[] status=new String[0];
	public static String[] tempSize=new String[0];
	public static int [] tempQuantity=new int[0];
	public static double[] tempAmountorder=new double[0];
	
    public static String generateid(){
        if(orderid.length>0){
            int id=Integer.parseInt(orderid[orderid.length-1].split("[#]")[1]);
            id++;
            return String.format("ODR#%05d",id);
        }
        return "ODR#00001";
    }
    public static boolean phonenumcheck(String phonenum){
		if(phonenum.charAt(0)=='0'& phonenum.length()==10){
			return true;
			}
		return false;
		}
	public static boolean sizecheck(String size){
		if(size.equals("XS")||size.equals("S")||size.equals("M")||size.equals("L")||size.equals("XL")||size.equals("XXL")){
				return true;
			}
		return false;
	}
	public static double Amount(String size,int QTY){
		double amount=1;
		if(size.equals("XS")){
			amount=600*QTY;
		}else if(size.equals("S")){
			amount=800*QTY;
		}else if(size.equals("M")){
			amount=900*QTY;
		}else if(size.equals("L")){
			amount=1000*QTY;
		}else if(size.equals("XL")){
			amount=1100*QTY;
		}else if(size.equals("XXL")){
			amount=1200*QTY;
		}
		return amount;
	}
	public static boolean isphonenumbervalid(String phonenum){
			for (int i = 0; i <phonenumber.length ; i++){
				if(phonenumber[i].equals(phonenum)){
					return true;
				}
			}
			return false;	
	}
    public static void placeorder(){
	L2:do{
		clearConsole();
        String id=generateid();
        System.out.println("\r\n  _____  _                   ____          _           \r\n |  __ \\| |                 / __ \\        | |          \r\n | |__) | | __ _  ___ ___  | |  | |_ __ __| | ___ _ __ \r\n |  ___/| |/ _` |/ __/ _ \\ | |  | | \'__/ _` |/ _ \\ \'__|\r\n | |    | | (_| | (_|  __/ | |__| | | | (_| |  __/ |   \r\n |_|    |_|\\__,_|\\___\\___|  \\____/|_|  \\__,_|\\___|_|   \r\n                                                       \r\n                                                       \r\n");
		System.out.println("--------------------------------------------------------");
        System.out.println("\nEnter Order ID : "+id);
		L1:do{
			System.out.print("\nEnter Customer Phone Number : ");
			String phonenum=input.next();
			if (phonenumcheck(phonenum)){
				do{
					System.out.print("\nEnter T-Shirt Size (XS/S/M/L/XL/XXL) : ");
					String size=input.next();
					if(sizecheck(size)){
						do{
							System.out.print("\nEnter QTY : ");
							int QTY=input.nextInt();
							if(QTY>0){
								double amount=Amount(size,QTY);
								System.out.println("\nAmount : "+amount);
								String statusA="processing";
								l12:do{
									System.out.print("\nDo you want to place this order ? (Y/N) : ");
									char op=input.next().charAt(0);
									if(op=='y'||op=='Y'){
										orderid = extendarrayString(orderid);
										orderid[orderid.length-1]=id;
										phonenumber=extendarrayString(phonenumber);
										phonenumber[phonenumber.length-1]=phonenum;
										Size=extendarrayString(Size);
										Size[Size.length-1]=size;
										Quantity=extendarrayInt(Quantity);
										Quantity[Quantity.length-1]=QTY;
										Amountorder=extendarrayDouble(Amountorder);
										Amountorder[Amountorder.length-1]=amount;
										status=extendarrayString(status);
										status[status.length-1]=statusA;
										System.out.println("\n\tOrder Placed..!");
											break;
									}else if(op=='n'||op=='N'){
										break;
									}else{
										System.out.println("\n\tWrong input...Input correct..\n");
										continue l12;
									}
									}while(true);
								l21:do{
										System.out.print("\nDo you want to place another order ? (Y/N) : ");
										char op=input.next().charAt(0);
										if(op=='y'||op=='Y'){
											continue L2;
										}else if(op=='n'||op=='N'){
											return;
										}else{
											System.out.println("\n\tWrong input...Input correct..\n");
											continue l21;
										}
								}while(true);
								}
						} while (true);
						
					}else{
						System.out.print("\033[2A");
						System.out.print("\033[0J");
					}
				} while (true);
				
			}else{
				System.out.println("\n\tInvalid Phone Number... Try again");
				l11:do{
						System.out.print("\nDo you want to enter Phone Number again(Y/N) : ");
						char op=input.next().charAt(0);
						if(op=='y'||op=='Y'){
							System.out.print("\033[6A");
							System.out.print("\033[0J");
							continue L1;
						}else if(op=='n'||op=='N'){
								return;
						}else{
							System.out.println("\n\tWrong input...Input correct..\n");
							continue l11;
						}
						}while(true);
			}
		} while (true);
	} while (true);	
    }
    public static String[] removeDuplicates(String[] ar){
			String br[]=new String[0];
			for (int i = 0; i < ar.length; i++){
				if(!isduplicate(br,ar[i])){
					br=extendarrayString(br);
					br[br.length-1]=ar[i];
				}else{
					int j=isduplicatefindelement(br,ar[i]);
					tempAmountorder[j]+=tempAmountorder[i];
					tempQuantity[j]+=tempQuantity[i];
					tempAmountorder=mergearrayDouble(tempAmountorder,i);
					tempQuantity=mergearrayInt(tempQuantity,i);
				}
			}
			return br;
	}
	public static boolean isduplicate(String[] ar,String a){
			for (int i = 0; i <ar.length ; i++){
				if (ar[i].equals(a)){
					return true;
				}
			}
			return false;
	}
	public static int isduplicatefindelement(String[] ar,String a){
			for (int i = 0; i <ar.length ; i++){
				if (ar[i].equals(a)){
					return i;
				}
			}
			return 0;
	}
	public static String[] createsizeString(String[] tempSize,String [] allSize){
		L6:for (int i = 0; i <tempSize.length ; i++){
			for (int j = 0; j < allSize.length; j++){
				if (tempSize[i].equals(allSize[j])){
					allSize=mergearrayString(allSize,j);
					continue L6;
				}
			}
		}
		String []temp=new String[tempSize.length+allSize.length];
		for (int i = 0; i <tempSize.length ; i++){
			temp[i]=tempSize[i];
		}
		for (int i = 0; i < allSize.length; i++){
			temp[i+tempSize.length]=allSize[i];
		}
		return temp;	
	}
	public static int[] createsizeInt(int[] tempQuantity){
		int[]br=new int[6];
		for (int i = 0; i <tempQuantity.length ; i++){
			br[i]=tempQuantity[i];
		}
		return br;
	}
	public static double[] createsizeDouble(double[] tempAmountorder){
		double[]br=new double[6];
		for (int i = 0; i <tempAmountorder.length ; i++){
			br[i]=tempAmountorder[i];
		}
		return br;
	}
    public static void searchcustomer(){
		L3:do{
		clearConsole();
		System.out.println("\r\n   _____                     _        _____          _                            \r\n  / ____|                   | |      / ____|        | |                           \r\n | (___   ___  __ _ _ __ ___| |__   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ \r\n  \\___ \\ / _ \\/ _` | \'__/ __| \'_ \\  | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__|\r\n  ____) |  __/ (_| | | | (__| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |   \r\n |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|   \r\n                                                                                  \r\n                                                                                  \r\n");
		System.out.println("---------------------------------------------------------------------------------");
		System.out.print("Enter Customer Phone Number : ");
		String phonenum=input.next();
		if(isphonenumbervalid(phonenum)){
			tempAmountorder=new double[0];
			tempQuantity=new int[0];
			tempSize=new String[0];
			for (int i = 0; i <phonenumber.length ; i++){
				if (phonenumber[i].equals(phonenum)){
					tempSize=extendarrayString(tempSize);
					tempSize[tempSize.length-1]=Size[i];
					tempQuantity=extendarrayInt(tempQuantity);
					tempQuantity[tempQuantity.length-1]=Quantity[i];
					tempAmountorder=extendarrayDouble(tempAmountorder);
					tempAmountorder[tempAmountorder.length-1]=Amountorder[i];
				}
			}
			tempSize=removeDuplicates(tempSize);
			for(int i=0; i<tempAmountorder.length-1; i++){
				for(int j=0; j<tempAmountorder.length-1; j++){
					if(tempAmountorder[j]<tempAmountorder[j+1]){
						double t1=tempAmountorder[j];
						tempAmountorder[j]=tempAmountorder[j+1];
						tempAmountorder[j+1]=t1;
						String t2=tempSize[j];
						tempSize[j]=tempSize[j+1];
						tempSize[j+1]=t2;
						int t3=tempQuantity[j];
						tempQuantity[j]=tempQuantity[j+1];
						tempQuantity[j+1]=t3;
					}	
				}
			}
			String[] allSize={"XS","S","M","L","XL","XXL"};
			String[] a=createsizeString(tempSize,allSize);
			int[] b=createsizeInt(tempQuantity);
			double[] c=createsizeDouble(tempAmountorder);
			double total=0;
			for (int i = 0; i <tempAmountorder.length ; i++){
					total+=tempAmountorder[i];
			}
			System.out.println("\n\t+----------+----------+---------------+");
			System.out.println("\t|  Size    |    QTY   |      Amount   |");
			System.out.println("\t+----------+----------+---------------+");
			for (int i = 0; i < a.length; i++){
				System.out.println("\t|\t   |\t      |\t              |");
				System.out.println("\t|"+a[i]+"\t   |"+b[i]+"\t      |"+c[i]+"\t      |");
			}
			System.out.println("\t+----------+----------+---------------+");
			System.out.println("\t|   Total Amount      |   "+total+"      |");
			System.out.println("\t+---------------------+---------------+");
		}else{
			System.out.println("\n\tInvalid input...");
		}
		l31:do{
				System.out.print("\nDo you want to search another customer ? (Y/N) : ");
				char op=input.next().charAt(0);
				if(op=='y'||op=='Y'){
					continue L3;
				}else if(op=='n'||op=='N'){
						return;
				}else{
					System.out.println("\n\tWrong input...Input correct..\n");
						continue l31;
				}
				}while(true);
		} while (true);	
	}
	public  static boolean isidvalid(String id){
		for (int i = 0; i < orderid.length; i++){
			if (orderid[i].equals(id)){
				return true;
			}
		}
		return false;	
	}
	public static int elementnumber(String id){
			for (int i = 0; i < orderid.length; i++){
				if (orderid[i].equals(id)){
					return i;
				}
			}
		return -1;
	}
	public static void searchorder(){
		L4:do{
		clearConsole();
		System.out.println("\r\n   _____                     _        ____          _           \r\n  / ____|                   | |      / __ \\        | |          \r\n | (___   ___  __ _ _ __ ___| |__   | |  | |_ __ __| | ___ _ __ \r\n  \\___ \\ / _ \\/ _` | \'__/ __| \'_ \\  | |  | | \'__/ _` |/ _ \\ \'__|\r\n  ____) |  __/ (_| | | | (__| | | | | |__| | | | (_| |  __/ |   \r\n |_____/ \\___|\\__,_|_|  \\___|_| |_|  \\____/|_|  \\__,_|\\___|_|   \r\n                                                                \r\n                                                                \r\n");
		System.out.println("---------------------------------------------------------------");
		System.out.print("Enter order ID : ");
		String id=input.next();
		if(isidvalid(id)){
			int i=elementnumber(id);
			System.out.println("\nPhone Number   : "+phonenumber[i]);
			System.out.println("Size           : "+Size[i]);
			System.out.println("QTY            : "+Quantity[i]);
			System.out.println("Amount         : "+Amountorder[i]);
			System.out.println("Status         : "+status[i]);
		}else{
			System.out.println("\n\tInvalid input...");
		}
		l41:do{
				System.out.print("\nDo you want to search another order ? (Y/N) : ");
				char op=input.next().charAt(0);
				if(op=='y'||op=='Y'){
					continue L4;
				}else if(op=='n'||op=='N'){
						return;
				}else{
					System.out.println("\n\tWrong input...Input correct..\n");
						continue l41;
				}
				}while(true);
		} while (true);
	}
	public static void deleteorder(){
	L5:do{
		clearConsole();
		System.out.println("\r\n  _____       _      _          ____          _           \r\n |  __ \\     | |    | |        / __ \\        | |          \r\n | |  | | ___| | ___| |_ ___  | |  | |_ __ __| | ___ _ __ \r\n | |  | |/ _ \\ |/ _ \\ __/ _ \\ | |  | | \'__/ _` |/ _ \\ \'__|\r\n | |__| |  __/ |  __/ ||  __/ | |__| | | | (_| |  __/ |   \r\n |_____/ \\___|_|\\___|\\__\\___|  \\____/|_|  \\__,_|\\___|_|   \r\n                                                          \r\n                                                          \r");
		System.out.println("---------------------------------------------------------------");
		System.out.print("\nEnter order ID : ");
		String id=input.next();
		if(isidvalid(id)){
			int i=elementnumber(id);
			System.out.println("\nPhone Number   : "+phonenumber[i]);
			System.out.println("Size           : "+Size[i]);
			System.out.println("QTY            : "+Quantity[i]);
			System.out.println("Amount         : "+Amountorder[i]);
			System.out.println("Status         : "+status[i]);
			l52:do{
				System.out.print("\nDo you want to delete this order ? (Y/N) : ");
				char op=input.next().charAt(0);
				if(op=='y'||op=='Y'){
					orderid=mergearrayString(orderid,i);
					phonenumber=mergearrayString(phonenumber,i);
					Size=mergearrayString(Size,i);
					status=mergearrayString(status,i);
					Quantity=mergearrayInt(Quantity,i);
					Amountorder=mergearrayDouble(Amountorder,i);
					System.out.println("\n\tOrder Deleted..!");
					break;
				}else if(op=='n'||op=='N'){
						return;
				}else{
					System.out.println("\n\tWrong input...Input correct..\n");
						continue l52;
				}
				}while(true);
		}else{
			System.out.println("\n\tInvalid input...");
		}
		l51:do{
				System.out.print("\nDo you want to delete another order ? (Y/N) : ");
				char op=input.next().charAt(0);
				if(op=='y'||op=='Y'){
					continue L5;
				}else if(op=='n'||op=='N'){
						return;
				}else{
					System.out.println("\n\tWrong input...Input correct..\n");
						continue l51;
				}
				}while(true);
		} while (true);
	}
	public static String[] mergearrayString(String[] ar,int num){
		String[] temp=new String[ar.length-1];
		int count=0;
		for (int i = 0; i <ar.length ; i++){
			if (num==i){
				continue;
			}else{
				temp[count]=ar[i];
				count++;
				}
		}
		return temp;	
	}
	public static int[] mergearrayInt(int[] ar,int num){
		int[] temp=new int[ar.length-1];
		int count=0;
		for (int i = 0; i < ar.length; i++){
			if (num==i){
				continue;
			}else{
				temp[count]=ar[i];
				count++;
				}
		}
		return temp;	
	}
	public static double[] mergearrayDouble(double[] ar,int num){
		double[] temp=new double[ar.length-1];
		int count=0;
		for (int i = 0; i < ar.length; i++){
			if (num==i){
				continue;
			}else{
				temp[count]=ar[i];
				count++;
				}
		}
		return temp;	
	}
    public static String[] extendarrayString(String[] br){
        String[] temp= new String[br.length+1];
        for(int i=0;i<br.length;i++){
            temp[i]=br[i];
        }
        return temp;
    }
    public static int[] extendarrayInt(int[] br){
        int[] temp= new int[br.length+1];
        for(int i=0;i<br.length;i++){
            temp[i]=br[i];
        }
        return temp;
    }
     public static double[] extendarrayDouble(double[] br){
        double[] temp= new double[br.length+1];
        for(int i=0;i<br.length;i++){
            temp[i]=br[i];
        }
        return temp;
    }
    public static void main (String args[]){
    L1:do{
        clearConsole();
        System.out.println("\r\n /$$$$$$$$                 /$$       /$$                            /$$$$$$  /$$                          \r\n| $$_____/                | $$      |__/                           /$$__  $$| $$                          \r\n| $$    /$$$$$$   /$$$$$$$| $$$$$$$  /$$  /$$$$$$  /$$$$$$$       | $$  \\__/| $$$$$$$   /$$$$$$   /$$$$$$ \r\n| $$$$$|____  $$ /$$_____/| $$__  $$| $$ /$$__  $$| $$__  $$      |  $$$$$$ | $$__  $$ /$$__  $$ /$$__  $$\r\n| $$__/ /$$$$$$$|  $$$$$$ | $$  \\ $$| $$| $$  \\ $$| $$  \\ $$       \\____  $$| $$  \\ $$| $$  \\ $$| $$  \\ $$\r\n| $$   /$$__  $$ \\____  $$| $$  | $$| $$| $$  | $$| $$  | $$       /$$  \\ $$| $$  | $$| $$  | $$| $$  | $$\r\n| $$  |  $$$$$$$ /$$$$$$$/| $$  | $$| $$|  $$$$$$/| $$  | $$      |  $$$$$$/| $$  | $$|  $$$$$$/| $$$$$$$/\r\n|__/   \\_______/|_______/ |__/  |__/|__/ \\______/ |__/  |__/       \\______/ |__/  |__/ \\______/ | $$____/ \r\n                                                                                                | $$      \r\n                                                                                                | $$      \r\n                                                                                                |__/      \r\n");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.println("\n\t[1] Place Order        \t\t[2]Search Customer");
        System.out.println("\n\t[3] Search Order       \t\t[4]view Reports");
        System.out.println("\n\t[5] Change Order Status\t\t[6]Delete Order");
        L2:do{
            System.out.print("\n\n\tInput Option : ");
            int option=input.nextInt();
            switch(option){
                case 1:placeorder();
						continue L1;
                case 2:searchcustomer();
						continue L1;
                case 3:searchorder();
						continue L1;
				case 6:deleteorder();
						continue L1;
            }
        }while(true);
    }while(true);
    }
    public final static void clearConsole() {
	try {
	final String os = System.getProperty("os.name");
	if (os.contains("Windows")) {
		new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	} else {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	} catch (final Exception e) {
		e.printStackTrace();
		// Handle any exceptions.
	}
  }
}
