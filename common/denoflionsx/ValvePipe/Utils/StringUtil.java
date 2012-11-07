package common.denoflionsx.ValvePipe.Utils;

public class StringUtil {
    
    public static String removeWhitespace(String input){
        return input.replaceAll("\\s","");
    }
    
    public static String removeWhiteSpaceLowerCase(String input){
        return removeWhitespace(input).toLowerCase();
    }
}
