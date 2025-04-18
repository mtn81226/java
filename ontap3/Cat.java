public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Meow! Meow!");
    }

    @Override
    public String toString() {
        return "A cat named " + getName();
    }
}
