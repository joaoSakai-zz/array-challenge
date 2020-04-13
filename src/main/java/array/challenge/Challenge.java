package array.challenge;

import java.util.Arrays;
import java.util.Scanner;

public class Challenge {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Enter the array size: ");
        int size = keyboard.nextInt();

        int[] numbers = new int[size];

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Type a random number: ");
            numbers[i] = keyboard.nextInt();
        }

        int evenCount = 0;
        int[] evenArray = null;
        int evenIndex = 0;

        for(int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenCount++;

                if(evenArray == null) {
                    evenArray = new int[evenCount];
                    evenArray[evenIndex] = numbers[i];
                    continue;
                }

                int[] tempArray = createTempArray(evenArray);

                evenArray = new int[evenCount];

                evenIndex = refillEvenArray(evenArray, tempArray, evenCount);

                evenArray[evenIndex] = numbers[i];
            }
        }

        System.out.println("\n");
        System.out.printf("Even count: %d", evenCount);
        System.out.println("\n");
        System.out.printf("Typed Numbers: %s", Arrays.toString(numbers));
        System.out.println("\n");
        System.out.printf("Even array: %s", Arrays.toString(evenArray));
    }

    private static int[] createTempArray(final int[] evenArray) {
        int[] tempArray = new int[evenArray.length];
        System.arraycopy( evenArray, 0, tempArray, 0, evenArray.length );
        return tempArray;
    }

    private static int refillEvenArray(final int[] evenArray,final int[] tempArray,final int evenCount) {
        int evenIndex = 0;
        for (int j = 0; j < tempArray.length; j++) {
            evenArray[j] = tempArray[j];
            evenIndex++;
        }
        return evenIndex;
    }
}
