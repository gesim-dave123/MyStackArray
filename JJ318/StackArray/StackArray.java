import java.util.Scanner;

public class StackArray
{
   private Object [] items;
   private int count;
   
   public StackArray(int size)
   { 
      if(size > 50 || size < 5 ){
         size = 10;
         items = new Object [size];
         count =0;
         }else{
          items= new Object[size];
         }
   }
   public boolean isFull()
   {
        return count == items.length;
   }
   public boolean isEmpty()
   {
        return count ==0;
   }
   public boolean push(Object value)
   {
      if(!isFull())
      {
         items[count]=value;
         count=count +1;
         return true;   
      }
      return false;
   }
   public Object peek()
   {
      if(!isEmpty())
      {
         return items[count -1];
      }
      return null;
   }
   public boolean pop()
   {
      if(!isEmpty())
      {
         items[count-1]=null;
         count = count -1;
         return true;
      }
      return false;
   }
   public String toString()
   {
      String result ="";
      for(int i = count -1; i >= 0; i=i-1)
      {
         result =result+ "["+items[i]+"]\n";
      }
      return result;
   }

}
class Main
{
   public static void main(String [] args)
   {
      Scanner in = new Scanner(System.in);   
      System.out.println("------------CHRISTIAN DAVE GESIM------------");
      System.out.println("----------------MY StackArray----------------");
      boolean proceed=true;
     while(proceed){   
         System.out.println("Menu:");
         System.out.println("1. Create\n0. Exit");
         System.out.print("Choose a menu: ");
       if (in.hasNextInt())
        { 
                int mainChoice = in.nextInt();
                in.nextLine(); 
                switch (mainChoice)
                {
                    case 1: Create(in); break;
                    case 0:proceed = false;System.out.println("Exiting program...");break;
                    default:System.out.println("Invalid choice. Please enter 1 or 0.");
                }
         } else {
             System.out.println("Invalid input. Please enter a number.");
             in.next(); 
            }
        }
        in.close(); 
      }
   
   
  public static void Create(Scanner in) {
    String[] createMenu = { "Push", "Peek", "Pop", "Display", "Go Back" };
    int noOfItem=0;
    boolean Continue = true;
    
    System.out.print("Enter the Size of the Array: ");
    
    if (!in.hasNextInt()) {  
        System.out.println("Invalid input. Please enter a number.");
        in.next();  
        return;
    }    
    int size = in.nextInt();
    in.nextLine(); 
    if(size<5){
      System.out.println("The size is too small, changing the size into default 10");
    }else if(size>50){
      System.out.println("The size is too big, changing the size into default 10");
    }else
      System.out.println("Array successfully created");  
    StackArray stack = new StackArray(size);

    while (Continue) {
        System.out.println("Menu:");
        displayMenu(createMenu);
        System.out.print("Enter Menu: ");
        
        String choice = in.next();

        switch (choice) {
            case "1":
            do{
                System.out.print("Enter the number of Items to push: ");
                
                if (!in.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    in.next(); 
                    break;
                }
                
                noOfItem = in.nextInt();
                in.nextLine();
                if(noOfItem>size){
                  System.out.println("Invalid, the number os item to push should not exceed the size");
                }
                }while(noOfItem<0||noOfItem>size); 

                for (int i = 0; i < noOfItem; i++) {
                    System.out.printf("Enter item #%d: ", i + 1);
                    Object newItem = in.next();
                    stack.push(newItem);
                }
                
                System.out.println("-----Items Pushed successfully-----");
                break;

            case "2":
                if(stack.peek()!=null){
                System.out.println("The last item in the top is " + stack.peek());
                }else
                  System.out.println("This Array is empty, please push item first");
                break;

            case "3":
            if(stack.pop()!=false){
                  do{
                      System.out.print("Enter the number of Items to Pop: ");                
                      if (!in.hasNextInt()) {
                          System.out.println("Invalid input. Please enter a number.");
                          in.next(); 
                          break;
                      }
                      
                         noOfItem = in.nextInt();
                         in.nextLine();
                      if(noOfItem>size){
                       System.out.println("Invalid, the number of items to Pop should not exceed the size");
                      }
                   }while(noOfItem>size);
                   
                   for (int i = 0; i < noOfItem; i++) {
                       stack.pop();
                   }               
                }else
                   System.out.println("This Array have no items to pop, please push items first");
                    break;
            case "4":
            if(!stack.isEmpty()){
                System.out.println("StackArray Contents:");
                System.out.println(stack.toString());
                }else
                System.out.println("This Array is empty, there is nothing to display");
                break;

            case "5":
                Continue = false;
                System.out.println("Going back to Main Menu");
                break;

            default:
                System.out.println("Please enter a number between 1 to 5 only.");
        }
    }
}
       
      public static void displayMenu(String [] menu)
         {
         
           for(int i = 0 ; i < menu.length; i =i+1)
           
               System.out.println(i+1+". "+menu[i]);    
          
         }
      
   
 }
 