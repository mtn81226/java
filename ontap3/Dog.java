public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Woof! Woof!");
    }

    @Override
    public String toString() {
        return "A dog named " + getName();
    }
}
