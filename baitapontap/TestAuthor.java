public class TestAuthor {
    public static void main(String[] args) {
       
        Author au = new Author("Ngân", "Ngan@gmail.com", 'f');
        System.out.println(au);  

        
        au.setEmail("Ngan@gmai.com");  
        System.out.println("name is: " + au.getName());     
        System.out.println("email is: " + au.getEmail());   
        System.out.println("gender is: " + au.getGender()); 
    }
}
