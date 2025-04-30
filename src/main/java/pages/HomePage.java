package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import baseClass.BaseClass;

public class HomePage extends BaseClass{
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy (xpath="//div[@class='text']") WebElement txtuser;
	@FindBy (xpath="//input[contains(@class,'text')]") WebElement txtpass ;
	@FindBy (xpath="//div[contains(text(), 'text')]") WebElement sub;
	@FindBy (xpath="//inpupt[starts-with(@class, 'text')]") WebElement drop;
	@FindBy (xpath="//div[text()='name']") WebElement dd;
	@FindBy (xpath="//div[normalize-space()='text']") WebElement sam;
	@FindBy (xpath="//input[@type='text' and @class='mans']") List<WebElement> flag;
	
	public void signup(String name, String pass) {
		txtuser.sendKeys(name);
		txtpass.sendKeys(pass);
		sub.click();
		
		Select slt=new Select(drop);
		slt.selectByVisibleText("indian");
		slt.selectByIndex(1);
		slt.selectByValue("iip");
		
		WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(sam)).click();
		
		
		
	}
	
	public void verifyTitle() {
		Assert.assertEquals(driver.getTitle(), "store");
		Assert.assertTrue(dd.getText().contains(prop.getProperty("username")));
	}

}
