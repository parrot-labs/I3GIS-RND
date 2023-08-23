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

WebUI.refresh()
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/AppSec/div_Application'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/06-Misconfiguration Repository/Button-Misconf Repository'))
WebUI.delay(1)
WebUI.verifyTextPresent('Misconfiguration Repository', false, FailureHandling.OPTIONAL)
WebUI.delay(1)
WebUI.takeScreenshot()

TestObject name = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div/div[1]/div/div[2]/button/div[2]")
String namerepo = WebUI.getText(name)
if(namerepo != 'React-Cypress') {
	WebUI.callTestCase(findTestCase('Test Cases/02-APPSEC/02-Project/05-Select Project'), [:], FailureHandling.STOP_ON_FAILURE)
}

String failure = WebUI.getText(findTestObject('Object Repository/06-Misconfiguration Repository/Summary Failure'))
WebUI.click(findTestObject('Object Repository/06-Misconfiguration Repository/Button-See Detail'))
WebUI.delay(1)
WebUI.takeScreenshot()
String failuredetail = WebUI.getText(findTestObject('Object Repository/06-Misconfiguration Repository/Summary Failure Detail'))
WebUI.verifyEqual(failure, failuredetail, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/06-Misconfiguration Repository/Button-Test History'))
WebUI.delay(1)
WebUI.takeScreenshot()
WebUI.click(findTestObject('Object Repository/06-Misconfiguration Repository/Button-Test Results'))
WebUI.delay(1)

String issue1 = WebUI.getText(findTestObject('Object Repository/06-Misconfiguration Repository/issue-name'))

TestObject status = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/ul/div[1]/div/div/div[1]/div[2]/button/div")
String strstt = WebUI.getText(status)
if(strstt != 'Open') {
	WebUI.click(findTestObject('Object Repository/06-Misconfiguration Repository/Button-Status'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/06-Misconfiguration Repository/li_Reopen'))
	WebUI.delay(1)
	WebUI.refresh()
	WebUI.takeScreenshot()
}

WebUI.click(findTestObject('Object Repository/06-Misconfiguration Repository/Button-Status'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/06-Misconfiguration Repository/li_Confirm'))
WebUI.delay(1)
WebUI.verifyTextPresent('Change Status result success', false, FailureHandling.STOP_ON_FAILURE)
WebUI.refresh()
WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/06-Misconfiguration Repository/Show-Filter'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/06-Misconfiguration Repository/div-Confirm'))
WebUI.delay(1)
TestObject issu2 = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div/div[2]/div/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/ul/div/div/div/div[1]/div[1]/div[2]/div[1]")
String issuename2 = WebUI.getText(issu2)
WebUI.verifyEqual(issue1, issuename2, FailureHandling.STOP_ON_FAILURE)
WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/06-Misconfiguration Repository/Button-Reset Filter'))
WebUI.delay(1)
WebUI.refresh()
WebUI.takeScreenshot()