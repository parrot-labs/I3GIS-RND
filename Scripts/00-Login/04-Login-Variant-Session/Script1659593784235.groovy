import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.keyword.builtin.CallTestCaseKeyword
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

TestData input = findTestData('Data Files/ROLE/00-Role')

WebUI.openBrowser(GlobalVariable.url)
WebUI.maximizeWindow()
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
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/Login/Button Login'))
	WebUI.waitForElementPresent(findTestObject('Object Repository/Login/Button Home'), 0, FailureHandling.OPTIONAL)
	WebUI.verifyElementClickable(findTestObject('Object Repository/Login/Button Home'), FailureHandling.OPTIONAL)
	WebUI.takeScreenshot()
	
	WebUI.callTestCase(findTestCase('Test Cases/00-Login/04-Login-Firefox'), null)
	WebUI.delay(1)
	//WebUI.callTestCase(findTestCase('Test Cases/00-Logout/00-Logout-sukses'), null)
	//WebUI.closeBrowser()
}