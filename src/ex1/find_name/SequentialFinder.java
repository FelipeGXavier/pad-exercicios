package ex1.find_name;

import java.util.ArrayList;
import java.util.List;

public class SequentialFinder extends Finder {

    @Override
    public List<FindResult> find(String name) {
        List<FindResult> result = new ArrayList<>();
        List<String> fileNames = this.listFiles("bin/");
        for (String fileName : fileNames) {
            List<String> names = this.readFile("bin/" + fileName);
            int line = 0;
            for (String currentName : names) {
                line++;
                if (currentName.toLowerCase().contains(name.toLowerCase())) {
                    result.add(new FindResult(currentName, fileName, line));
                }
            }
        }
        return result;
    }
}
