package ex2.complementary_strand;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        // Sequential
        ComplementaryStrand sequentialComplementaryStrand = new SequentialComplementaryStrand();
        sequentialComplementaryStrand.complementaryStrandFromDir("bin/dna/in", "bin/dna/out");

        // Concurrent
        ComplementaryStrand concurrentComplementaryStrand = new SequentialComplementaryStrand();
        concurrentComplementaryStrand.complementaryStrandFromDir("bin/dna/in", "bin/dna/out");
    }
}
