package ex1.find_name;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        // Sequential finder
        Finder sequentialFinder = new SequentialFinder();
        List<FindResult> result = sequentialFinder.find("Rodrigo");
        sequentialFinder.print(result);

        // ConcurrentFinder
        Finder concurrentFinder = new ConcurrentFinder();
        List<FindResult> concurrentResult = concurrentFinder.find("Rodrigo");
        concurrentFinder.print(concurrentResult);
    }
}
