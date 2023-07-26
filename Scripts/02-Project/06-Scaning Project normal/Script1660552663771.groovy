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

	
	WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Scan Project/Button Scan Project'))
	WebUI.delay(1)
	
	if(WebUI.verifyTextPresent('Please update your code', false, FailureHandling.OPTIONAL) == true) {
		WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Scan Project/Scanning Progres'))
	}
	
	boolean scanning = true
	while (scanning == true) {
		scanning = WebUI.verifyTextPresent('Getting logs scan please wait...', false, FailureHandling.OPTIONAL)
	}
	WebUI.scrollToPosition(200, 0)
	boolean wait = true
	while (wait == true) {
		
		TestObject data_warna = findTestObject('Object Repository/AppSec/02-Summary Project/02-Scan Project/Color Scanning')
	
		String css_color = WebUI.getCSSValue(data_warna, 'background-color', FailureHandling.OPTIONAL)
		//println(css_color)
		wait = WebUI.verifyEqual(css_color, GlobalVariable.grey,FailureHandling.OPTIONAL)
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