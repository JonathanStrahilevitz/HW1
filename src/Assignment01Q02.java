public class Assignment01Q02 {
    public static void main(String[] args) {
        double actualPi = Math.PI;
        double approxPi = 0;
        int input = Integer.parseInt(args[0]) ;
        double s = 0 ;
        for (int i=0; i<input; i++) {
            if (i % 2 == 0) {
                s = s + 1.0/(1 + 2*i) ;
            }
            else {
                s = s - 1.0/(1 + 2*i) ;
            }
        }    
        approxPi = 4 * s ;
    
        System.out.println(approxPi + " " + actualPi);
    }
}

