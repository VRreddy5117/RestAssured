package JSONReadingHTTPMethods;

import java.util.Random;

public class Random_numberGenerator {
    public static  String rand_int;

    public static void main(String args[])
    {
        radomNumber();


    }

    public static String radomNumber() {
        Random rand = new Random();
        rand_int = String.valueOf( rand.nextInt(100000));
      // System.out.println(rand_int);

        return  rand_int;



    }
}
