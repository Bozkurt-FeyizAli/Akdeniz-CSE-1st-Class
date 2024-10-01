import java.util.Scanner;
public class Ex0320220808073 {
   public static void main(String[] args) {
   Scanner input = new Scanner(System.in);
   //Question 1


   System.out.println("please choose meal as number");
   int numberMeal = input.nextInt();
    System.out.println("please drink as number");
   int numberDrink = input.nextInt();
   int feeMeal =0;
   int feeDrink =0;
   String output = "";
   if (numberMeal == 1){
   output += "Doner";
   feeMeal = 80;}
   else if (numberMeal == 2){
   output += "Kebab";
   feeMeal = 110;}
   else if (numberMeal == 3){
   output += "Lahmacun";
   feeMeal = 75;}
   if (numberDrink == 1){
   output += " and Ayran";
   feeDrink = 10;}
   else if (numberDrink == 2){
   output += " and Kola";
   feeDrink = 20;}
   else if (numberDrink == 3){
   output += " and Salgam";
   feeDrink = 15;}
       System.out.printf(output+" is %d lira .\n", (feeDrink+feeMeal));


   //Question 2


double fee;
System.out.println("please choose your member type:");
int typeOfMembership = input.nextInt();
System.out.println("please choose your using amount as GB:");
int qota = input.nextInt();
if (qota>=0){
   if (typeOfMembership==1&&qota>=100){
    fee = 80+((qota - 100)*3);
    fee = fee +(15*fee/100.0);
   System.out.printf("The total amount the consumer has to pay is: %f lira\n",fee);}
   else if(typeOfMembership==1&&qota<100){
   fee= 80;
   fee+= (15*fee)/100;
   System.out.printf("The total amount the consumer has to pay is: %f lira\n",fee);}
   else if (typeOfMembership==2&&qota>=200){
      fee = 140+((qota - 200)*5);
    fee = fee +(10*fee/100.0);
       System.out.printf("The total amount the consumer has to pay is: %f lira\n",fee);}
   else if (typeOfMembership==2&&qota<200){
   fee= 140;
   fee+= (10*fee)/100;
   System.out.printf("The total amount the consumer has to pay is: %f lira\n",fee);}
  else 
  System.out.println("ERROR: Please give your amount as positive!"); }


//question 3


double damage;
System.out.println("please select an attack type: (1 or 2)");
int typeOfAttack = input.nextInt();
if (typeOfAttack==1||typeOfAttack==2){
System.out.println("please select value of first coin: (2 is for random)");
int coin1 = input.nextInt();
System.out.println("please select value of second coin: (2 is for random)");
int coin2 = input.nextInt();
if ((coin1==1&&coin2==1)||(coin1==1&&coin2==0)
   ||(coin1==0&&coin2==1)||(coin1==0&&coin2==0)
   ||(coin1==1&&coin2==2)||(coin1==2&&coin2==1)
   ||(coin1==2&&coin2==2)||(coin1==2&&coin2==0)
   ||(coin1==0&&coin2==2)){
   if (coin1 == 2 ){
   int random1 = (int) Math.round(Math.random());
   coin1=random1;}
   if (coin2 == 2 ){
   int random1 = (int) Math.round(Math.random());
   coin2=random1;}
      if (typeOfAttack==1){
         if (coin1==1&&coin2==1){
         damage=60;
         System.out.printf("the damage dealt by the attack is %.1f .", damage);}
         else
         System.out.printf("the damage dealt by the attack is 0 .");}
            if (typeOfAttack==2){
            damage = 50+(coin1+coin2)*20;
            System.out.printf("the damage dealt by the attack is %.1f .", damage);}}
            else 
            System.out.println("ERROR:You have only three possibility");}
   else
   System.out.println("ERROR:You have only two possibility");
   
}
   }














