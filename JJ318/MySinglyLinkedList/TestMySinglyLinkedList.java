public class TestMySinglyLinkedList 
{
   public static void main(String[] args)
   {
      MySinglyLinkedList list = new MySinglyLinkedList();
      list.add(5);
      list.add(8);
      list.add(2);
      list.add(6);
      list.add(5);
      list.add(2);
      System.out.println("---------------------------\nAdded in the list\n"+list);
      
      System.out.println("---------------------------\nSearched in the list\n"+list.search(5));
      System.out.println("---------------------------\nSearched Location in the list\n"+list.searchPart2(5));
      
      list.delete(8);
      System.out.println("---------------------------\nDeleted in the list\n"+list);
      
      list.deleteByLocation(2);
      System.out.println("---------------------------\nDeleted by Location in the list\n"+list);
      
      list.edit(5,4);
      System.out.println("---------------------------\nEdited in the list\n"+list);
      
      list.editByLocation(8,1);
      System.out.println("---------------------------\nEdited by Location in the list\n"+list);
      
      System.out.println("---------------------------\nSearched in the list\n"+list.getByLocation(1));
      
      
      list.insert(9,0);
      System.out.println("---------------------------\nInserted in the list\n"+list);
      
      list.deleteAll();
      System.out.println("---------------------------\nDeleted ALL in the list\n"+list);

      
      
             
   }
   
   
}