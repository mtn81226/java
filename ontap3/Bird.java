public class Bird extends Animal {

    public Bird(String name) {
        super(name);
    }

    @Override
    public void sound() {
        System.out.println("Chirp! Chirp!");
    }

    @Override
    public String toString() {
        return "A bird named " + getName();
    }
}
