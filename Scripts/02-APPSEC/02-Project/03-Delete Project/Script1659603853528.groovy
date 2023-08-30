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

TestData input = findTestData('Data Files/project')

WebUI.refresh()
WebUI.delay(3)
WebUI.takeScreenshot()


for (int baris = 1; baris <= 1; baris++) {

	WebUI.waitForElementClickable(findTestObject('Object Repository/AppSec/02-Summary Project/02-Menu Summary Project/Button Setting Project'), 0, FailureHandling.OPTIONAL)
	
//	String name = input.getValue('project-name', baris)
//	String result = name.toLowerCase();
//	WebUI.verifyTextPresent(result, false, FailureHandling.OPTIONAL)
	
	WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Menu Summary Project/Button Setting Project'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.scrollToElement(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Delete Project'), 0)
	WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Delete Project'), input.getValue('project-name', baris))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Button Delete'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Button-Yes, sure'))
	WebUI.delay(5)
	WebUI.verifyTextPresent('Project deleted successfully', false, FailureHandling.OPTIONAL)
	WebUI.delay(1)
	
}