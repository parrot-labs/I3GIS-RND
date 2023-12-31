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
import com.kms.katalon.core.testobject.ConditionType as ConditionType

	
	WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Scan Project/Button Scan Project'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	
	if(WebUI.verifyTextPresent('Please update your code', false, FailureHandling.OPTIONAL) == true) {
		WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Scan Project/Scanning Progres'))
	}
	
	boolean scanning = true
	while (scanning == true) {
		scanning = WebUI.verifyTextPresent('Getting logs scan please wait...', false, FailureHandling.OPTIONAL)
	}
	WebUI.scrollToPosition(400, 0)
	
	//MISCONF
	boolean wait = true
	while (wait == true) {
		
		TestObject data_warna = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div/div[3]/div[2]/div/div/div/div[2]/div[1]/div[9]/div")
	
		String css_color = WebUI.getCSSValue(data_warna, 'background-color', FailureHandling.OPTIONAL)
		println(css_color)
		wait = WebUI.verifyEqual(css_color, GlobalVariable.grey,FailureHandling.OPTIONAL)
	}
	WebUI.takeScreenshot()
	boolean misconf = true
	while (misconf == true) {
		
		TestObject warna_misconf = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div/div[3]/div[2]/div/div/div/div[2]/div[1]/div[9]/div")
	
		String color_misconf = WebUI.getCSSValue(warna_misconf, 'background-color', FailureHandling.OPTIONAL)
		println(color_misconf)
		misconf = WebUI.verifyEqual(color_misconf, GlobalVariable.Blue,FailureHandling.OPTIONAL)
	}
	
	WebUI.delay(2)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Scan Project/Button See Result'))
	WebUI.delay(2)	
	if (WebUI.verifyTextPresent('Close', false, FailureHandling.OPTIONAL) == true)	{
		WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Scan Project/Button Close'))
		WebUI.delay(1)
	}
	WebUI.verifyTextPresent('SCAN SUCCESS', false, FailureHandling.OPTIONAL)
	WebUI.takeScreenshot()