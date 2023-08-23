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
WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Secret Check'))
WebUI.delay(1)
WebUI.verifyTextPresent('Result Secrets', false, FailureHandling.OPTIONAL)
WebUI.delay(1)
WebUI.takeScreenshot()

TestObject name = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div/div[1]/div[2]/button/div[2]")
String namerepo = WebUI.getText(name)
if(namerepo != 'Secret-test') {
	WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Existing Project/Button Project Current'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Existing Project/Input Search Project'), 'Secret-test')
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Existing Project/Div Project'))
	WebUI.delay(4)
}

WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Show more code'))
WebUI.delay(1)
WebUI.takeScreenshot()
WebUI.sendKeys(findTestObject('Object Repository/05-Secret Check/Text-box'), Keys.chord(Keys.ESCAPE))
WebUI.delay(1)
WebUI.takeScreenshot()

TestObject status = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div[2]/div/button")
String strstt = WebUI.getText(status)
if(strstt != 'Open') {
	WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Status'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/05-Secret Check/div-Reopen'))
	WebUI.delay(1)
	WebUI.refresh()
	WebUI.takeScreenshot()
}

TestObject issu1 = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div[2]/div/div[1]")
String issuename1 = WebUI.getText(issu1)
WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Status'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/05-Secret Check/div-Confirm'))
WebUI.delay(1)
WebUI.verifyTextNotPresent('Change Status result success', false, FailureHandling.STOP_ON_FAILURE)
WebUI.refresh()
WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Filter'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/05-Secret Check/filter-Confirm'))
WebUI.delay(1)
TestObject issu2 = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div/div[1]/div/div[1]/div[2]/div/div[1]")
String issuename2 = WebUI.getText(issu2)
WebUI.verifyEqual(issuename1, issuename2, FailureHandling.STOP_ON_FAILURE)
WebUI.takeScreenshot()

WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Reset Filter'))
WebUI.delay(1)
WebUI.refresh()
WebUI.takeScreenshot()

