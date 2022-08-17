package ex1.find_name;

import util.UtilReader;

import java.util.List;

abstract public class Finder extends UtilReader<FindResult> {

    abstract public List<FindResult> find(String name);
}
