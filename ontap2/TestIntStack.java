public class TestIntStack {
    public static void main(String[] args) {
        MyIntStack stack = new MyIntStack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        System.out.println("Pushed 5 elements onto the stack.");

        
        stack.push(60); 
        stack.push(70);

        System.out.println("Top element is: " + stack.peek());

    
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

      
        try {
            stack.pop();
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
