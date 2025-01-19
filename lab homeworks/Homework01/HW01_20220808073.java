public class HW01_20220808073{
    public static void main(String[] args) {
        Stock aaa= new Stock("Fab", "bi ço ğz ok uu kr gt");

        aaa.setCurrentPrice(100);
        aaa.setPreviousClosingPrice(5);
        System.out.println(aaa.getPreviousClosingPrice());
        System.out.println(aaa.getCurrentPrice());
        System.out.println(aaa.getChangePercent());
        System.out.println(aaa);

        Fan bbb= new Fan(5.4, "red");

        bbb.change();
        // bbb.(3, "s");
        System.out.println(bbb);
        bbb.setColor("yeşil t");
        bbb.setRadius(2.24525);
        bbb.setSpeed(3);
        System.out.println(bbb.getColor());
        System.out.println(bbb.getRadius());
        System.out.println(bbb.getSpeed());
        System.out.println(bbb.getClass());

        System.out.println(bbb.isOn());
        
    }
}

class Stock{
    private String symbol;
    private String name; 
    private double previousClosingPrice; 
    private double currentPrice;

    public String capitalizeWord(String word){
        return word.toUpperCase();
    }
    
    public String UpperFirstLetter(String word){
        return Character.toUpperCase(word.charAt(0))
                +word.substring(1).toLowerCase();
    }

    public String UpperFirstLetterEachWord(String word){
        String[] name= word.split(" ");
        String newWord="";
        for (int index = 0; index < name.length; index++) {
            if(index==name.length-1)
            newWord+=UpperFirstLetter(name[index])    ;
            else
            newWord+=UpperFirstLetter(name[index])+" ";
        }
        return newWord;
    }
