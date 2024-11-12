        public static char randomChar(int a,int b){
char number=(char)(a+(int)(Math.random()*(b-a+1)));
return number;}


  public static char randomChar(){
char number=(char)((int)(Math.random()*123));
return number;}


public static void randomWord(int n){
String result="";
    for(int i=n;i>0;i--){
        result+=randomChar((int)'a',(int)'z');
    }
    System.out.println(result);
}

public static int random(int... exculded){
    int result=(int)Math.random()+11;
  for(int i=0;0<exculded.length;i++){
    if(exculded[i]==result)
    result=random(exculded);
    }
    return result;
}
