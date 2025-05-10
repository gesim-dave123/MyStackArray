public class StackNode 
{
   MyNode top;
   
   public StackNode()
   {
      top = null;
   }
   
   public boolean isEmpty()
   {
      return top == null;
   }
   public int getCount()
   {
   if(!isEmpty())
   {
      int count =0;
      MyNode temptop =top;
      while(temptop.next!=null){
         count++; 
         temptop=temptop.next;          
      }
      return count;
      }
       return -1;
   }
   
   public boolean isFull()
   {
      return false;
   }        
   public boolean push(Object o)
   {
      MyNode newNode= new MyNode();
      newNode.item=o;
      if(isEmpty())
      {
         top=newNode;
      }else{
            MyNode tempTop=top;
            while(tempTop.next!=null){
               tempTop =tempTop.next;
            }
            tempTop.next = newNode;      
            }
            return true;    
   }
   
    public Object peek()
    {
      if(!isEmpty()){
      
         if(top.next==null){
         return top.item;
         
         }else{
          MyNode tempTop =top;
          while(tempTop.next!=null){
          tempTop =tempTop.next;
          }
          return tempTop.item;     
         }
            
      }
      return null;   
    } 
  public boolean pop()
    {
     if(!isEmpty())
     {
       if(top.next==null){
         top=null;       
       }else
       {
         MyNode tempTop = top;
         MyNode tempPrevious =null;
         while(tempTop.next!=null)
         {
            tempPrevious=tempTop;
            tempTop=tempTop.next; 
         }
         tempPrevious.next=null;
       }
       return true;   
     }
     return false;  
    } 
   
   public String Display() {
    String result = "";
    
    if (!isEmpty()) { 
        if (top.next == null) {  
            result += "[" + top.item + "]\n";
            return result;
        } else {
            MyNode tempTop = top;
            while (tempTop.next != null) {
                tempTop = tempTop.next;
            }

            MyNode tempPrevious = tempTop;
            result += "[" + tempTop.item + "]\n";        
            tempTop = top;
            while (tempPrevious != top) {
                tempTop = top;
                while (tempTop.next != tempPrevious) { 
                    tempTop = tempTop.next;            
                }
                result += "[" + tempTop.item + "]\n";
                tempPrevious = tempTop;
            }
            return result;
        }
    }
    return "";
}

}