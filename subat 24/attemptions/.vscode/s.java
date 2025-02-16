public class s {
    public static void main(String[] args) {
        //  Fan fan =new Fan(9,"red");
        // fan.getInfo();
        // fan.setInfo(3, 6, "purple");
        // fan.getInfo();
        Stock aaa= new Stock("Fab", "bozkurt");
        aaa.setCurrentPrice(100);
        aaa.setPreviousClosingPrice(5);
        System.out.println(aaa.getPreviousClosingPrice());
        System.out.println(aaa.getCurrentPrice());
        System.out.println(aaa.getChangePercent());

        Fan bbb= new Fan(5.4, "red");

        bbb.change();
        // bbb.(3, "s");
        System.out.println(bbb);
        bbb.setColor("yeşil");
        bbb.setRadius(2.24525);
        bbb.setSpeed(3);
        System.out.println(bbb.getColor());
        System.out.println(bbb.getRadius());
        System.out.println(bbb.getSpeed());
        System.out.println(bbb.getClass());

        System.out.println(bbb);
    }
}

class Stock{
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;

    Stock(String symbol,String name){
        char a=name.charAt(0);
        a=Character.toUpperCase(a);
        String rest =name.substring(1).toLowerCase();
        this.name=a+rest;
        this.symbol=symbol.toUpperCase();
    }

    public void getData(){
        System.out.printf("symbol: %s, name: %s, "+
        "previous closing price: %f, current price: %f\n"
        ,symbol,name,previousClosingPrice,currentPrice);
    }

    public String getSymbol(){
        return symbol;
    }

    public String getName(){
        return name;
    }

    public double getPreviousClosingPrice(){
        return previousClosingPrice;
    }

    public double getCurrentPrice(){
        return currentPrice;
    }

    public void setData(double previousClosingPrice,double currentPrice){
        if(previousClosingPrice<0||currentPrice<0){
            System.out.println("ERROR : values cant be negative.");
        }else{
        this.previousClosingPrice=previousClosingPrice;
        this.currentPrice=currentPrice;
        }
    }

    public void setPreviousClosingPrice(double previousClosingPrice){
        if(previousClosingPrice<0){
            System.out.println("ERROR : values cant be negative.");
        }else{
        this.previousClosingPrice=previousClosingPrice;
        
        }
    }

    public void setCurrentPrice(double currentPrice){
        if(previousClosingPrice<0){
            System.out.println("ERROR : values cant be negative.");
        }else{
        this.currentPrice=currentPrice;
        }
    }

    @Override
    public String toString(){
        return symbol+" "+name+":"+currentPrice;
    }

    public double getChangePercent(){
        return ((currentPrice-previousClosingPrice)/previousClosingPrice)*100;
    }
}

class Fan{
    static final int SLOW=1;
    static final int MEDIUM=2;
    static final int FAST=3;
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    Fan(double radius,String color){
        this();
        this.radius=radius;
        this.color=color;
    }

    Fan(){
        speed=1;
        on=false;
        radius=5;
        color ="Blue";
    }

    public void getData(){
        System.out.printf("speed: %d, radius: %.2f, color: %s\n"
        ,speed,radius,color);
    }

    public int getSpeed(){
        if(on==true)
        return speed;
        else
        return 0;
    }

    public double getRadius(){
        return radius;
    }

    public String getColor(){
        return color;
    }

    public void setData(int speed,double radius,String color){
        this.color=color;
        this.radius=radius;
        this.speed=speed;
    }

    public void setRadius(double radius){
        this.radius=radius;
    }

    public void setSpeed(int speed){
        if(on==true){
            this.speed=speed;
        }
    }

    public void setColor(String color){
        this.color=color;
    }

    public boolean isOn(){
        return on;
    }

    @Override
    public String toString(){
        if(on==true){
            return String.format("Speed: %d, Radius %.2f, Color: %s",
            speed,radius,color);
        }else{
            return "Fan is off";
        }
    }

    public void change(){
        if(on==true)
        on=false;
        else
        on=true;
    }
}
