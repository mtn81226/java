public class Animal {
    protected String name;  
    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void sound() {
        System.out.println("Animal makes a sound");
    }

    @Override
    public String toString() {
        return "Animal[name=" + name + "]";
    }
}
