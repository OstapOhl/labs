package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Regex {

    String text = " $gh-rt tuirbvrbvchbrudvlrenvbr,hv vnuvtn fhrufn $gh-rt fhrufrufhurhfurhfurhufhrufh " +
            "rt-hg $ fjrfnrjnfjrf $hutf-rg $hutf-rg$hutf-rg$hutf-rg $hutf-rg";
    String replaceWith = "_";


    public String replaceData() {

        Pattern pattern1 = Pattern.compile("\\s\\$\\w*(-)\\w*\\s");
        Matcher matcher = pattern1.matcher(text);

        String replaceFirstTry = text.replaceAll("\\s\\$\\w*(-)\\w*\\s", " (replaced) ");


        System.out.println("Default text: " + text);


        System.out.println("replaced text: " + replaceFirstTry);

        System.out.println("\ndone:");


        while (matcher.find()) {
            System.out.println(matcher.group().replaceAll("-", "="));
        }
        return replaceFirstTry.toString();
    }

}
