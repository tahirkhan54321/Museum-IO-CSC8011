package CSC8011;

import java.util.ArrayList;

public class Museum {

    private String name;
    private ArrayList<Exhibit> list = new ArrayList<>();

    public Museum(String name, ArrayList<Exhibit> list) {
        this.name = name;
        this.list = list;
    }

    /*
     * initialise local variables. Assign the highest value object in the for loop.
     */
    public Exhibit highestValueExhibit(ArrayList list) {
        double highestValue = 0;
        Exhibit highestValueExhibit = new Exhibit("0","a", 1,0);
        for (Exhibit item : this.list) {
            if (item.getValue() > highestValue) {
                highestValue = item.getValue();
                highestValueExhibit = item;
            }
        }
        return highestValueExhibit;
    }

    /*
     * initialise local variables. Assign the lowest year object in the for loop.
     */
    public Exhibit firstExhibit(ArrayList list) {
        int lowestYear = this.list.get(0).getYearAcquired();
        Exhibit oldestExhibit = new Exhibit("0","a", 1,0);
        for (Exhibit item : this.list) {
            if (item.getYearAcquired() < lowestYear) {
                lowestYear = item.getYearAcquired();
                oldestExhibit = item;
            }
        }
        return oldestExhibit;
    }

    /*
     * initialise local variables. Add the value of each exhibit object together.
     */
    public double averageValueOfExhibits(ArrayList list) {
        double sumOfExhibitValues = 0;
        for (Exhibit item : this.list) {
            sumOfExhibitValues += item.getValue();
        }
        return sumOfExhibitValues;
    }

    /*
     * no getters needed here, the toString allows us to print the museum name when required in MuseumIO
     */
    public void setName(String name) {
        this.name = name;
    }


    public String toString() {
        return "Museum name: " + this.name + "\n" + list.toString();
    }
}
