package Selenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

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
		
		//Create Lead
		driver.findElementByLinkText("Create Lead").click();
		driver.findElementByXPath("//input[@id='createLeadForm_companyName']").sendKeys("TestLeaf");
		driver.findElementByXPath("(//input[@name='firstName'])[3]").sendKeys("LachmiPriya");
		driver.findElementByXPath("(//input[@name='lastName'])[3]").sendKeys("Ganesan");	
		Select selectsource = new Select (driver.findElementByName("dataSourceId"));
		selectsource.selectByValue("LEAD_EMPLOYEE");		
		driver.findElementByXPath("(//span[text()='Annual Revenue']/following::input)[1]").sendKeys("45000");
		Select selectownership = new Select (driver.findElementByName("ownershipEnumId"));
		selectownership.selectByVisibleText("S-Corporation");
		driver.findElementById("createLeadForm_description").sendKeys("Selenium Automation Tester");
		Select selectMC = new Select (driver.findElementByName("marketingCampaignId"));
		selectMC.selectByIndex(6);
		Select selectState = new Select (driver.findElementById("createLeadForm_generalStateProvinceGeoId"));
		selectState.selectByValue("TX");
		driver.findElementById("createLeadForm_primaryEmail").sendKeys("abc@xyz.com");
		driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("987654321");
		driver.findElementByXPath("//input[@value='Create Lead']").click();	

	}

}
