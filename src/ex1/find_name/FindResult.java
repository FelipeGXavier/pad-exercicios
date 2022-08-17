package ex1.find_name;

public class FindResult {

    private final String name;
    private final String filename;
    private final int line;

    public FindResult(String name, String filename, int line) {
        this.name = name;
        this.filename = filename;
        this.line = line;
    }

    @Override
    public String toString() {
        return "Arquivo: " + this.filename + " | Linha: " + this.line + " | " + this.name;
    }
}
