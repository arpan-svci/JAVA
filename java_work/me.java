import java.io.FileInputStream;
import java.io.ObjectInputStream;

class me {
public static void main(String args[]){
    try{
    FileInputStream f=new FileInputStream("output");
    ObjectInputStream input=new ObjectInputStream(f);
    System.out.println(input.readObject().toString());
    input.close();
    }
    catch(Exception e){
        System.out.println(e.getMessage());
    }

}    
}
