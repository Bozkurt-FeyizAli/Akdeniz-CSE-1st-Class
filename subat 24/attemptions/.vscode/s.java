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
