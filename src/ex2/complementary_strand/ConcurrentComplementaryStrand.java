package ex2.complementary_strand;

import ex1.find_name.FindResult;
import util.UtilReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentComplementaryStrand extends ComplementaryStrand{

    @Override
    void complementaryStrandFromDir(String inputDir, String outDir) {
        List<String> fileNames = UtilReader.listFiles(inputDir);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (String fileName : fileNames) {
            executor.execute(() -> {
                List<String> complementaryTape = new ArrayList<>();
                List<String> tapes = UtilReader.readFile(inputDir + "/" + fileName);
                for (String currentTape : tapes) {
                    String[] nucleotides = currentTape.split("");
                    complementaryTape.add(this.getComplementaryStrand(nucleotides));
                }
                try {
                    UtilReader.writeFileTo(outDir + "/" + fileName, complementaryTape);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        }
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException ex) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
        System.out.println("Finish!");
    }
}
