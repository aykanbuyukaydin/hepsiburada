package hepsiburadaProject.stepdefinitions;

import hepsiburadaProject.pages.UIPage;
import hepsiburadaProject.utilities.ConfigReader;
import hepsiburadaProject.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.python.modules.itertools.product;
import org.sikuli.hotkey.Keys;
import org.testng.Assert;

import java.util.List;
import java.util.Set;

public class UIStepDefs {
    String firstWindow="";
    String secondWindow="";
    UIPage uiPage = new UIPage();

    @Given("Kullanici {string} sitesine gider")
    public void kullanici_sitesine_gider(String url) throws InterruptedException {
        Driver.getDriver().get(ConfigReader.getProperty(url));
        Thread.sleep(2000);
    }

    @Then("Kullanici {string} icin arama islemi yapar")
    public void kullanici_icin_arama_islemi_yapar(String product) throws InterruptedException {
        uiPage.searchBox.sendKeys(product);
        Thread.sleep(1000);
        uiPage.araButton.click();
    }

    @Then("Kullanici arama sonucunda gelen ilk urune gider")
    public void kullanici_arama_sonucunda_gelen_ilk_urune_gider() throws InterruptedException {
        firstWindow=Driver.getDriver().getWindowHandle();
        Thread.sleep(2000);
        uiPage.firstProduct.click();
        Set<String> windows = Driver.getDriver().getWindowHandles();
        for (String each: windows) {
            if (!each.equals(firstWindow)){
                secondWindow=each;
            }
        }
        Driver.getDriver().switchTo().window(secondWindow);
    }

    @When("Kullanici gidilen urundeki {string} tabina tiklar")
    public void kullanici_gidilen_urundeki_tabina_tiklar(String tab) throws InterruptedException {
        Thread.sleep(2000);
        List<WebElement> productTabs = uiPage.productTab;
        for (int i = 0; i < productTabs.size(); i++) {
            if(productTabs.get(i).getText().contains(tab) && productTabs.get(i).getText().substring(18).equals("0")){
                System.out.println("Bu urune ait degerlendirme yok");
                kullanici_sayfayi_kapatir();
            }else if (productTabs.get(i).getText().contains(tab) && !(productTabs.get(i).getText().substring(18).equals("0"))) {
                productTabs.get(i).click();
                break;
            }
        }
    }

    @When("Kullanici gelen yorumlar icerisinde ilk degerlendirmenin {string} butonuna tiklar")
    public void kullanici_gelen_yorumlar_icerisinde_ilk_degerlendirmenin_butonuna_tiklar(String button) throws InterruptedException {
        Thread.sleep(3000);
        if(button.equals("Evet")){
            Actions action = new Actions(Driver.getDriver().switchTo().window(secondWindow));
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            Thread.sleep(3000);
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            uiPage.yesButton.click();
        }else if(button.equals("Hayır")){
            Actions action = new Actions(Driver.getDriver().switchTo().window(secondWindow));
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            Thread.sleep(3000);
            action.sendKeys(Keys.PAGE_DOWN).build().perform();
            uiPage.noButton.click();
        }else{
            Assert.assertTrue(false);
        }
    }

    @Then("Kullanici {string} yazisini gorur")
    public void kullanici_yazisini_gorur(String script) throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("message: " + uiPage.script.getText());
        System.out.println(uiPage.script.getText().equals(script));
        Assert.assertTrue(uiPage.script.getText().equals(script));
    }

    @Then("Kullanici sayfayi kapatir")
    public void kullanici_sayfayi_kapatir() {
        Driver.getDriver().quit();
    }
}
