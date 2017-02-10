
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Task {

	@Test
	public static void message() throws InterruptedException 
	{
		//WebDriver driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","C:\\Users\\swetha\\exefiles\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://slack.com");

		//Sign details
		driver.findElement(By.linkText("Sign in")).click();

		//Domain details
		driver.findElement(By.id("domain")).sendKeys("swetha-team");
		driver.findElement(By.id("submit_team_domain")).click();

		//UserName&password
		driver.findElement(By.id("email")).sendKeys("madduri.swetha@gmail.com");
		driver.findElement(By.id("password")).sendKeys("swethamadduri");
		driver.findElement(By.id("signin_btn")).click();
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.id("msg_input"));
		element1.sendKeys("swethamadduri1");
		element1.sendKeys(Keys.ENTER);	
		
		Thread.sleep(3000);
		//WebDriverWait wait = new WebDriverWait(driver, 5);

		//*click
		List<WebElement> buttons = driver.findElements(By.xpath("//span[@class='message_star_holder']"));
		int no_of_buttons = buttons.size();

		buttons.get(no_of_buttons-1).click();
		
		//Search window
		WebElement element3 = driver.findElement(By.id("search_terms"));
		element3.sendKeys("has:star");
		element3.sendKeys(Keys.ENTER);
		
		
		//* stars_toggle
		Thread.sleep(2000);
		driver.findElement(By.id("stars_toggle")).click();
		
		List<WebElement> messages = driver.findElements(By.xpath(".//*[@id='member_stars_list']/div"));
		
	
		for(int i=0;i<messages.size();i++){
			
			String[] mess=messages.get(i).getText().split("\n");
			
			//System.out.println(mess);
			
			String newMessage = mess[0];
	
			System.out.println(newMessage);
			
			Assert.assertTrue(newMessage.contains("swethamadduri1"));
		}
		

		driver.close();
		//5i67df
		//901 238 370

	}
}
