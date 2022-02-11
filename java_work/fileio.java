import java.io.*;
import java.io.Serializable;
import java.util.Scanner;
class Student1 implements Serializable{
    String roll;
    String name;
    int score;
    //public Scanner sc=new Scanner(System.in);
    //public Scanner s=new Scanner(System.in);
    //public Scanner s1=new Scanner(System.in);
    //public void getdata(){
     //   System.out.print("enter name:");
     //   name=sc.nextLine();
     //   System.out.print("enter roll:");
     //   roll=sc.nextLine();
     //   System.out.print("enter score:");
     //   score=s.nextInt();
   // }
   Student1(String name,String roll,int score){
       this.name=name;
       this.roll=roll;
       this.score=score;
   }
    @Override
    public String toString(){
        return("name:"+name+"\troll:"+roll+"\tscore:"+score);
    }
}
public class fileio {
    static void writeToFile(String filename,Object s){
        try{
            FileOutputStream f=new FileOutputStream(filename,true);
            ObjectOutputStream obj=new ObjectOutputStream(f);
            obj.writeObject(s);
            obj.close();
        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }
    static void readFromFile(String filename){
        try{
            FileInputStream f=new FileInputStream(filename);
            ObjectInputStream objin=new ObjectInputStream(f);
            Object s=null;
            System.out.println(objin.readObject().toString());
            while((s=objin.readObject())!=null){
                System.out.println(s);
            }
            objin.close();
        }
        catch(Exception e){
            e.getStackTrace();
        }
    }
public static void main(String args[]){
    try{
        Student1 s=new Student1("abc","001910501061",51);
       // s.getdata();
        fileio.writeToFile("output",s);
        fileio.readFromFile("output");
    }
    catch(Exception e){
        e.fillInStackTrace();
    }
}
}
