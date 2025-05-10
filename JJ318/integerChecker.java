/*Christian Dave Gesim*/
/*Activity 1*/
import java.util.Scanner;

public class integerChecker
{
	public static void main(String[] args) {
	    Scanner scanner= new Scanner(System.in);
	    
		int [] numbers = new int[20];
		int even=0,odd=0,zeroes=0,negative=0,positive=0;
		
		System.out.println("Please enter 20 integer numbers:\n");
		for(int i = 0; i < numbers.length; i++){
		    System.out.printf("Enter integer No. %d: ",i+1);
		    numbers[i]=scanner.nextInt();
		    System.out.println("-------------");
		}
		
		for(int i = 0; i < numbers.length; i++){
		    if(numbers[i]%2==0){
		        even+=1;
		    }else{
		        odd+=1;
		    }
		     if(numbers[i]==0){
		        zeroes+=1;
		    }
		     if(numbers[i]>0){
		        positive+=1;
		    }
		     if(numbers[i]<0){
		        negative+=1;
		    }
		    
		}
		System.out.println("|===================== Result ============================|");
		System.out.printf("Number of Even numbers entered is : %d\n",even);
		System.out.printf("Number of odd numbers entered is : %d\n",odd);
		System.out.printf("Number of zeroes numbers entered is : %d\n",zeroes);
		System.out.printf("Number of negative numbers entered is : %d\n",negative);
		System.out.printf("Number of positive numbers entered is : %d\n",positive);
		
	}
}