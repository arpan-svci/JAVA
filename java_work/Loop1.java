import java.util.Scanner;
class Loop1{
	public static void main(String args[]){
		Scanner obj=new Scanner(System.in);
		int i,a,b,count=0;
		System.out.println("enter the no to which you want to want to print prime no.");
		a=obj.nextInt();
		for(b=2;b<=a;b++){
			for(i=2;i<=b/2;i++){
				   if(b%i==0){
					count++;
				   }
			}
			if(count==0){
				System.out.println("\t"+b);
			}
			count=0;
		}
	}
}