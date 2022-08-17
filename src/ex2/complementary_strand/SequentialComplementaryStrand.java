package ex2.complementary_strand;

import ex1.find_name.FindResult;
import util.UtilReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SequentialComplementaryStrand extends ComplementaryStrand{

    @Override
    public void complementaryStrandFromDir(String inputDir, String outDir) {
        List<String> fileNames = UtilReader.listFiles(inputDir);
        for (String fileName : fileNames) {
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
        }
    }
}
