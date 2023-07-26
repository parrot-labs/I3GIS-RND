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

TestObject title = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div/div[3]/div[2]/div[1]/div[1]/div[1]/a/div")
String title1 = WebUI.getText(title)
TestObject desc = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div/div[3]/div[2]/div[1]/div[1]/div[2]/div")
String desc1 = WebUI.getText(desc)

WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Button-See Detail'))
WebUI.delay(1)
WebUI.takeScreenshot()

TestObject titledetail = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div[2]/div[1]/div/div[1]/div/div")
String title2 = WebUI.getText(titledetail)
TestObject descdetail = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div[2]/div[1]/div/div[2]/div[2]/div[1]/p")
String desc2 = WebUI.getText(descdetail)

WebUI.verifyEqual(title1, title2, FailureHandling.STOP_ON_FAILURE)
WebUI.verifyEqual(desc1, desc2, FailureHandling.STOP_ON_FAILURE)

for (int div = 1; div <= 10; div++) {
	isbreak = false
	TestObject url = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div[2]/div[1]/div/div[3]/div[1]/table/tbody/tr[$div]/td[2]/div")
	String urlpars = WebUI.getText(url)
	if(url == input.getValue('context', 1)) {
		TestObject button = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[6]/div/div/div[2]/div[1]/div/div[3]/div[1]/table/tbody/tr[$div+1]/td[3]/button")
		WebUI.click(button)
		isbreak = true
	}
}