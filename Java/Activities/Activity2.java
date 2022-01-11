package Activities;
import java.util.Arrays;

public class Activity2 {
    public static void main(String [] args) {
        // Initialize an array
        int[] testArray = {10, 77, 10, 54, -11, 10};
        System.out.println("Original Array: " + Arrays.toString(testArray));
        // Constants
        int findNum = 10;
        int totalSum = 30;
        boolean result;

        // output
        result = checkSum(testArray, findNum, totalSum);
        System.out.println("The result is:" + result);
    }
     // checkSum method
        public static boolean checkSum(int[] numArray, int checkNum, int intTotal) {
            int tempsum = 0;
            for(int i = 0; i<=numArray.length -1; i++){
                if(numArray[i]==checkNum){
                    tempsum = tempsum + numArray[i];
                }
                if(tempsum> intTotal){
                    break;
                }
            }
            return tempsum ==intTotal;
        }



    }

