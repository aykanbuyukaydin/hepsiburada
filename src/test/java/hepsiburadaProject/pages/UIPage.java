package hepsiburadaProject.pages;

import hepsiburadaProject.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UIPage {
    public UIPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement searchBox;

    @FindBy(xpath = "//div[@class='SearchBoxOld-cHxjyU99nxdIaAbGyX7F']")
    public WebElement araButton;

    @FindBy(xpath = "//li[@id='i0']")
    public WebElement firstProduct;

    @FindBy(xpath = "/html/body/div[2]/main/div[3]/section[3]/div/div/table/tbody/tr/td")
    public List<WebElement> productTab;

    @FindBy(xpath = "(//div[@class='thumbsUp hermes-ReviewCard-module-lOsa4wAwncdp3GgzpaaV'])[1]")
    public WebElement yesButton;

    @FindBy(xpath = "(//div[@class='thumbsUp hermes-ReviewCard-module-lOsa4wAwncdp3GgzpaaV'])[2]")
    public WebElement noButton;

    @FindBy(xpath = "(//span[@class='hermes-ReviewCard-module-eFtSSTU4lYZLCnzHtzca'])[1]")
    public WebElement script;



}
