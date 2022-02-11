import java.util.Scanner;
class Complex{
	int imaginary,real;
	Scanner obj=new Scanner(System.in);
		void setdata(){
			System.out.println("\n enter real part of the complex no.");
			real=obj.nextInt();
			System.out.println("\n enter imaginary part of the complex no.");
			imaginary=obj.nextInt();
		}
		void viewdata(){
			System.out.println("real part="+real);
			System.out.println("\n imaginary part="+imaginary);
		}
		Complex(){
			imaginary=0;
			real=0;
		}
}
class Operations{
	public static void main(String args[]){
		Complex c1=new Complex(),c2=new Complex();
		c1.setdata();
		c1.viewdata();
		c2.viewdata();
	}
}