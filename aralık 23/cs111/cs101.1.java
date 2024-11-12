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
