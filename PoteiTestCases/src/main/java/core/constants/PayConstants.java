package core.constants;

import java.time.LocalDate;

public interface PayConstants extends BaseConstantUserData{
    LocalDate date = java.time.LocalDate.now();
    String DEF_USER_EMAIL = "nikitaIvanovitc@gmail.com";
    Long DEF_NUMBER_CARD = 5536910016376277L;
    String DEF_DATE = "10"+"/"+date.getYear()+1;
    String ALERT_MESSAGE ="Thank you for using MasterCard!";

    Object[][] INVALID_NUMBER_CARD_LIST =
            new Object[][] {
                    {"1234"},
                    {"11111"},
                    {"text"},
                    {"55369100163"},
                    {".,/"},
                    {""},
            };

    Object[][] INVALID_DATE_CARD_LIST =
            new Object[][] {
                    {"50/27"},
                    {"21/21"},
                    {date.getMonth().getValue()-1+"/"+date.getYear()},
                    {"1234"},
                    {"11111"},
                    {"text"},
                    {"55369100163"},
                    {".,/"},
                    {""},
            };

}
