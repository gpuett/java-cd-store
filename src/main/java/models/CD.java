package models;

public class CD {
    public String artist;
    public String album;
    public int year;
    public int price;

    public CD(String artist, String album, int year, int price) {
        this.artist = artist;
        this.album = album;
        this.year = year;
        this.price = price;
    }

    public boolean affordable(int maxPrice){
        return (this.price < maxPrice);
    }
}
