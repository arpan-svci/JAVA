
import java.util.*;
import java.io.*;
class Word{
    String str;
    public int presence;
    ArrayList<Integer> x=new ArrayList<Integer>(); 
    void viewData(){
        System.out.print("\nString:"+str+"\nno. of occurence:"+presence + "\n");
        for(int i=0;i<x.size();i++){
            System.out.println("line number :- " +x.get(i));
        }
    }
    Word(){
        presence=0;
    }
}
class File{
    public static void main(String args[])throws IOException{
            HashMap<String,Word>list=new HashMap<String,Word>();
            FileWriter f=new FileWriter("program.txt",true);
            f.close();
            FileReader r=new FileReader("program.txt");
            int line_count=1;
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
                            p.x.add(line_count);
                            list.put(str,p);
                        }
                        else{
                            p.str=str;
                            p.presence++;
                            p.x.add(line_count);
                            list.put(str,p);
                        }
                        if(c1=='\n'||c1=='\r'){
                            line_count++;
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
                p.x.add(line_count);
                list.put(str,p);
            }
            else{
                p.str=str;
                p.presence++;
                p.x.add(line_count);
                list.put(str,p);
            }
            
            for(String check:list.keySet()){
                Word w=new Word();
                w=list.get(check);
                w.viewData();
            }
        }
    }
}
