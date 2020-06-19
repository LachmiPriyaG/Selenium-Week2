package Selenium;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class EditLead {

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
		
			
		//Edit Lead
		driver.findElementByLinkText("Find Leads").click();
		driver.findElementByXPath("(//input[@name='companyName'])[2]").sendKeys("TestLeaf");
		driver.findElementByXPath("//button[text()='Find Leads']").click();
		Thread.sleep(30000);
		driver.findElementByXPath("(//a[@class='linktext'])[4]").click();
		driver.findElementByLinkText("Edit").click();
		String companyname = driver.findElementById("updateLeadForm_companyName").getAttribute("value");
		System.out.println("Company name is " + companyname);
		driver.findElementById("updateLeadForm_companyName").clear();
		driver.findElementById("updateLeadForm_companyName").sendKeys("TestLeaf OpenTaps");
		driver.findElementByXPath("//input[@value='Update']").click();
		
		
	}

}
