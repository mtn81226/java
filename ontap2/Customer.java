public class Customer {
	    private String name;
	    private boolean member;
	    private String memberType; 

	   
	    public Customer(String name) {
	        this.name = name;
	        this.member = false; 
	        this.memberType = "None"; 
	    }


	    public String getName() {
	        return name;
	    }

	   
	    public boolean isMember() {
	        return member;
	    }

	    public void setMember(boolean member) {
	        this.member = member;
	    }

	  
	    public String getMemberType() {
	        return memberType;
	    }

	    public void setMemberType(String memberType) {
	        this.memberType = memberType;
	        this.member = !memberType.equalsIgnoreCase("None");
	    }
	}


