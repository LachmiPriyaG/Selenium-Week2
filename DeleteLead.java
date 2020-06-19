package Selenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DeleteLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
    	ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("http://leaftaps.com/opentaps");
		driver.findElementById("username").sendKeys("Demosalesmanager");
		driver.findElementById("password").sendKeys("crmsfa");
		driver.findElementByClassName("decorativeSubmit").click();
		
		driver.findElementByLinkText("CRM/SFA").click();
		driver.findElementByLinkText("Leads").click();
		
		
		//Delete Lead
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("//span[text()='Email']").click();
		driver.findElementByName("emailAddress").sendKeys("abc@xyz.com");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(30000);
		driver.findElementByXPath("(//a[@class='linktext'])[4]").click();	
		String leadid = driver.findElementById("viewLead_companyName_sp").getText();
		System.out.println("Lead Id is " + leadid);
		driver.findElementByLinkText("Delete").click(); // Delete
		driver.findElementByLinkText("Find Leads").click();
		String intValue = leadid.replaceAll("[^0-9]", "");
		driver.findElementByName("id").sendKeys(intValue);
		driver.findElementByXPath("//button[text()='Find Leads']").click();		
		Thread.sleep(10000);					
		driver.findElementByXPath("//div[text()='No records to display']");
	}

}
