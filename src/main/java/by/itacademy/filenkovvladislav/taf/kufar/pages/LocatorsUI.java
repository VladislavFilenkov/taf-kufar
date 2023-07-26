package by.itacademy.filenkovvladislav.taf.kufar.pages;

public class LocatorsUI {

    protected String baseUrl = "https://www.kufar.by/";
    protected String buttonCookieByXpath = "//div[@class='styles_buttons__fA69m']/button";
    protected String buttonCookie2ByXpath = "//button[@class='styles_button__oKUgO styles_outline__maWFU styles_block___PraQ']";
    protected String buttonLoginByXpath = "//div[@data-testid='login_button']/button";
    protected String inputLoginById = "login";
    protected String inputPasswordById = "password";
    protected String buttonSubmitByXpath = "//div[@data-name='login_submit']/button";
    protected String iframePopUpByXpath = "//div[contains(@style, 'z-index: 999999;')]//iframe";
    protected String buttonClosePopUpById = "control__close";
    public String alertEmptyEmailByXpath = "//div[text()='Заполните обязательное поле']";
    public String alertIncorrectEmailByXpath = "//div[text()='Проверьте введенный email - неправильный формат']";
    public String alertEmptyPasswordByXpath = "//div[text()='Введите пароль']";
    public String alertNoCombinationByXpath = "//form[@data-name='form_login']//p";
}
