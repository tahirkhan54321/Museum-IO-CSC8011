package CSC8011;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class MuseumIO {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //initialising the Museum object and setting to default values
        String museumName = "name";
        ArrayList exhibitList = new ArrayList<Exhibit>();
        Museum museum = new Museum(museumName, exhibitList);

        while (true) {
            //listing options + reading user input and assigning to variable
            printOptionList();
            String input = scanner.nextLine();

            //program logic for dealing with each input
            if (input.equals("1")) {
                setMuseumName(museum);
            } else if (input.equals("2")) {
                readCsvFile(exhibitList);
            }
            else if (input.equals("3")) {
                    printSummary(museum);
            } else if (input.equals("4")) {
                    printStatistics(museum, exhibitList);
            } else if (input.equals("5")) {
                    break;
            } else {
                    System.out.println("Invalid input, please try again. \n");
                    continue;
                }
            }
        }

        /*
         * print the list of options for the user to input
         */
        private static void printOptionList () {
            System.out.println("Select from the list of options below (type number only): ");
            System.out.println("1 - Enter the name of the museum.");
            System.out.println("2 - Read in information on the exhibits from a .csv file.");
            System.out.println("3 - Print a summary of the museum name.");
            System.out.println("4 - Print statistics on exhibits.");
            System.out.println("5 - Exit the program.");
        }

        /*
         *setting the name for the museum
         */
        private static void setMuseumName (Museum museum){
            System.out.println("Enter the name of the museum");
            String museumName = scanner.nextLine();
            museum.setName(museumName);
            /* test to see if the museum name is set
             System.out.println(museum.getName()); */
        }

        /*
         * read CSV file and add objects to ArrayList of Exhibits
         */
        private static void readCsvFile (ArrayList arrayList){
            try (
                    /*
                     * using file reading from the Helsinki MOOC located here:
                     * https://java-programming.mooc.fi/part-4/3-files-and-reading-data
                     */
                    Scanner fileReader = new Scanner(Paths.get("exhibits.csv"))) {
                while (fileReader.hasNext()) {
                    // split the parts of the line and then assign to local variables to be passed as arguments
                    String line = fileReader.nextLine();
                    String partsOfExhibit[] = line.split(",");

                    String id = partsOfExhibit[0];
                    String desc = partsOfExhibit[1];
                    int year = Integer.valueOf(partsOfExhibit[2]);
                    double val = Double.parseDouble(partsOfExhibit[3]);
                    /* test to see if the values above are set
                    System.out.println(id);
                    System.out.println(desc);
                    System.out.println(year);
                    System.out.println(val);
                    */
                    // add the above parts of the line to the ArrayList as an Exhibit object
                    arrayList.add(new Exhibit(id, desc, year, val));
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /*
         * print a summary of the museum object with name and constituent exhibits
         */
        private static void printSummary(Museum museum) {
            //using replace to remove the square brackets and commas to get this in the specified format
            System.out.println(museum.toString().replace("[", "")
                    .replace("]", "").replace(", ", ""));
        }

        /*
         * print statistics for the museum
         */
        private static void printStatistics(Museum museum, ArrayList exhibitList) {
            System.out.println("The statistics on highest value, first exhibit acquired and average value of exhibits:");
            System.out.println("Highest value exhibit: " + museum.highestValueExhibit(exhibitList).getDescription() + " ("
                    + museum.highestValueExhibit(exhibitList).getExhibitId()
                    + "), £" + museum.highestValueExhibit(exhibitList).getValue());
            System.out.println("First exhibit acquired: " + museum.firstExhibit(exhibitList).getDescription() + " (acquired "
                    + museum.firstExhibit(exhibitList).getYearAcquired() + ")");
            System.out.println("Average value of exhibits: £" + museum.averageValueOfExhibits(exhibitList) + "\n");
        }
    }
