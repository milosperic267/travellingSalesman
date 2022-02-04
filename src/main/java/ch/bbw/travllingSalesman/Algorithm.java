package ch.bbw.travllingSalesman;

import java.util.ArrayList;

public class Algorithm {
    public void RunForAllCombinations(RunForAllFunction runForAllFunction, ArrayList<Coordinates> coordinates, ArrayList<Coordinates> combination){
        if (coordinates.size() > 0){
            for (int i = 0; i < coordinates.size(); i++){
                ArrayList<Coordinates> newList = (ArrayList<Coordinates>) coordinates.clone();
                combination.add(newList.get(i));
                newList.remove(i);
                RunForAllCombinations(runForAllFunction, newList, combination);
                combination.remove(combination.size() - 1);
            }
            return;
        }

        runForAllFunction.RunForAll(combination);
    }
}
