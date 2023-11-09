package christmas.Controller;

import christmas.View.OutputView;
import christmas.View.InputView;
import christmas.Model.PrintContentTitleList;
import christmas.Model.ErrorsList;
import christmas.Model.ValidationInput;

public class ChristmasEventController {
    public void run () {
        validateDate();
    }

    private void validateDate () {
        OutputView.printGreeting();
        while(true) {
            try {
                int date = ValidationInput.isInteger(InputView.printInputDate());
                ValidationInput.isInvalidDate(date);
            } catch (IllegalArgumentException e) {
                OutputView.printContent(e.getMessage());
            }
        }
    }

}
