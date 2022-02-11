import java.util.Scanner;
class Student{
    String admission_date;
    String name;
    String course;
    String roll;
    String student_id;
    int[] marks=new int[5];
    int total_score;
    void get_data(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter name of student: ");
        name=scan.nextLine();
        System.out.print("Enter admission date(in dd/mm/yy): ");
        admission_date=scan.nextLine();
        System.out.print("Enter name of course: ");
        course=scan.nextLine();
        System.out.print("Enter roll of student: ");
        roll=scan.nextLine();
        System.out.println("Enter marks of the 5 subject: ");
        for(int i=0;i<5;i++){
            marks[i]=scan.nextInt();
            total_score+=marks[i];
        }
    }
}
class StudentDepartment extends Student{
    String department;
    static int dept1_id=0;
    static int dept1_no_of_student=0;
    static int dept2_id=0;
    static int dept2_no_of_student=0;
    static int dept3_id=0;
    static int dept3_no_of_student=0;
    static int dept4_id=0;
    static int dept4_no_of_student=0;
    String get_id(int id){
        String id_int=new String();
        if(id<10){
            id_int="00".concat(Integer.toString(id));
        }
        else if(id<100 && id>=10){
            id_int="0".concat(Integer.toString(id));
        }
        else{
            id_int=Integer.toString(id);
        }
        return id_int;
    }
    void get_data(){
        Scanner scan=new Scanner(System.in);
        super.get_data();
        System.out.print("Enter name of department(CSE/ETCE/IT/ME): ");
        department=scan.nextLine();
        if(department.equalsIgnoreCase("CSE")){
            dept1_id++;
            dept1_no_of_student++;
            student_id=(department.concat(admission_date.substring(admission_date.length()-2,admission_date.length()))).concat(get_id(dept1_id));
        }else if(department.equalsIgnoreCase("ETCE")){
            dept2_id++;
            dept2_no_of_student++;
            student_id=(department.concat(admission_date.substring(admission_date.length()-2,admission_date.length()))).concat(get_id(dept2_id));
        }else if(department.equalsIgnoreCase("IT")){
            dept3_id++;
            dept3_no_of_student++;
            student_id=(department.concat(admission_date.substring(admission_date.length()-2,admission_date.length()))).concat(get_id(dept3_id));
        }else if(department.equalsIgnoreCase("ME")){
            dept4_id++;
            dept4_no_of_student++;
            student_id=(department.concat(admission_date.substring(admission_date.length()-2,admission_date.length()))).concat(get_id(dept4_id));
        }
    }
    void show_data(){
        System.out.println(":_____STUDENT DETAILS_____:");
        System.out.println("Name: "+name);
        System.out.println("Roll: "+roll);
        System.out.println("Admission date: "+admission_date);
        System.out.println("Course: "+course);
        System.out.println("Student id: "+student_id);
        System.out.println("Department: "+department);
        System.out.println("Marks in 5 subject: ");
        for(int i=0;i<5;i++)
            System.out.println("Mark in subj-"+(i+1)+": "+marks[i]);
        System.out.println("Total marks: "+total_score);
    }
    StudentDepartment(){}
    StudentDepartment(StudentDepartment S){
        admission_date=S.admission_date;
        name=S.name;
        course=S.course;
        roll=S.roll;
        student_id=S.student_id;
        for(int i=0;i<5;i++)
            marks[i]=S.marks[i];
        total_score=S.total_score;
        department=S.department;
    }
}
class StudentList{
    static int size=0;
    StudentDepartment[] student_record=new StudentDepartment[400];
    void add_student(){
        student_record[size]=new StudentDepartment();
        student_record[size].get_data();
        size++;
    }
    void view_list(){
        System.out.println("*_____LIST OF STUDENT_____*");
        for(int i=0;i<size;i++){
            student_record[i].show_data();
        }
    }
    void sorted_list_of_department(){
        StudentDepartment []temp=new StudentDepartment[100];
        Scanner scan=new Scanner(System.in);
        System.out.println("Enter name of department(CSE/ETCE/ME/IT):");
        String dep;
        dep=scan.nextLine();
        System.out.println(dep);
        int j=0;
        if(dep.equals("CSE")){
            System.out.println("Hello everyone");
            for(int i=0;i<size;i++){
                if(student_record[i].department.equals("CSE")){
                    temp[j]=new StudentDepartment(student_record[i]);
                    j++;
                }
            }
        }
        if(dep.equals("ETCE")){
            for(int i=0;i<size;i++){
                if(student_record[i].department.equals("ETCE")){
                    temp[j]=new StudentDepartment(student_record[i]);
                    j++;
                }
            }
        }
        if(dep.equals("ME")){
            for(int i=0;i<size;i++){
                if(student_record[i].department.equals("ME")){
                    temp[j]=new StudentDepartment(student_record[i]);
                    j++;
                }
            }
        }
        if(dep.equals("IT")){
            for(int i=0;i<size;i++){
                if(student_record[i].department.equals("IT")){
                    temp[j]=new StudentDepartment(student_record[i]);
                    j++;
                }
            }
        }
        for(int i=0;i<j-1;i++){
            for(int k=0;k<j-i-1;k++){
                if(temp[k].total_score>temp[k+1].total_score){
                    StudentDepartment t;
                    t=temp[k];
                    temp[k]=temp[k+1];
                    temp[k+1]=t;
                }
            }
        }
        for(int i=0;i<j;i++){
            temp[i].show_data();
        }
    }
    void delete_student(){
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the total score of student which to be deleted: ");
        int r=scan.nextInt();
        int i,k;
        for(i=0,k=0;i<size;i++){
            if(student_record[i].total_score==r)
                continue;
            student_record[k++]=student_record[i];
        }
        size=k;
        System.gc();
    }
}
public class Assignment1{
    public static void main(String args[]){
        StudentList list=new StudentList();
        Scanner scan=new Scanner(System.in);
        while(true) {
            System.out.print("Press 1 for add student\nPress 2 for view list\nPress 3 for view sorted list of department\nPress 4 for delete student\nPress 5 for exit\n");
            int t=scan.nextInt();
            switch (t) {
                case 1:
                    list.add_student();
                    break;
                case 2:
                    list.view_list();
                    break;
                case 3:
                    list.sorted_list_of_department();
                    break;
                case 4:
                    list.delete_student();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Entered value is invalid");
            }
        }
    }
}

