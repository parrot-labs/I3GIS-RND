import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType

TestData input = findTestData('Data Files/DAST')

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
	
	WebUI.click(findTestObject('Object Repository/07-DAST/Button-DAST'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-DAST/Button-SiteScan'))
	WebUI.delay(1)
	WebUI.waitForElementClickable(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Button-CreateSites'), 0)
	WebUI.takeScreenshot()
	WebUI.sendKeys(findTestObject('Object Repository/07-DAST/Sites/Input-NameSite'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Object Repository/07-DAST/Sites/Input-NameSite'), Keys.chord(Keys.BACK_SPACE))
	if(input.getValue('site-type', baris)== 'API') {
		WebUI.setText(findTestObject('Object Repository/07-DAST/Sites/Input-NameSite'), input.getValue('site-name-api', baris))
		WebUI.delay(1)
	}else {
		WebUI.setText(findTestObject('Object Repository/07-DAST/Sites/Input-NameSite'), input.getValue('site-name', baris))
		WebUI.delay(1)
	}
	WebUI.click(findTestObject('Object Repository/07-DAST/Sites/div-Sites'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.setText(findTestObject('Object Repository/07-DAST/Issue-Context/Input-SearchContextName'), input.getValue('context', baris))
	WebUI.delay(1)
	
	WebUI.click(findTestObject('Object Repository/07-DAST/Sites/Button-Scan Context'))
	WebUI.delay(5)
	WebUI.takeScreenshot()
	WebUI.verifyTextPresent('Scan Running, Please Wait..', false, FailureHandling.OPTIONAL)
	boolean instance = true
	while (instance == true) {
		instance = WebUI.verifyTextPresent('STARTING INSTANCE', false, FailureHandling.OPTIONAL)
	}
	boolean discurl = true
	while (discurl == true) {
		discurl = WebUI.verifyTextPresent('DISCOVERING URL YOUR SITE', false, FailureHandling.OPTIONAL)
	}
	boolean running = true
	while (running == true) {
		running = WebUI.verifyTextPresent('SCAN RUNNING', false, FailureHandling.OPTIONAL)
	}
	WebUI.delay(10)
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Div-Context'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/div_Latest Scan Version'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Button-See Detail'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	
	for (int div = 1; div <= 10; div++) {
		isbreak = false
		TestObject url = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div[2]/div[1]/div/div[3]/div[1]/table/tbody/tr[$div]/td[2]/div")
		String urlpars = WebUI.getText(url)
		println(urlpars)
		if(urlpars == GlobalVariable.urlweb) {
			
			isbreak = true
			break;
		}
	}
	TestObject button = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div[2]/div[1]/div/div[3]/div[1]/table/tbody/tr[1]/td[3]/button")
	String textbutton = WebUI.getText(button)
	
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/See-Detail/Detail-Method'))
	WebUI.delay(5)
	WebUI.takeScreenshot()
	String textStatus = WebUI.getText(findTestObject('Object Repository/07-DAST/Issue-Context/See-Detail/Verify-Status'))
	WebUI.verifyEqual(textbutton, textStatus, FailureHandling.STOP_ON_FAILURE)
}