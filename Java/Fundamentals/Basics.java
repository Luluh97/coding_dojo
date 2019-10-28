import java.util.ArrayList;

public class Basics {
 
    public int PrintNums(int a, int b) {
        int sum = 0;
        for (int i = a; i <= b; i++){
                  sum = sum + i;;
        }  
        return sum;   
    }

    public String Odd(int a, int b) {
        
        for (int i = a; i <= b; i++){
            if(i%2 != 0){
                  System.out.println(i);

            }
          
        }
        return "";  
          
    }

    public String PrintNums1(int b) {
        int sum = 0;
        for (int i = 0; i <= b; i++){
            sum = sum + i;;
            System.out.println("New Number:"+i+" Sum: "+sum);
                  
        }  
        return "";   
    }


    
}


