package ru.yandex.praktikum.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import ru.yandex.praktikum.page.MainPage;
import ru.yandex.praktikum.page.OrderPage;
import ru.yandex.praktikum.page.RentPage;

public class OrderTest {
    private WebDriver webDriver;


    @Before
    public void setup() {
        webDriver = new ChromeDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Test
    public void clientCreateOrderWithTopButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickCreateOrderTopButton();

        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustormerInfo("Дарья", "Леденева", "Москва,Складочная 1", "Савёловская", "88005553535");
        orderPage.clickNextButton();

        RentPage rentPage = new RentPage(webDriver);
        rentPage.clickRenOrderButton();


        rentPage.enterBringScooter();

        rentPage.enterPeriodInput();

        rentPage.enterRenPeriodMenu();

        rentPage.clickScooterColor();

        rentPage.enterCommentForCourier("Не сломайте самокат по дороге");

        rentPage.clickRenOrderButton();

        rentPage.clickButtonYesInput();

        rentPage.successOrderText();
    }

    @Test

    public void createOrderWithLowerButton() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickCreateOrderLowerButton();


        OrderPage orderPage = new OrderPage(webDriver);
        orderPage.fillCustormerInfo("Владимир", "Кузнецов", "Москва,Складочная 1", "Савёловская", "88005553535");
        orderPage.clickNextButton();

        RentPage rentPage = new RentPage(webDriver);
        rentPage.clickRenOrderButton();


        rentPage.enterBringScooter();

        rentPage.enterPeriodInput();

        rentPage.enterRenPeriodMenu();

        rentPage.clickScooterColor();

        rentPage.enterCommentForCourier("Не сломайте самокат по дороге");

        rentPage.clickRenOrderButton();

        rentPage.clickButtonYesInput();

        rentPage.successOrderText();
    }

    @After
    public void tearDown() {
        webDriver.quit();
    }
}



