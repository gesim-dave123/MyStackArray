import javax.swing.*;

class Main {
    public static void main(String[] args) {
        boolean Continue = true;

        while (Continue) {
            String input = JOptionPane.showInputDialog(null, "QueueNode\nMenu:\n1. Create\n0. Exit\nInput", JOptionPane.QUESTION_MESSAGE);

            if (input == null) {
                JOptionPane.showMessageDialog(null, "You cancelled the operation. Exiting program.");
                break;
            }

            switch (input) {
                case "1":
                    Create();
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Closing the program");
                    Continue = false;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid Input");
            }
        }
    }

    public static void Create() {
        QueueNode queue = new QueueNode();
        boolean reloop = true;

        while (reloop) {
            String choice = JOptionPane.showInputDialog(null,
                    "Create:\n1. Enqueue\n2. Dequeue\n3. Display\n4. Destroy Queue\n0. Go back", JOptionPane.QUESTION_MESSAGE);

            if (choice == null) continue;

            switch (choice) {
                case "1":
                    String noOfItemsStr = JOptionPane.showInputDialog(null,
                            "Enter the number of items to enqueue", JOptionPane.QUESTION_MESSAGE);
                    
                    if (noOfItemsStr == null) break;

                    if (!isNumber(noOfItemsStr)) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                        break;
                    }
                    

                    int noOfItems = Integer.parseInt(noOfItemsStr);
                    for (int i = 0; i < noOfItems; i++) {
                        String item = JOptionPane.showInputDialog(null,
                                "Enter Item #" + (i + 1), JOptionPane.QUESTION_MESSAGE);
                        
                        if (item == null) break;
                        if(isNumber(item)){
                       if (queue.searchPart1(item)) {
                            JOptionPane.showMessageDialog(null, "This Item is already in the queue. Please enter a new one.");
                            i--;
                        } else {
                            queue.enqueue(item);
                        }
                        }else{
                        JOptionPane.showMessageDialog(null, "Please enter integer only");
                            i--;
                        }                    
                     }
                     break;

                case "2":
                    if (!queue.dequeue()) {
                        JOptionPane.showMessageDialog(null, "Queue is empty. Please enqueue first.");
                    } else {
                        JOptionPane.showMessageDialog(null, "Successfully dequeued the first item.");
                    }
                    break;

                case "3":
                    String output = queue.display();
                    if (output == null) {
                        JOptionPane.showMessageDialog(null, "Queue is empty.");
                    } else {
                        JOptionPane.showMessageDialog(null, output);
                    }
                    break;
                    
                case "4":
                    if(!queue.destroyQueue()){
                      JOptionPane.showMessageDialog(null, "This Queue is Empty.");
                    }
                    queue.destroyQueue();
                    JOptionPane.showMessageDialog(null, "Successfully destroyed the queue, it is now empty");

                    

                case "0":
                    JOptionPane.showMessageDialog(null, "Going back to main menu");
                    reloop = false;
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid Input");
            }
        }
    }

       public static boolean isNumber(String s) {
        if (s.isEmpty()) return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) return false;
        }
        return true;
    }
}

class QueueNode {
    private Node front;

    private class Node {
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
            this.next = null;
        }
    }

    public QueueNode() {
        front = null;
    }

    public boolean isEmpty() {
        return front == null;
    }
     public boolean searchPart1(Object item) {
        if (isEmpty()) return false;
        Node temp = front;
        while (temp != null) {
            if (temp.data.equals(item)) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    public void enqueue(Object item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
        } else {
            Node temp = front;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    public boolean dequeue() {
        if (isEmpty()) return false;
        front = front.next;
        return true;
    }
    public boolean destroyQueue(){
    if(!isEmpty()){
        front=null;
        return true;  
    }
    return false;
       
    }

    public String display() {
        if (isEmpty()) return null;

        String result = "[";
        Node temp = front;
        while (temp != null) {
            result = result + temp.data;
            if (temp.next != null) {
                result = result + ", ";
            }
            temp = temp.next;
        }
        result = result + "]";
        return result;
    }
}