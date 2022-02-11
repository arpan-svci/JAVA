import java.io.*;
import java.lang.*;
 class Stack{
     char a[]=new char[100];
     int top=-1;
     boolean checkOverflow(){
         if(top==100)
            return true;
        else
            return false;
     }
     boolean checkUnderflow(){
         if(top==-1)
            return true;
        else
            return false;
     }
     void push(char c){
        if(checkOverflow()==true)
        System.out.println("Stack overflow");
        else{
            top++;
            a[top]=c;
        }
     }
     void pop(){
         if(checkUnderflow()==true)
            System.out.println("Stack underflow");
        else{
            top--;
        }
     }
     char peek(){
        return a[top];
     }
 }
 class Set_level {
     public static void main (String []args) throws IOException{
         Stack a=new Stack();
         FileWriter f=new FileWriter("program.txt",true);
         f.close();
         int c,o=0;
         char c1;
         FileReader fp=new FileReader("program.txt");
         while((c=fp.read())!=-1){
             c1=(char)c;
             if(c1=='['||c1=='('){
                a.push(c1);
                o++;
             }
            else if(c1==']'){
                if(a.checkUnderflow()==true){
                    System.out.println("mismatch");
                    System.exit(0);
                }
                else if(a.peek()=='[')
                a.pop();
                else{
                    System.out.println("mismatch");
                    System.exit(0); 
                }
            }
            else if(c1==')'){
                if(a.checkUnderflow()==true){
                    System.out.println("mismatch");
                    System.exit(0);
                }
                else if(a.peek()=='('){
                    a.pop();
                }
                else{
                    System.out.println("mismatch");
                    System.exit(0);
                }
            }
            else{

            }
         }
         if(o==0){
             System.out.println("no such bracktes exist");
         }
         if(o>0&&a.checkUnderflow()==false){
             System.out.println("mismatch");
         }
         if(o>0&&a.checkUnderflow()==true){
             System.out.println("match");
         }
         fp.close();
     }
}
