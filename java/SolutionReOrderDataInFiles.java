import java.util.ArrayList;
import java.util.List;

public class SolutionReOrderDataInFiles {

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterList = new ArrayList<>();
        List<String> digitList = new ArrayList<>();

        for(String log: logs){
            String splitted = log.split(" ", 2)[1];
            if(Character.isDigit(splitted.charAt(0))){
                digitList.add(log);
            } else {
                letterList.add(log);
            }

        }

        letterList.sort((s1, s2) -> {
            String[] s1Split = s1.split(" ", 2);
            String[] s2Split = s2.split(" ", 2);

            int compare = s1Split[1].compareTo(s2Split[1]);
            if(compare == 0){
                return s1Split[0].compareTo(s2Split[0]);
            }
            return compare;
        });

        letterList.addAll(digitList);

        return letterList.toArray(new String[0]);
    }
}
