package mobi.com.bothofus;

/**
 * Created by Acer on 24-Mar-18.
 */

public class Restaurants {

    String name;
    String address;
    double latitude;
    double longitude;
    String telephone;
    String website;
    String openinghours;

    public Restaurants(String name, String address, double latitude, double longitude, String telephone, String website, String openinghours) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.telephone = telephone;
        this.website = website;
        this.openinghours = openinghours;
    }

    public Restaurants(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getOpeninghours() {
        return openinghours;
    }

    public void setOpeninghours(String openinghours) {
        this.openinghours = openinghours;
    }

    @Override
    public String toString() {
        return "Restaurants{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", telephone=" + telephone +
                ", website='" + website + '\'' +
                ", openinghours='" + openinghours + '\'' +
                '}';
    }
}
