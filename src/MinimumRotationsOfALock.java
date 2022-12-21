/*
* https://www.geeksforgeeks.org/minimum-rotations-unlock-circular-lock/
* */

public class MinimumRotationsOfALock {

    public static int minRotation(int input, int code){
        int input_digit, code_digit = 0;
        int totalMinRotations = 0;
        while (input > 0 || code > 0) {
            input_digit = input%10;
            code_digit = code%10;
            totalMinRotations += Math.min( Math.abs(input_digit-code_digit), 10 - Math.abs(input_digit-code_digit) );
            input = input/10;
            code = code/10;
        }
        return totalMinRotations;
    }

    public static void main(String[] args) {
        System.out.println(minRotation(2345, 5432));
    }
}