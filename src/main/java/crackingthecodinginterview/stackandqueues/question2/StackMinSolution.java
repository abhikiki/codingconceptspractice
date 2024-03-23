package crackingthecodinginterview.stackandqueues.question2;


/**
     Stack Min: How would you design a stack which, in addition to push and pop, has a function min which returns the
     minimum element? Push, pop and min should all operate in 0(1) time.
     */
    class Node{
        int data;
        int min;
        Node next;

        Node(int data){
            this.data = data;
            this.min = Integer.MAX_VALUE;
        }
    }

public class StackMinSolution {
        private Node head;

        // Time Complexity: O(1)
        public void push(int data) {
            Node n = new Node(data);
            if(head == null){
                n.min = Math.min(data, n.min);
            }else{
                n.min = Math.min(head.min, data);
                n.next = head;
            }
            head = n;
        }

        // Time Complexity: O(1)
        public int pop(){
            if(head == null){
                throw new IllegalStateException("Stack is empty");
            }
            int deletedData = head.data;
            head = head.next;

            return deletedData;
        }

        // Time Complexity: O(1)
        public int min(){
            if(head == null){
                throw new IllegalStateException("Stack is empty");
            }
            return head.min;
        }

        public static void main(String[] args) {
            StackMinSolution sol = new StackMinSolution();
            sol.push(50);
            sol.push(80);
            sol.push(10);
            sol.push(100);
            System.out.println("Minimum=" + sol.min());

            System.out.println("Popped Data=" + sol.pop());
            System.out.println("Popped Data=" + sol.pop());
            System.out.println("Minimum=" + sol.min());

            sol.push(9);
            System.out.println("Minimum=" + sol.min());
        }
    }

