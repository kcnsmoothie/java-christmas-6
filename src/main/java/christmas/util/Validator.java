package christmas.util;

import static christmas.constant.ErrorMessage.DATE_ERROR;
import static christmas.constant.ErrorMessage.DEFAULT_ERROR;

import christmas.constant.Menu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    public static void validateNumberRange(int number){
        if (number < 1 || number > 31) {
            throw new IllegalArgumentException(DATE_ERROR.getErrorMessage());
        }
    }

    public static void validateAmount(int number){
        if (number < 1) {
            throw new IllegalArgumentException(DEFAULT_ERROR.getErrorMessage());
        }
    }
}
