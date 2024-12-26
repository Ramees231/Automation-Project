package pagepkg;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Curapage {
	WebDriver driver;
	@FindBy(xpath = "//*[@id=\"btn-make-appointment\"]")
	WebElement Apnmnt;

	@FindBy(xpath = "//*[@id=\"login\"]/div/div/div[2]/form/div[1]/div[1]/div/div/input")
	WebElement Usrdemo;

	@FindBy(xpath = "//*[@id=\"txt-username\"]")
	WebElement Username;

	@FindBy(xpath = "//*[@id=\"login\"]/div/div/div[2]/form/div[1]/div[2]/div/div/input")
	WebElement Passdemo;
	@FindBy(xpath = "//*[@id=\"txt-password\"]")
	WebElement Password;
	@FindBy(xpath = "//*[@id=\"btn-login\"]")
	WebElement Login;
	@FindBy(name="facility")
	WebElement Dpdown;
	@FindBy(xpath="//*[@id=\"chk_hospotal_readmission\"]")
	WebElement ckbox;
	@FindBy(xpath="//*[@id=\"radio_program_medicaid\"]")
	WebElement Rdbutton;
	@FindBy(xpath="//*[@id=\"txt_visit_date\"]")
	WebElement Vdate;
	@FindBy(xpath="/html/body/div/div[1]/table/thead/tr[2]/th[2]")
	WebElement Month;
	@FindBy(xpath="/html/body/div/div[1]/table/tbody/tr[4]/td[5]")
	List<WebElement> Day;
	@FindBy(xpath="/html/body/div/div[1]/table/thead/tr[2]/th[3]")
	WebElement Year;
	@FindBy(xpath="//*[@id=\"txt_comment\"]")
	WebElement Comment;
	@FindBy(xpath="//*[@id=\"btn-book-appointment\"]")
	WebElement Book;
	@FindBy(xpath="//*[@id=\"summary\"]/div/div/div[7]/p/a")
	WebElement Back;

	public Curapage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void click() {
		Apnmnt.click();
		
	}
	

	public void copyPaste() throws InterruptedException {
		Actions act=new Actions(driver);
		act.keyDown(Usrdemo,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		act.keyDown(Usrdemo,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		act.keyDown(Username,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		act.keyDown(Username,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);	
		act.keyDown(Passdemo,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		act.keyDown(Passdemo,Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL);
		act.keyDown(Password,Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL);
		act.keyDown(Password,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL);
		Thread.sleep(2000);
		act.perform();
		Login.click();
	}
	public void switchToNewWindow() {
		String currentWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for (String window : allWindows) {
			if (!window.equals(currentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}

	

	public void appointment() {
		Select dp=new Select(Dpdown);
		dp.selectByValue("Hongkong CURA Healthcare Center");
		ckbox.click();
		Rdbutton.click();
		Vdate.click();
		datePick("January 2025","23");

	}
	public void datePick(String expmonth,String expdate) {
		while(true) {
			
		String month=Month.getText();
		if(month.equals(expmonth)) {
			break;
		}
		else {
			Year.click();
		}
	}
	List<WebElement> date=Day;
	for(WebElement d:date)
	{
		String datetext=d.getText();
		if(datetext.equals(expdate))
		{
			d.click();
			break;
		}
	}

	}
	public void comnt(String comment) throws InterruptedException {
		Comment.sendKeys(comment);
		Book.click();
		Thread.sleep(2000);
		Back.click();
		
	}
	}