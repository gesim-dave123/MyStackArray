import javax.swing.*;

class Main {
    public static void main(String[] args) {
        boolean Continue = true;

        while (Continue) {
            String input = JOptionPane.showInputDialog(null, "QueueNode\nMenu:\n1. Create\n0. Exit\nInput");

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
                    "Create:\n1. Enqueue\n2. Dequeue\n3. Display\n0. Go back");

            if (choice == null) continue;

            switch (choice) {
                case "1":
                    String noOfItemsStr = JOptionPane.showInputDialog(null,
                            "Enter the number of items to enqueue");
                    if (noOfItemsStr == null) break;

                    if (!isNumber(noOfItemsStr)) {
                        JOptionPane.showMessageDialog(null, "Please enter a valid number.");
                        break;
                    }

                    int noOfItems = Integer.parseInt(noOfItemsStr);

                    for (int i = 0; i < noOfItems; i++) {
                        String item = JOptionPane.showInputDialog(null,
                                "Enter Item #" + (i + 1));
                        if (item == null) break;
                        queue.enqueue(item);
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
    private Node tail;

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
        tail =null;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void enqueue(Object item) {
        Node newNode = new Node(item);
        if (isEmpty()) {
            front = newNode;
            tail = front;
        } else {
             tail = front;
            
            while (tail.next != null) {
                tail = tail.next;
            }
            tail.next= newNode;
            tail = tail.next;
            tail =front;
        }
    }

    public boolean dequeue() {
        if (!isEmpty()) {
        
            if(front != null && front.next==null){
             front = null;
            
            }else{
              front = front.next;
               tail=front;
            }
            return true;
        }
        return false;
    }

    public String display() {
        if (isEmpty()) return null;

        String result = "";
         tail = front;
        while (tail.next != null) {
            result = result + "["+tail.data;
            if (tail.next != null) {
                result = result + "]=> ";
            }
            tail = tail.next;
        }
        result = result+"["+tail.data;
        
        result = result + "] =>" + "["+front.data.toString()+"]=>";
        return result;
    }
}