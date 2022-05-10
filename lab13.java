import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;

class lab13 {

    private ArrayList<Integer> inputData;

    public void readData(String filename) {
        inputData = new ArrayList<>();
        try {
            Integer[] input = Files.lines(new File(lab13.class.getResource(filename).getFile()).toPath())
                    .map(Integer::valueOf)
                    .toArray(Integer[]::new);
            for (Integer i : input)
                inputData.add(i);
        } catch (Exception e) {
        }
    }

    public Integer[] getResult1() {
        return inputData.stream()
                .filter(x -> x % 2 == 0 && 5 < x && x < 50)
                .sorted()
                .toArray(Integer[]::new);
    }

    public Integer[] getResult2() {
        return inputData.stream()
                .map(x -> x * x * 3)
                .limit(50)
                .toArray(Integer[]::new);
    }

    public Integer[] getResult3() {
        return inputData.stream()
                .filter(x -> x % 2 == 1)
                .map(x -> x * 2)
                .sorted()
                .skip(20)
                .distinct()
                .toArray(Integer[]::new);
    }

    public long getTotalCount() {
        return inputData.stream()
                .count();
    }

    public long getOddCount() {
        return inputData.stream()
                .filter(x -> x % 2 == 1)
                .count();
    }

    public long getEvenCount() {
        return inputData.stream()
                .filter(x -> x % 2 == 0)
                .count();
    }

    public long getDistinctGreaterThanFiveCount() {
        return inputData.stream()
                .filter(x -> 5 < x)
                .distinct()
                .count();
    }
}