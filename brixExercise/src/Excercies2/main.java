package Excercies2;


import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by serhan.i on 2019-08-18
 **/
public class main {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader("/Users/serhan.i/workspace/brixExercise/src/data.txt");
        BufferedReader bufferedReader =
                new BufferedReader(fileReader);
        String text = getFileData(bufferedReader);
        System.out.println(" please enter 5 chars");
        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));
        String alphanumerical = reader.readLine();
        Pattern r = Pattern.compile(getRegex(alphanumerical));

        Matcher m = r.matcher(text);
        if (m.find( )) {
            System.out.println("Found");
        }
        else
        {
            System.out.println("NO MATCH");
        }
    }

    private static String getFileData(BufferedReader bufferedReader) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        String tmpStr = null;
        while((tmpStr = bufferedReader.readLine()) != null) {
            stringBuilder.append(tmpStr);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    private static String getRegex(String alphanumerical) {
        StringBuilder str = new StringBuilder();
        List<String> added = new ArrayList<>();
        for (char c : alphanumerical.toCharArray()) {
            String theChar = Character.toString(c);
            if (!added.contains(theChar)) {
                added.add(theChar);
                str.append("(?=.+" + c + "){" + getCount(theChar, alphanumerical) + "}");
            }
        }
        return str.toString();
    }

    private static Integer getCount(String c, String alphanumerical) {
        return StringUtils.countOccurrencesOf(alphanumerical, c);
    }
}
