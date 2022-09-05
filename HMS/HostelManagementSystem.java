import java.util.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.lang.*;

class student
{

	//member variables of student class
	public int registerNo ;
	public String name;
	public int year;
	public String address;
	public String phone;
	public String GuardianName;
	public String gphone;

	 student(int regNo, String sname, int yr, String add, String no,String gname,String gph)
	{
		registerNo = regNo;
		name = sname;
		year = yr;
		address = add;
		phone = no;
		GuardianName=gname;
		gphone=gph;

	}
}



class hostel extends student
{
	public int roomType;
	public int roomNo;
	public String messNeeded;
	public String laundryNeeded;
	public int laundryFee;
	public int messFee;
	public String laundryPay;
	public String messPay;


	hostel(int regNo, String sname, int yr, String add, String no, String gname,String gph,int type, int roomno, String mess, String laundry)
	{
		super(regNo, sname, yr, add, no,gname,gph);
		roomType = type;
		roomNo = roomno;
		messNeeded = mess;
		laundryNeeded = laundry;
		laundryFee =0;
		messFee = 0;
		laundryPay = "no";
		messPay  = "no";
	}


	public void calcMessLaundry()
	{
		if(laundryNeeded == "yes" || laundryNeeded == "Yes")
		{
				laundryFee = 500;

		}
		if(messNeeded == "yes" || messNeeded == "Yes")
		{
			messFee = 1000;

		}
		System.out.println("Laundry Fee: "+laundryFee);
		System.out.println("Mess Fee: "+messFee);
	}

public String toString() //For the display option
    {
        //System.out.println("REG NO.\tNAME\tYEAR\tADDRESS\tPHONE\tROOM TYPE\tROOM NO.\tMESS NEEDED\tLAUNDRY NEEDED");
		return("\nREG NO: " +registerNo+ "\nNAME: " +name + "\nYEAR: " +year + "\nADDRESS: " + address + "\nPHONE: " + phone + "\nROOM TYPE: " + roomType +"ROOM NO: " + roomNo +"\nMESS? " + messNeeded +"\nLAUNDRY? " + laundryNeeded + "\nGUARDIAN NAME: " + GuardianName + "\nGUARDIAN PHONE: "+gphone);
    }

}


