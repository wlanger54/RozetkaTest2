import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MainPage {



    private SelenideElement smartPhoneTvAndElectronic = $(By.xpath("//div[@class='menu-wrapper display-block menu-wrapper_state_static']//a[text()='Смартфоны, ТВ и электроника']"));



    public SmartPhoneTvAndElectronic redirectOn_smartPhoneTvAndElectronic() {
       smartPhoneTvAndElectronic.click();
        return page(SmartPhoneTvAndElectronic.class);
    }


}
