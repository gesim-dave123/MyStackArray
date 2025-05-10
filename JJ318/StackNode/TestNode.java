import java.util.Scanner;
class TestNode
{
   public static void main(String [] args)
   {
      Scanner in = new Scanner(System.in);   
      System.out.println("------------CHRISTIAN DAVE GESIM------------");
      System.out.println("               MY StackNode ");
      boolean proceed=true;
     while(proceed){   
         System.out.println("|----------------- Menu -----------------|");
         System.out.println("1. Create\n0. Exit");
         System.out.print("--> Choose a menu: ");
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
    StackNode stackNode = new StackNode();
    while (Continue) {
        System.out.println("|---------------- Menu ----------------|");
        displayMenu(createMenu);
        System.out.print("--> Enter Menu: ");
        
        String choice = in.next();

        switch (choice) {
            case "1":
                System.out.println("|---------------- PUSH ----------------|\n");
           
                System.out.print("--> Enter the number of Items to push: ");
                
                if (!in.hasNextInt()) {
                    System.out.println("Invalid input. Please enter a number.");
                    in.next(); 
                    break;
                }
                
                noOfItem = in.nextInt();
                in.nextLine();
               

                for (int i = 0; i < noOfItem; i++) {
                    System.out.printf("--> Enter item #%d: ", i + 1);
                    Object newItem = in.next();
                    stackNode.push(newItem);
                }
                
                System.out.println("Items Pushed successfully");
                break;

            case "2":
               System.out.println("|---------------- PEEK ----------------|\n");
                if(stackNode.peek()!=null){
                System.out.println("The last item in the stack is " + stackNode.peek());
                }else
                  System.out.println("This Stack is empty, please push item first");
                break;

            case "3":
             System.out.println("|---------------- POP ----------------|\n");
            if(stackNode.getCount()!=-1){
                int count = stackNode.getCount();
                String poppedItems ="";
                   do{
                      System.out.print("--> Enter the number of Items to Pop: ");                
                      if (!in.hasNextInt()) {
                          System.out.println("Invalid input. Please enter a number.");
                          in.next(); 
                          break;
                      }
                      
                         noOfItem = in.nextInt();
                         in.nextLine();
                      if(noOfItem>count){
                       System.out.println("Invalid, the number of items to Pop should not exceed the number of items");
                      }
                   }while(noOfItem>count);
                   
                   for (int i = 0; i < noOfItem; i++) {
                       poppedItems+="["+stackNode.peek().toString()+"]";
                       stackNode.pop();
                   }
                   if(noOfItem ==1){
                   System.out.println("The item "+poppedItems +" was successfully popped");
                   }else if(noOfItem>1){
                   System.out.println("The items "+poppedItems +" were successfully popped");
                   }             
                            
                }else
                   System.out.println("This Stack have no items to pop, please push items first");
                    break;
            case "4":
             System.out.println("|---------------- DISPLAY ----------------|\n");
            if(!stackNode.isEmpty()){
                System.out.println("|---------- Stacked Items Contents ----------|");
                System.out.println(stackNode.Display());
                }else
                System.out.println("This Stack is empty, there is nothing to display");
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