package pack2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Readdatefromconfig {

	public void testCase() throws IOException {
		System.setProperty("webdriver.gecko.driver",
				"C:/Users/VIJAYA/git2/AutomationProject/AutomationProject/Drivers/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();

		// configuration properties file code
		String configFilePath = "C:\\Users\\VIJAYA\\git2\\AutomationProject\\AutomationProject\\Data\\config.properties";
		File f = new File(configFilePath);
		FileInputStream fi = new FileInputStream(f);
		Properties prop = new Properties();
		prop.load(fi);

		// String url=prop.getProperty("fbUrl");
		// System.out.println(url);

		driver.get(prop.getProperty("fbUrl"));
		driver.findElement(By.id(prop.getProperty("usernameTxtLocatorId"))).sendKeys(prop.getProperty("username"));
		driver.findElement(By.id(prop.getProperty("passwordTxtLocatorId"))).sendKeys(prop.getProperty("password"));
		driver.findElement(By.id(prop.getProperty("loginBtnLocatorId"))).click();

	}

	public static void main(String[] args) throws IOException {
		Readdatefromconfig r = new Readdatefromconfig();
		r.testCase();
	}
}
