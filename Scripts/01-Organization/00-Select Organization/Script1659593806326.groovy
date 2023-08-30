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

for (int baris = 2; baris <= 2; baris++) {

	WebUI.click(findTestObject('Object Repository/01-Organization/01-Menu-Organization/Button_Organization'))
	WebUI.waitForElementPresent(findTestObject('Object Repository/01-Organization/01-Menu-Organization/Input SearchOrganization'), 0, FailureHandling.OPTIONAL)
	WebUI.takeScreenshot()
	WebUI.setText(findTestObject('Object Repository/01-Organization/01-Menu-Organization/Input SearchOrganization'), input.getValue('organization', baris))
	WebUI.delay(2)
	WebUI.waitForElementClickable(findTestObject('Object Repository/01-Organization/01-Menu-Organization/div Organization'), 0, FailureHandling.OPTIONAL)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/01-Organization/01-Menu-Organization/div Organization'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
		
}