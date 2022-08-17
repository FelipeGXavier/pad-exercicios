package ex1.find_name;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ConcurrentFinder extends Finder{
    @Override
    public List<FindResult> find(String name) {
        List<FindResult> result = new ArrayList<>();
        List<String> fileNames = this.listFiles("bin/");
        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (String fileName : fileNames) {
            List<String> names = this.readFile("bin/" + fileName);
            executor.execute(() -> {
                int line = 0;
                for (String currentName : names) {
                    line++;
                    if (currentName.toLowerCase().contains(name.toLowerCase())) {
                        result.add(new FindResult(currentName, fileName, line));
                    }
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
        return result;
    }
}
