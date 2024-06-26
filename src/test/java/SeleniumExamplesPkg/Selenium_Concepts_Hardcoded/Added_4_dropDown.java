package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Added_4_dropDown{
	
	// This test case is very well written. Follow carefully.
	@Test
	public void check() throws InterruptedException
	{ 
		// TestCase: In "https://www.spicejet.com/": Ensure that 5 adults can be selected.
		  System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		  ChromeOptions options = new ChromeOptions();
		  options.addArguments("--remote-allow-origins=*"); 
		  WebDriver driver = new ChromeDriver(options);   // or only include this line without the 'options' argument & the System.setproperty() line (Using Selenium Manager)
		  driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		  
		  int wanted_numb_adults= 5; 
		  WebElement passengers_dropdown= driver.findElement(By.id("divpaxinfo"));
		  passengers_dropdown.click();
		  Thread.sleep(1000L); // As it takes time for the drop down to open up, let alone loading elements inside it. (Notice, it's a 'dropdown'; Neither a static dropdown
		  //nor a dynamic dropdown.
		  for(int i=0; i<wanted_numb_adults-1; i++)  // -1 as 1 adult is added by default. i=0, i=1, i=2, i=3 (meaning line of code will repeat 4 times==> cuz i= something is repeated 4 times
		  {
			  driver.findElement(By.id("hrefIncAdt")).click();
		  }
		  
		  // Now, it's CRUCIAL to verify that the wanted # of adults have ACTUALLY been selected = now displayed in the UI
		  String expected_displayed_adults= wanted_numb_adults + " Adult".toLowerCase(); //Adding .trim() is going to trim psace in front of " Adult"= failing assertion.
		  Assert.assertEquals(passengers_dropdown.getText().toLowerCase().trim(), expected_displayed_adults); 
	}
	
	// The below testcase was composed earlier than the above one. It may or may NOT needs to be refined
	@Test
	public void Added_dropdownTest() throws InterruptedException
	{
		// In: https://rahulshettyacademy.com/dropdownsPractise/"
		  // From the 'PASSENGERS' dropdown, select 3 adults and click on 'Done'
	    System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Third_Party_Browsers\\chromedriver-win64\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*"); 
		WebDriver driver = new ChromeDriver(options);   // or only include this line without the 'options' argument & the System.setproperty() line (Using Selenium Manager)
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// IMPORTANT: Open in-cognito if you encounter issues with elements on the web page.
		
		int wanted_adults_number= 3;
				
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(1000L); // As it takes time for the drop down to open up
		
		int i=0;
		while  (i<wanted_adults_number-1)        //i=0  i=1  // wanted_adults_number-1   since 1 adult is selected by default
		{
			driver.findElement(By.id("hrefIncAdt")).click();
			i++;
		}
		
		// or use for-loops instead:
		/*
		  for (int i=0; i<wanted_adults_number-1; i++)  // i=0  i=1         // wanted_adults_number-1   since 1 adult is selected by default
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		} 
		*/

		// Now- Check if the wanted adult numbers is correctly reflected onto the screen
		String arry[]= driver.findElement(By.id("divpaxinfo")).getText().split(" ");
		int actual_displayed_number_adults= Integer.parseInt(arry[0]);
				                   
		Assert.assertEquals(actual_displayed_number_adults, wanted_adults_number, "Actual displayed number of adults does NOT match the numbers of adults added by the script");
		
		Thread.sleep(3000L);
		driver.quit();
		
	}

}
