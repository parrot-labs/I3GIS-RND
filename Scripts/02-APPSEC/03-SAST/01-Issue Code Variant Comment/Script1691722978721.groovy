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

TestData input = findTestData('Data Files/AppSec-Issuecode')

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
	
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Issue Code/Button Comment'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/03-SAST/03-Issues Code/Issue Code/Input Comment'), input.getValue('Comment', baris))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Issue Code/Comment Save'))
	WebUI.delay(1)
	WebUI.verifyTextPresent(input.getValue('verify-comment', baris), false, FailureHandling.OPTIONAL)
	WebUI.takeScreenshot()
}

TestObject issue = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/ul/div/ul/li[1]/div[2]/div[2]/div")
String text = WebUI.getText(issue)

WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Issue Code/Button Statuses'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Issue Code/Div Confirmed'))
WebUI.delay(1)
WebUI.takeScreenshot()
//CEK FILTER
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Statuses/Statuses'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Statuses/Div Confirmed'))
WebUI.delay(2)
TestObject issueafter = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div/div[2]/div/div[1]/div/div[1]/div/div[2]/ul/div/ul/li[1]/div[2]/div[2]/div")
String text1 = WebUI.getText(issueafter)
WebUI.verifyEqual(text, text1, FailureHandling.STOP_ON_FAILURE)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Issue Code/Button Confirm'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Issue Code/Div Unconfirm'))
WebUI.delay(1)
WebUI.verifyTextPresent('Change Issue Transition successfully', false, FailureHandling.STOP_ON_FAILURE)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Clear FIlter'))
WebUI.delay(1)

