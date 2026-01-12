import java.util.*;
class Example{
	public static int[] extendarray(int dayscount){
		int[] ar=new int[dayscount];
		return ar;
	}
	public static void main(String args[]){
		String[] months={"January","February","March","April","May","June","July","August","September","October","November","December"};
		int[] daysinMonth={31,28,31,30,31,30,31,31,30,31,30,31};
		Random input=new Random();
		int[][] count=new int[12][0];
		for (int i = 0; i < months.length; i++){
			count[i]=extendarray(daysinMonth[i]);
			for (int j = 0; j < daysinMonth[i]; j++){
				count[i][j]=input.nextInt(501);
			}
		}
int[] total=new int[12];
int[] avg=new int[12];
for (int i = 0; i < count.length; i++){
	int total1=0;
	double avg1=0;
	for (int j = 0; j <daysinMonth[i] ; j++){
		total1+=count[i][j];
	}
	total[i]=total1;
	avg1=Math.round(total1/(double)daysinMonth[i]);
	avg[i]=(int)avg1;
}
System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
System.out.println("		                                            Covid-19 Patient Report-2021                                   ");
System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
System.out.print("\n\t  ");
for (int i = 0; i <months.length ; i++){
	System.out.printf("%10s",months[i]);
}
System.out.println();
for (int i = 0; i <31 ; i++){
	System.out.print(i+1+" ->\t");
	for (int j = 0; j <months.length ; j++){
		if (daysinMonth[j]==31){
			System.out.printf("%10d",count[j][i]);
		}else if (daysinMonth[j]==30 & i<30){
			System.out.printf("%10d",count[j][i]);
		}else if (daysinMonth[j]==28 & i<28){
			System.out.printf("%10d",count[j][i]);
		}else{
			System.out.printf("%10s","");
		}
	}	
	System.out.println();
}
System.out.println("\n");
System.out.print("Total   ");
for (int i = 0; i <total.length ; i++){
	System.out.printf("%10d",total[i]);
}
System.out.println();
System.out.print("Average ");
for (int i = 0; i <avg.length ; i++){
	System.out.printf("%10d",avg[i]);
}

	}
}
