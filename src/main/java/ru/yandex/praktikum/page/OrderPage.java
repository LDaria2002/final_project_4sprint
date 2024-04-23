package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class OrderPage {
    private final WebDriver webDriver;
    private final By nameLocator = By.xpath("//input[@placeholder='* Имя']");
    private final By lastNameLocator = By.xpath(".//input[@placeholder='* Фамилия']");
    private final By ClientOrderAddress = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    private final By subwayLocator = By.xpath("//input[@placeholder='* Станция метро']");
    private final By phoneLocator = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");
    private final By nexButtonLocator = By.xpath("//button[text()='Далее']");
    private final String MenuInputLocator = "//div[text()='%s']";

    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void fillCustormerInfo(String name, String lastname, String address, String subwayTitle, String phone) {

        WebElement nameInput = webDriver.findElement(nameLocator);
        nameInput.sendKeys(name);
//Ввод имени на странице  "Для кого самокат"

        WebElement lastNameInput = webDriver.findElement(lastNameLocator);
        lastNameInput.sendKeys(lastname);
// Ввод фамилии на странице  "Для кого самокат"

        WebElement orderAddress = webDriver.findElement(ClientOrderAddress);
        orderAddress.sendKeys(address);
//Ввод в поле "Адрес" куда доставить самокат на странице  "Для кого самокат"

        WebElement subwayInput = webDriver.findElement(subwayLocator);
        subwayInput.click();
//Тап на поле "Станция метро" на странице  "Для кого самокат"
        WebElement arbatskayStationMenu = webDriver.findElement(By.xpath(String.format(MenuInputLocator, subwayTitle)));

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", arbatskayStationMenu);
        arbatskayStationMenu.click();
//Выбор станции метро для доставки самоката на странице  "Для кого самокат"

        WebElement phoneNumber = webDriver.findElement(phoneLocator);
        phoneNumber.sendKeys(phone);
        //Ввод номера телефона на странице  "Для кого самокат"
    }

    public void clickNextButton() {
        WebElement nextButton = webDriver.findElement(nexButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(15)).until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();
//Кнопка "Далее" на странице  "Для кого самокат"
    }
}

