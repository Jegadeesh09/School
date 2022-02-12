import java.sql.*;
import java.util.Scanner;
public class Connect {
	Connection con = null;
	Connection getConnection() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");  
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
		return con;
	}
	void Student_login() throws Exception
	{
		int end=0;
		do
		{
			int s2=0;
				Statement stmt = con.createStatement();
				Scanner in = new Scanner(System.in);
				System.out.println("Teacher (or) Student");
				String a="student";
				String b="teacher";
				System.out.print("Login: ");
				String c=in.next();
				if(c.equalsIgnoreCase(a))
				{
					int a2=2;
					do
					{
						System.out.println();
						System.out.println("Username: ");
						String s4=in.next();
						System.out.println("Password: ");
						String s3=in.next();
						ResultSet rs = stmt.executeQuery("select * from student_details where Username ='"+s4+"' and Password ='"+s3+"'");
						if(rs.next())
						{
						System.out.println("		Login Sucessfull		");
						System.out.println("HomeWork (or) Report_Card (or) Fees_Pending (or) School_Updates (or) Attendence");
						System.out.println();
						System.out.println();
						int s=0;
						do {
							s=0;
						System.out.println("PRESS 1 FOR HOMEWORK");
						System.out.println("PRESS 2 FOR REPORT_CARD");
						System.out.println("PRESS 3 FOR FEES_PENDING");
						System.out.println("PRESS 4 FOR ATTENDANCE");
						System.out.println("PRESS 5 FOR SCHOOL_UPDATES");
						System.out.println();
						System.out.println();
						int a1=0;
						do
						{
								a1=0;
							System.out.println("Enter Number");
							int iNum=in.nextInt();
							System.out.println();
							switch(iNum)
							{
							  case 1:
							  {
								 Homework(s4,s3,con,in);
								 break;
							  }
							  case 2:
							  {
								 Report_Card(s4,s3,con,in);
								 break;
							  }
							  case 3:
							  {
								 Fees_Pending(s4,s3,con,in );
								 break;
							  }
							  case 4:
							  {
								 Attendence_Check(s4,s3,con,in);
								 break;
							  }
							  case 5:
							  {
								 School_updates(s4,s3,con,in);
								 break;
							  }
							  
							  default :
							  {
								  a1++;
								  System.out.println("		Invalid Number		");
								  break;
							  }
							}
						}while(a1>0);	
						if(s==0)
						  {
							int s1=0;
							 do {
									 s1=0;
									 System.out.println();
								  System.out.println("Press Y/N TO MOVE PREVIOUS PAGE");
								  System.out.println();
								  System.out.println("Enter character :");
								  char ch=in.next().charAt(0);
								  System.out.println();
								  if(ch=='Y')
								  {
									 s++; 
								  }
								  else if(ch=='N')
								  {
									  s=0;
									  System.out.println("		THANK YOU !!!		");
								  }
								  else
								  {
									  System.out.println("		Invalid Statement		");
									  s1++;
								  }
							   }while(s1>0);
						  }
						}while(s>0);
					}
						else	
						{
							System.out.print("		Invalid Username or password		");	
							System.out.println();
							System.out.print("		Only "+a2+" attempts allowed");
							end++;
							a2--;
						}	
					}while(a2>=0);
				}
				else if(c.equalsIgnoreCase(b))
				{
					int e=2;
					do
					{
						System.out.println();
						System.out.println("Username: ");
						String s5=in.next();
						in.nextLine();
						System.out.println("Password: ");
						String s6=in.next();
						ResultSet rs = stmt.executeQuery("select * from teacher_login where Username ='"+s5+"' and Password ='"+s6+"'");
						if(rs.next())
						{
							System.out.println("		Login Sucessfull		");
							System.out.println("Attendance (or) HomeTask (or) ExamMarks (or) School_Updates (or) Fees_Update");
							System.out.println();
							System.out.println();
							int s=0;
							do {
									s=0;
								System.out.println("PRESS 1 FOR Attendence");
								System.out.println("PRESS 2 FOR HomeTask");
								System.out.println("PRESS 3 FOR ExamMarks");
								System.out.println("PRESS 4 FOR School_updates");
								System.out.println("PRESS 5 FOR Fees_updates");
								System.out.println();
								System.out.println();
								int a1=0;
								do
								{	
									a1=0;
									System.out.println("Enter Number");
									int iNum=in.nextInt();
									System.out.println();
									switch(iNum)
									{
									  case 1:
									  {
										 Attendence(s5,s6,con,in);
										 break;
									  }
									  case 2:
									  {
										 Home_Task(s5,s6,con,in);
										 break;
									  }
									  case 3:
									  {
										 ExamMarks(s5,s6,con,in);
										 break;
									  }
									  case 4:
									  {
										 School_update(s5,s6,con,in);
										 break;
									  }
									  case 5:
									  {
										 Fees_update(s5,s6,con,in);
										 break;
									  }
									  default :
									  {
										  System.out.println("		Invalid Number		");
										  a1++;
										  break;
									  }
									}
								}while(a1>0);		  
								 if(s==0)
								  {
									 int s1=0;
									  do {
												  s1=0;
												  System.out.println();
											  System.out.println("Press Y/N TO MOVE PREVIOUS PAGE");
											  System.out.println();
											  System.out.println("Enter Character :");
											  char ch=in.next().charAt(0);
											  System.out.println();
											  if(ch=='Y'||ch=='y')
											  {
												 s++; 
											  }
											  else if(ch=='N'||ch=='n')
											  {
												  s=0;
												  System.out.println("		THANK YOU !!!		");	
												  e=-1;
											      
											  }
											  else
											  {
												  System.out.println("		Invalid Statement		");
												  s1++;
											  }
									   }while(s1>0);
								  }
								
							}while(s>0);
						}
						else							
						{
							System.out.print("		Invalid Username or password		");	
							System.out.println();
							System.out.print("		Only "+e+" attempts allowed");
							e--;
							end++;
						}	
					}while(e>=0);	
				}
				else
				{
					System.out.print("		Invalid Login		");
				}
		}while(end>0);		
	}
		public static void Homework(String s4,String s3,Connection con,Scanner sc)throws Exception
		{
	          System.out.println("		You Selected Homework		");	
	          System.out.println();
	          Statement stmt1 = con.createStatement();
	          ResultSet result2= stmt1.executeQuery("Select date from homeWorks ");
	          result2.next();
	          String Date=result2.getString("Date");
	          if(Date==null)
	          {
	        	  System.out.println("No HomeWorks");
	          }
	          else
	          {	  
		          System.out.println();
		          System.out.println("HomeWork on "+Date);
		          ResultSet result3= stmt1.executeQuery("Select * from homeWorks where Username ='"+s4+"'");
		    	  while(result3.next())
		    	  {
		    		  String sub=result3.getString("Subject");
		    		  String homeWork=result3.getString("homework");
		    		  System.out.println(sub+" : "+homeWork);
		    	  }
	          } 	  
		}
		public static void Report_Card(String s4,String s3,Connection con,Scanner in)throws Exception
		{
		    	Statement stmt1 = con.createStatement();
	          System.out.println("		You Selected Report_Card		");		
	          System.out.println();
	          System.out.println("Subject Marks..");
	          System.out.println();
	          ResultSet result= stmt1.executeQuery("Select count(subject) from Exammarks where Username ='"+s4+"'");
	          result.next();
	          int count=result.getInt(1);
	          System.out.println("No of Subjects : "+count);
	          ResultSet result2= stmt1.executeQuery("Select * from ExamMarks where Username ='"+s4+"'");
	    	  while(result2.next())
	    	  {
	    		  String sub=result2.getString("Subject");
	    		  int Marks=result2.getInt("Marks");
	    		  System.out.println(sub+" : "+Marks);
	    	  }
	    	  System.out.println();
	    	  ResultSet rs2= stmt1.executeQuery("Select * from student_details where Username ='"+s4+"'");
	    	  System.out.println();
	    	  rs2.next();
	    	      int a1=rs2.getInt("total");
	    	      Double a2=rs2.getDouble("average");
	    		  System.out.println("Total : "+a1);
	    		  System.out.println("Average : "+String.format("%.2f",a2)+"%");
		}
		public static void Fees_Pending(String s4,String s3,Connection con,Scanner in)throws Exception
		{
			  Statement stmt1 = con.createStatement();
	          System.out.println("		You Selected Fees_Pending		");		
	          System.out.println();
	          ResultSet result2= stmt1.executeQuery("Select * from fees_updates where Username ='"+s4+"'");
	    	  result2.next();
	    	  int fees=result2.getInt("fees");
	    	  int paid=result2.getInt("paid");
	    	  int balance=fees-paid;
	          System.out.println(" Amount should be paid : "+fees);
	          System.out.println(" Amount  paid : "+paid);
	          System.out.println(" Balance : "+balance);
	          System.out.println();
	          if(balance>0)
	          {
		          int a1=0;
		          do
		          {
		        	  a1=0;
			          System.out.println("Press Y/N to Pay Fees");
			          System.out.println("Enter Character ");
			          
			          char ch=in.next().charAt(0);
			          if(ch=='Y'||ch=='y')
			          {
			        	  System.out.println("Enter Amount :");
			        	  int Amount=in.nextInt();
			        	  balance=balance-Amount;
			        	  paid=paid+Amount;
			        	  int result1= stmt1.executeUpdate("Update fees_updates set balance ='"+a1+"',paid='"+paid+"' where Username ='"+s4+"'");
			        	  if(result1==1)
			        	  {
			        		  System.out.println("		Amount Paid..		");
			    	          if(balance==0)
			    	          {
			    	        	  System.out.println("		Fees Pending is Completed		");
			    	          }
			    	          else
			    	          {
			    	        	  System.out.println(" Total Amount Paid of "+s4+" : "+paid);
			    	        	  System.out.println(" Pending Fees of "+s4+" : "+balance); 
			    	          }
			        	  }
			        	  else
			        	  {
			        		  System.out.println("		Payment Pending  **TRY LATER**..		");
			        	  }
			          }
			          else if(ch=='N'||ch=='n')
			          {
			        	  System.out.println(" Pending Fees of "+s4+" : "+balance);
			          }
			          else
			          {
			        	  a1++;
			        	  System.out.println("Invalid Character..");
			          }
		          }while(a1>0);    
	          }
	          else
	          {
	        	 System.out.println("		Fees Pending is Completed		");  
	          }
		}
		public static void Attendence_Check(String s4,String s3,Connection con,Scanner in)throws Exception
		{
			Statement stmt1 = con.createStatement();
	          System.out.println("		You Selected Attendence%		");
	          System.out.println();
	          System.out.println("Total no of days of attendence : 150");
	          ResultSet result2= stmt1.executeQuery("Select absentdays,Percentage from Attendence where Username ='"+s4+"'");
	    	  result2.next();
	    	  int a1=result2.getInt("absentdays");
	    	  double a2=result2.getDouble("Percentage");
	    	   a1=150-a1;
	    	   System.out.println("Total no of days of Present : "+a1);
	    	   System.out.println("Attendence Percentage : "+String.format("%.2f",a2)+"%");
		}
		public static void School_updates(String s4,String s3,Connection con,Scanner in)throws Exception
		{
	          System.out.println("		You Selected School Updates		");
	          System.out.println();
	          Statement stmt1 = con.createStatement();
	          System.out.println();
	          ResultSet result= stmt1.executeQuery("Select updates,date from School_updates where  Username1 ='"+s4+"' and Password1 ='"+s3+"' ");
	           result.next();
	        	  String result1=result.getString("updates");
	        	  String result2=result.getString("date");
	        	  System.out.println("**Heart Welcome**");
	        	  System.out.println(result1+" (->) "+result2);
		}
		public static void Home_Task(String s5,String s6,Connection con,Scanner in)throws Exception
		{
	          System.out.println("		You Selected HomeTask		");		
	          Statement stmt1 = con.createStatement();
	          System.out.println();
	          ResultSet result= stmt1.executeQuery("Select distinct count(Username) from homeworks");
	          result.next();
	          int count=result.getInt(1);
	          for(int i=0;i<count;i++)
	          {
	        	  System.out.println("Enter Username : ");
	        	  String U1=in.next();
	        	 ResultSet rs = stmt1.executeQuery("select * from student_details where Username ='"+U1+"'");
	  			if(rs.next())
	  			{
	  				System.out.println("Do you want to Delete old Record or Home_work of "+U1);
	  				int s=0;
	  				do {
	  					s=0;
		  				System.out.println("Press Y/N : ");
		  				char ch=in.next().charAt(0);
		  				if(ch=='Y'||ch=='y')
		  				{
		  					int result2= stmt1.executeUpdate("delete from homeWorks where Username = '"+U1+"'");
		  					System.out.println("No of Records Affected :: "+result2);
		  					int k=0;
		  					do {
			  					      k=0;
				  				System.out.println("Enter no of Subjects (1-10) :");
				  				int iNum=in.nextInt();
				  				if(iNum>=1 && iNum<=10)
				  				{
						          for(int j=0;j<iNum;j++)
						          {
						        	  System.out.println("Subject Name : ");
						        	  String Sub=in.next();
						        	  System.out.println("Home_Task :");
						        	  String homeTask=in.next();
						        	  System.out.println("Enter Date of HomeWork :");
						        	  String Date=in.next();
						        	  int result1= stmt1.executeUpdate("Insert into homeWorks values ('"+Sub+"','"+homeTask+"','"+U1+"','"+Date+"')");
							          System.out.println("No of Records Affected :: "+result1);
							          if(result1==1)
							          {
							        	  System.out.println("		Records Updated!!!		");
							          }
						          }
				  				}
				  				else
				  				{
				  					 k++;
				  					 System.out.println("		Invalid Number..		");
				  				}
		  					}while(k>0);  
		  				}
		  				else if(ch=='N'||ch=='n')
		  				{
		  					System.out.println("Records Unchanged...");
		  				}
		  				else
		  				{
		  					s++;
		  					System.out.println("Invalid Character");
		  				}
	  				}while(s>0);	
		        }
	  			else
	  			{
	  				count=count+1;
	  				System.out.println("Invalid Username");
	  			}
	          }
		}
		public static void Attendence(String s5,String s6,Connection con,Scanner in)throws Exception
		{
			Statement stmt1 = con.createStatement();
	          System.out.println("		You Selected Attendence		");
	          System.out.println();
	          ResultSet result= stmt1.executeQuery("Select count(Username) from student_details");
	          result.next();
	          System.out.println("Total no of days of attendence : 150");
	          int count=result.getInt(1);
	          for(int i=0;i<count;i++)
	          {
	        	  System.out.println("Enter Username :");
	        	  String U1=in.next();
	        	  System.out.println("Enter P/A of "+U1);
	        	  System.out.println("Enter Character :");
	        	  char ch=in.next().charAt(0);
	        	  if(ch=='P'||ch=='p')
	        	  {
	        		  ResultSet result2= stmt1.executeQuery("Select absentdays,Percentage from Attendence where Username='"+U1+"'");
	    	          result2.next();
	    	          double a1=result2.getInt("absentdays");
	    	          a1=a1+0;
	        	      int result1= stmt1.executeUpdate("Update Attendence set absentdays ='"+a1+"' where Username ='"+U1+"'");
	    	          System.out.println("No of Records Affected :: "+result1);
	    	          if(result1==1)
	    	          {
	    	        	  System.out.println("		Records Updated!!!		");
	    	          }
	        	  }
	        	  else if(ch=='A'||ch=='a')
	        	  {
	        		  ResultSet result2= stmt1.executeQuery("Select absentdays,Percentage from Attendence where Username='"+U1+"'");
	    	          result2.next();
	    	          double a1=result2.getInt("absentdays");
	    	          double a2=result2.getInt("Percentage");
	    	          a1=a1+1;
	    	          a2=(a1/150)*100;
	    	          double a3=100-a2;
	        	      int result1= stmt1.executeUpdate("Update Attendence set absentdays ='"+a1+"',Percentage='"+a3+"' where Username ='"+U1+"'");
	    	          System.out.println("No of Records Affected :: "+result1);
	    	          if(result1==1)
	    	          {
	    	        	  System.out.println("		Records Updated!!!		");
	    	          }
	        	  }
	        	  else
	        	  {
	        		  count=count+1;
	        		  System.out.println("Invalid Character...");
	        	  }
	          }
		}
		public static void ExamMarks(String s5,String s6,Connection con,Scanner in)throws Exception
		{
			Statement stmt1 = con.createStatement();
	          System.out.println("		You Selected Exam_Marks		");	
	          System.out.println();
	          ResultSet result= stmt1.executeQuery("Select distinct count(Username) from Attendence");
	          result.next();
	          int count=result.getInt(1);
	          for(int i=0;i<count;i++)
	          {
	        	  double total=0;
	        	  System.out.println("Enter Username : ");
	        	  String U1=in.next();
	        	 ResultSet rs = stmt1.executeQuery("select * from student_details where Username ='"+U1+"'");
	  			if(rs.next())
	  			{
	  				System.out.println("Do you want to Delete old Record or Marks");
	  				int s=0;
	  				do {
	  					s=0;
		  				System.out.println("Press Y/N : ");
		  				char ch=in.next().charAt(0);
		  				if(ch=='Y'||ch=='y')
		  				{
		  					int result2= stmt1.executeUpdate("delete from Exammarks where Username = '"+U1+"'");
		  					System.out.println("No of Records Affected :: "+result2);
		  					int k=0;
		  					do {
		  						k=0;
			  				System.out.println("Enter no of Subjects (1-10) :");
			  				double iNum=in.nextInt();
			  				if(iNum>=1 && iNum<=10)
			  				{
						          for(int j=0;j<iNum;j++)
						          {
						        	  System.out.println("Subject Name : ");
						        	  String Sub=in.next();
						        	  System.out.println(Sub+" Mark ( Out of 100 ) :");
						        	  double Marks =in.nextInt();
						        	  total=total+Marks;
						        	  int result1= stmt1.executeUpdate("Insert into Exammarks values ('"+Sub+"','"+Marks+"','"+U1+"')");
							          System.out.println("No of Records Affected :: "+result1);
							          if(result1==1)
							          {
							        	  System.out.println("		Records Updated!!!		");
							          }
						          }
						          double average = (total/iNum);
						          System.out.println("Total"+" = "+ total);
						          System.out.println("Average"+" = "+average);
						          int result1= stmt1.executeUpdate("Update student_details set total='"+total+"',average='"+average+"' where Username = '"+U1+"' ");
						            System.out.println("No of Records Affected :: "+result1);
						            if(result1==1)
							          {
							        	  System.out.println("		Records Updated!!!		");
							          }
			  				}
			  				else
			  				{
			  					System.out.println("		 Invalid Number		");
			  					k++;
			  				}
		  					}while(k>0);  
		  				}
		  				else if(ch=='N'||ch=='n')
		  				{
		  					System.out.println("Records Unchanged...");
		  				}
		  				else
		  				{
		  					s++;
		  					System.out.println("Invalid Character");
		  				}
	  				}while(s>0);	
		        }
	  			else
	  			{
	  				count=count+1;
	  				System.out.println("Invalid Username");
	  			}
	          }	
		}
		public static void School_update(String s5,String s6,Connection con,Scanner in)throws Exception
		{
			Statement stmt1 = con.createStatement();
	          System.out.println("		You Selected School Updates		");
	          System.out.println();
	          System.out.println();
	          System.out.println("Function name");
	          String up1=in.next();
	          System.out.println("Date of Function");
	          String date=in.next();
	          int result= stmt1.executeUpdate("Update school_updates set updates ='"+up1+"',date ='"+date+"' where class = 'A'");
	          System.out.println("No of Records Affected :: "+result);
	          if(result==1)
	          {
	        	  System.out.println("		Records Updated!!!		");
	          }
	     }
		public static void Fees_update(String s5,String s6,Connection con,Scanner in)throws Exception
		{
			Statement stmt1 = con.createStatement();
	          System.out.println("		You Selected Fees Updates		");
	          System.out.println();
	          ResultSet result= stmt1.executeQuery("Select count(Username) from fees_updates");
	          result.next();
	          int count=result.getInt(1);
	          for(int i=0;i<count;i++)
	          {
	        	  System.out.println("Enter Username : ");
	        	  String U1=in.next();
	        	 ResultSet rs = stmt1.executeQuery("select * from fees_updates where Username ='"+U1+"'");
	  			if(rs.next())
	  			{
	  				System.out.println("		Do you want to Update fees		");
	  				int s=0;
	  				do {
		  					 s=0;
		  				System.out.println("Press Y/N to update fees");
		  				System.out.println("Enter Character : ");
		  				char ch=in.next().charAt(0);
		  				if(ch=='Y'||ch=='y') 
		  				{
				  			ResultSet result2= stmt1.executeQuery("Select * from fees_updates where Username = '"+U1+"'");
				  			result2.next();
				  			int a=result2.getInt("fees");
				  			System.out.println("Enter Amount :");
				  			int a1=in.nextInt();
				  			a=a+a1;	
					        int result1= stmt1.executeUpdate("Update fees_updates set fees='"+a+"'where Username='"+U1+"'");
					        System.out.println("No of Records Affected :: "+result1);
					        if(result1==1)
					        {
					        	System.out.println("		Records Updated!!!		");
					        }
		  				}
		  				else if(ch=='N'||ch=='n')
		  				{
		  					System.out.println("Records Unchanged...");
		  				}
		  				else
		  				{
		  					System.out.println("Invalid Character..");
		  					s++;
		  				}
	  				}while(s>0);
		        }
	  			else
	  			{
	  				count=count+1;
	  				System.out.println("Invalid Username");
	  			}
	          }  
		}
	public static void main(String[] args) throws Exception {
		Connect c = new Connect();
		c.getConnection();
		c.Student_login();		
	}
}
