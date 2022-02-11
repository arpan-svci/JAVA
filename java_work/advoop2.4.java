import java.util.*;

class wrapper{
    int i; 
    Integer i_obj;
    String str;

    public void input(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter any integer: ");
        i = input.nextInt();        
        String s = input.nextLine();
    }

    public void basic_to_object(){
        i_obj = Integer.valueOf(i);
        System.out.println("Integer value as object: " + i_obj);
    }

    public void object_to_basic(){
        i_obj = Integer.valueOf(i);
        int iv = i_obj;
        System.out.println("Integer value as basic data type: " + iv);
    }

    public void basic_to_String(){
        str = String.valueOf(i);
        System.out.println("Integer value as String: " + str);
    }

    public void String_to_object(){
        str = String.valueOf(i);
        Object str_obj = str;
        System.out.println("Integer value as object: " + str_obj);
    }

    public void object_to_String(){
        String s = String.valueOf(i);
        Object str_obj = s;
        String ns = String.valueOf(str_obj);
        System.out.println("Integer value as String: " + ns);
    }

}

public class assignment2_4{
    public static void main(String[] args){
        wrapper n = new wrapper();
        Scanner input = new Scanner(System.in);
        int c;
        while(true){
            System.out.println("Press:\n1. To Input integer \n2. To convert basic data type to object \n3. To convert object to basic data type \n4. To convert basic data type to String \n5. To convert String to object \n6. To convert object to String\n0. To exit"); 
            System.out.print("Your Choice: ");
            c = input.nextInt();
            String s = input.nextLine();
            switch(c){
            case 1:
                n.input();
                break;
            case 2:
                n.basic_to_object();
                break;
            case 3:
                n.object_to_basic();
                break;
            case 4:
                n.basic_to_String();
                break;
            case 5:
                n.String_to_object();
                break;
            case 6:
                n.object_to_String();
                break;
            case 0:
                System.out.println("Thank you!!");
                System.exit(0);
                break;
            default:
                System.out.println("You have entered an invalid choice\nPlease enter correct choice next time!!");
                break;
            }
        }       
    }
}