//***INPUT-OUTPUT***//
/*
Press 1 for add student
Press 2 for view list
Press 3 for view sorted list of department
Press 4 for delete student
Press 5 for exit
1
Enter name of student: rohan
Enter admission date(in dd/mm/yy): 10/10/21
Enter name of course: BE
Enter roll of student: 70
Enter marks of the 5 subject:
100
94
90
93
95
Enter name of department(CSE/ETCE/IT/ME): CSE
Press 1 for add student
Press 2 for view list
Press 3 for view sorted list of department
Press 4 for delete student
Press 5 for exit
1
Enter name of student: sohan
Enter admission date(in dd/mm/yy): 10/10/21
Enter name of course: BE
Enter roll of student: 56
Enter marks of the 5 subject:
100
100
87
96
100
Enter name of department(CSE/ETCE/IT/ME): CSE
Press 1 for add student
Press 2 for view list
Press 3 for view sorted list of department
Press 4 for delete student
Press 5 for exit
1
Enter name of student: pallab
Enter admission date(in dd/mm/yy): 10/11/21
Enter name of course: BE
Enter roll of student: 87
Enter marks of the 5 subject:
68
96
86
74
66
Enter name of department(CSE/ETCE/IT/ME): CSE
Press 1 for add student
Press 2 for view list
Press 3 for view sorted list of department
Press 4 for delete student
Press 5 for exit
1
Enter name of student: kollol
Enter admission date(in dd/mm/yy): 11/10/21
Enter name of course: BE
Enter roll of student: 85
Enter marks of the 5 subject:
94
99
99
100
89
Enter name of department(CSE/ETCE/IT/ME): IT
Press 1 for add student
Press 2 for view list
Press 3 for view sorted list of department
Press 4 for delete student
Press 5 for exit
2
*_____LIST OF STUDENT_____*
:_____STUDENT DETAILS_____:
Name: rohan
Roll: 70
Admission date: 10/10/21
Course: BE
Student id: CSE21001
Department: CSE
Marks in 5 subject:
Mark in subj-1: 100
Mark in subj-2: 94
Mark in subj-3: 90
Mark in subj-4: 93
Mark in subj-5: 95
Total marks: 472
:_____STUDENT DETAILS_____:
Name: sohan
Roll: 56
Admission date: 10/10/21
Course: BE
Student id: CSE21002
Department: CSE
Marks in 5 subject:
Mark in subj-1: 100
Mark in subj-2: 100
Mark in subj-3: 87
Mark in subj-4: 96
Mark in subj-5: 100
Total marks: 483
:_____STUDENT DETAILS_____:
Name: pallab
Roll: 87
Admission date: 10/11/21
Course: BE
Student id: CSE21003
Department: CSE
Marks in 5 subject:
Mark in subj-1: 68
Mark in subj-2: 96
Mark in subj-3: 86
Mark in subj-4: 74
Mark in subj-5: 66
Total marks: 390
:_____STUDENT DETAILS_____:
Name: kollol
Roll: 85
Admission date: 11/10/21
Course: BE
Student id: IT21001
Department: IT
Marks in 5 subject:
Mark in subj-1: 94
Mark in subj-2: 99
Mark in subj-3: 99
Mark in subj-4: 100
Mark in subj-5: 89
Total marks: 481
Press 1 for add student
Press 2 for view list
Press 3 for view sorted list of department
Press 4 for delete student
Press 5 for exit
3
Enter name of department(CSE/ETCE/ME/IT):
CSE
CSE
Hello everyone
:_____STUDENT DETAILS_____:
Name: pallab
Roll: 87
Admission date: 10/11/21
Course: BE
Student id: CSE21003
Department: CSE
Marks in 5 subject:
Mark in subj-1: 68
Mark in subj-2: 96
Mark in subj-3: 86
Mark in subj-4: 74
Mark in subj-5: 66
Total marks: 390
:_____STUDENT DETAILS_____:
Name: rohan
Roll: 70
Admission date: 10/10/21
Course: BE
Student id: CSE21001
Department: CSE
Marks in 5 subject:
Mark in subj-1: 100
Mark in subj-2: 94
Mark in subj-3: 90
Mark in subj-4: 93
Mark in subj-5: 95
Total marks: 472
:_____STUDENT DETAILS_____:
Name: sohan
Roll: 56
Admission date: 10/10/21
Course: BE
Student id: CSE21002
Department: CSE
Marks in 5 subject:
Mark in subj-1: 100
Mark in subj-2: 100
Mark in subj-3: 87
Mark in subj-4: 96
Mark in subj-5: 100
Total marks: 483
Press 1 for add student
Press 2 for view list
Press 3 for view sorted list of department
Press 4 for delete student
Press 5 for exit
4
Enter the total score of student which to be deleted: 390
Press 1 for add student
Press 2 for view list
Press 3 for view sorted list of department
Press 4 for delete student
Press 5 for exit
2
*_____LIST OF STUDENT_____*
:_____STUDENT DETAILS_____:
Name: rohan
Roll: 70
Admission date: 10/10/21
Course: BE
Student id: CSE21001
Department: CSE
Marks in 5 subject:
Mark in subj-1: 100
Mark in subj-2: 94
Mark in subj-3: 90
Mark in subj-4: 93
Mark in subj-5: 95
Total marks: 472
:_____STUDENT DETAILS_____:
Name: sohan
Roll: 56
Admission date: 10/10/21
Course: BE
Student id: CSE21002
Department: CSE
Marks in 5 subject:
Mark in subj-1: 100
Mark in subj-2: 100
Mark in subj-3: 87
Mark in subj-4: 96
Mark in subj-5: 100
Total marks: 483
:_____STUDENT DETAILS_____:
Name: kollol
Roll: 85
Admission date: 11/10/21
Course: BE
Student id: IT21001
Department: IT
Marks in 5 subject:
Mark in subj-1: 94
Mark in subj-2: 99
Mark in subj-3: 99
Mark in subj-4: 100
Mark in subj-5: 89
Total marks: 481
Press 1 for add student
Press 2 for view list
Press 3 for view sorted list of department
Press 4 for delete student
Press 5 for exit
5

Process finished with exit code 0

*/
