package ch.bbw.travllingSalesman;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Input input = gson.fromJson(Files.readString(Path.of("./input.json")), Input.class);

        ArrayList<Coordinates> startCombination = new ArrayList<>();
        startCombination.add(input.getStart());

        Algorithm algorithm = new Algorithm();
        algorithm.RunForAllCombinations((combination -> {
            ArrayList<Coordinates> fullList = (ArrayList<Coordinates>) startCombination.clone();

            fullList.add(input.getStart());

            double fullDistance = 0;

            for (int i = 1; i < fullList.size(); i++) {
                fullDistance += fullList.get(i - 1).distanceTo(fullList.get(i));
            }

            if (fullDistance < fastest.getLength()) {
                fast = faster;
                faster = fastest;
                fastest = new Outcome(fullList, fullDistance);
            } else if (fullDistance < faster.getLength()) {
                fast = faster;
                faster = new Outcome(fullList, fullDistance);
            } else if (fullDistance < fast.getLength()) {
                fast = new Outcome(fullList, fullDistance);
            }
        }), input.getCoordinates(), startCombination);

        System.out.println("First: " + fastest);
        System.out.println();
        System.out.println("Second: " + faster);
        System.out.println();
        System.out.println("Third: " + fast);

        Output outputJson = new Output(fastest, faster, fast);
        String json = gson.toJson(outputJson);
        Files.writeString(Path.of("./output.json"), json);
    }

    private static Outcome fastest = new Outcome(new ArrayList<>(), Double.MAX_VALUE);
    private static Outcome faster = new Outcome(new ArrayList<>(), Double.MAX_VALUE);
    private static Outcome fast = new Outcome(new ArrayList<>(), Double.MAX_VALUE);
}
