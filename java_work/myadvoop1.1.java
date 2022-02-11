import java.util.*;
class Date{
    int day;
    int month;
    int year;
  void getDate(){
      Scanner s=new Scanner(System.in);
      System.out.println("enter day:");
      day=s.nextInt();
      System.out.println("enter month:");
      month=s.nextInt();
      System.out.println("enter year:");
      year=s.nextInt();
  }
  void viewDate(){
      System.out.println(day+"/"+month+"/"+year);
  }
  Date(Date d){
      day=d.day;
      month=d.month;
      year=d.year;
  }
  Date(){
  }
}
class Score{
    int []p=new int[5];
    int i;
    int totalscore;
    void getData(){
        System.out.println("enter scores in 5 subjects:");
        Scanner sc=new Scanner(System.in);
        for(i=0;i<5;i++){
            int j=i+1;
            System.out.println("subject"+j+":");
            p[i]=sc.nextInt();
             totalscore=totalscore+p[i];
        }
    }
    void ViewData(){
        System.out.println("marks in 5 subjects :");
        for(i=0;i<5;i++){
            int j=i+1;
            System.out.println("subject"+j+":"+p[i]);
        }
        System.out.println("total score:"+totalscore);
    } 
    Score(Score s){
        int i,tot=0;
        for(i=0;i<5;i++){
            p[i]=s.p[i];
            tot=tot+p[i];
        }
        totalscore=tot;
    } 
    Score(){
    } 
}

