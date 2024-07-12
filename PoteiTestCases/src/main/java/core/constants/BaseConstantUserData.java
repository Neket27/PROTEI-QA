package core.constants;

public interface BaseConstantUserData {
    String DEF_USER_FULL_NAME = "Nikita K";

    String DEF_USER_EMAIL = "neket@gmail.com";

    String DEF_USER_PASSWORD = "Qwas1234";

    Object[][] INVALID_FUll_NAME_LIST =
            new Object[][] {
                    {"1234"},
                    {"1"},
                    {"xxxx1"},
                    {".,/"},
                    {"emailgmail.com"},
                    {"email@com"},
                    {""},
            };

    Object[][] INVALID_EMAIL_LIST =
            new Object[][] {
                    {"emailgmail.com"},
                    {"email@com"},
                    {"email"},
                    {".,/"},
                    {""},
            };

    Object[][] INVALID_PASSWORD_LIST =
            new Object[][] {
                    {"1234"},
                    {"1"},
                    {"xxxx1"},
                    {".,/"},
                    {""},
            };
}
