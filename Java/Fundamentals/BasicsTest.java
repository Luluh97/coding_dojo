public class BasicsTest {
    public static void main(String[] args) {

        Basics a = new Basics();
        String sum1 = a.PrintNums1(255);
      

        Basics b = new Basics();
        int sum = b.PrintNums(1,255);
        System.out.println("sum from 1 - 255: "+sum); 

        Basics c = new Basics();
        String odd = b.Odd(1,255);
      

        
        // int[] myArray = {1, 5, 10, -2};
        // int min = myArray[0];
        // int max = myArray[0];
        // int sumavg = 0;
        // for (int i = 0; i <= myArray.length; i++){
        //    if(myArray[i] < min){
        //        min = myArray[i];
        //    }

        //    if(myArray[i] > max){
        //     max = myArray[i];
        //     }

        //     sumavg = sumavg + myArray[i];
                  
        // } 
        // int avg = sumavg/myArray.length;
        // System.out.println("Min"+min+", Max "+max+" Average: "+avg);

    }
}