class STUDENT{
String roll;
Score s=new Score();
int total_score;
String name;
Date d=new Date();
void getData(){
    Scanner s1=new Scanner(System.in);
    System.out.println("enter student details:");
    Scanner s2=new Scanner(System.in);
    System.out.println("enter name");
    name=s2.nextLine();
    System.out.println("enter admission date:");
    d.getDate();
    s.getData();
    total_score=s.totalscore;
}
void viewData(){
    System.out.println("student details:");
    System.out.println("roll:"+roll+"\n"+"name:"+name);
    System.out.println("admission date:");
    d.viewDate();
    s.ViewData();
}
}
class Student_dept extends STUDENT{
    String depertment;//consist of 4 letters
    int deptid;
    static int id1=1;
    static int id2=1;
    static int id3=1;
    static int id4=1;
    String id;
    Scanner sc=new Scanner(System.in);
    String getId(int id1){
        String id=new String();
        if(id1<10){
            id="00".concat(Integer.toString(id1));
        }
        else if(id1<100 && id1>=10){
            id="0".concat(Integer.toString(id1));
        }   
        else{
            id=Integer.toString(id1);
        }
        return id;
    }
        void getData(){
            int choice;
            super.getData();
            Scanner scr=new Scanner(System.in);
            System.out.println("enter depertment:(1 for BCSE,2 for ETCE,3 for MECH,4 for ITCE)");
            choice=scr.nextInt();
            switch(choice){                                                                      //depertment choice
                case 1:
                        depertment=new String("BCSE");
                        deptid=1;
                        break;
                case 2:
                        depertment=new String("ETCE");
                        deptid=2;
                        break;
                case 3:
                        depertment=new String("MECH");
                        deptid=3;
                        break;
                case 4:
                        depertment=new String("ITCE");
                        deptid=4;
                        break;
                default:
                        System.out.println("wrong input");
            }
            if(deptid==1){                                                                  //roll creation part
                roll=(depertment.concat(Integer.toString(d.year%100))).concat(getId(id1));
                id1++;
            }
            if(deptid==2){
                roll=(depertment.concat(Integer.toString(d.year%100))).concat(getId(id2));
                id2++;
            }
            if(deptid==3){
                roll=(depertment.concat(Integer.toString(d.year%100))).concat(getId(id3));
                id3++;
            }
            if(deptid==4){
                roll=(depertment.concat(Integer.toString(d.year%100))).concat(getId(id4));
                id4++;
            }
        }
        void viewData(){
            super.viewData();
            System.out.println("depertment:"+depertment);
        }
        public Student_dept(){
            super();
        }
        public Student_dept(Student_dept s1){
            roll=new String(s1.roll);
            d=new Date(s1.d);
            s=new Score(s1.s);
            name=new String(s1.name);
            total_score=s1.total_score;
            depertment=new String(s1.depertment);
            deptid=s1.deptid;
        }
}
class StudentList{
    int dept,number=0;
    Student_dept []t=new Student_dept[400];
    void addStudent(){
        t[number]=new Student_dept();
        t[number].getData();
        number++;
    }
    void viewStudentList(){
        int i;
        for(i=0;i<number;i++){
            int j=i+1;
            System.out.println("\nStudent "+j+":"+"\n");
            t[i].viewData();
        }
    }
    void deleteStudentList(){
        int range,i,k,a,b,c;
        Scanner num=new Scanner(System.in);
        System.out.println("enter the no. below which students are deleted");
        range=num.nextInt();
        for(i=0;i<number-1;i++){
            for(k=0;k<number-i-1;k++){
                if(t[k].total_score>t[k+1].total_score){
                    Student_dept temp;
                    temp=t[k];
                    t[k]=t[k+1];
                    t[k+1]=temp;
                }
            }
        }
        for(i=0;i<number;i++){
            if(t[i].total_score>=range){
                break;
            }
            else{
                t[i]=null;
                System.gc();
            }
        }
        Student_dept []temp=new Student_dept[100];
        a=i;
        for(i=a;i<number;i++){
            int g=i-a;
            temp[g]=new Student_dept(t[i]);
        }
        b=number-a;
        t=null;
        System.gc();
        t=new Student_dept[100];
        for(i=0;i<b;i++){
            t[i]=new Student_dept(temp[i]);
        }
        number=b;
    }
    void getInformation(){
        int j=0,k=0;
        Student_dept []t1=new Student_dept[100];
        Scanner sc=new Scanner(System.in);
        System.out.println("depertment list(Enter 1 for BCSE 2 for ETCE 3 for MECH 4 for ITCE):");
        dept=sc.nextInt();
        int i;
        if(dept==1){
            for(i=0;i<number;i++){
                if(t[i].deptid==1){
                    t1[j]=new Student_dept(t[i]);
                    j++;
                }
            }
        }
        if(dept==2){
            for(i=0;i<number;i++){
                if(t[i].deptid==2){
                    System.out.println("hello1");
                    t1[j]=new Student_dept(t[i]);
                    j++;
                }
            }
        }
        if(dept==3){
            for(i=0;i<number;i++){
                if(t[i].deptid==3){
                    t1[j]=new Student_dept(t[i]);
                    j++;
                }
            }
        }
        if(dept==4){
            for(i=0;i<number;i++){
                if(t[i].deptid==4){
                    t1[j]=new Student_dept(t[i]);
                    j++;
                }
            }
        }
        for(i=0;i<j-1;i++){
            for(k=0;k<j-i-1;k++){
                if(t1[k].total_score>t1[k+1].total_score){
                    Student_dept temp;
                    temp=t1[k];
                    t1[k]=t1[k+1];
                    t1[k+1]=temp;
                }
            }
        }
        for(i=0;i<j;i++){
            t1[i].viewData();
        }
    }
}
class main{
    public static void main(String[]args){
        int i;
        boolean j=true;
        Scanner sc=new Scanner(System.in);
        StudentList st=new StudentList();
        while(j){
            System.out.println("press:");
            System.out.println("\n1 to add Student in the list\n2 to view the whole student list\n3 to get the sorted list of a particular depertment wrt score\n4delete Students below a particular score\n");
            i=sc.nextInt();
            switch(i){                                                                      
                case 1:
                        st.addStudent();
                        break;
                case 2:
                        st.viewStudentList();
                        break;
                case 3:
                        st.getInformation();
                        break;
                case 4:
                        st.deleteStudentList();
                        break;
                default:
                        System.out.println("wrong input");
            }
             System.out.println("\n do you want to contineu(true/false):\n");
            j=sc.nextBoolean();
        }
    }
}