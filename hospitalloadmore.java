import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class hospitalloadmore {

	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\TestAutomation\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver =  new ChromeDriver();
        driver.get("https://westbengal.covidsafe.in/");
        driver.manage().window().maximize();
        
	   int numberOfhosp = driver.findElements(By.xpath("//tbody/tr")).size();
	   System.out.println("name of the hospital is : "+numberOfhosp);
			
		for(int i=1; i<=numberOfhosp;i++)
		{
								
			//Number of Hospital
			WebElement hospNameEle = driver.findElement(By.xpath("//tr["+i+"]//strong"));
			String hospName = hospNameEle.getText();
			System.out.println("name of the hospital is : "+hospName);
			
			//withoutoxygen
			WebElement WithoutOxygenEle = driver.findElement(By.xpath("//tr["+i+"]/td[2]//span"));
			String WithoutOxygen = WithoutOxygenEle.getText();
			System.out.println("Number of Beds Without Oxygen : "+WithoutOxygen);
			
			//withoxygen
			WebElement WithOxygenEle = driver.findElement(By.xpath("//tr["+i+"]/td[3]//span"));
			String WithOxygen = WithOxygenEle.getText();
			System.out.println("Number of Beds With Oxygen : "+WithOxygen);
			
			
			//WithoutICU ventilator
			WebElement ICUwithoutVenEle = driver.findElement(By.xpath("//tr["+i+"]/td[4]//span"));
			String ICUwithoutVen = ICUwithoutVenEle.getText();
			System.out.println("Number of Beds Without ICU Ventilator : "+ICUwithoutVen);
			
			//With ICU Ventilator
			WebElement ICUwithVenEle = driver.findElement(By.xpath("//tr["+i+"]/td[5]//span"));
			String ICUwithVen = ICUwithVenEle.getText();
			System.out.println("Number of Beds With ICU Ventilator : "+ICUwithVen);
			
			int j= i+1;
			
			driver.findElement(By.xpath("//tr["+i+"]//strong")).click();  
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
  
			Thread.sleep(1000);
			WebElement PhoneEle = driver.findElement(By.xpath("//tr["+j+"]/td/p[2]/span"));
			String Phone = PhoneEle.getText();
			System.out.println("Hospital "+Phone);
			
			WebElement PinCodeEle = driver.findElement(By.xpath("//tr["+j+"]/td/p[3]//span"));
			String PinCode = PinCodeEle.getText();
			System.out.println("Hospital " +PinCode);
			js.executeScript("arguments[0].scrollIntoView();", PinCodeEle);
			
			WebElement AddressEle = driver.findElement(By.xpath("//tr["+j+"]/td/p[4]//span"));
			String Address = AddressEle.getText();
			System.out.println("Hospital "+Address);
			
			//Scroll Down to the address element
			//js.executeScript("arguments[0].scrollIntoView();", AddressEle);
						
			driver.findElement(By.xpath("//tr["+i+"]//strong")).click();
	    
			if (i==numberOfhosp)
			{
				driver.findElement(By.xpath("//button[contains(text(),'Load next 20')]")).click();
				int numberOfhospload = driver.findElements(By.xpath("//tbody/tr")).size();
				numberOfhosp = numberOfhospload;
			}
			//scroll down to the hospital name element
			js.executeScript("arguments[0].scrollIntoView();", hospNameEle);
		
		}
	}
}
