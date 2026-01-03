package christmas.util;

import static christmas.constant.ErrorMessage.DEFAULT_ERROR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {

    public static int stringToInt(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DEFAULT_ERROR.getErrorMessage());
        }
    }

    public static List<Integer> stringToInt(List<String> parsedNumber) {
        try {
            return parsedNumber.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(DEFAULT_ERROR.getErrorMessage());
        }
    }
}
