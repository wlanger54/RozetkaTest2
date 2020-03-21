import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.page;

public class PhoneHeadphonesGps {


    private SelenideElement mobilePhone = $x("//div[@class='portal-navigation__wrapper']//span[text()=' Мобильные телефоны ']");



    public MobilePhone_Page3 redirectOnMobilePhone(){
        mobilePhone.click();
        return page(MobilePhone_Page3.class);
    }


}
