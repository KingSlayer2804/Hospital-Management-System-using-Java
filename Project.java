// Hospital management system project
import java.util.*;

class Staff
{
    private int staff_id = 0, password = 0;
    public Staff(int staff_id, int password)
    {
        this.staff_id = staff_id;
        this.password = password; 
    }

    int get_id()
    {
        return staff_id;
    }

    public int get_password()
    {
        return password;
    }
}

class Patient
{
    private int patient_id = 0;
    private String patient_name = "";
    private String doctor_name = "";
    private String disease_name = "";
    Scanner sc= new Scanner(System.in);

    public int getid()
    {
        return patient_id;
    }

    public void input()
    {
        System.out.print("Enter the ID of the patient: \n");
        patient_id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the name of the patient: \n");
        patient_name = sc.nextLine();
        System.out.print("Enter the name of the doctor: \n");
        doctor_name = sc.nextLine();
        System.out.print("Enter the name of the disease: \n");
        disease_name = sc.nextLine();
    }

    public void display()
    {
        System.out.print("Patient ID : "+patient_id+"\n");
        System.out.print("Patient Name : "+patient_name+"\n");
        System.out.print("Consulting doctors name : "+doctor_name+"\n");
        System.out.print("Name of the disease being diagnosed : "+disease_name+"\n");
    }
}

class Admitted_patient extends Patient
{
    private int ward_no = 0;
    private String type_ward = "";
    private String days = "";

    public void input()
    {
        super.input();
        System.out.print("Enter the ward number : \n");
        ward_no = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the type of ward : \n");
        type_ward = sc.nextLine();
        System.out.print("Enter the number of days of stay : \n");
        days = sc.nextLine();
    }

    public void display()
    {
        super.display();
        System.out.print("Ward Number : "+ward_no+"\n");
        System.out.print("Type of ward : "+type_ward+"\n");
        System.out.print("Days of stay : "+days+"\n");
    }
}

class Normal_patient extends Patient
{
    private String next_appt;
    
    public void input()
    {
        super.input();
        System.out.print("Enter the date of the next appoinment : \n");
        next_appt = sc.nextLine();
    }

    public void display()
    {
        super.display();
        System.out.print("Next appointment date : "+next_appt+"\n");
    }
}

class Bill
{
    private int price[] = new int[100];
    private String product[] = new String[100];
    private int total = 0, bill_id, num,staff_i;
    private double cgst,sgst;
    private double grand_total;

    Scanner sc=new Scanner(System.in);

    public void getItem()
    {
        System.out.print("Enter the number of medicines to be bought [Max 100 Products] : \n");
        num = sc.nextInt();
    }

    public void input()
    {
        System.out.println("Enter the bill ID : ");
        bill_id = sc.nextInt();

        for(int i = 0; i < num; i++)
        {
            System.out.print("Enter the product name : \n");
            product[i] = sc.next();
            sc.nextLine();
            System.out.println("Enter the price of the product : ");
            price[i] = sc.nextInt();
        }
    }
    public void setIndex(int si)
    {
        staff_i=si;
    }
    public int getIndex()
    {
        return staff_i;
    }
    public int getid()
    {
        return bill_id;
    }

    public void calculate()
    {
        for(int i = 0; i < num; i++)
        {
            total = total + price[i];
        }

        cgst = (double)total * 0.04;
        sgst = (double)total * 0.05;
        grand_total = (double)total + cgst + sgst;
    }

    void display(Admitted_patient ap)
    {
        System.out.print("---------------------PATIENT DETAILS---------------------------\n");
        ap.display();
        System.out.print("--------------------------------Bill---------------------------\n");
        System.out.print("Bill ID:"+bill_id+"\n");
        System.out.print("Product Name\t\t\tProduct Price");
        for(int  i = 0; i < num; i++)
        {
            System.out.print("\n"+product[i]+"\t\t\t\t"+price[i]);
        }
        System.out.print("\nTotal : "+total+"\n");
        System.out.print("CGST : "+cgst+"\n");
        System.out.print("SGST : "+sgst+"\n");
        System.out.print("Grand Total : "+grand_total+"\n");
        System.out.print("---------------------------------------------------------------\n");
    }

    void display(Normal_patient np)
    {
        System.out.print("---------------------PATIENT DETAILS---------------------------\n");
        np.display();
        System.out.print("--------------------------------Bill---------------------------\n");
        System.out.print("Bill ID:"+bill_id+"\n");
        System.out.print("Product Name\t\t\tProduct Price");
        for(int  i = 0; i < num; i++)
        {
            System.out.print("\n"+product[i]+"\t\t\t\t"+price[i]);
        }
        System.out.print("\nTotal : "+total+"\n");
        System.out.print("CGST : "+cgst+"\n");
        System.out.print("SGST : "+sgst+"\n");
        System.out.print("Grand Total : "+grand_total+"\n");
        System.out.print("---------------------------------------------------------------\n");
    }
}

