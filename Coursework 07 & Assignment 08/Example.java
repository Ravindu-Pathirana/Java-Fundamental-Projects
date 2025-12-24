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
	public static String[] tempphonenumber=new String[0];
	
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
    public static String[] removeDuplicatessearchcustomer(String[] ar){
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
			tempSize=removeDuplicatessearchcustomer(tempSize);
			for(int i=0; i<tempAmountorder.length-1; i++){
				for(int j=0; j<tempAmountorder.length-1-i; j++){
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
			System.out.println("\t|   Total Amount      |   "+total+"     |");
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
	public static void changeorderstatus(){
		L6:do{
		clearConsole();
		System.out.println("\r\n   ____          _              _____ _        _             \r\n  / __ \\        | |            / ____| |      | |            \r\n | |  | |_ __ __| | ___ _ __  | (___ | |_ __ _| |_ _   _ ___ \r\n | |  | | \'__/ _` |/ _ \\ \'__|  \\___ \\| __/ _` | __| | | / __|\r\n | |__| | | | (_| |  __/ |     ____) | || (_| | |_| |_| \\__ \\\r\n  \\____/|_|  \\__,_|\\___|_|    |_____/ \\__\\__,_|\\__|\\__,_|___/\r\n                    ");
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
			if (status[i]!="delivered"){
				l61:do{
				System.out.print("\nDo you want to change this order status ? (Y/N) : ");
				char op=input.next().charAt(0);
				if(op=='y'||op=='Y'){
					if (status[i].equals("processing")){
						System.out.println("\n\t[1] Order Delivering");
						System.out.println("\n\t[2] Order Delivered");
						l611:do{
							System.out.print("\n Enter option : ");
							int op1= input.nextInt();
							switch (op1){
								case 1:status[i]="delivering";
										System.out.println("\n\tStatus Updated..! ");break l61;
								case 2:status[i]="delivered";
										System.out.println("\n\tStatus Updated..! ");break l61;
								default:System.out.println("\n\tInvalid input..");
										continue l611;
							}
						} while (true);	
					}else if (status[i].equals("delivering")){
						System.out.println("\n\t[1] Order Delivered");
						l612:do{
							System.out.print("\n Enter option : ");
							int op2= input.nextInt();
							switch (op2){
								case 1:status[i]="delivered";
										System.out.println("\n\tStatus Updated..! ");break l61;
								default:System.out.println("\n\tInvalid input..");
										continue l612;
							}
						} while (true);	
					}
					
				}else if(op=='n'||op=='N'){
						break;
				}else{
					System.out.println("\n\tWrong input...Input correct..\n");
						continue l61;
				}
				}while(true);
			}else if (status[i].equals("delivered")){
						System.out.println("\n\tCan't change this order status,Order already delivered..!");
			}
		}else{
			System.out.println("\n\tInvalid input...");
		}
		l62:do{
				System.out.print("\nDo you want to change another order status ? (Y/N) : ");
				char op=input.next().charAt(0);
				if(op=='y'||op=='Y'){
					continue L6;
				}else if(op=='n'||op=='N'){
						return;
				}else{
					System.out.println("\n\tWrong input...Input correct..\n");
						continue l62;
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
				case 4:viewreports();
						continue L1;
				case 5:changeorderstatus();
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
    public static void viewreports(){
		clearConsole();
		System.out.println("\r\n  _____                       _       \r\n |  __ \\                     | |      \r\n | |__) |___ _ __   ___  _ __| |_ ___ \r\n |  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|\r\n | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n |_|  \\_\\___| .__/ \\___/|_|   \\__|___/\r\n            | |                       \r\n            |_|                       \r\n");
		System.out.println("------------------------------------------");
		System.out.println("\n\t[1] Customer Reports ");
		System.out.println("\n\t[2] Item Reports ");
		System.out.println("\n\t[3] Orders Reports ");
		L7:do{
			System.out.print("\n\nEnter Option : ");
			int op=input.nextInt();
			switch (op){
				case 1:customerreports();return;
				case 2:itemreports();return;
				case 3:ordersreports();return;
				default:System.out.println("\n\t Invalid Input..");
						continue L7;
		}
		} while (true);
	}
	public static void customerreports(){
		clearConsole();
		System.out.println("\r\n   _____          _                              _____                       _       \r\n  / ____|        | |                            |  __ \\                     | |      \r\n | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ \r\n | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__| |  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|\r\n | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/\r\n                                                           | |                       \r\n                                                           |_|                       \r\n");
		System.out.println("--------------------------------------------------------------------------------------");
		System.out.println("\n\t[1] Best in Customers ");
		System.out.println("\n\t[2] View Customers ");
		System.out.println("\n\t[3] All Customer Report ");
		L8:do{
			System.out.print("\n\nEnter Option : ");
			int op=input.nextInt();
			switch (op){
				case 1:bestincustomers();return;
				case 2:viewcustomers();return;
				case 3:allcustomerreports();return;
				default:System.out.println("\n\t Invalid Input..");
						continue L8;
		}
		} while (true);	
	}
	public static void allcustomerreports(){
		clearConsole();
		System.out.println("\r\n           _ _    _____          _                              _____                       _   \r\n     /\\   | | |  / ____|        | |                            |  __ \\                     | |  \r\n    /  \\  | | | | |    _   _ ___| |_ ___  _ __ ___   ___ _ __  | |__) |___ _ __   ___  _ __| |_ \r\n   / /\\ \\ | | | | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__| |  _  // _ \\ \'_ \\ / _ \\| \'__| __|\r\n  / ____ \\| | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_ \r\n /_/    \\_\\_|_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|\r\n                                                                          | |                   \r\n                                                                          |_|                  ");
		System.out.println("-----------------------------------------------------------------------------------------");
		double[] tempAmountorder1=new double[Amountorder.length];
		int[] tempQuantity1=new int[Quantity.length];
		String[] tempphonenumber1=new String[phonenumber.length];
		String[] tempSize1=new String[Size.length];
		System.arraycopy(Amountorder, 0, tempAmountorder1, 0, tempAmountorder1.length);
		System.arraycopy(Quantity, 0, tempQuantity1, 0, tempQuantity1.length);
		System.arraycopy(phonenumber, 0, tempphonenumber1, 0, tempphonenumber1.length);
		System.arraycopy(Size, 0, tempSize1, 0, tempSize1.length);
		System.out.println("\t+---------------+-------+-------+-------+-------+-------+-------+---------------+");
		System.out.println("\t|Phone Number   |   XS  |    S  |    M  |    L  |   XL  |  XXL  |     Total     |");
		System.out.println("\t+---------------+-------+-------+-------+-------+-------+-------+---------------+");
		for (int i = 0; i <tempphonenumber1.length ; i++){
			tempAmountorder=new double[0];
			tempQuantity=new int[0];
			tempSize=new String[0];
			tempphonenumber=new String[0];
			tempSize=extendarrayString(tempSize);
			tempSize[tempSize.length-1]=tempSize1[i];
			tempQuantity=extendarrayInt(tempQuantity);
			tempQuantity[tempQuantity.length-1]=tempQuantity1[i];
			tempAmountorder=extendarrayDouble(tempAmountorder);
			tempAmountorder[tempAmountorder.length-1]=tempAmountorder1[i];
			for (int j = i+1; j < tempphonenumber1.length; j++){
				if (tempphonenumber1[i].equals(tempphonenumber1[j])){
						tempSize=extendarrayString(tempSize);
						tempSize[tempSize.length-1]=tempSize1[j];
						tempQuantity=extendarrayInt(tempQuantity);
						tempQuantity[tempQuantity.length-1]=tempQuantity1[j];
						tempAmountorder=extendarrayDouble(tempAmountorder);
						tempAmountorder[tempAmountorder.length-1]=tempAmountorder1[j];
						tempAmountorder1=mergearrayDouble(tempAmountorder1,j);
						tempQuantity1=mergearrayInt(tempQuantity1,j);
						tempphonenumber1=mergearrayString(tempphonenumber1,j);
						tempSize1=mergearrayString(tempSize1,j);
						j--;
				}
			}
			double total=0;
			for (int k = 0; k <tempAmountorder.length ; k++){
				total+=tempAmountorder[k];
			}
			int[] b=new int[6];
			for (int l = 0; l < tempSize.length; l++){
				if (tempSize[l].equals("XS")){
					b[0]+=tempQuantity[l];
				}else if(tempSize[l].equals("S")){
					b[1]+=tempQuantity[l];
				}else if(tempSize[l].equals("M")){
					b[2]+=tempQuantity[l];
				}else if(tempSize[l].equals("L")){
					b[3]+=tempQuantity[l];
				}else if(tempSize[l].equals("XL")){
					b[4]+=tempQuantity[l];
				}else if(tempSize[l].equals("XXL")){
					b[5]+=tempQuantity[l];
				}
			}
			System.out.println("\t|\t\t|\t|\t|\t|\t|\t|\t|\t\t|");
			System.out.println("\t|"+tempphonenumber1[i]+"\t|"+b[0]+"\t|"+b[1]+"\t|"+b[2]+"\t|"+b[3]+"\t|"+b[4]+"\t|"+b[5]+"\t|"+total+"  \t|");
		}
		System.out.println("\t+---------------+-------+-------+-------+-------+-------+-------+---------------+");
		do{
			System.out.print("\n\nTo access the Main Menu,please enter 0 : ");
			int op=input.nextInt();
			if(op==0){
				return;
			}else{
				System.out.print("\033[3A");
				System.out.print("\033[0J");
			}
		} while (true);		
	}
	public static void viewcustomers(){
		clearConsole();
		System.out.println("\r\n __      ___                  _____          _                                \r\n \\ \\    / (_)                / ____|        | |                               \r\n  \\ \\  / / _  _____      __ | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ \r\n   \\ \\/ / | |/ _ \\ \\ /\\ / / | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__/ __|\r\n    \\  /  | |  __/\\ V  V /  | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\\r\n     \\/   |_|\\___| \\_/\\_/    \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/\r\n                                                                              \r\n                                                                              ");
		System.out.println("-----------------------------------------------------------------------------------------");
		tempAmountorder=new double[Amountorder.length];
		tempQuantity=new int[Quantity.length];
		tempphonenumber=new String[phonenumber.length];
		tempSize=new String[Size.length];
		System.arraycopy(Amountorder, 0, tempAmountorder, 0, tempAmountorder.length);
		System.arraycopy(Quantity, 0, tempQuantity, 0, tempQuantity.length);
		System.arraycopy(phonenumber, 0, tempphonenumber, 0, tempphonenumber.length);
		System.arraycopy(Size, 0, tempSize, 0, tempSize.length);
		removeDuplicatesviewreports();	
		makecorrectorder();
		String[] a=tempphonenumber;
		int[] b=tempQuantity;
		double[] c=tempAmountorder;
		System.out.println("\t+-----------------+---------+-----------------+");
		System.out.println("\t|Customer ID	  | All QTY |   Total Amount  |");
		System.out.println("\t+-----------------+---------+-----------------+");
		for (int i = 0; i <tempAmountorder.length ; i++){
		System.out.println("\t|\t\t  |\t    |\t\t      |");
		System.out.println("\t|"+a[i]+"\t  |"+b[i]+"\t    |"+c[i]+"\t      |");
		}
		System.out.println("\t+-----------------+---------+-----------------+");
		do{
			System.out.print("\n\nTo access the Main Menu,please enter 0 : ");
			int op=input.nextInt();
			if(op==0){
				return;
			}else{
				System.out.print("\033[3A");
				System.out.print("\033[0J");
			}
		} while (true);	
	}
	public static void removeDuplicatesviewreports(){
			for (int i = 0; i < tempSize.length; i++){
				for (int j =i+1; j <tempSize.length ; j++){
					if(tempSize[i].equals(tempSize[j]) & tempphonenumber[i].equals(tempphonenumber[j])){
						tempAmountorder[i]+=tempAmountorder[j];
						tempQuantity[i]+=tempQuantity[j];
						tempAmountorder=mergearrayDouble(tempAmountorder,j);
						tempQuantity=mergearrayInt(tempQuantity,j);
						tempphonenumber=mergearrayString(tempphonenumber,j);
						tempSize=mergearrayString(tempSize,j);
					}
				}
			}		
	}
	public static void makecorrectorder(){
			for (int i = 0; i <tempphonenumber.length ; i++){
				for (int j = i+1; j < tempphonenumber.length; j++){
					if (tempphonenumber[i].equals(tempphonenumber[j])){
							tempAmountorder[i]+=tempAmountorder[j];
							tempQuantity[i]+=tempQuantity[j];
							tempAmountorder=mergearrayDouble(tempAmountorder,j);
							tempphonenumber=mergearrayString(tempphonenumber,j);
							tempQuantity=mergearrayInt(tempQuantity,j);
							tempSize=mergearrayString(tempSize,j);	
						}
					}
				}
	}
	public static void bestincustomers(){
		clearConsole();
		System.out.println("\r\n  ____            _     _____          _____          _                                \r\n |  _ \\          | |   |_   _|        / ____|        | |                               \r\n | |_) | ___  ___| |_    | |  _ __   | |    _   _ ___| |_ ___  _ __ ___   ___ _ __ ___ \r\n |  _ < / _ \\/ __| __|   | | | \'_ \\  | |   | | | / __| __/ _ \\| \'_ ` _ \\ / _ \\ \'__/ __|\r\n | |_) |  __/\\__ \\ |_   _| |_| | | | | |___| |_| \\__ \\ || (_) | | | | | |  __/ |  \\__ \\\r\n |____/ \\___||___/\\__| |_____|_| |_|  \\_____\\__,_|___/\\__\\___/|_| |_| |_|\\___|_|  |___/\r\n                                                                                       \r\n                                                                                       \r\n");
		System.out.println("-----------------------------------------------------------------------------------------");
		tempAmountorder=new double[Amountorder.length];
		tempQuantity=new int[Quantity.length];
		tempphonenumber=new String[phonenumber.length];
		tempSize=new String[Size.length];
		System.arraycopy(Amountorder, 0, tempAmountorder, 0, tempAmountorder.length);
		System.arraycopy(Quantity, 0, tempQuantity, 0, tempQuantity.length);
		System.arraycopy(phonenumber, 0, tempphonenumber, 0, tempphonenumber.length);
		System.arraycopy(Size, 0, tempSize, 0, tempSize.length);
		removeDuplicatesviewreports();
		makecorrectorder();
		for (int i = 0; i < tempAmountorder.length-1; i++){
			for (int j = 0; j < tempAmountorder.length-1-i; j++){
				if (tempAmountorder[j]<tempAmountorder[j+1]){
					double t1=tempAmountorder[j];
					tempAmountorder[j]=tempAmountorder[j+1];
					tempAmountorder[j+1]=t1;
					int t2=tempQuantity[j];
					tempQuantity[j]=tempQuantity[j+1];
					tempQuantity[j+1]=t2;
					String t3=tempphonenumber[j];
					tempphonenumber[j]=tempphonenumber[j+1];
					tempphonenumber[j+1]=t3;
					String t4=tempSize[j];
					tempSize[j]=tempSize[j+1];
					tempSize[j+1]=t4;
				}
			}
		}
		String[] a=tempphonenumber;
		int[] b=tempQuantity;
		double[] c=tempAmountorder;
		System.out.println("\t+-----------------+---------+-----------------+");
		System.out.println("\t|Customer ID	  | All QTY |   Total Amount  |");
		System.out.println("\t+-----------------+---------+-----------------+");
		for (int i = 0; i <tempAmountorder.length ; i++){
		System.out.println("\t|\t\t  |\t    |\t\t      |");
		System.out.println("\t|"+a[i]+"\t  |"+b[i]+"\t    |"+c[i]+"\t      |");
		}
		System.out.println("\t+-----------------+---------+-----------------+");
		do{
			System.out.print("\n\nTo access the Main Menu,please enter 0 : ");
			int op=input.nextInt();
			if(op==0){
				return;
			}else{
				System.out.print("\033[3A");
				System.out.print("\033[0J");
			}
		} while (true);
	}
	public static void itemreports(){
		clearConsole();
		System.out.println("\r\n  _____ _                   _____                       _       \r\n |_   _| |                 |  __ \\                     | |      \r\n   | | | |_ ___ _ __ ___   | |__) |___ _ __   ___  _ __| |_ ___ \r\n   | | | __/ _ \\ \'_ ` _ \\  |  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|\r\n  _| |_| ||  __/ | | | | | | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n |_____|\\__\\___|_| |_| |_| |_|  \\_\\___| .__/ \\___/|_|   \\__|___/\r\n                                      | |                       \r\n                                      |_|                       \r\n");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("\n\t[1] Best Selling Categories Sorted by QTY");
		System.out.println("\n\t[2] Best Selling Categories Sorted by Amount");
		L9:do{
			System.out.print("\n\nEnter Option : ");
			int op=input.nextInt();
			switch (op){
				case 1:sortedbyQTY();return;
				case 2:sortedbyAmount();return;
				default:System.out.println("\n\t Invalid Input..");
						continue L9;
		}
		} while (true);		
	}
	public static void sortedbyQTY(){
		clearConsole();
		System.out.println("\r\n   _____            _           _   ____           ____ _________     __\r\n  / ____|          | |         | | |  _ \\         / __ \\__   __\\ \\   / /\r\n | (___   ___  _ __| |_ ___  __| | | |_) |_   _  | |  | | | |   \\ \\_/ / \r\n  \\___ \\ / _ \\| \'__| __/ _ \\/ _` | |  _ <| | | | | |  | | | |    \\   /  \r\n  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| | | |__| | | |     | |   \r\n |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, |  \\___\\_\\ |_|     |_|   \r\n                                           __/ |                        \r\n                                          |___/                         \r\n");
		System.out.println("-----------------------------------------------------------------------------");
		String[] a={"XS","S","M","L","XL","XXL"};
		int[] b= new int[6];
		double[] c=new double[6];
		for (int i = 0; i <Size.length ; i++){
			if (Size[i].equals("XS")){
				b[0]+=Quantity[i];
				c[0]+=Amountorder[i];
			}else if (Size[i].equals("S")){
				b[1]+=Quantity[i];
				c[1]+=Amountorder[i];
			}else if (Size[i].equals("M")){
				b[2]+=Quantity[i];
				c[2]+=Amountorder[i];
			}else if (Size[i].equals("L")){
				b[3]+=Quantity[i];
				c[3]+=Amountorder[i];
			}else if (Size[i].equals("XL")){
				b[4]+=Quantity[i];
				c[4]+=Amountorder[i];
			}else if (Size[i].equals("XXL")){
				b[5]+=Quantity[i];
				c[5]+=Amountorder[i];
			}
		}
		for (int i = 0; i < b.length-1; i++){
			for (int j = 0; j <b.length-1-i ; j++){
				if (b[j+1]>b[j]){
					int t1=b[j];
					b[j]=b[j+1];
					b[j+1]=t1;
					double t2=c[j];
					c[j]=c[j+1];
					c[j+1]=t2;
					String t3=a[j];
					a[j]=a[j+1];
					a[j+1]=t3;
				}
			}
		}
		System.out.println("\n\t+----------+----------+---------------+");
		System.out.println("\t|  Size    |    QTY   |      Amount   |");
		System.out.println("\t+----------+----------+---------------+");
		for (int i = 0; i < a.length; i++){
			System.out.println("\t|\t   |\t      |\t              |");
			System.out.println("\t|"+a[i]+"\t   |"+b[i]+"\t      |"+c[i]+"\t      |");
		}
		System.out.println("\t+----------+----------+---------------+");
		do{
			System.out.print("\n\nTo access the Main Menu,please enter 0 : ");
			int op=input.nextInt();
			if(op==0){
				return;
			}else{
				System.out.print("\033[3A");
				System.out.print("\033[0J");
			}
		} while (true);
	}
	public static void sortedbyAmount(){
		clearConsole();
		System.out.println("\r\n   _____            _           _   ____                                               _   \r\n  / ____|          | |         | | |  _ \\            /\\                               | |  \r\n | (___   ___  _ __| |_ ___  __| | | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ \r\n  \\___ \\ / _ \\| \'__| __/ _ \\/ _` | |  _ <| | | |   / /\\ \\ | \'_ ` _ \\ / _ \\| | | | \'_ \\| __|\r\n  ____) | (_) | |  | ||  __/ (_| | | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ \r\n |_____/ \\___/|_|   \\__\\___|\\__,_| |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|\r\n                                           __/ |                                           \r\n                                          |___/                                            \r\n");
		System.out.println("--------------------------------------------------------------------------------------------");
		String[] a={"XS","S","M","L","XL","XXL"};
		int[] b= new int[6];
		double[] c=new double[6];
		for (int i = 0; i <Size.length ; i++){
			if (Size[i].equals("XS")){
				b[0]+=Quantity[i];
				c[0]+=Amountorder[i];
			}else if (Size[i].equals("S")){
				b[1]+=Quantity[i];
				c[1]+=Amountorder[i];
			}else if (Size[i].equals("M")){
				b[2]+=Quantity[i];
				c[2]+=Amountorder[i];
			}else if (Size[i].equals("L")){
				b[3]+=Quantity[i];
				c[3]+=Amountorder[i];
			}else if (Size[i].equals("XL")){
				b[4]+=Quantity[i];
				c[4]+=Amountorder[i];
			}else if (Size[i].equals("XXL")){
				b[5]+=Quantity[i];
				c[5]+=Amountorder[i];
			}
		}
		for (int i = 0; i < c.length-1; i++){
			for (int j = 0; j <c.length-1-i ; j++){
				if (c[j+1]>c[j]){
					double t2=c[j];
					c[j]=c[j+1];
					c[j+1]=t2;
					int t1=b[j];
					b[j]=b[j+1];
					b[j+1]=t1;
					String t3=a[j];
					a[j]=a[j+1];
					a[j+1]=t3;
				}
			}
		}
		System.out.println("\n\t+----------+----------+---------------+");
		System.out.println("\t|  Size    |    QTY   |      Amount   |");
		System.out.println("\t+----------+----------+---------------+");
		for (int i = 0; i < a.length; i++){
			System.out.println("\t|\t   |\t      |\t              |");
			System.out.println("\t|"+a[i]+"\t   |"+b[i]+"\t      |"+c[i]+"\t      |");
		}
		System.out.println("\t+----------+----------+---------------+");
		do{
			System.out.print("\n\nTo access the Main Menu,please enter 0 : ");
			int op=input.nextInt();
			if(op==0){
				return;
			}else{
				System.out.print("\033[3A");
				System.out.print("\033[0J");
			}
		} while (true);
	}
	public static void ordersreports(){
		clearConsole();
		System.out.println("\r\n   ____          _             _____                       _       \r\n  / __ \\        | |           |  __ \\                     | |      \r\n | |  | |_ __ __| | ___ _ __  | |__) |___ _ __   ___  _ __| |_ ___ \r\n | |  | | \'__/ _` |/ _ \\ \'__| |  _  // _ \\ \'_ \\ / _ \\| \'__| __/ __|\r\n | |__| | | | (_| |  __/ |    | | \\ \\  __/ |_) | (_) | |  | |_\\__ \\\r\n  \\____/|_|  \\__,_|\\___|_|    |_|  \\_\\___| .__/ \\___/|_|   \\__|___/\r\n                                         | |                       \r\n                                         |_|                       \r\n");	
		System.out.println("--------------------------------------------------------------------");
		System.out.println("\n\t[1] All Orders");
		System.out.println("\n\t[2] Orders by Amount");
		L10:do{
			System.out.print("\n\nEnter Option : ");
			int op=input.nextInt();
			switch (op){
				case 1:allorders();return;
				case 2:ordersbyamount();return;
				default:System.out.println("\n\t Invalid Input..");
						continue L10;
		}
		} while (true);			
	}
	public static void allorders(){
		clearConsole();
		System.out.println("\r\n __      ___                  ____          _               \r\n \\ \\    / (_)                / __ \\        | |              \r\n  \\ \\  / / _  _____      __ | |  | |_ __ __| | ___ _ __ ___ \r\n   \\ \\/ / | |/ _ \\ \\ /\\ / / | |  | | \'__/ _` |/ _ \\ \'__/ __|\r\n    \\  /  | |  __/\\ V  V /  | |__| | | | (_| |  __/ |  \\__ \\\r\n     \\/   |_|\\___| \\_/\\_/    \\____/|_|  \\__,_|\\___|_|  |___/\r\n                                                            \r\n                               ");	
		System.out.println("-------------------------------------------------------------");
		String[] a=orderid;
		String[] b=phonenumber;
		String[] c=Size;
		int[] d=Quantity;
		double[] e=Amountorder;
		String[] f=status;
		System.out.println("\t+----------+---------------+--------+-----------+---------------+---------------+");
		System.out.println("\t| Order ID |  Customer ID  |  Size  |    QTY    |     Amount    |     Status    |");
		System.out.println("\t+----------+---------------+--------+-----------+---------------+---------------+");
		for (int i = a.length-1; i>=0 ; i--){
		System.out.println("\t| "+a[i]+"| "+b[i]+"    |"+c[i]+"\t    |"+d[i]+"\t\t| "+e[i]+"\t| "+f[i]+"\t|");
		}
		System.out.println("\t+----------+---------------+--------+-----------+---------------+---------------+");
		do{
			System.out.print("\n\nTo access the Main Menu,please enter 0 : ");
			int op=input.nextInt();
			if(op==0){
				return;
			}else{
				System.out.print("\033[3A");
				System.out.print("\033[0J");
			}
		} while (true);	
	}
	public static void ordersbyamount(){
		clearConsole();
		System.out.println("\r\n   ____          _                 ____                                               _   \r\n  / __ \\        | |               |  _ \\            /\\                               | |  \r\n | |  | |_ __ __| | ___ _ __ ___  | |_) |_   _     /  \\   _ __ ___   ___  _   _ _ __ | |_ \r\n | |  | | \'__/ _` |/ _ \\ \'__/ __| |  _ <| | | |   / /\\ \\ | \'_ ` _ \\ / _ \\| | | | \'_ \\| __|\r\n | |__| | | | (_| |  __/ |  \\__ \\ | |_) | |_| |  / ____ \\| | | | | | (_) | |_| | | | | |_ \r\n  \\____/|_|  \\__,_|\\___|_|  |___/ |____/ \\__, | /_/    \\_\\_| |_| |_|\\___/ \\__,_|_| |_|\\__|\r\n                                          __/ |                                           \r\n                                         |___/                                            \r\n");
		System.out.println("--------------------------------------------------------------------------------------------");
		String[] a=new String[orderid.length];
		String[] b=new String[phonenumber.length];
		String[] c=new String[Size.length];
		int[] d=new int[Quantity.length];
		double[] e=new double[Amountorder.length];
		String[] f=new String[status.length];
		System.arraycopy(orderid, 0, a, 0, a.length);
		System.arraycopy(phonenumber, 0, b, 0, b.length);
		System.arraycopy(Size, 0, c, 0, c.length);
		System.arraycopy(Quantity, 0, d, 0, d.length);
		System.arraycopy(Amountorder, 0, e, 0, e.length);
		System.arraycopy(status, 0, f, 0, f.length);
		for (int i = 0; i < e.length ; i++){
			for (int j = 0; j < e.length-1-i ; j++){
				if (e[j+1]>e[j]){
					double t1=e[j];
					e[j]=e[j+1];
					e[j+1]=t1;
					String t2=a[j];
					a[j]=a[j+1];
					a[j+1]=t2;
					String t3=b[j];
					b[j]=b[j+1];
					b[j+1]=t3;
					String t4=c[j];
					c[j]=c[j+1];
					c[j+1]=t4;
					int t5=d[j];
					d[j]=d[j+1];
					d[j+1]=t5;
					String t6=f[j];
					f[j]=f[j+1];
					f[j+1]=t6;
				}
			}
		}
		System.out.println("\t+----------+---------------+--------+-----------+---------------+---------------+");
		System.out.println("\t| Order ID |  Customer ID  |  Size  |    QTY    |     Amount    |     Status    |");
		System.out.println("\t+----------+---------------+--------+-----------+---------------+---------------+");
		for (int i = 0; i< a.length ; i++){
		System.out.println("\t| "+a[i]+"| "+b[i]+"    |"+c[i]+"\t    |"+d[i]+"\t\t| "+e[i]+"\t| "+f[i]+"\t|");
		}
		System.out.println("\t+----------+---------------+--------+-----------+---------------+---------------+");
		do{
			System.out.print("\n\nTo access the Main Menu,please enter 0 : ");
			int op=input.nextInt();
			if(op==0){
				return;
			}else{
				System.out.print("\033[3A");
				System.out.print("\033[0J");
			}
		} while (true);	
	}
}
