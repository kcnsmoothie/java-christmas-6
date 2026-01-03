package christmas.util;

import static christmas.constant.ErrorMessage.DEFAULT_ERROR;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    public static void validateNumberRange(int number){
        if (number < 1 || number > 31) {
            throw new IllegalArgumentException(DEFAULT_ERROR.getErrorMessage());
        }
    }
}