class Project{
    public static void main(String[] args) 
    {
        int num,ch = 0,i,x=0,y=0,a=0;
        int temp_id,temp_password;
        Staff[] staff= new Staff[100];
        Bill[] bill = new Bill[100];
        for(i = 0; i < bill.length; i++)
        {
            bill[i] = new Bill();
        }
        int staff_index = 0;
        Normal_patient[] np = new Normal_patient[100];
        for(i = 0; i < np.length; i++)
        {
            np[i] = new Normal_patient();
        }
        Admitted_patient[] ap = new Admitted_patient[100];
        for(i = 0; i < ap.length; i++)
        {
            ap[i] = new Admitted_patient();
        }
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of Staff you want to register : \n");
        num = sc.nextInt();
        for(i = 0; i < num; i++)
        {
            System.out.print("Enter the ID for the Employee : \n");
            temp_id = sc.nextInt();
            System.out.print("Enter the password : \n");
            temp_password = sc.nextInt();

            Staff temp = new Staff(temp_id,temp_password);
            staff[i] = temp;
        }
        System.out.print("-----------------------MMT Hospital----------------------\n");
        while(true)
        {
            System.out.print("Press 1 to go to Log in page\nPress 2 to exit the program!(This will erase all data)\n");
            ch=sc.nextInt();
            if(ch==1)
            {
                System.out.print("-----------------------Staff Login-----------------------\n");
                System.out.print("Enter Your ID : \n");
                temp_id = sc.nextInt();
                for(i = 0; i < num; i++)
                {
                    if(staff[i].get_id() == temp_id)
                    {
                        staff_index = i;
                        break;
                    }
                }
                System.out.print("Enter your password : \n");
                temp_password = sc.nextInt();

                if(staff[staff_index].get_password() == temp_password)
                {
                    while(true)
                    {
                        System.out.print("Press 1 to Admit a New patient\nPress 2 to Check out and get Bill of the patient\nPress 3 to search\nPress 4 to Log out\n");
                        System.out.print("Enter your choice : \n");
                        ch = sc.nextInt();
                        if(ch == 1)
                        {
                            System.out.print("Press 1 to for Admitting a patient\nPress 2 for a normal patient\n");
                            System.out.print("Enter your choice: \n");
                            ch = sc.nextInt();

                            if(ch == 1)
                            {
                                ap[x].input();
                                System.out.print("--------------------------------------------------\n");
                                ap[x].display();
                                System.out.print("-----------DATA SAVED SUCCESSFULLY!---------------\n");
                                x++;
                            }
                            else if(ch == 2)
                            {
                                np[y].input();
                                System.out.print("--------------------------------------------------\n");
                                np[y].display();
                                System.out.print("-----------DATA SAVED SUCCESSFULLY!---------------\n");
                                y++;
                            }
                            else
                            {
                                System.out.println("Invalid input!\n");
                            }
                        }
                        else if(ch==2)
                        {
                            System.out.print("Press 1 for admitted patient\nPress 2 for Normal patient\n");
                            ch = sc.nextInt();

                            if(ch == 1)
                            {
                                System.out.print("Enter The ID of the patient : \n");
                                temp_id = sc.nextInt();
                                for(i = 0; i < x; i++)
                                {
                                    if(ap[i].getid() == temp_id)
                                    {
                                        staff_index = i;
                                        break;
                                    }
                                }
                                bill[a].setIndex(staff_index);
                                bill[a].getItem();
                                bill[a].input();
                                bill[a].calculate();
                                bill[a].display(ap[staff_index]);
                                a++;
                            }
                            else if(ch == 2)
                            {
                                System.out.print("Enter The ID of the patient : \n");
                                temp_id = sc.nextInt();
                                for(i = 0; i < y; i++)
                                {
                                    if(np[i].getid() == temp_id)
                                    {
                                        staff_index = i;
                                        break;
                                    }
                                }
                                bill[a].getItem();
                                bill[a].input();
                                bill[a].calculate();
                                bill[a].display(np[staff_index]);
                                a++;
                            }
                        }
                        else if (ch==3)
                        {
                            System.out.println("\nPress 1 to search data of a patient.\nPress 2 to search a bill.\n");
                            ch=sc.nextInt();
                            if (ch==1)
                            {
                                System.out.println("Enter the ID of the patient:\n");
                                temp_id=sc.nextInt();
                                for (i=0;i<x;i++)
                                {
                                    if(temp_id==ap[i].getid())
                                    {
                                        System.out.println("Patient found!");
                                        ap[i].display();
                                        break;
                                    }
                                }
                                for (i=0;i<y;i++)
                                {
                                    if (temp_id==np[i].getid())
                                    {
                                        System.out.println("Patient found!");
                                        np[i].display();
                                        break;
                                    }
                                }
                            }
                            else if (ch==2)
                            {
                                System.out.println("Press 1 to see admitted patient's bill\nPress 2 to see normal patients bill\n");
                                ch=sc.nextInt();
                                System.out.println("Enter the ID of the Bill:\n");
                                temp_id=sc.nextInt();
                                if (ch==1)
                                {
                                    for (i=0;i<a;i++)
                                    {
                                        if (bill[i].getid()==temp_id)
                                        {
                                            System.out.println("Bill found!");
                                            bill[i].display(ap[bill[i].getIndex()]);
                                            break;
                                        }
                                    }
                                }
                                else if (ch==2)
                                {
                                    for (i=0;i<a;i++)
                                    {
                                        if (bill[i].getid()==temp_id)
                                        {
                                            System.out.println("Bill found!");
                                            bill[i].display(np[bill[i].getIndex()]);
                                            break;
                                        }
                                    }
                                }
                            }
                        }
                        else if(ch == 4)
                        {
                            System.out.println("Logged out successfully!");
                            break;
                        }
                        else
                        {
                            System.out.print("Invalid input!\n");
                        }
                    }
                }
                else
                {
                    System.out.print("\nInvalid login credentials!\n");
                }
            }
            else if (ch==2)
            {
                System.exit(0);
            }
            else
            {
                System.out.print("Invalid input!");
            }
        }
    }  
}
