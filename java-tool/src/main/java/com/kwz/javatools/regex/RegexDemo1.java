package javatools.regex;

import java.util.regex.Pattern;

/**
 * Description
 * Date 2021/7/13 23:42
 * Created by kwz
 */
public class RegexDemo1 {

    private static String likeBaiDuPattern = ".*baidu.*";

    public static void main(String[] args) {
        String content = "www.baidu.com.cn";
        boolean matches = Pattern.matches(likeBaiDuPattern, content);
        System.out.println(matches);
    }
}
