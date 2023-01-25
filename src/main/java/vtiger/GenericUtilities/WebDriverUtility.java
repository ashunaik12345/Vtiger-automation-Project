package vtiger.GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class consist of generic methods related to web driver actions
 * @author ASHWINI
 *
 */
public class WebDriverUtility {

	/**
	 * This method will maximize
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver) {
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize
	 * @param driver
	 */
	public void minimizeWindow(WebDriver driver) {
		driver.manage().window().minimize();
	}
	/**
	 * This method will wait for 20 seconds for all the elements to get loaded 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * This method will wait until a particular element becomes visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToVisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	 /**
	  * This element will wait until a particular element becomes click able
	  * @param driver
	  * @param element
	  */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * This method will handle drop down by using index
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index) {
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method will handle drop down by using value
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value) {
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * This method will handle drop down by using visible text
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element) {
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	/**
	 * This method will perform move to specified element
	 * @param driver
	 * @param element
	 */
	public void actionToMovetoElement(WebDriver driver,WebElement element) {
		Actions a=new Actions(driver);
		a.moveToElement(element);
	}
	/**
	 * This method will to perform a click operation
	 * @param driver
	 */
	public void actionToClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.click();
	}
	/**
	 * This method will to perform a click operation a particular element
	 * @param driver
	 * @param target
	 */
	public void actionToClick(WebDriver driver,WebElement target) {
		Actions act=new Actions(driver);
		act.click(target);
	}
	/**
	 * This method for double click on a any where on page
	 * @param driver
	 */
	public void actionToDoubleClick(WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick();
	}
	/**
	 * This method for the double click a particular element
	 * @param element
	 * @param driver
	 */
	public void actionToDoubleClick(WebElement element,WebDriver driver) {
		Actions act=new Actions(driver);
		act.doubleClick(element);
	}
	/**
	 * This method for the drag and drop operation
	 * @param driver
	 * @param source
	 * @param target
	 */
	public void actionToDargAndDrop(WebDriver driver,WebElement source,WebElement target) {
		Actions act=new Actions(driver);
		act.dragAndDrop(source, target);
	}
	/**
	 * This method will perform the right click action
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver) {
		Actions act=new Actions(driver);
		act.contextClick();
	}
	/**
	 * This method will perform right click on the particular element
	 * @param driver
	 * @param element
	 */
	public void actionRightClick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element);
	}
	/**
	 * This method will switch to frame based on the Index
	 * @param driver
	 * @param farmeIndex
	 */
	public void switchToFrame(WebDriver driver,int farmeIndex) {
		driver.switchTo().frame(farmeIndex);
	}
	/**
	 * This method will switch to frame based on the frame id number
	 * @param driver
	 * @param frameIdno
	 */
	public void switchToFrame(WebDriver driver,String frameIdno) {
		driver.switchTo().frame(frameIdno);
	}
	/**
	 * This method will switch to frame based on the element
	 * @param driver
	 * @param frameElement
	 */
	public void switchToFrame(WebDriver driver,WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	/**
	 * This method will switch to frame based on the parent frame
	 * @param driver
	 */
	public void switchToFrame(WebDriver driver) {
		driver.switchTo().parentFrame();
	}
	/**
	 * This method will switch to frame based on default content
	 * @param driver
	 */
	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	/**
	 * This method will switch to alert accept
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	/**
	 * This method will switch to alert dismiss
	 * @param driver
	 */
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	/**
	 * This method will switch to get alert get text method
	 * @param driver
	 * @return 
	 */
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	/**
	 * This method for get text 
	 * @param driver
	 * @return
	 */
	public String getText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	public void switchToWindow(WebDriver driver,String partialWinTitle) {
		//Step 1:capture all the window ID's
		Set<String> winIds = driver.getWindowHandles();
		
		//Step 2:extract indisual window Id
		for (String winID : winIds) {
			//Step 3:capture the current window Title
			String currentTitle = driver.switchTo().window(winID).getTitle();
			
			//Step 4: compare the current window Title with required title
			if(currentTitle.contains(partialWinTitle)){
				break;
			}
			
		}
	}
	/**
	 * THis method will take screenshots and store it in a folder
	 * @param driver
	 * @param screenShotname
	 * @throws IOException 
	 */
	public String takeScreenShot(WebDriver driver,String screenShotName) throws IOException {
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screenshots/"+screenShotName+".png");
		FileUtils.copyFile(src, dest);// from commons io dependency
		
		return dest.getAbsolutePath(); //extent reports
	}
	/**
	 * This method will scroll  the screen 
	 * @param driver
	 */
	public void scrollAction(WebDriver driver) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
	}
	/**
	 * This method will scroll the particular place
	 * @param driver
	 * @param element
	 */
	public void scrollAction(WebDriver driver,WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")", element);
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
