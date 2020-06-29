package com.algorithm.queue;

import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.function.Function;

/**
 * 猫狗队列
 *
 * @author wencai.xu
 */
public class DogCatPetQueue {

    private static final String DOG = "DOG";
    private static final String CAT = "CAT";

    private Queue<NewPet> dogQueue;
    private Queue<NewPet> catQueue;

    public DogCatPetQueue() {
        this.dogQueue = new ConcurrentLinkedQueue<>();
        this.catQueue = new ConcurrentLinkedQueue<>();
    }

    private static void accept(NewPet x) {
        System.out.println(x.toString());
    }

    public void add(NewPet newPet){
        if(newPet.getPet().getType().equals(DOG)){
            this.dogQueue.add(new NewPet(new Pet(DOG),System.currentTimeMillis()));
        }else if(newPet.getPet().getType().equals(CAT)){
            this.catQueue.add(new NewPet(new Pet(CAT),System.currentTimeMillis()));
        }else{
            throw new RuntimeException("Is Not Dog Or Cat");
        }
    }

    public List<NewPet> pollAll(){
        List<NewPet> newPets = new ArrayList<>();
        while(!this.dogQueue.isEmpty() && !this.catQueue.isEmpty()){
            NewPet dog = this.dogQueue.peek();
            NewPet cat = this.catQueue.peek();
            if(dog.getTimer() < cat.getTimer()){
                newPets.add(this.dogQueue.poll());
            }else{
                newPets.add(this.catQueue.poll());
            }
        }
        while(!this.dogQueue.isEmpty()){
            newPets.add(this.dogQueue.poll());
        }
        while(!this.catQueue.isEmpty()){
            newPets.add(this.catQueue.poll());
        }
        return newPets;
    }

    public List<NewPet> pollDog(){
        List<NewPet> dogPets = new ArrayList<>();
        while(!this.dogQueue.isEmpty()){
            dogPets.add(this.dogQueue.poll());
        }
        return dogPets;
    }

    public List<NewPet> pollCat(){
        List<NewPet> catPets = new ArrayList<>();
        while(!this.catQueue.isEmpty()){
            catPets.add(this.catQueue.poll());
        }
        return catPets;
    }

    public boolean isEmpty(){
        return catQueue.isEmpty() && dogQueue.isEmpty();
    }

    public boolean isDogEmpty(){
        return dogQueue.isEmpty();
    }

    public boolean isCatEmpty(){
        return catQueue.isEmpty();
    }

    public static void main(String[] args) throws InterruptedException {
        DogCatPetQueue queue = new DogCatPetQueue();
        queue.add(new NewPet(new Pet(DOG),System.currentTimeMillis()));
        Thread.sleep(1);
        queue.add(new NewPet(new Pet(DOG),System.currentTimeMillis()));
        Thread.sleep(1);
        queue.add(new NewPet(new Pet(CAT),System.currentTimeMillis()));
        Thread.sleep(1);

        System.out.println(queue.isEmpty());
        System.out.println(queue.isDogEmpty());
        System.out.println(queue.isCatEmpty());
        //queue.pollCat().forEach(x-> System.out.println(x.toString()));
        //queue.pollDog().forEach(x-> System.out.println(x.toString()));
        for (NewPet x : queue.pollAll()) {
            System.out.println(x.toString());
        }
    }
}


class Pet{
    private String type;

    public Pet(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

@ToString
class NewPet{
    private Pet pet;
    private long timer;

    public NewPet(Pet pet, long timer) {
        this.pet = pet;
        this.timer = timer;
    }

    public NewPet(Pet dog) {
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public long getTimer() {
        return timer;
    }

    public void setTimer(long timer) {
        this.timer = timer;
    }
}
