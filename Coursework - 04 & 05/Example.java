import java.util.*;
class Example{
	public static void main(String args[]){
	Scanner input=new Scanner(System.in);
	L1:do{
	System.out.println("\r\n                                           __   ______   ________  ________ \r\n                                          |  \\ /      \\ |        \\|        \\\r\n                                           \\$$|  $$$$$$\\| $$$$$$$$ \\$$$$$$$$\r\n                                          |  \\| $$   \\$$| $$__       | $$   \r\n                                          | $$| $$      | $$  \\      | $$   \r\n                                          | $$| $$   __ | $$$$$      | $$   \r\n                                          | $$| $$__/  \\| $$_____    | $$   \r\n                                          | $$ \\$$    $$| $$     \\   | $$   \r\n                                           \\$$  \\$$$$$$  \\$$$$$$$$    \\$$   \r\n                                                                            \r\n");
	System.out.println("  _______             __   __   _____              _         _____   _    _   _                   _______    ____    _____  \r\n |__   __|     /\\     \\ \\ / /  / ____|     /\\     | |       / ____| | |  | | | |          /\\     |__   __|  / __ \\  |  __ \\ \r\n    | |       /  \\     \\ V /  | |         /  \\    | |      | |      | |  | | | |         /  \\       | |    | |  | | | |__) |\r\n    | |      / /\\ \\     > <   | |        / /\\ \\   | |      | |      | |  | | | |        / /\\ \\      | |    | |  | | |  _  / \r\n    | |     / ____ \\   / . \\  | |____   / ____ \\  | |____  | |____  | |__| | | |____   / ____ \\     | |    | |__| | | | \\ \\ \r\n    |_|    /_/    \\_\\ /_/ \\_\\  \\_____| /_/    \\_\\ |______|  \\_____|  \\____/  |______| /_/    \\_\\    |_|     \\____/  |_|  \\_\\\r\n");
	System.out.println("=============================================================================================================================");
	System.out.println("");
	System.out.println("		[1] Withholding Tax");
	System.out.println("");
	System.out.println("		[2] Payable Tax");
	System.out.println("");
	System.out.println("		[3] Income Tax");
	System.out.println("");
	System.out.println("		[4] Social Security Contribution Levy (SSCL) Tax");
	System.out.println("");
	System.out.println("		[5] Leasing Payment");
	System.out.println("");
	System.out.println("		[6] Exit");
	System.out.println("");
	L13:do{
	System.out.print("    Enter an option to continue -> ");
	int option=input.nextInt();
	switch(option){
		case 1:{
				System.out.println("");
				System.out.println("+----------------------------------------------------------------+");
				System.out.println("|                        WITHHOLDING TAX                         |"); 
				System.out.println("+----------------------------------------------------------------+");
				System.out.println("");
				System.out.println("		[1] Rent Tax");
				System.out.println("");
				System.out.println("		[2] Bank Interest Tax");
				System.out.println("");
				System.out.println("		[3] Dividend Tax");
				System.out.println("");
				System.out.println("		[4] Exit");
				System.out.println("");
		L5:do{
				System.out.print("    Enter an option to continue -> ");
				int option1=input.nextInt();
	 			switch(option1){
					case 1:
					L2:do{
					System.out.println("");
					System.out.println("+----------------------------------------------------------------+");
					System.out.println("|                            RENT TAX                            |"); 
					System.out.println("+----------------------------------------------------------------+");
					l21:do{
					System.out.println("");
					System.out.print("	Enter your rent          : ");
					double rent=input.nextDouble();
					if(rent>0){
						if(rent>100000){
							double renttax=(rent-100000)*0.1;
							renttax=Math.round(renttax);
							System.out.printf("\n	You have to pay Rent Tax : %.2f",renttax);
						}else{
							System.out.println("\n		You don\'t have to pay Rent Tax... ");}
					}else{
							System.out.println("\n\tWrong input...Input correct..\n");
							continue l21;
					}
					l22:do{
						System.out.print("\n\tDo you want to calculate another Rent Tax (Y/N) : ");
						char op=input.next().charAt(0);
						if(op=='y'||op=='Y'){
								continue L2;
						}else if(op=='n'||op=='N'){
								continue L1;
						}else{
							System.out.println("\n\tWrong input...Input correct..\n");
							continue l22;
						}
						}while(true);
					}while(true);
					}while(true);
					case 2:
					L3:do{
					System.out.println("");
					System.out.println("+----------------------------------------------------------------+");
					System.out.println("|                       BANK INTEREST TAX                        |"); 
					System.out.println("+----------------------------------------------------------------+");
					System.out.println("");
					l31:do{
					System.out.print("	Enter your bank interest per year          : ");
					double bankinterest=input.nextDouble();
						if(bankinterest>0){
						double banktax=bankinterest*0.05;
						banktax=Math.round(banktax);
						System.out.printf("\n	You have to pay Bank Interest Tax per year : %.2f",banktax);
						}else{
							System.out.println("\n\tWrong input...Input correct..\n");
							continue l31;
						}
					l32:do{
						System.out.print("\n\tDo you want to calculate another Bank Interest Tax (Y/N) : ");
						char op=input.next().charAt(0);
						if(op=='y'||op=='Y'){
								continue L3;
						}else if(op=='n'||op=='N'){
								continue L1;
						}else{
							System.out.println("\n\tWrong input...Input correct..\n");
							continue l32;
						}
						}while(true);
					}while(true);
					}while(true);
					case 3:
					L4:do{
					System.out.println("");
					System.out.println("+----------------------------------------------------------------+");
					System.out.println("|                           DIVIDEND TAX                         |"); 
					System.out.println("+----------------------------------------------------------------+");
					System.out.println("");
					l41:do{
					System.out.print("	Enter your total dividend per year    : ");
					double dividend=input.nextDouble();
					if(dividend>0){
						if(dividend>100000){
							double dividendtax=(dividend-100000)*0.14;
							dividendtax=Math.round(dividendtax);
							System.out.printf("\n	You have to pay Dividend Tax per year : %.2f",dividendtax);
						}else{
							System.out.println("\n		You don\'t have to pay Rent Tax...\n");
						}
					}else{
						System.out.println("\n\tWrong input...Input correct..\n");
							continue l41;
					}
					l42:do{
						System.out.print("\n\n\tDo you want to calculate another Dividend Tax (Y/N) : ");
						char op=input.next().charAt(0);
						if(op=='y'||op=='Y'){
								continue L4;
						}else if(op=='n'||op=='N'){
								continue L1;
						}else{
							System.out.println("\n\tWrong input...Input correct..\n");
							continue l42;
						}
						}while(true);
					}while(true);
					}while(true);
					case 4:continue L1;
					default:System.out.println("\n\tWrong input...Input correct..\n");
							continue L5;
				}
			}while(true);
		}
		case 2:{
			L6:do{
				System.out.println("");
				System.out.println("+----------------------------------------------------------------+");
				System.out.println("|                            PAYABLE TAX                         |"); 
				System.out.println("+----------------------------------------------------------------+");
				System.out.println("");
				l61:do{
				System.out.print("	Enter your employee payment per month : ");
				double ep=input.nextDouble();
				if(ep>0){
				double eptax;
					if(0<ep & ep<=100000){
						System.out.println("\n		You don\'t have to pay Payable Tax...");
					}else if(ep>100000 & ep<=141667){
						eptax=(ep-100000)*0.06;
						eptax=Math.round(eptax);
						System.out.printf("\n	You have to pay Payable Tax per month : %.2f",eptax);
					}else if(ep>141667 & ep<=183333){
						eptax=((ep-141667)*0.12)+2500;
						eptax=Math.round(eptax);
						System.out.printf("\n	You have to pay Payable Tax per month : %.2f",eptax);
					}else if(ep>183333 & ep<=225000){
						eptax=((ep-183333)*0.18)+7500;
						eptax=Math.round(eptax);
						System.out.printf("\n	You have to pay Payable Tax per month : %.2f",eptax);
					}else if(ep>225000 & ep<=266667){
						eptax=((ep-225000)*0.24)+15000;
						eptax=Math.round(eptax);
						System.out.printf("\n	You have to pay Payable Tax per month : %.2f",eptax);
					}else if(ep>266667 & ep<=308333){
						eptax=((ep-266667)*0.3)+25000;
						eptax=Math.round(eptax);
						System.out.printf("\n	You have to pay Payable Tax per month : %.2f",eptax);
					}else if(ep>308333){
						eptax=((ep-308333)*0.36)+37500;
						eptax=Math.round(eptax);
						System.out.printf("\n	You have to pay Payable Tax per month : %.2f",eptax);
					}
				}else{
					System.out.println("\n\tWrong input...Input correct..\n");
					continue l61;
				}
				l62:do{
						System.out.print("\n\n\tDo you want to calculate another Payable Tax (Y/N) : ");
						char op=input.next().charAt(0);
						if(op=='y'||op=='Y'){
								continue L6;
						}else if(op=='n'||op=='N'){
								continue L1;
						}else{
							System.out.println("\n\tWrong input...Input correct..\n");
							continue l62;
						}
					}while(true);
				}while(true);
			}while(true);
		}
		case 3:	{
			L7:do{		
				System.out.println("");
				System.out.println("+----------------------------------------------------------------+");
				System.out.println("|                            INCOME TAX                          |"); 
				System.out.println("+----------------------------------------------------------------+");
				System.out.println("");
				l71:do{
				System.out.print("	Enter your total income per year    : ");
				double in=input.nextDouble();
				if(in>0){
					double intax;
					if(0<in & in<=1200000){
						System.out.println("\n		You don\'t have to pay Income Tax...");
					}else if(in>1200000 & in<=1700000){
						intax=(in-1200000)*0.06;
						intax=Math.round(intax);
						System.out.printf("\n	You have to pay Income Tax per year : %.2f",intax);
					}else if(in>1700000 & in<=2200000){
						intax=(in-1700000)*0.12+30000;
						intax=Math.round(intax);
						System.out.printf("\n	You have to pay Income Tax per year : %.2f",intax);
					}else if(in>2200000 & in<=2700000){
						intax=(in-2200000)*0.18+90000;
						intax=Math.round(intax);
						System.out.printf("\n	You have to pay Income Tax per year : %.2f",intax);
					}else if(in>2700000 & in<=3200000){
						intax=(in-2700000)*0.24+180000;
						intax=Math.round(intax);
						System.out.printf("\n	You have to pay Income Tax per year : %.2f",intax);
					}else if(in>3200000 & in<=3700000){
						intax=(in-3200000)*0.3+300000;
						intax=Math.round(intax);
						System.out.printf("\n	You have to pay Income Tax per year : %.2f",intax);
					}else if(in>3700000){
						intax=(in-3700000)*0.36+450000;
						intax=Math.round(intax);
						System.out.printf("\n	You have to pay Income Tax per year : %.2f",intax);
					}
				}else{
					System.out.println("\n\tWrong input...Input correct..\n");
					continue l71;
				}
				l72:do{
						System.out.print("\n\n\tDo you want to calculate another Income Tax (Y/N) : ");
						char op=input.next().charAt(0);
						if(op=='y'||op=='Y'){
								continue L7;
						}else if(op=='n'||op=='N'){
								continue L1;
						}else{
							System.out.println("\n\tWrong input...Input correct..\n");
							continue l72;
						}
					}while(true);
				}while(true);
			}while(true);
		}	
		case 4:{
			L8:do{
				System.out.println("");
				System.out.println("+----------------------------------------------------------------+");
				System.out.println("|          SOCIAL SECURITY CONTRIBUTION LEVY (SSCL) TAX          |"); 
				System.out.println("+----------------------------------------------------------------+");
				System.out.println("");
				l81:do{
				System.out.print("	Enter value of Good or Service    : ");
				double value=input.nextDouble();
				if(value>0){
					double saletax=value*0.025 , vat,sscl;
					value=value+saletax;
					vat= value*0.15;
					sscl=saletax+vat;
					System.out.printf("\n	You have to pay SSCL Tax          : %.2f",sscl);
				}else{
					System.out.println("\n\tWrong input...Input correct..\n");
					continue l81;
				}
				l82:do{
						System.out.print("\n\n\tDo you want to calculate another SSCL Tax (Y/N) : ");
						char op=input.next().charAt(0);
						if(op=='y'||op=='Y'){
								continue L8;
						}else if(op=='n'||op=='N'){
								continue L1;
						}else{
							System.out.println("\n\tWrong input...Input correct..\n");
							continue l82;
						}
					}while(true);
				}while(true);
			}while(true);
		}
		case 5:{
				System.out.println("");
				System.out.println("+----------------------------------------------------------------+");
				System.out.println("|                          LEASING PAYMENT                       |"); 
				System.out.println("+----------------------------------------------------------------+");
				System.out.println("");
				System.out.println("		[1] Calculate Monthly Installment");
				System.out.println("");
				System.out.println("		[2] Search Leasing Category");
				System.out.println("");
				System.out.println("		[3] Find Leasing Amount");
				System.out.println("");
				System.out.println("		[4] Exit");
				System.out.println("");
			L9:do{
				System.out.print("    Enter an option to continue -> ");
				int option5=input.nextInt();
	 			switch(option5){
					case 1:{
						L10:do{
							System.out.println("");
							System.out.println("+----------------------------------------------------------------+");
							System.out.println("|                    Calculate Leasing Payment                   |"); 
							System.out.println("+----------------------------------------------------------------+");
							System.out.println("");
							L101:do{
								System.out.print("	Enter lease amount                 : ");
								double A=input.nextDouble();
								if(A>0){
									L102:do{
										System.out.print("\n	Enter annual interest rate         : ");
										double i=input.nextDouble();
										if(i>0){
											L103:do{
												System.out.print("\n	Enter number of year               : ");
												int c=input.nextInt();
												if(c>0 & c<=5){
													int n=c*12;
													i=i/12;
													double x= 1+(i/100) ;
													double y=Math.pow(x,n);
													double monthlyinstallment = (A*(i/100))/(1-(1 /y));
													monthlyinstallment=Math.round(monthlyinstallment);
													System.out.printf("\n	Your monthly instalment            : %.2f",monthlyinstallment);
													L104:do{
														System.out.print("\n\tDo you want to calculate another Leasing Payment (Y/N) : ");
														char op=input.next().charAt(0);
														if(op=='y'||op=='Y'){
															continue L10;
														}else if(op=='n'||op=='N'){
															continue L1;
														}else{
															System.out.println("\n\tWrong input...Input correct..\n");
															continue L104;
														}
													}while(true);
												}else{
													System.out.println("\n\tWrong input...Input correct..\n");
													continue L103;
												}
											}while(true);
										}else{
											System.out.println("\n\tWrong input...Input correct..\n");
											continue L102;
										}
									}while(true);
								}else{
									System.out.println("\n\tWrong input...Input correct..\n");
									continue L101;
								}
							}while(true);
						}while(true);
					}
					case 2:{
						L11:do{
							System.out.println("");
							System.out.println("+----------------------------------------------------------------+");
							System.out.println("|                       Search Leasing Category                  |"); 
							System.out.println("+----------------------------------------------------------------+");
							System.out.println("");
							L111:do{
								System.out.print("	Enter lease amount                 : ");
								double A=input.nextDouble();
								if(A>0){
									L112:do{
										System.out.print("\n	Enter annual interest rate         : ");
										double i=input.nextDouble();
										if(i>0){
											int n=3*12;
											i=i/12;
											double x= 1+(i/100) ;
											double y=Math.pow(x,n);
											double monthlyinstallment = (A*(i/100))/(1-(1 /y));
											monthlyinstallment=Math.round(monthlyinstallment);
											System.out.printf("\n	Your monthly instalment for 3 year leasing plan		- %.2f",monthlyinstallment);
											n=4*12;
											y=Math.pow(x,n);
											monthlyinstallment = (A*(i/100))/(1-(1 /y));
											monthlyinstallment=Math.round(monthlyinstallment);
											System.out.printf("\n	Your monthly instalment for 4 year leasing plan		- %.2f",monthlyinstallment);
											n=5*12;
											y=Math.pow(x,n);
											monthlyinstallment = (A*(i/100))/(1-(1 /y));
											monthlyinstallment=Math.round(monthlyinstallment);
											System.out.printf("\n	Your monthly instalment for 5 year leasing plan		- %.2f",monthlyinstallment);
										}else{
											System.out.println("\n\tWrong input...Input correct..\n");
											continue L112;
										}
										L113:do{
												System.out.print("\n\n\tDo you want to calculate another Monthly Instalment (Y/N) : ");
												char op=input.next().charAt(0);
												if(op=='y'||op=='Y'){
													continue L11;
												}else if(op=='n'||op=='N'){
													continue L1;
												}else{
													System.out.println("\n\tWrong input...Input correct..\n");
													continue L113;
												}
											}while(true);
									}while(true);
								}else{
									System.out.println("\n\tWrong input...Input correct..\n");
									continue L111;	
								}
							}while(true);	
						}while(true);
						}
					case 3:{
						L12:do{
							System.out.println("");
							System.out.println("+----------------------------------------------------------------+");
							System.out.println("|                       Find Leasing Amount                      |"); 
							System.out.println("+----------------------------------------------------------------+");
							System.out.println("");
							L121:do{
									System.out.print("	Enter the monthly lease payment amount you can affort   : ");
									double mi=input.nextDouble();
									if(mi>0){
										L122:do{
												System.out.print("\n	Enter annual interest rate                              : ");
												double i=input.nextDouble();
												if(i>0){
													L123:do{
															System.out.print("\n	Enter number of year                                    : ");
															int c=input.nextInt();
															if(c>0){
																	int n=c*12;
																	i=i/12;
																	double x= 1+(i/100) ;
																	double y=Math.pow(x,n);
																	double  A=(mi*(1-(1/y)))/(i/100);
																	A=Math.round(A);
																	System.out.printf("\n	Your monthly instalment       				: %.2f",A);
															}else{
																System.out.println("\n\tWrong input...Input correct..\n");
																continue L123;
															}
															L124:do{
																	System.out.print("\n\n\tDo you want to Find another Leasing Amount (Y/N) : ");
																	char op=input.next().charAt(0);
																	if(op=='y'||op=='Y'){
																			continue L12;
																	}else if(op=='n'||op=='N'){
																			continue L1;
																	}else{
																			System.out.println("\n\tWrong input...Input correct..\n");
																			continue L124;
																	}
																}while(true);
														}while(true);
												}else{
													System.out.println("\n\tWrong input...Input correct..\n");
													continue L122;
												}
											}while(true);
									}else{
										System.out.println("\n\tWrong input...Input correct..\n");
										continue L121;
									}
						}while(true);
						}while(true);
						
					}
					case 4:continue L1;
					default:{System.out.println("\n\tWrong input...Input correct..\n");
							continue L9;}
				}
			}while(true);
		}
		case 6:System.exit(0);
		default:{System.out.println("\n\tWrong input...Input correct..\n");
				continue L13;}
	}
	}while(true);	
    }while(true);
  }
}