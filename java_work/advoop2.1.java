import java.util.Scanner;
class BankAcct{
    String account_no;
    int balance;
    static int interest=0;
    void getdata(){
        Scanner sc=new Scanner(System.in);
        System.out.print("\nEnter account no.:");
        account_no=sc.nextLine();
        Scanner s=new Scanner(System.in);
        System.out.print("\nenter balance:");
        balance=s.nextInt();

    }
    void view_interest_rate(){
        System.out.print("\nInterest Rate="+interest);
    }
    void change_interest_rate(){
        System.out.print("\nEnter new interest rate:");
        Scanner sc=new Scanner(System.in);
        interest=sc.nextInt();
    }
    int returnBalance(){
        System.out.print("account balance="+balance);
        return balance;
    }
    void viewInterest(){
        int k=(balance*interest)/100;
        System.out.print("Interest="+k);
    }
    BankAcct(){

    }
    BankAcct(int k){
        interest=k;
    }
}
class Solution{
    public static void main(String args[]){
        BankAcct ac1=new BankAcct(6);
        BankAcct ac2=new BankAcct();
        BankAcct ac3=new BankAcct();
        regulate(ac1);
        regulate(ac2);
        regulate(ac3);
    }
    static void regulate(BankAcct ac){
        int k=1;
        while(k!=0){
            Scanner s=new Scanner(System.in);
            int j;
            System.out.println("press\n1.see balance\n2.view interest rate\n3.change interest rate\n4.view interest\n5.get information");
            j=s.nextInt();
            switch(j){
                case 1:
                    ac.returnBalance();
                    break;
                case 2:
                    ac.view_interest_rate();
                    break;
                case 3:
                    ac.change_interest_rate();
                    break;
                case 4:
                    ac.viewInterest();
                    break;
                case 5:
                    ac.getdata();
                    break;
                default:
                    System.out.print("wrong input");
                    break;

            }
            System.out.print("\n do you want to continue(1/0):");
            k=s.nextInt();
        }
    }
}