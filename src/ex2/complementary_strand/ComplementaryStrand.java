package ex2.complementary_strand;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

abstract class ComplementaryStrand {

    private final Map<String, String> nucleotidesMapping = new HashMap<>();

    public ComplementaryStrand() {
        this.nucleotidesMapping.put("A", "T");
        this.nucleotidesMapping.put("T", "A");
        this.nucleotidesMapping.put("C", "G");
        this.nucleotidesMapping.put("G", "C");
    }
    protected String getComplementaryStrand(String[] tape) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < tape.length; i++) {
            builder.append(this.nucleotidesMapping.get(tape[i]));
        }
        return builder.toString();
    }
    abstract void complementaryStrandFromDir(String inputDir, String outDir) throws IOException;

}
