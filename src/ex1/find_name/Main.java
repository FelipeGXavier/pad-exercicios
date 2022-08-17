package ex1.find_name;

import util.UtilReader;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Sequential finder
        Finder sequentialFinder = new SequentialFinder();
        long startSequential = System.currentTimeMillis();
        List<FindResult> result = sequentialFinder.find("Rodrigo");
        long endSequential = System.currentTimeMillis();
        //sequentialFinder.print(result);
        System.out.println("Sequential - Elapsed Time in milli seconds: "+ (endSequential-startSequential));

        // ConcurrentFinder
        Finder concurrentFinder = new ConcurrentFinder();
        long startConcurrent = System.currentTimeMillis();
        List<FindResult> concurrentResult = concurrentFinder.find("Rodrigo");
        long endConcurrent = System.currentTimeMillis();
        //concurrentFinder.print(concurrentResult);
        System.out.println("Concurrent - Elapsed Time in milli seconds: "+ (endConcurrent-startConcurrent));
    }
}
