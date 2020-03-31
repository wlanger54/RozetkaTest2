import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;

import static com.codeborne.selenide.Selenide.*;

public class MobilePhone_Page3 {


    private SelenideElement moreProducts = $x("//div[@class='catalog-more']//span[text()=' Показать еще 60 товаров ']"),
            namePage = $x("//h1[text()=' Мобильные телефоны ']");
    private ElementsCollection topProducts = $$x("//span[contains(@class,'promo-label_type_popularity')]/ancestor::div[@class='goods-tile']");

    private SelenideElement selectFilter = $(By.xpath("//select[@class='select-css ng-untouched ng-pristine ng-valid']")),
            selectFilterFromCheapToExpensive = $(By.xpath("//option[text()=' От дешевых к дорогим ']"));

    private ElementsCollection productsFromCheapOnExpensive = $$x(".//span[@class='goods-tile__price-value']");



    private ArrayList<String> listTopProducts = new ArrayList<String>();


    public MobilePhone_Page3 clickOnButtonMoreProducts() {
        namePage.shouldBe(Condition.visible);
        moreProducts.click();
        return this;
    }


    public MobilePhone_Page3 getNameAndPriceTopProducts() {
        if (topProducts.size() > 0) {
            for (SelenideElement divTop : topProducts) {
                String name = divTop.$x(".//a[@class='goods-tile__heading']").getAttribute("title");
                String price = divTop.$x(".//span[@class='goods-tile__price-value']").getText().replaceAll("\\s*", "");
                String writeFile = String.format("%s\t%s\r\n", name, price);
                listTopProducts.add(writeFile);
                System.out.println(writeFile);
            }

        }
        return this;
    }


    public MobilePhone_Page3 saveInFileNameAndPrice() throws Exception {
        FileWriter fileWriter = new FileWriter("C:\\autodoc\\result.txt");
        for (String divTopWrite : listTopProducts) {
            fileWriter.write(divTopWrite);
        }
        fileWriter.close();
        return this;

    }

//   Сортируем от Дешевых к Дорогим


    public MobilePhone_Page3 openSelectFilter() {
        selectFilter.click();
        return this;
    }

    public MobilePhone_Page3 sortPageFromCheapToExpensive() {
        selectFilterFromCheapToExpensive.click();
        sleep(2000);
        return this;
    }



    public MobilePhone_Page3 getProductsFromCheapToExpensive(){
        ArrayList<Double> listForSortProducts = new ArrayList<Double>();
        for (SelenideElement min:productsFromCheapOnExpensive) {
            double price = Double.parseDouble(min.getText().replaceAll("\\s*", ""));

            listForSortProducts.add(price);
            System.out.println(price);
        }

        ArrayList<Double> listForSortProducts_2 = new ArrayList(listForSortProducts);
        Collections.sort(listForSortProducts_2);
        Assert.assertEquals(listForSortProducts, listForSortProducts_2);

        System.out.println(listForSortProducts_2);

        return this;

    }




}
