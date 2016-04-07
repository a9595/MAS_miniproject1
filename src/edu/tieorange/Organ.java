package edu.tieorange;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tieorange on 07/04/16.
 */
public abstract class Organ extends ParentObject {
    public static List<Organ> extent = new ArrayList<>();
    public String Name;
    public String Surname; // optional // TODO:
    public int CaloriesConsumptionPerMinute;
    public int MinimalCaloriesConsumption;

    public int getDeltaMinimalCaloriesConsumption() {
        return CaloriesConsumptionPerMinute - MinimalCaloriesConsumption;
    }

    public int DeltaMinimalCaloriesConsumption; // derived attr

    public Organ(List<String> sounds, String surname, int caloriesConsumptionPerMinute, int minimalCaloriesConsumption, String name) {
        Sounds = sounds;
        Surname = surname;
        CaloriesConsumptionPerMinute = caloriesConsumptionPerMinute;
        MinimalCaloriesConsumption = minimalCaloriesConsumption;
        Name = name;
    }

    private Organ() {
        super();
        Organ.extent.add(this);
    }

    // multi-value
    public List<String> Sounds = new ArrayList<>();

    // exact location in the body
    // complex attribute
    public Location Location;

    // part of the body to which organ belongs
    public BodyPart BodyPart;

    // return sum of all Calories used by all organs
    public static int CaloriesSum() {
        int sum = 0;
        for (Organ organ :
                extent) {
            sum += organ.getCaloriesConsumptionPerMinute();
        }
        return sum;
    }

    // true if the changes where successful
    public boolean ChangeCaloriesConsumption(int newConsumption) {
        if (newConsumption < MinimalCaloriesConsumption) {
            // TODO: komunikat
            return false;
        } else {
            this.CaloriesConsumptionPerMinute = newConsumption;
            return true;
        }
    }

    public void SignalTheExistance(Organ otherOrgan) {
        System.out.println(Name + " said to " + otherOrgan.Name + " that he works well");
    }

    public abstract void BroadcastYourFunction(Organ otherOrgan);

    public static List<Organ> getOrgans() {
        List<Organ> tmp = new ArrayList<>(Organ.extent);
        return tmp;
    }

    // overloading
    public static List<Organ> getOrgans(int minConsumption) {
        List<Organ> tmp = new ArrayList<>(Organ.extent);

        List<Organ> results = new ArrayList<>();
        for (Organ t : tmp) {
            if (t.getCaloriesConsumptionPerMinute() > minConsumption) {
                results.add(t);
            }
        }
        return results;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getCaloriesConsumptionPerMinute() {
        return CaloriesConsumptionPerMinute;
    }

    public void setCaloriesConsumptionPerMinute(int caloriesConsumptionPerMinute) {
        CaloriesConsumptionPerMinute = caloriesConsumptionPerMinute;
    }

    public int getMinimalCaloriesConsumption() {
        return MinimalCaloriesConsumption;
    }

    public void setMinimalCaloriesConsumption(int minimalCaloriesConsumption) {
        MinimalCaloriesConsumption = minimalCaloriesConsumption;
    }

    public List<String> getSounds() {
        return Sounds;
    }

    public void setSounds(List<String> sounds) {
        Sounds = sounds;
    }

    public edu.tieorange.Location getLocation() {
        return Location;
    }

    public void setLocation(edu.tieorange.Location location) {
        Location = location;
    }

    public edu.tieorange.BodyPart getBodyPart() {
        return BodyPart;
    }

}
