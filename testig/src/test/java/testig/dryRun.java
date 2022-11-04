package testig;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class dryRun {
	static WebDriver driver;
	static String driverlocation = "C:\\Antony\\Driver\\chromedriver.exe";
	static String movie = "bigil";
	public static void main(String[] args) {
		dryRun dry = new dryRun();
		dry.launchbrowser();
		// TODO Auto-generated method stub

	}
	public void launchbrowser()
	{
		System.setProperty("webdriver.chrome.driver", driverlocation);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com");
		String title = driver.getTitle();
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(movie);
		driver.findElement(By.xpath("/html/body/div[1]/div[3]/form/div[1]/div[1]/div[4]/center/input[1]")).click();
		System.out.println(title);
		WebElement imdb = driver.findElement(By.xpath("(//a[contains(@href,'imdb.com')])[1]"));
		String imdbUrl = imdb.getAttribute("href");
		System.out.println(imdbUrl);
		WebElement wiki = driver.findElement(By.xpath("(//a[contains(@href,'wikipedia')])[1]"));
		String wikiUrl = wiki.getAttribute("href");
		System.out.println(wikiUrl);
		driver.get(imdbUrl);
		String imdbreleasedate = driver.findElement(By.xpath("//a[contains(text(), 'Release date')]/following-sibling::div//ul/child::li/a")).getText();
		System.out.println(imdbreleasedate);
		String imdbreleasecountry = driver.findElement(By.xpath("//span[contains(text(), 'Country of origin')]/parent::li/div/child::ul/li/a")).getText();
		System.out.println(imdbreleasecountry);
	}
	

}
