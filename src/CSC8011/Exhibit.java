package CSC8011;

public class Exhibit {

    private String exhibitId;
    private String description;
    private int yearAcquired;
    private double value;

    public Exhibit(String exhibitId, String description, int yearAcquired, double value) {
        this.exhibitId = exhibitId;
        this.description = description;
        this.yearAcquired = yearAcquired;
        this.value = value;
    }

    /*
     * no setters here, as they are not needed and for security purposes.
     */
    public String getExhibitId() {
        return exhibitId;
    }

    public String getDescription() {
        return description;
    }

    public int getYearAcquired() {
        return yearAcquired;
    }

    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Exhibit ID: " + this.exhibitId + " Description: " + this.description +
                " Year acquired: " + this.yearAcquired + " Value: £" + this.value + "\n";
    }
}
