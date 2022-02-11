//package java_assignment;
import java.util.*;

class Patient{
    static int patient_id=1;
    int id;
    String name;
    float blood_pressure=0;
    float temperature=0;
    String doctor_name;
    int social_security_no;
    int status;
    public boolean equals(Patient p){
        if(id==p.id)
            return true;
        else
            return false;
    }
    void getdata(){
        Scanner s=new Scanner(System.in);
        System.out.print("enter name of patient: ");
        name=s.nextLine();
    }
    void admit(){
        Scanner sc=new Scanner(System.in);
        System.out.println("enter blood pressure: ");
        blood_pressure=sc.nextFloat();
        System.out.println("enter temperature in fahrenheit: ");
        temperature=sc.nextFloat();
    }
    void viewdata(){
        System.out.println("\nname: "+name+"\nid: "+id+"\n");
        if(status==1){
            System.out.println("name of doctor: "+doctor_name+"\ntemperature: "+temperature+"\nblood pressure: "+blood_pressure);
        }
    }
    Patient(){
        social_security_no=0;
        id=patient_id++;
        status=0;
        blood_pressure=0;
        temperature=0;
    }
}

class Doctor{
    String name=new String();
    static int doctor_id=1;
    int id;
    ArrayList<Patient> patient=new ArrayList<Patient>();
    void getDoctor(){
        Scanner sc=new Scanner(System.in);
        System.out.print("name of doctor: ");
        name=sc.nextLine();
        id=doctor_id++;
    }
    void add_Patient(Patient p){
        patient.add(p);
    }
    void viewdoctor(){
        System.out.println("\nname: "+name+"\ndoctor id: "+id);
        System.out.println("\nlist of patient: ");
        for(int i=0;i<patient.size();i++){
            System.out.println("patient "+i+1+": ");
            patient.get(i).viewdata();
            System.out.println("\n");
        }
    }
}

class Hospital{
    Scanner k=new Scanner(System.in);
    HashMap<String,Doctor> doc=new HashMap<String,Doctor>();
    HashMap<Integer,Patient> p=new HashMap<Integer,Patient>();
    void addPatient(){
        Patient pt=new Patient();
        pt.getdata();
        p.put(pt.id, pt);
    }
    void addDoctor(){
        Doctor d=new Doctor();
        d.getDoctor();
        doc.put(d.name, d);
    }
    void assignDoctor(){
        String name=new String();
        Doctor d=new Doctor();
        Scanner s=new Scanner(System.in);
        Scanner o=new Scanner(System.in);
        Patient temp=new Patient();
        int t;
        System.out.print("\nEnter id. of patient you want to admit: ");
        t=s.nextInt();
        if (p.containsKey(t)==false){
            System.out.print("\npatient is not present\n");
            return;
        }
        temp=p.get(t);
        if(temp.status==1){
            System.out.print("\npatient already admitted\n");
            return;
        }
        System.out.print("\nenter the name of doctor: ");
        name=o.nextLine();
        if(doc.containsKey(name)==false){
            System.out.print("\ndoctor is not present\n");
            return;
        }
        temp.doctor_name=new String(name);
        temp.admit();
        temp.status=1;
        d=doc.get(name);
        d.add_Patient(temp);
    }
    void admit(){
        int temp;
        Patient temp1=new Patient();
        Scanner sc=new Scanner(System.in);
        System.out.print("\nenter the id of patient to be check: ");
        temp=sc.nextInt();
        if(p.containsKey(temp)==false){
            System.out.println("\nno Such patient admit in hospital\n");
            return;
        }
        temp1=p.get(temp);
        temp1.social_security_no=0;
        if(temp1.status==0){
            System.out.println("\nno doctor assigned till now\n");
        }
        else{
            temp1.admit();
        }
    }
    void leave(){
        int i;
        Patient p1=new Patient();
        System.out.print("\nenter the id of patient want to relive: ");
        i=k.nextInt();
        if(p.containsKey(i)==false){
            System.out.print("\npatient is not present in hospital list\n");
            return;
        }
        p1=p.get(i);
        if(p1.status==0){
            System.out.println("till the patient is not assigned to a doctor");
            return;
        }
        if(p1.social_security_no==0){
            System.out.print("\nEnter Social Security no.(except 0) before leave: ");
            p1.social_security_no=k.nextInt();
            p1.status=0;
        }
        else{
            System.out.print("\npatient alreadey left the hospital\n");
        }
    }
    void viewlistpatient(){
        int h=1;
        for(Integer i:p.keySet()){
            Patient p1=new Patient();
            p1=p.get(i);
            System.out.print("\npatient "+h+":");
            p1.viewdata();
            h++;
        }
    }
    void viewlistDoctor(){
        int i=1;
        for(String str:doc.keySet()){
            Doctor d=new Doctor();
            d=doc.get(str);
            System.out.print("\ndoctor "+i+": ");
            d.viewdoctor();
            i++;
        }
    }
}

