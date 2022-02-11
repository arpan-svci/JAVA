import java.util.Scanner;
import java.util.StringTokenizer;
class My_string{
    String s;
    void getString(){
        Scanner sc=new Scanner(System.in);
        System.out.print("\n enter the string:");
        s=sc.nextLine();
    }
    void appearence_Of_a(){
        int count=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='a'){
                count++;
            }
        }
        System.out.print("\n no. of appearence of 'a':"+count);
    }
    void the_at_first(){
        String sub=new String();
        String s1=new String("the");
        sub=s.substring(0,3);
        if(sub.equals(s1)){
            System.out.print("\nthe is present at first");
        }
        else{
            System.out.print("\nthe is not present at first");
        }
    }
    void find_no_of_and(){
        int count=0;
        StringTokenizer st=new StringTokenizer(s);
        while(st.hasMoreTokens()){
            if(st.nextToken().equals("and"))
            count++;
        }
        System.out.print("\n no. of times and appear:"+count);
    }
    void Str_to_char_array(){
        char []ch=s.toCharArray();
        for(char c:ch){
            System.out.println(c);
        }
    }
    void tokenSepertor(){
        StringTokenizer st=new StringTokenizer(s," .@");
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
    My_string(){
        s=new String();
    }

}
class Solve{
    public static void main(String []args){ 
        My_string s=new My_string();
        regulate(s);
    }
    public static void regulate(My_string p){
        boolean k=true;
        while(k){
            Scanner s=new Scanner(System.in);
            int j;
            System.out.println("\npress\n1 for enter string\n2 to find apperence of a\n3 to check if the is present at first\n4 to find no. of and\n5 see the tokens\n6 to convert string to char array");
            j=s.nextInt();
            switch(j){
                case 1:
                    p.getString();
                    break;
                case 2:
                    p.appearence_Of_a();
                    break;
                case 3:
                    p.the_at_first();
                    break;
                case 4:
                    p.find_no_of_and();
                    break;
                case 5:
                    p.tokenSepertor();
                    break;
                case 6:
                    p.Str_to_char_array();
                    break;
                default:
                    System.out.print("wrong input");
                    break;

            }
            System.out.print("\n do you want to continue:");
            k=s.nextBoolean();
        }
    }
}