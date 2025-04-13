public class TestAnimal {
    public static void main(String[] args) {
        Animal animal = new Animal("Generic Animal");
        Dog dog = new Dog("Buddy");
        Cat cat = new Cat("Whiskers");
        Bird bird = new Bird("Tweety");

        
        animal.sound();  
        dog.sound();     
        cat.sound();     
        bird.sound();    

     
        System.out.println(animal);  
        System.out.println(dog);    
        System.out.println(cat);     
        System.out.println(bird);    
    }
}
