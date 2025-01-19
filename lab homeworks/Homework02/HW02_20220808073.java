import java.util.Date;

public class HW02_20220808073{
     public static void main(String[] args) {
        // int i=86400000;
        // Date d= new Date(i);
        // City f=new City(null, null);
        // City a= new City(null, null);
        // Ticket z= new Ticket(f, a,  0);
        // System.out.println(z.getDate());
        
     }
}

class Ticket{
    private City from;
    private City to;
    private Date date;
    private int seat;
    private final int ONEDAY=86400000;

    Ticket( City from, City to, Date date, int seat){
        setDate(date);
        setSeat(seat);
        this.from=from;
        this.to=to;
    }
    Ticket(City from, City to, int seat){
        setSeat(seat);
        Date defaultDate= new Date(System.currentTimeMillis()+ONEDAY);
        setDate(defaultDate);
        this.from=from;
        this.to=to;
    }
    public City getFrom() {
        return from;
    }
    public City getTo() {
        return to;
    }
    public Date getDate() {
        return date;
    }
    public int getSeat() {
        return seat;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public void setSeat(int seat) {
        this.seat = seat;
    }
}

class City{
    private String postalCode;
    private String name;
    City(String postalCode ,String name){
        this.postalCode=postalCode;
        this.name=name;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public String getName() {
        return name;
    }
}
