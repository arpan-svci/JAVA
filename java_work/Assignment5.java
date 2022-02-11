//package java_assignment;
import java.io.FileReader;
import java.util.*;
import java.io.*;
class Word{
    String str;
    int presence;
    ArrayList<Integer>L=new ArrayList<Integer>();
    void viewData(){
        System.out.println("String: "+str+"\nno. of occurence: "+presence);
        for(int i=0;i<L.size();i++){
            System.out.println("line number : " +L.get(i));
        }
    }
    Word(){
        presence=0;
    }
}
public class Assignment5 {
    public static void main(String[] args)throws IOException {
        HashMap<String,Word>list=new HashMap<String,Word>();
        FileWriter f=new FileWriter("program.txt",true);
        f.close();
        FileReader r=new FileReader("program.txt");
        int count=1;
        int c;
        char c1;
        ArrayList<String>a=new ArrayList<String>();
        String str=new String();
        String s=new String();
        while((c=r.read())!=-1){
            Word p=new Word();
            c1=(char)c;
            s=Character.toString(c1);
            if((c1==' ')||(c1=='\n')||(c1=='\r')){
                if(a.size()!=0){
                    StringBuffer sb=new StringBuffer();
                    int i=0;
                    for(String token:a){
                        i++;
                        sb.append(token);
                    }
                    a.clear();
                    str=sb.toString();
                    sb=sb.delete(0,sb.length()+1);
                    if(list.containsKey(str)==true){
                        p=list.get(str);
                        p.presence++;
                        p.L.add(count);
                        list.put(str,p);
                    }
                    else{
                        p.str=str;
                        p.presence++;
                        p.L.add(count);
                        list.put(str,p);
                    }
                    if(c1=='\n'||c1=='\r'){
                        count++;
                        a.clear();
                        sb=sb.delete(0, sb.length());
                    }
                }
                else{}
            }
            else{
                a.add(s);
            }
        }
        Word p=new Word();
        StringBuffer sb=new StringBuffer();
        if(a.size()!=0){
            for(String token:a){
                sb.append(token);
            }
            a.clear();
            str=sb.toString();
            sb=sb.delete(0,sb.length());
            if(list.containsKey(str)==true){
                p=list.get(str);
                p.presence++;
                p.L.add(count);
                list.put(str,p);
            }
            else{
                p.str=str;
                p.presence++;
                p.L.add(count);
                list.put(str,p);
            }
            System.out.println("___The list of string and their occurance___");
            for(String check:list.keySet()){
                Word w=new Word();
                w=list.get(check);
                w.viewData();
            }
        }
    }
    }
    //INPUT-OUTPUT
/*
___The list of string and their occurance___
String: the
no. of occurence: 1
line number : 1
String: file
no. of occurence: 1
line number : 1
String: assignment
no. of occurence: 1
line number : 1
String: of
no. of occurence: 1
line number : 1
String: by
no. of occurence: 1
line number : 2
String: This
no. of occurence: 1
line number : 1
String: is
no. of occurence: 1
line number : 1
String: Mandal
no. of occurence: 1
line number : 2
String: text
no. of occurence: 1
line number : 1
String: done
no. of occurence: 1
line number : 2
String: Satabda
no. of occurence: 1
line number : 2

Process finished with exit code 0
 */