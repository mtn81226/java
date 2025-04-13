public class Visit {
    private Customer customer;
    private double serviceExpense;
    private double productExpense;   
    public Visit(Customer customer) {
        this.customer = customer;
        this.serviceExpense = 0.0;
        this.productExpense = 0.0;
    }

   
    public void setServiceExpense(double serviceExpense) {
        this.serviceExpense = serviceExpense;
    }

    
    public void setProductExpense(double productExpense) {
        this.productExpense = productExpense;
    }

    
    public double getTotalExpense() {
        double serviceDiscount = DiscountRate.getServiceDiscountRate(customer.getMemberType());
        double productDiscount = DiscountRate.getProductDiscountRate();

        double totalServiceCost = serviceExpense * (1 - serviceDiscount);
        double totalProductCost = productExpense * (1 - productDiscount);

        return totalServiceCost + totalProductCost;
    }

    
    public Customer getCustomer() {
        return customer;
    }

   
    public double getServiceExpense() {
        return serviceExpense;
    }

    public double getProductExpense() {
        return productExpense;
    }
}
