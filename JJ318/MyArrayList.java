 import java.util.Scanner;
 
 public class Main
{
	public static void main(String[] args) {
	    Scanner scanner = new Scanner(System.in);
	    String [] menu = {"Add","Search","Search Part 2","Remove 1","Remove 2","Edit 1","Edit 2","Get","Go Back"};
	    int size = 0;
	    MyArrayList Items =new MyArrayList(size);
	    boolean reloop = false, reloop2 =false;
	    int choice1=0,choice2=0,location=0;
	    String item="",new_item="";
	  
	   
	   System.out.println("My ArrayList Menu:");
	   
	   while(!reloop){
	       
	       System.out.println("1. Create Array\n2. Exit");
	       System.out.print("Enter Choice: ");
	       String input = scanner.nextLine();
	       choice1=tryParseInt(input);
	       
	      if(choice1==1){
	          System.out.printf("Enter the size of the Array: ");
	          input = scanner.nextLine();
	          size=tryParseInt(input);
	          if(size!=-1){
    	          while(!reloop2){
    	              System.out.println("\n=============Main Menu============");
        	          displayOptions(menu);
        	          System.out.printf("Enter Choice: ");
        	          input = scanner.nextLine();
        	          choice2=tryParseInt(input);
        	          if(choice2!=-1){
        	          
            	          switch(choice2){
            	              case 0 :
            	                  System.out.println("Exiting main menu......");
            	                  reloop2=true;
            	                  break;
            	              case 1: 
            	                  System.out.print("Enter the number of items you want to add: ");
            	                  int no_of_items=scanner.nextInt();
            	                  for(int i =0; i<no_of_items;i++){
            	                      System.out.printf("Enter item # %d: ",i+1);
            	                      item=scanner.next();
            	                      Items.add(item);
            	                  }
            	                  System.out.println("ArrayList Contents");
            	                  Items.display();
            	                  System.out.println("Items Successfully Added!........");
            	                  break;
            	              case 2:
            	                  Items.display();
            	                  System.out.printf("Enter an item you want to search: ");
            	                  item=scanner.next();
            	                  if(Items.search(item)){
            	                      System.out.println("The item '"+item+"' is in the list ");
            	                  }else{
            	                      System.out.println("The item '"+item+"' is not in the list ");
            	                  }
            	                  break;
            	              case 3:
            	                  Items.display();
            	                  System.out.printf("Enter a an item you want to locate: ");
            	                  item=scanner.next();
            	                  location=Items.searchPart2(item)+1;
            	                  if(Items.searchPart2(item)!=-1){
            	                      System.out.println("The item '"+item+"' is located in the location "+location);
            	                  }else{
            	                      System.out.println("This item is not in the list");
            	                  }
            	                  break;
            	              case 4:
            	                  Items.display();
            	                  System.out.print("Enter the item to remove: ");
            	                  item=scanner.next();
            	                  if(Items.remove(item)){
            	                      System.out.println("Item Removed.....\nNew ArrayList Contents:");
            	                      Items.display();
            	                  }else{
            	                      System.out.println("This item is not in the list");
            	                  }
            	                  break;
            	               case 5:
            	                   Items.display();
            	                   System.out.print("Enter the location of item to remove :");
            	                   location=scanner.nextInt();
            	                   if(Items.remove(location-1)){
            	                       System.out.println("Item Removed.......\nNew ArrayList Contents");
            	                       Items.display();
            	                   }else if(location > size-1){
            	                       System.out.println("Invalid! This location exceeds the Arraylist size");
            	                   }else{
            	                       System.out.println("This location is empty");
            	                   }
            	                   break;
            	               case 6:
            	                   
            	                   System.out.printf("Enter an item :");
            	                   item=scanner.next();
            	                   Items.display();
            	                   System.out.printf("Location of the Item you want to edit: ");
            	                   location=scanner.nextInt();
            	                   if(Items.edit(item,location)){
            	                       System.out.println("Item successfully edited....\nNew ArrayList Contents: ");
            	                       Items.display();
            	                   }else if(location> size-1){
            	                       System.out.println("Invalid! This location exceeds the ArrayList size");
            	                   }else{
            	                       System.out.println("This location is empty");
            	                   }
            	                   break;
            	               case 7:
            	                   
            	                   System.out.print("Enter an item: ");
            	                   new_item=scanner.next();
            	                   Items.display();
            	                   System.out.print("Enter the item you want to edit: ");
            	                   item=scanner.next();
            	                   if(Items.edit(item,new_item)){
            	                       System.out.println("Item successfully edited....\nNew ArrayList Contents: ");
            	                       Items.display();
            	                   }else{
            	                       System.out.println("The item '"+item+"' is not in the list");
            	                   }
            	                   break;
            	               case 8: 
            	                   
            	                   System.out.println("Enter the location you want to get: ");
            	                   location=scanner.nextInt();
            	                   if(Items.get(location)!=null){
            	                       System.out.println("The item in the location "+location+" is :"+Items.get(location));
            	                   }else if(location > size||location<0){
            	                       System.out.println("The location exceeds the ArrayList size");
            	                   }else{
            	                       System.out.println("This location is empty");
            	                   }
            	                   break;
            	          }
        	          }
    	          }
	      }
	      }else if(choice1==2){
	          System.out.println("Exiting the program........");
	          reloop=true;
	      }else if(choice1>2){
	          System.out.println("Invalid! Please enter 1 or 2 only");
	      }
	   }
	   
	 
	}
	public static void displayOptions(String [] menu){
	    
	    for(int i = 0 ; i < menu.length-1; i++ ){
	        System.out.println(i+1+". "+menu[i]);
	    }
	    System.out.println("0. "+menu[menu.length-1]);
	}
	public static Integer tryParseInt(String value) {
        try {
            return Integer.parseInt(value); 
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Please enter a valid number.");
            return -1; 
        }
    }
	
}
 class MyArrayList{
     private Object [] items;
	 private int count;
	 public MyArrayList(){
	     items =new Object[10];
	     count = 0;
	     
	 }
	 
	 public MyArrayList(int size){
	     if(size>= 5 && size <=50){
	         items = new Object[size];
	     }else{
	         items = new Object[10];
	     }
	     count =0;
	 }
	 
	 
	 private boolean isFull(){
	     return count==items.length;
	 }
	 private boolean isEmpty(){
	     return count ==0;
	 }
	 private boolean isLocationValid(int location){
	     return location >= 0 && location <= count-1;
	 }
	 public boolean add(Object i){
	     if(!isFull()){
	         items[count]=i;
	         count = count +1;
	         return true;
	     }else{
	         return false;
	     }
	     
	 }
	 public boolean search(Object o){
	     if(!isEmpty()){
	         for(int i = 0; i < count; i++){
	             if(items[i].toString().equals(o.toString())){
	                 return true;
	             }
	         }
	     }
	     return false;
	 }
	 
	 public int searchPart2(Object o){
	     if(!isEmpty()){
	         for(int i = 0; i < count ;i++){
	             if(items[i].toString().equals(o.toString())){
	                 return i;
	             }
	         }
	     }
	     return-1;
	 }
	 public Object get(int location){
	     if(!isEmpty()&& isLocationValid(location)){
	         return items[location-1];
	     }else{
	        return null;
	     }
	 }
	 
	 public boolean remove(Object o){
	     if(!isEmpty()){
	         int loc = searchPart2(o);
	         if(loc != -1){
	             items[loc]=items[count-1];
	             items[count-1]=null;
	             count = count-1;
	             return true;
	             
	         }else{
	             return false;
	         }
	     }
	     return false;
	 }
	 public boolean remove(int location){
	     if(!isEmpty()&&isLocationValid(location)){
	         items[location]=items[count-1];
	         items[count-1]=null;
	         count = count -1;
	         return true;
	     }
	     return false;
	 }
	 public void display(){
	     
	     for(int i = 0; i < count; i ++){
	         System.out.printf("["+items[i]+"]");
	     }
	     System.out.println();
	    
	 }
	 public boolean edit(Object i, int location){
	    if(!isEmpty() && isLocationValid(location)){
	        items[location-1]=i;
	        return true;
	    }
	    return false;
	 }
	 public boolean edit(Object old, Object newo){
	    if(!isEmpty() ){
	        int location = searchPart2(old);
	        if(location != -1){
	            items[location]=newo;
	            return true;
	        }
	        
	    }
	    return false;
}
}