package mobi.com.bothofus;

/**
 * Created by Acer on 24-Mar-18.
 */

public class Event  {

    String identifier;
    String eventdate;
    String title;
    String location;
    String venue;
    String Eventtype;

    public Event(String identifier, String eventdate, String title, String location, String venue, String eventtype) {
        this.identifier = identifier;
        this.eventdate = eventdate;
        this.title = title;
        this.location = location;
        this.venue = venue;
        Eventtype = eventtype;
    }

    public Event(){

    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getEventdate() {
        return eventdate;
    }

    public void setEventdate(String eventdate) {
        this.eventdate = eventdate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getEventtype() {
        return Eventtype;
    }

    public void setEventtype(String eventtype) {
        Eventtype = eventtype;
    }
}
