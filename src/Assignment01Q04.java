import java.util.Arrays;

public class Assignment01Q04 {

    public static int[] shiftArrayCyclic(int[] array, int move, char direction) {
        int n = array.length ;
        if (n <= 1 || move == 0 || (direction != 'L' && direction != 'R')) {
    return array;
}
    char EffectiveDirection = getEffectiveDirection(move, direction) ;
    int  EffectiveMoves = getEffectiveMoves(array, move) ;
    
    if (EffectiveDirection == 'R'){
        array = shiftRight(array, EffectiveMoves) ;
    } else {
        array = shiftRight(array, n - EffectiveMoves) ;
    } 
    return array;
    }

    public static char getEffectiveDirection (int move, char direction) {
        if (direction == 'R' && move > 0 || direction == 'L' && move < 0) {
            return 'R' ;
        }
        else {
            return 'L' ;
        }
    }

    public static int getEffectiveMoves (int[] array, int move) {
        return Math.abs(move % array.length) ;
    }

    public static int[] shiftRight(int[] array, int move) {
        int n = array.length ;
        int[] helper_array = new int [n] ;
        for (int i=0 ; i < n ; i++) {
            helper_array[(i + move) % n] = array[i] ;
        }
        for (int i = 0; i < n; i++) {
            array[i] = helper_array[i];
            }
    return array;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -1, 'R'))); // [2, 3, 4, 5, 1]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'R'))); // [5, 1, 2, 3, 4]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 1, 'r'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -2, 'g'))); // [1, 2, 3, 4, 5]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, 3, 'L'))); // [4, 5, 1, 2, 3]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{1, 2, 3, 4, 5}, -3, 'L'))); // [3, 4, 5, 1, 2]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{0, 8, 9, 5, 6}, 6, 'L'))); // [8, 9, 5, 6, 0]
        System.out.println(Arrays.toString(
            shiftArrayCyclic(new int[]{}, 3, 'R'))); // []
    }
}