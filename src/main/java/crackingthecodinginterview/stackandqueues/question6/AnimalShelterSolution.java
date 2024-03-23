package crackingthecodinginterview.stackandqueues.question6;

import java.util.LinkedList;

/**
 * Implement queue(FIFO) using stacks(LIFO)
 */
enum AnimalType{
    DOG,
    CAT
}

class Animal{
    private AnimalType type;
    private String name;
    private int order;

    private Animal(){}

    public Animal(String name, AnimalType animalType){
        this.name = name;
        this.type = animalType;
    }
    public AnimalType getType() {
        return type;
    }
    public void setType(AnimalType type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getOrder() {
        return order;
    }
    public void setOrder(int order) {
        this.order = order;
    }


}
class AnimalShelterSolution{

    private int order = 0;
    private LinkedList<Animal> dogs = new LinkedList<>();
    private LinkedList<Animal> cats = new LinkedList<>();

    // TimeComplexity: O(1)
    public void enqueue(Animal animal){
        animal.setOrder(order++);
        if(AnimalType.DOG == animal.getType()){
            dogs.addLast(animal);
        }else{
            cats.addLast(animal);
        }
    }

    // TimeComplexity: O(1)
    public Animal dequeueAny(){
        if(dogs.isEmpty() && cats.isEmpty())
            throw new IllegalStateException("animal list is empty");
        if(dogs.isEmpty() && !cats.isEmpty())
            return cats.removeFirst();
        if(cats.isEmpty() && dogs.isEmpty())
            return dogs.removeFirst();

        return dogs.peek().getOrder() < cats.peek().getOrder() ? dogs.removeFirst() : cats.removeFirst();
    }

    // TimeComplexity: O(1)
    public Animal dequeueDog(){
        if(dogs.isEmpty())
            throw new IllegalStateException("Dog list is empty");
        return dogs.removeFirst();
    }

    // TimeComplexity: O(1)
    public Animal dequeueCat(){
        if(dogs.isEmpty())
            throw new IllegalStateException("Cat list is empty");
        return cats.removeFirst();
    }

    public static void main(String[] args) {
        AnimalShelterSolution sol = new AnimalShelterSolution();
        Animal d1 = new Animal("DOG1", AnimalType.DOG);
        Animal c1 = new Animal("CAT2", AnimalType.CAT);
        Animal d2 = new Animal("DOG3", AnimalType.DOG);
        Animal c2 = new Animal("CAT4", AnimalType.CAT);
        Animal d3 = new Animal("DOG5", AnimalType.DOG);
        Animal c3 = new Animal("CAT6", AnimalType.CAT);

        sol.enqueue(d1);
        sol.enqueue(c1);
        sol.enqueue(d2);
        sol.enqueue(c2);
        sol.enqueue(d3);
        sol.enqueue(c3);

        System.out.println(sol.dequeueDog().getName()); // DOG1
        System.out.println(sol.dequeueAny().getName()); // CAT2
        System.out.println(sol.dequeueCat().getName()); // CAT4

    }
}