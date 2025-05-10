/*Christian Dave Gesim Activity 3*/
import java.util.Scanner;

public class numberSolving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[20];
        int sum = 0;
        double difference = 0;
        double product = 1;
        double quotient = 1;

        System.out.println("Please enter 20 integer numbers:\n");

      
        for (int i = 0; i < numbers.length; i++) {
            System.out.printf("Enter integer no.%d: ", i + 1);
            numbers[i] = scanner.nextInt();
            System.out.println("--------------");
        }

        
        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

       
        for (int i = 0; i < numbers.length; i++) {
            difference -= numbers[i]; 
            product *= numbers[i];  
            if (numbers[i] != 0) {
                quotient /= numbers[i]; 
            }
        }

        
        System.out.printf("SUM: %d\n", sum);
        System.out.printf("DIFFERENCE: %.2f\n", difference);
        System.out.printf("PRODUCT: %.2f\n", product);
        if (quotient != 1) {
            System.out.printf("QUOTIENT: %.2f\n", quotient);
        } else {
            System.out.println("QUOTIENT: Undefined (division by zero detected)");
        }
    }
}
