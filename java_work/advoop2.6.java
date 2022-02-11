
import java.util.Scanner;
class Address{
    int home_no;
    String Street,city,pin,state;
    private Scanner sc=new Scanner(System.in);
    private Scanner s=new Scanner(System.in);
    void getdata(){   
        System.out.print("\nhome no.:");
        home_no=sc.nextInt();
        System.out.print("\nenter the name of Street:");
        Street=s.nextLine();
        System.out.print("\nenter the name of city:");
        city=s.nextLine();
        System.out.print("\nenter pin:");
        pin=s.nextLine();
        System.out.print("\nenter name of state:");
        state=s.nextLine();
    }
    String add_return(){
        return(((((((((Integer.toString(home_no)).concat(",")).concat(Street)).concat(",")).concat(city)).concat(",")).concat(pin)).concat(",")).concat(state));
    }
    void Channge_add(){
        System.out.print("\nwhich field you want to change(for home no. press 1,for street press 2,for city press 3,for pin press 4,for state press 5):");
        int choice=sc.nextInt();
        switch(choice){
            case 1:
                System.out.print("\nenter new home no.:");
                home_no=sc.nextInt();
                break;
            case 2:
                System.out.print("\nenter new home no.:");
                home_no=sc.nextInt();
                System.out.print("\n enter new street:");
                Street=s.nextLine();
                break;
            case 3:
                System.out.print("\nenter new home no.:");
                home_no=sc.nextInt();
                System.out.print("\n enter new street:");
                Street=s.nextLine();
                System.out.print("\nenter new city:");
                city=s.nextLine();
                break;
            case 4:
                System.out.print("\nenter new home no.:");
                home_no=sc.nextInt();
                System.out.print("\n enter new street:");
                Street=s.nextLine();
                System.out.print("\nenter new city:");
                city=s.nextLine();
                System.out.print("\nenter new pin:");
                pin=s.nextLine();
                break;
            case 5:
                 System.out.print("\nenter new home no.:");
                home_no=sc.nextInt();
                System.out.print("\n enter new street:");
                Street=s.nextLine();
                System.out.print("\nenter new city:");
                city=s.nextLine();
                System.out.print("\nenter new pin:");
                pin=s.nextLine();
                System.out.print("\n enter new State");
                state=s.nextLine();
                break;
            default:
                System.out.print("\nwrong input");
        }


    }
    Address(){
        Street=new String();
        city=new String();
        pin=new String();
        state=new String();
    }
}
class Person{
    Address a;
    String name,ph_no,email_id;
    Scanner sc;
    void change_address(){
        System.out.print("\n");
        a.Channge_add();
    } 
    Person(){
        sc=new Scanner(System.in);
        a=new Address();
        name=new String();
        ph_no=new String();
        email_id=new String();
    }
}
class Student extends Person{
    String Roll_no,course_of_study;
    void getdata(){
        System.out.print("\n\nenter address:");
        a.getdata();
        System.out.print("\nenter name:");
        name=sc.nextLine();
        System.out.print("\nenter phone no:");
        ph_no=sc.nextLine();
        System.out.print("\nenter email id:");
        email_id=sc.nextLine();
        System.out.print("\nenter roll no.:");
        Roll_no=sc.nextLine();
        System.out.print("\nenter cource:");
        course_of_study=sc.nextLine();
    }
    void Showdata(){
        System.out.print("\n\nname:"+name);
        System.out.print("\naddress:"+a.add_return());
        System.out.print("\nphone no.:"+ph_no);
        System.out.print("\nemail id:"+email_id);
        System.out.print("\nroll no.:"+Roll_no);
        System.out.print("\ncource:"+course_of_study);
    }
    void reg(){
        boolean k=true;
        while(k){
            Scanner s=new Scanner(System.in);
            int j;
            System.out.println("\npress\n1 for enter data for student\n2 to see details of student\n3 to change the address");
            j=s.nextInt();
            switch(j){
                case 1:
                    getdata();
                    break;
                case 2:
                    Showdata();
                    break;
                case 3:
                    change_address();
                    break;
                default:
                    System.out.print("wrong input");
                    break;

            }
            System.out.print("\n do you want to continue:");
            k=s.nextBoolean();
        }
    }
    Student(){
        Roll_no=new String();
        course_of_study=new String();
    }
}
class Faculty extends Person{
    String emp_id,dept,specail;
    Scanner sc;
    void getdata(){
        System.out.print("\n\nenter address:");
        a.getdata();
        System.out.print("\nenter name:");
        name=sc.nextLine();
        System.out.print("\nenter phone no.:");
        ph_no=sc.nextLine();
        System.out.print("\nenter email id:");
        email_id=sc.nextLine();
        System.out.print("\nenter employ id:");
        emp_id=sc.nextLine();
        System.out.print("\nenter depertment:");
        dept=sc.nextLine();
        System.out.print("\nenter specalization:");
        specail=sc.nextLine();
    }
    void regulate(){
        boolean k=true;
        while(k){
            Scanner s=new Scanner(System.in);
            int j;
            System.out.println("\npress\n1 for enter data for faculty\n2 to see details of faculty\n3 to change the address");
            j=s.nextInt();
            switch(j){
                case 1:
                    getdata();
                    break;
                case 2:
                    Showdata();
                    break;
                case 3:
                    change_address();
                    break;
                default:
                    System.out.print("wrong input");
                    break;

            }
            System.out.print("\n do you want to continue:");
            k=s.nextBoolean();
        }
    }
    void Showdata(){
        System.out.print("\n\nname:"+name);
        System.out.print("\naddress:"+a.add_return());
        System.out.print("\nphone no.:"+ph_no);
        System.out.print("\nemail id:"+email_id);
        System.out.print("\nemploy id:"+emp_id);
        System.out.print("\ndepertment:"+dept);
        System.out.print("\nspecalization:"+specail);
    }
    Faculty(){
        sc=new Scanner(System.in);
        emp_id=new String();
        dept=new String();
        specail=new String();
    }
}
class Self{
    public static void main(String[]args){
        Student s=new Student();
        Faculty f=new Faculty();
        s.reg();
        f.regulate();
    }
}
