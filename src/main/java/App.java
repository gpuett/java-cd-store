import models.CD;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) {

        CD inspiration = new CD("Sheku Kanneh-Mason", "Inspiration", 2018, 14);
        CD electric = new CD("Jimmy Hendrix", "Electric Ladyland", 2010, 12);
        CD last = new CD("Willie Nelson", "Last Man Standing", 2018, 10);
        CD vampire = new CD("Vampire Weekend", "Vampire Weekend", 2008, 18);


        ArrayList<CD> allCDs = new ArrayList<CD>();

        allCDs.add(inspiration);
        allCDs.add(electric);
        allCDs.add(last);
        allCDs.add(vampire);

        boolean programRunning = true;

        while (programRunning){
            System.out.println("Welcome to our CD Store. What would you like to do? Choose one of the following options: All CDs, Search Year, Search Artist, Search Price, Add CD or Exit");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            try {

                String navigationChoice = bufferedReader.readLine();

                if (navigationChoice.equals("All CDs")) {
                    for (CD individualCD : allCDs){
                        System.out.println("-------------------");
                        System.out.println(individualCD.artist);
                        System.out.println(individualCD.album);
                        System.out.println(individualCD.year);
                        System.out.println(individualCD.price);
                    }
                } else if (navigationChoice.equals("Search Year")){
                    System.out.println("What year would you like to search?");
                    String stringYearInput = bufferedReader.readLine();
                    int userYearInput = Integer.parseInt(stringYearInput);
                    System.out.println("Here are the albums available from that year:");
                    for (CD individualCD : allCDs){
                        if (individualCD.year == userYearInput){
                            System.out.println("-------------------");
                            System.out.println(individualCD.artist);
                            System.out.println(individualCD.album);
                            System.out.println(individualCD.year);
                            System.out.println(individualCD.price);
                        }
                    }
                } else if (navigationChoice.equals("Search Artist")) {
                    System.out.println("Enter an artist name.");
                    String artistInput = bufferedReader.readLine();
                    System.out.println("Here are the available CDs from this artist:");
                    for (CD individualCD : allCDs){
                        if (individualCD.artist.equals(artistInput)) {
                            System.out.println("-------------------");
                            System.out.println(individualCD.artist);
                            System.out.println(individualCD.album);
                            System.out.println(individualCD.year);
                            System.out.println(individualCD.price);
                        }
                    }
                } else if (navigationChoice.equals("Search Price")) {
                    System.out.println("Enter your budget");
                    String stringPriceInput = bufferedReader.readLine();
                    int userPriceInput = Integer.parseInt(stringPriceInput);
                    System.out.println("Here are the available CDs in your price range");
                    for (CD individualCD : allCDs){
                        if (individualCD.affordable(userPriceInput)) {
                            System.out.println("-------------------");
                            System.out.println(individualCD.artist);
                            System.out.println(individualCD.album);
                            System.out.println(individualCD.year);
                            System.out.println(individualCD.price);
                        }
                    }
                } else if (navigationChoice.equals("Add CD")){
                    System.out.println("Let's add a CD to our stock! What is the name of the artist?");
                    String artistInput = bufferedReader.readLine();
                    System.out.println("What is the name of the album?");
                    String albumInput = bufferedReader.readLine();
                    System.out.println("What year was the album released?");
                    int yearInput = Integer.parseInt(bufferedReader.readLine());
                    System.out.println("What is the price of the album?");
                    int priceInput = Integer.parseInt(bufferedReader.readLine());
                    CD userCD = new CD(artistInput, albumInput, yearInput, priceInput);
                    allCDs.add(userCD);

                    System.out.println("Alright, here is your new CD:");
                    System.out.println("-------------------");
                    System.out.println(userCD.artist);
                    System.out.println(userCD.album);
                    System.out.println(userCD.year);
                    System.out.println(userCD.price);
                } else if (navigationChoice.equals("Exit")){
                    System.out.println("Goodbye!");
                    programRunning = false;
                } else {
                    System.out.println("I'm sorry, we don't recognize your input");
                }

            } catch (IOException e) {
                    e.printStackTrace();
                }

        }

    }
}
