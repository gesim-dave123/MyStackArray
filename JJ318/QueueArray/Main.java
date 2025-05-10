
import javax.swing.*;
class Main
{
   public static void main(String [] args)
   {
  
    QueueArray qa=new QueueArray(5);
    boolean Continue = true;
    while(Continue==true){
   String Input= JOptionPane.showInputDialog(null,"QueueArray\nMenu:\n"+"1. Create\n"+"0. Exit\n"+"Input",JOptionPane.QUESTION_MESSAGE);
   if (Input == null)
    {
    JOptionPane.showMessageDialog(null, "You cancelled the operation. Exiting program.");
    break; 
    }
   switch(Input){
   case "1":Create();break;
   case "0":JOptionPane.showMessageDialog(null,"Closing the program"); Continue = false;break;
   default :  JOptionPane.showMessageDialog(null,"Invalid Input");

      } 
    }
   }
   
   public static void Create()
   {
    String Size= JOptionPane.showInputDialog(null,"Enter Array Size\n",JOptionPane.QUESTION_MESSAGE);
        int size = Integer.parseInt(Size);
    QueueArray arr =new QueueArray(size);
    boolean reloop =true;

 while(reloop==true){
   String choice= JOptionPane.showInputDialog(null,"Create:\n"+"1. Enqueue\n"+"2. Dequeue\n"+"3.Display\n"+"0. Go back",JOptionPane.QUESTION_MESSAGE); 
   switch(choice){
   case "1":
             String NoOfItems= JOptionPane.showInputDialog(null,"Enter the number of items to enqueue\n",JOptionPane.QUESTION_MESSAGE);
            int NoItems = Integer.parseInt(NoOfItems);
            for(int i = 0 ; i <NoItems; i++){
                String item = JOptionPane.showInputDialog(null, String.format("Enter Item #%d", i + 1), JOptionPane.QUESTION_MESSAGE);
                arr.enqueue(item);                    
            }
            break;
                 
   case "2":if(!arr.dequeue()){
               JOptionPane.showMessageDialog(null,"This Array is empty, Please enqueue first");
   
                }else{
                JOptionPane.showMessageDialog(null,"Successfully dequeued the first item");
                arr.dequeue();
                } 
            
            break;

   case "3":if(arr.display()==null){
               JOptionPane.showMessageDialog(null,"This Array is empty, Please enqueue first");
   
                  }else{
                   JOptionPane.showMessageDialog(null,arr.display()); 
                  }      
           break;
   case "0": JOptionPane.showMessageDialog(null,"Going back to main menu");

            reloop = false;break;
   
   default :JOptionPane.showMessageDialog(null,"Invalid Input");
       }
     }  
   }
}
class QueueArray
{
   private Object [] items;
   private int count;
   
   public QueueArray(int size)
   {
      items = new Object[size];
      count = 0;
   }
   public boolean isEmpty(){
    return count ==0;
   }
   public boolean isFull(){
    return count == items.length;
   }
   public boolean enqueue(Object i){
      if(!isFull())
      {
       items[count]= i;
       count = count +1;
       return true;  
      }
       return false; 
   }
   public boolean dequeue(){
      if(!isEmpty()){
         if(count == 1)
         {
           items[0]=null;
           
         }else{
            for(int i = 0; i < count -1; i++){
             items[i]=items[i+1];            
            }
            items[count-1]=null;         
         }
         count = count -1;
         return true;
      }
      return false;
   }
   
   public String display(){
   
   if(!isEmpty()){
    String result ="[";
    for(int i = 0 ; i < count ; i++){
      result = result +items[i];
      if(i < count - 1){
       result = result +",";
      }
    
    }
    result = result +"]";
    return result;
   
   }
   return null;
  }
      
   

}