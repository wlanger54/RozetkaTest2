import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class SmartPhoneTvAndElectronic {

    private SelenideElement smartPhone = $x("//ul[@class='portal-grid portal-grid_type_1_3']//a[text()=' Телефоны, наушники, GPS ']");

    public PhoneHeadphonesGps redirectOnSmartPhone(){
        smartPhone.scrollTo().click();
        return page(PhoneHeadphonesGps.class);
    }
}
