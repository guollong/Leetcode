/**
 * Question description: Write a program that outputs the string representation of numbers from 1 to n.
 * 		But for multiples of three it should output “Fizz” instead of the number.
 * 		For the multiples of five output “Buzz”. For numbers which are multiples of both three and five output “FizzBuzz”.
 */

/**
 * Author: Jinglong Guo
 * Difficulty: Easy; Company: .
 * Date: 02/24/2017
 */

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> output = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                output.add(Integer.toString(i));
            } else if (i % 3 == 0 && i % 5 != 0) {
                output.add("Fizz");
            } else if (i % 3 != 0 && i % 5 == 0) {
                output.add("Buzz");
            } else {
                output.add("FizzBuzz");
            }
        }
        return output;
    }
}

