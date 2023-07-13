package by.itacademy.filenkovvladislav.taf.kufar.pages;

public class LocatorsUI {

    protected String baseUrl = "https://www.kufar.by/";
    protected String buttonCookieByXpath = "//div[@class='styles_buttons__fA69m']/button";
    protected String buttonLoginByXpath = "//div[@data-testid='login_button']/button";
    protected String inputLoginById = "login";
    protected String inputPasswordById = "password";
    protected String buttonSubmitByXpath = "//div[@data-name='login_submit']/button";
    protected String iframePopUpByXpath = "/html/body/div[3]/div/div[3]/div/div/iframe";
    protected String buttonClosePopUpById = "control__close";
    protected String closePopUpByXpath = "//div[@class='lb61e5a9a']";
    public String alertEmptyEmailByXpath = "//div[text()='Заполните обязательное поле']";
    public String alertIncorrectEmailByXpath = "//div[text()='Проверьте введенный email - неправильный формат']";
    public String alertEmptyPasswordByXpath = "//div[text()='Введите пароль']";
    public String alertNoCombinationByXpath = "//p[text()='Введен неверный пароль либо такого профиля не существует']";
}