public class Assignment6 {
    public static void main(String[] args) {
        Hospital h=new Hospital();
        int choice;
        Scanner sc=new Scanner(System.in);
        while(true){
            System.out.println("Press \n1. to add a patient\n2. to recruit a doctor\n3. to assign a doctor to a particular patient\n4. to admit or check a particular patient\n5. to leave a particular patient \n6. to view doctor list\n7. to view patient list\n8. to exit\n");
            System.out.print("enter your choice:");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    h.addPatient();
                    break;
                case 2:
                    h.addDoctor();
                    break;
                case 3:
                    h.assignDoctor();
                    break;
                case 4:
                    h.admit();
                    break;
                case 5:
                    h.leave();
                    break;
                case 6:
                    h.viewlistDoctor();
                    break;
                case 7:
                    h.viewlistpatient();
                    break;
                case 8:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }
}
//INPUT-OUTPUT
/*
Press
1. to add a patient
2. to recruit a doctor
3. to assign a doctor to a particular patient
4. to admit or check a particular patient
5. to leave a particular patient
6. to view doctor list
7. to view patient list
8. to exit

enter your choice:1
enter name of patient: kamal
Press
1. to add a patient
2. to recruit a doctor
3. to assign a doctor to a particular patient
4. to admit or check a particular patient
5. to leave a particular patient
6. to view doctor list
7. to view patient list
8. to exit

enter your choice:2
name of doctor: sohan
Press
1. to add a patient
2. to recruit a doctor
3. to assign a doctor to a particular patient
4. to admit or check a particular patient
5. to leave a particular patient
6. to view doctor list
7. to view patient list
8. to exit

enter your choice:3

Enter id. of patient you want to admit: 1

enter the name of doctor: sohan
enter blood pressure:
75
enter temperature in fahrenheit:
98
Press
1. to add a patient
2. to recruit a doctor
3. to assign a doctor to a particular patient
4. to admit or check a particular patient
5. to leave a particular patient
6. to view doctor list
7. to view patient list
8. to exit

enter your choice:7

patient 1:
name: kamal
id: 1

name of doctor: sohan
temperature: 98.0
blood pressure: 75.0
Press
1. to add a patient
2. to recruit a doctor
3. to assign a doctor to a particular patient
4. to admit or check a particular patient
5. to leave a particular patient
6. to view doctor list
7. to view patient list
8. to exit

enter your choice:6

doctor 1:
name: sohan
doctor id: 1

list of patient:
patient 01:

name: kamal
id: 1

name of doctor: sohan
temperature: 98.0
blood pressure: 75.0


Press
1. to add a patient
2. to recruit a doctor
3. to assign a doctor to a particular patient
4. to admit or check a particular patient
5. to leave a particular patient
6. to view doctor list
7. to view patient list
8. to exit

enter your choice:5

enter the id of patient want to relive: 1

Enter Social Security no.(except 0) before leave: 78
Press
1. to add a patient
2. to recruit a doctor
3. to assign a doctor to a particular patient
4. to admit or check a particular patient
5. to leave a particular patient
6. to view doctor list
7. to view patient list
8. to exit

enter your choice:8

Process finished with exit code 0

 */