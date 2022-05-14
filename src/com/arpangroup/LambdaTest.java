package com.arpangroup;

import java.io.Serializable;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LambdaTest implements Serializable {

    protected void readResolved() {

    }

    public static void checkPrime(){
        System.out.println("checkPrime.........");
        IntStream.rangeClosed(1, 20).forEach(x -> System.out.println(x + ": " + (isPrime(x) ? "prime":"non-prime")));
    }

    public static void generateSqrtOfFirstNPrimeNumbers(int n){
        System.out.print(
                Stream.iterate(1, i-> i+1)
                        .filter(LambdaTest::isPrime)
                        .peek(x -> System.out.print("N: " + x + "==>"))
                        .map(Math::sqrt)
                        .limit(n)
                        .peek(x -> System.out.println(String.format("%.2f", x)))
//                .collect(Collectors.toList())
                        .map(aDouble -> String.format("%.2f", aDouble))
                        .reduce("", (a,b)-> a + "" + b +", ")
        );
    }

    public static boolean isPrime(int n){
        return n > 1 && IntStream.range(2, n-1)
                .noneMatch(i -> n % i == 0);
    }
}
