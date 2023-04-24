package 해시.걸그룹마스터준석이;
//https://www.acmicpc.net/problem/16165
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");

        int girlGroups = Integer.parseInt(input[0]);
        int quizzes = Integer.parseInt(input[1]);

        Map<String,List<String>> gGMap = new HashMap<>();

        for(int i=0; i<girlGroups; i++){
            List<String> girlsName = new ArrayList<>();
            String groupName = bf.readLine();
            int count = Integer.parseInt(bf.readLine());

            for(int j=0; j<count; j++){
                girlsName.add(bf.readLine());
            }
            girlsName.sort(String::compareTo);
            gGMap.put(groupName, girlsName);
        }

        List<String> quizName = new ArrayList<>();
        List<String> quizType = new ArrayList<>();

        for(int i=0; i<quizzes; i++){
            quizName.add(bf.readLine());
            quizType.add(bf.readLine());
        }

        for(int i=0; i<quizName.size(); i++){
            if("0".equals(quizType.get(i))){
                List<String> members = gGMap.get(quizName.get(i));
                members.forEach(System.out::println);
            }else if("1".equals(quizType.get(i))){
                int finalI = i;
                System.out.println(gGMap.entrySet().stream()
                    .filter(map -> map.getValue().contains(quizName.get(finalI)))
                    .map(Map.Entry::getKey).collect(Collectors.joining()));
            }
        }
    }
}
