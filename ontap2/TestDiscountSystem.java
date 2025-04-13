public class TestDiscountSystem {
    public static void main(String[] args) {
       
        Customer customer1 = new Customer("Alice");
        customer1.setMemberType("Gold");  

       
        Visit visit1 = new Visit(customer1);
        visit1.setServiceExpense(100);    
        visit1.setProductExpense(50);     

        System.out.println("Customer: " + visit1.getCustomer().getName());
        System.out.println("Membership Type: " + visit1.getCustomer().getMemberType());
        System.out.println("Service Expense: $" + visit1.getServiceExpense());
        System.out.println("Product Expense: $" + visit1.getProductExpense());
        System.out.println("Total Expense (after discounts): $" + visit1.getTotalExpense());

   
        Customer customer2 = new Customer("Bob");
        Visit visit2 = new Visit(customer2);
        visit2.setServiceExpense(80); 
        visit2.setProductExpense(30);  

        System.out.println("\nCustomer: " + visit2.getCustomer().getName());
        System.out.println("Membership Type: " + visit2.getCustomer().getMemberType());
        System.out.println("Service Expense: $" + visit2.getServiceExpense());
        System.out.println("Product Expense: $" + visit2.getProductExpense());
        System.out.println("Total Expense (after discounts): $" + visit2.getTotalExpense());
    }
}
