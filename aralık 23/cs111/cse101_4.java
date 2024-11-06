public class cse101{
    public static void main(String[] args){

//  System.out.println(factorial(5));
// System.out.println(fibonacci(7));
int[] a={1,2,3,4,5,6,7,8,9,};
int m =10000;
int[] memo= new int[m];
// System.out.println(sumOfArray(a, 4));
// System.out.println(fibonacci(1000, memo));
// System.out.println(isPalindromeA("abba", 0, 3));

    }

    public static int factorial(int n){
        if(n==2){
            return 2;
        }
        else{
            return n*factorial(n-1);
        }
        
    }

    public static int fibonacci(int n, int[] memo){
        if(n<=1)
            return n;
            if(memo[n]!=0)
            return memo[n];
        else{
            memo[n]=fibonacci(n-1,memo)+fibonacci(n-2,memo);
        }
        return memo[n];
    
    }

    public static int sumOfArray(int[] array, int n){
        int result=0;
        if(n==0){
            return array[0];
        }
        else 
            result=array[n]+sumOfArray(array, n-1);
            return result;
    }

    public static boolean isPalindrome(String str, int start, int end){
        if(str.length()==1||str.equals(""))
        return true;
        else if(str.charAt(start)==str.charAt(end-1))
        return true;
        else return isPalindrome(str, start+1, end);
    }
    
    public static boolean isPalindromeA(String str, int start, int end){
    if(start>=end)
    return true;
    if(str.charAt(start)!=str.charAt(end-1))
    return false;
    return isPalindrome(str, start+1, end-1);
    }

    public static int binarySearch(int[] array, int low, int high, int a){
        return a;
    }





}