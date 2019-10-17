package ca.uvic.k4ncelled.Backend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class Fridge {
    private ArrayList<Food> storage;

    public Fridge(){
        storage = new ArrayList<Food>();
    }

    public ArrayList<Food> getStorage(){
        return storage;
    }

    public void addFood(String name, LocalDate purchaseDate, LocalDate expiryDate){
        storage.add(new Food(name, purchaseDate,expiryDate));
        storage.sort(new ExpiryComparator());
    }

    public void removeFood(Food toRemove){
        storage.remove(toRemove);
    }
}

class ExpiryComparator implements Comparator{
    @Override
    public int compare(Object o1, Object o2) {
        Food food1 = (Food)o1;
        Food food2 = (Food)o2;
        return food1.getExpiryDate().compareTo(food2.getExpiryDate());
    }
}