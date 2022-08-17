package ex1.find_name;

import util.UtilReader;

import java.util.List;

abstract public class Finder {
    public void print(List<FindResult> result) {
        result.forEach(System.out::println);
    }
    abstract public List<FindResult> find(String name);
}