public class hostelmanagement
{
	public static void main(String[] args)
    {
		ArrayList<hostel> al = new ArrayList<hostel>();
		Scanner input = new Scanner(System.in);

		int choice1=4;
		do
		{
			System.out.println("\n\t\t\t************SSS LADIES HOSTEL SERVICES*********");
			System.out.println("\n\n\n\n\t\t\t\t\tEnter choice: \n\t\t1. Admin \n\t\t2. Student facilities\n\t\t3. Exit\n");
			choice1 = input.nextInt();

			switch(choice1)
			{
				case 1:
				{
					System.out.println("\nEnter admin key:");
					String password = input.next();

					if(password.equals("sss123"))
					{

						int choice2;
						do
						{
							System.out.println("\n\t\t\t******ADMINISTRATION CHOICES******");
							System.out.println("\n\n\n\t\t1. Display students  \n\t\t2.Find a student record\n\t\t3. Display student fee details\n\t\t4. Delete Student record\n\t\t5. Add student\n\t\t6. Exit\n\t\t\tEnter option:");
							choice2 = input.nextInt();
							switch(choice2)
							{
								case 1:
									for (hostel i : al)
									{
										System.out.println(i);
									}
									break;


								case 2:
									System.out.println("\n\t\t\tEnter option:");
									System.out.println("\n\t\t1. Search by name  \n\t\t2. Search register number");
									int choice3 = input.nextInt();
									if(choice3 == 1)
									{
										System.out.println("Enter name to search: ");
										String sname  = input.next();
										for (hostel i : al)
										{
											if(sname.equals(i.name))
											{
												System.out.println("\n\n\t\t\t**** Details of "+i.name+" ****");
												System.out.println(i);
											}
										}
									}
									else
									{
										System.out.println("Enter register no to search: ");
										int reg = input.nextInt();
										for (hostel i : al)
										{
											if(reg == i.registerNo)
											{
												System.out.println("\n\n\t\t\t**** Details of "+i.name+" ****");
												System.out.println(i);
												break;
											}
										}
									}
									break;


								case 3:

									System.out.println("\n\t\t1. View students who have not paid laundry fees\n\t\t2. View students who have not paid mess fees");
									int choice5 = input.nextInt();

									if(choice5 == 1)
									{
										System.out.println("\n\n\nTHE FOLLOWING STUDENTS HAVE NOT PAID LAUNDRY FEES:");
										for (hostel i : al)
										{
											if((i.laundryNeeded.equals("yes")) && (i.laundryPay.equals("no")))
											{
												System.out.println(i);
											}
										}
									}
									else
									{
										System.out.println("\n\n\nTHE FOLLOWING STUDENTS HAVE NOT PAID MESS FEES:");
										for (hostel i : al)
										{
											if((i.messNeeded.equals("yes")) && (i.messPay.equals("no")))
											{
												System.out.println(i);
											}
										}
									}
									break;

								case 4:
									System.out.println("Enter name to delete: ");
									String name = input.next();
									System.out.println("Enter register no to delete: ");
									int no = input.nextInt();
									for (hostel i : al)
									{
										if(no == i.registerNo && name.equals(i.name))
										{
											al.remove(i);
											break;

										}
									}
									System.out.println("\n\n\nDELETION SUCCESSFUL!");
									break;

								case 5:

									System.out.println("\n\t\t\t*********Enter the details********\n\n\n");

									System.out.println("Enter register no: ");
									int registerNo = input.nextInt();

									System.out.println("Enter name: ");
									String tname = input.next();

									System.out.println("Enter year: ");
									int year = input.nextInt();

									System.out.println("Enter address: ");
									String address = input.next();
									input.nextLine();

									System.out.println("Enter phone no: ");
									String phone = input.next();
									input.nextLine();

									System.out.println("Enter room type(1/2/3): ");
									int roomType = input.nextInt();

									System.out.println("Enter room number: ");
									int roomNo = input.nextInt();

									System.out.println("Mess required?(yes/no)  ");
									String messFeePaid = input.next();

									System.out.println("Laundry required?(yes/no)  ");
									String laundryNeeded = input.next();

									System.out.println("Enter the name of guardian: ");
									String guardian = input.next();

									System.out.println("Enter the phone number of guardian: ");
									String gphone = input.next();

									hostel hob = new hostel(registerNo, tname, year, address, phone,guardian,gphone, roomType, roomNo,messFeePaid, laundryNeeded);

									al.add(hob);

									break;

							}
						}while(choice2!=6);
					}
					else
					{
						System.out.println("Incorrect Password!");
					}
					break;
				}


				case 2:
				{
					System.out.println("\n\t\t\t***********STUDENT FACILITIES***********");
					System.out.println("\n\n\n\t\t1. View Fee Details  \n\t\t2. Update Paid Fees\n\t\t\tEnter option:");
					int choice4 = input.nextInt();


					if(choice4 == 1)
					{
						System.out.println("Enter your name: ");
						String fname = input.next();
						System.out.println("Enter your register no: ");
						int fno = input.nextInt();

						for (hostel i : al)
						{
							if(fno == i.registerNo && fname.equals(i.name))
							{
								if((i.laundryNeeded).equals("yes"))
								{
									i.laundryFee = 800;
									System.out.println("Your laundry fees is Rs."+i.laundryFee);
								}

								if((i.messNeeded).equals("yes"))
								{
									i.messFee = 2500;
									System.out.println("Your mess fees is Rs."+i.messFee);
								}

								System.out.println("\n\n\t\t\tTHANKYOUU!");
							}
						}
					}
					else
					{
						System.out.println("Enter your name: ");
						String fname = input.next();
						System.out.println("Enter your register no: ");
						int fno = input.nextInt();

						for (hostel i : al)
						{
							if(fno == i.registerNo && fname.equals(i.name))
							{
								if((i.laundryNeeded).equals("yes") || (i.laundryNeeded).equals("Yes"))
								{
									System.out.println("Have you paid your laundry fees? (yes/no)");
									String lf = input.next();
									if(lf.equals("yes"));
									{
										i.laundryPay = "yes";
									}
								}

								if((i.messNeeded).equals("yes") || (i.messNeeded).equals("Yes"))
								{
									System.out.println("Have you paid your mess fees? (yes/no)");
									String mf = input.next();
									if(mf.equals("yes"));
									{
										i.messPay = "yes";
									}
								}
							}
						}
						System.out.println("\n\n\t\t\tUPDATION SUCCESSFUL!!");
					}


				}

			}

		}while(choice1 != 3);
	}
}
