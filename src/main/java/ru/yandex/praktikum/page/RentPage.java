package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class RentPage {
    private final WebDriver webDriver;
    private final By bringScooterLocator = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    private final By PeriodLocator = By.xpath("//div[text()='* Срок аренды']");
    private final By renPeriodLocator = By.xpath("//div[text()='двое суток']");
    private final By scooterColorLocator = By.xpath("//input[@id='black']");
    private final By commentForCourierLocator = By.xpath("//input[@placeholder= 'Комментарий для курьера']");
    private final By creatOrderButtonLocator = By.xpath("//div[contains(@class,'Order')]/button[text()='Заказать']");
    private final By buttonYesInputLocator = By.xpath("//div[contains(@class,'Order')]/button[text()='Да']");
    private final By successOrder = By.xpath("//div[text()='Заказ оформлен']");

    public RentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void enterBringScooter() {
        WebElement bringScooter = webDriver.findElement(bringScooterLocator);
        bringScooter.sendKeys("22.04.2024", Keys.ENTER);
//Выбор даты аренды из календаря на странице "Про аренду"

    }

    public void enterPeriodInput() {
        WebElement renPeriodInput = webDriver.findElement(PeriodLocator);
        renPeriodInput.click();
//Нажатие на поле "Срок аренды" на странице "Про аренду"
    }

    public void enterRenPeriodMenu() {
        WebElement renPeriodMenu = webDriver.findElement(renPeriodLocator);
        renPeriodMenu.click();
// Выбор срока аренды ( количество суток) на странице "Про аренду"
    }

    public void clickScooterColor() {
        WebElement scooterColor = webDriver.findElement(scooterColorLocator);
        scooterColor.click();
        // выбор цвета самоката на странице "Про аренду"
    }

    public void enterCommentForCourier(String commentInput) {
        WebElement commentForCourier = webDriver.findElement(commentForCourierLocator);
        commentForCourier.sendKeys(commentInput);
        // Комментарий для курьера на странице "Про аренду"
    }

    public void clickRenOrderButton() {
        WebElement creatOrderButton = webDriver.findElement(creatOrderButtonLocator);
        new WebDriverWait(webDriver, ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(creatOrderButton));
        creatOrderButton.click();
        //Кнопка заказать на странице "Про аренду"
    }

    public void clickButtonYesInput() {
        WebElement buttonYesInput = webDriver.findElement(buttonYesInputLocator);
        buttonYesInput.click();
//Кнопка да в окне "Хотите оформить заказ?"
    }

    public void successOrderText () {
        WebElement checkSuccessOrderText = webDriver.findElement(successOrder);
    }
}
