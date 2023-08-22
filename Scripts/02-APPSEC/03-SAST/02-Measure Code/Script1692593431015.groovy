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

WebUI.click(findTestObject('Object Repository/Button Home'))
WebUI.refresh()
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/AppSec/div_Application'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/Button SAST'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/AppSec/02-Measure Code/Button-Measures Code'))
WebUI.delay(1)
WebUI.takeScreenshot()

TestObject name = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div/div[2]/div[1]/div/div[2]/div[1]/div/nav/ol/li/button")
String namerepo = WebUI.getText(name)
if(namerepo != 'React-Cypress') {
	WebUI.callTestCase(findTestCase('Test Cases/02-APPSEC/02-Project/05-Select Project'), [:], FailureHandling.STOP_ON_FAILURE)
}

TestObject uncovered = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[1]/div[2]/div[2]")
String uncover = WebUI.getText(uncovered)
println(uncover)
TestObject linetocover = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[3]/div[2]")
String cover = WebUI.getText(linetocover)
println(cover)
TestObject uncovered1 = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[1]/div[2]/div[2]")
String uncover1 = WebUI.getText(uncovered1)
println(uncover1)
TestObject linetocover1 = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div/div/div/div[1]/div/div[1]/div[2]/div[3]/div[2]")
String cover1 = WebUI.getText(linetocover1)
println(cover1)

WebUI.click(findTestObject('Object Repository/AppSec/02-Measure Code/Sub Filter Coverage'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/AppSec/02-Measure Code/li_Uncovered Lines'))
WebUI.delay(1)
WebUI.takeScreenshot()
WebUI.verifyEqual(uncover, uncover1, FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/AppSec/02-Measure Code/Sub Filter Coverage'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/AppSec/02-Measure Code/li_Line To Cover'))
WebUI.delay(1)
WebUI.takeScreenshot()
WebUI.verifyEqual(cover, cover1, FailureHandling.STOP_ON_FAILURE)