import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import org.openqa.selenium.Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.firefox.FirefoxDriver

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.entity.global.GlobalVariableEntity

import internal.GlobalVariable

//GET FIREFOX DRIVER PATH
String dirPath = RunConfiguration.getProjectDir()
String firefoxDir = dirPath+'/Include/drivers/firefox_win64/geckodriver.exe'
System.setProperty('webdriver.gecko.driver', firefoxDir)
WebDriver driver = new FirefoxDriver()
DriverFactory.changeWebDriver(driver)

TestData input = findTestData('Data Files/ROLE/00-Role')

WebUI.maximizeWindow()
WebUI.navigateToUrl(GlobalVariable.url)
WebUI.delay(1)
WebUI.takeScreenshot()
WebUI.waitForElementClickable(findTestObject('Object Repository/Login/Input Username'), 0)

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
	
	WebUI.setText(findTestObject('Object Repository/Login/Input Username'), GlobalVariable.username)
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/Login/Input Password'), GlobalVariable.password)
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Login/Div Remember me'))
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/Login/Button Login'))
	WebUI.delay(1)
	WebUI.verifyTextPresent(input.getValue('alert-login', baris), false, FailureHandling.OPTIONAL)
	WebUI.delay(1)
	WebUI.takeScreenshot()
}
WebUI.closeBrowser()