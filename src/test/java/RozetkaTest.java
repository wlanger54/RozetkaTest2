import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class RozetkaTest {

    @BeforeMethod
    public void setUp() {
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        open("https://rozetka.com.ua/");
    }



    @Test
    public void runRozetka() throws Exception {
       new MainPage().redirectOn_smartPhoneTvAndElectronic()
               .redirectOnSmartPhone()
               .redirectOnMobilePhone()
               .clickOnButtonMoreProducts()
               .clickOnButtonMoreProducts()
               .getNameAndPriceTopProducts();

             new MobilePhone_Page3().saveInFileNameAndPrice()
               .openSelectFilter()
               .sortPageFromCheapToExpensive()
               .getProductsFromCheapToExpensive();
    }





    @AfterMethod
    public void turnDown(){
        close();
    }












}
