import java.util.Scanner;
class Customer{
    String name,phone_no;
    protected String customer_id;
    protected int loan,credit_limit;
    protected Scanner sc=new Scanner(System.in);
    protected Scanner s=new Scanner(System.in);
    void getdata(){
        System.out.print("\nenter name:");
        name=sc.nextLine();
        System.out.print("\nenter phone no.:");
        phone_no=sc.nextLine();
        System.out.print("\nenter customer id:");
        customer_id=sc.nextLine();
    }
    void get_information_customer(){
        System.out.print("\ncredit limit:"+credit_limit);
        System.out.print("\ncurrent loan amount:"+loan);
        System.out.print("\namount of loan can seek:"+(credit_limit-loan));
    }
    void get_information_bank(){
        System.out.print("\nname:"+name);
        System.out.print("\nphone no.:"+phone_no);
        System.out.print("\ncustomer id:"+customer_id);
        System.out.print("\ncredit limit:"+credit_limit);
        System.out.print("\ncurrent loan amount:"+loan);
        System.out.print("\namount of loan can seek:"+(credit_limit-loan));
    }
    void get_loan(){
        System.out.print("\nenter the amount of loan needed:");
        int k=s.nextInt();
        if(k>credit_limit-loan){
            System.out.print("\ncredit limit exceed");
        }
        else{
            loan=loan+k;
        }
    }
    void change_ph_no(){
        System.out.print("\nenter new phone no.:");
        phone_no=sc.nextLine();
    }
    void change_name(){
        System.out.print("\nenter new name:");
        name=sc.nextLine();
    }
    Customer(){
        name=new String();
        phone_no=new String();
        customer_id=new String();
        credit_limit=50000;
    }
}
class Privilledge_customer extends Customer{
    Privilledge_customer(){
        credit_limit=60000;
    }
}
class Solution1 {
    public static void main(String[]args){
        Customer c1=new Customer();
        Privilledge_customer p1=new Privilledge_customer();
        //regulate(c1);
        regulate(p1);
    }
   public static void regulate(Customer p){
        boolean k=true;
        while(k){
            Scanner s=new Scanner(System.in);
            int j;
            System.out.println("\npress\n1 for enter data for customer\n2 for get loan\n3 to see the information by customer\n4 to see the informaton of customer by bank\n5 to change name\n6 to change mobile no.");
            j=s.nextInt();
            switch(j){
                case 1:
                    p.getdata();
                    break;
                case 2:
                    p.get_loan();
                    break;
                case 3:
                    p.get_information_customer();
                    break;
                case 4:
                    p.get_information_bank();
                    break;
                case 5:
                    p.change_name();
                case 6:
                    p.change_ph_no();
                default:
                    System.out.print("wrong input");
                    break;

            }
            System.out.print("\n do you want to continue:");
            k=s.nextBoolean();
        }
    }
}
