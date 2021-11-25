import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {



    public static void main(String[] args){

        //<PrimeNumber, PrimeNumbers next factor>
        Map<BigInteger,BigInteger> numberNextNumber = new HashMap<>();

        //putting the first value
        numberNextNumber.put(new BigInteger("2"),new BigInteger("4"));
        BigInteger currentInteger = new BigInteger("3");
        while(true){

            //check if the current number is the next number of previously found prime numbers
            if(numberNextNumber.containsValue(currentInteger)){
                for(BigInteger key: numberNextNumber.keySet()){
                    if(numberNextNumber.get(key).equals(currentInteger)){
                        incrementNext(numberNextNumber,key);
                    }
                }
            }else{
                //put the current number as one of the prime numbers and put its next factor as the value
                numberNextNumber.put(currentInteger,currentInteger.add(currentInteger));
                System.out.println(currentInteger);
            }

            //less efficient aproach because it will check the numbers devided by 2
            //but it is here to be proof of concept
            currentInteger = currentInteger.add(new BigInteger("1"));

        }

    }

    //change the next value of the key
    public static void incrementNext(Map<BigInteger,BigInteger> numberNextNumber, BigInteger key){
        numberNextNumber.put(key,numberNextNumber.get(key).add(key));
    }
}
