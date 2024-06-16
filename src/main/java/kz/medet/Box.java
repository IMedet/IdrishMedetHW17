package kz.medet;


import java.util.ArrayList;

public class Box<T extends Fruit>{
    private ArrayList<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void addFruit(T fruit) {
        fruits.add(fruit);
    }

    public float getWeight(){
        float totalWeight = 0;
        for (T fruit : fruits) {
            totalWeight +=fruit.getWeight();
        }

        return totalWeight;
    }

    public boolean compare(Box<?> otherBox){
        return this.getWeight() == otherBox.getWeight();
    }

    public void moveFruitsTo(Box<T> otherBox){
        if (this == otherBox){
            throw new IllegalArgumentException("Cannot move fruit to the same box");
        }

        otherBox.fruits.addAll(this.fruits);
        this.fruits.clear();
    }

    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        appleBox.addFruit(new Apple());
        appleBox.addFruit(new Apple());

        Box<Orange> orangeBox = new Box<>();
        orangeBox.addFruit(new Orange());
        orangeBox.addFruit(new Orange());

        System.out.println("AppleBox weight: " + appleBox.getWeight());
        System.out.println("OrangeBox weight: " + orangeBox.getWeight());
        System.out.println("Boxes have same weight: " + appleBox.compare(orangeBox));

        Box<Apple> anotherAppleBox = new Box<>();
        appleBox.moveFruitsTo(anotherAppleBox);

        System.out.println("After moving AppleBox weight: " + appleBox.getWeight());
        System.out.println("After moving AnotherAppleBox weight: " + anotherAppleBox.getWeight());
    }
}
