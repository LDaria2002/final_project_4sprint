package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class MainPage {
    public final WebDriver webDriver;
    private final String answerLocator = "//div[contains(@id, 'accordion__panel')][.='%s']";
    private final String questionLocator = "accordion__heading-%s";
    private By createOrderTopButtonLocator = By.xpath("//div[contains(@class,'Header')]/button[text()='Заказать']");
    private By createOrderLowerButtonLocator = By.xpath("//div[@class = 'Home_FinishButton__1_cWm']/button[text()='Заказать']");

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void expandQuestion(int index) {
        WebElement element = webDriver.findElement(By.id(String.format(questionLocator, index)));

        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);

        new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean answerIsDisplayed(String expectedAnswer) {
        WebElement element = webDriver.findElement(By.xpath(String.format(answerLocator, expectedAnswer)));
        return element.isDisplayed();
    }

    public void clickCreateOrderTopButton() {
        WebElement createOrderTopButton = webDriver.findElement(createOrderTopButtonLocator);
        // кнопка заказать в верхнем в правом углу на главной странице
        new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(createOrderTopButton));
        createOrderTopButton.click();
        //ожидание при нажатии на кнопку "Заказать" вверху
    }
    public void clickCreateOrderLowerButton() {
        WebElement createOrderLowerButton = webDriver.findElement(createOrderLowerButtonLocator);
        // кнопка заказать внизу страницы
        ((JavascriptExecutor)webDriver).executeScript("arguments[0].scrollIntoView();", createOrderLowerButton);

        new WebDriverWait(webDriver, Duration.ofSeconds(15))
                .until(ExpectedConditions.elementToBeClickable(createOrderLowerButton));
        createOrderLowerButton.click();
        //пролистать и кликнуть на кнопку заказать
    }
}




