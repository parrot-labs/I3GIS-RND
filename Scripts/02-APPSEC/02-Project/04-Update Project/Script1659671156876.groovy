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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.ConditionType as ConditionType

WebUI.refresh()
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/AppSec/div_Application'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Menu Summary Project/Button Summary Project'))
WebUI.delay(1)
WebUI.takeScreenshot()

TestData Data = findTestData('Data Files/project')
for (int baris = 1; baris <= 1; baris++) {
	
	WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Existing Project/Button Project Current'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Existing Project/Input Search Project'), Data.getValue('project-name', baris))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Existing Project/Div Project'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.waitForElementClickable(findTestObject('Object Repository/AppSec/02-Summary Project/02-Menu Summary Project/Button Setting Project'), 0, FailureHandling.OPTIONAL)
}

TestData input = findTestData('Data Files/project-update')
for (int row = 1; row <= 1; row++) {
	
	WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Menu Summary Project/Button Setting Project'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Edit-project'))
	WebUI.delay(1)
	WebUI.sendKeys(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Desc'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Desc'), input.getValue('desc', row))
	WebUI.delay(1)
	WebUI.sendKeys(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input repo-url update'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input repo-url update'), input.getValue('repo-url', row))
	WebUI.delay(1)
	WebUI.sendKeys(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Branch'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Branch'), input.getValue('branch', row))
	WebUI.delay(1)
	
	TestObject data = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div/div[5]/div/div/div/div[3]/div/div[1]/div/div/div/div[2]/div/div[1]/div/div[3]/div[2]/div[2]")
	String repoaccess = WebUI.getText(data)
	println(repoaccess)
	String nama = input.getValue('access', row)
	String repo = nama.toUpperCase();
	println(repo)
	
	if (repoaccess != repo) {
		WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Span-'+input.getValue('access', row)))
		WebUI.delay(1)
	}else {
		WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Span-'+input.getValue('access', row)))
		WebUI.delay(1)
	}
	WebUI.takeScreenshot()
	WebUI.scrollToElement(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Switch'), 0)
	if (repo == 'PRIVATE')	{
		
		if(WebUI.verifyTextPresent('Username Repository', false, FailureHandling.OPTIONAL) == true) {
			
			WebUI.scrollToElement(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Switch'), 0)
			WebUI.delay(1)
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Username'), input.getValue('username-repo', row))
			WebUI.delay(1)
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Token'), input.getValue('token-repo', row))
			WebUI.delay(1)
			WebUI.takeScreenshot()			
		}else {
			if(WebUI.verifyTextPresent('Username Repository', false, FailureHandling.OPTIONAL) == true) {
				WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Button Edit Account Repo'))
				WebUI.delay(1)
				WebUI.scrollToElement(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Switch'), 0)
				WebUI.delay(1)
				WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Username'), input.getValue('username-repo', row))
				WebUI.delay(1)
				WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Token'), input.getValue('token-repo', row))
				WebUI.delay(1)
				WebUI.takeScreenshot()
			}
		}
	}

	if(input.getValue('auto-scanning', row) == 'ON') {
		
		if (WebUI.verifyElementNotClickable(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Div-Monthly'), FailureHandling.OPTIONAL) == true) {
			
			WebUI.delay(2)
			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Switch'))
			WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Div-'+input.getValue('schedule', row)))
			WebUI.delay(1)
			
			WebUI.sendKeys(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Date and Time'), Keys.chord(Keys.CONTROL, 'a'))
			WebUI.sendKeys(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Date and Time'), Keys.chord(Keys.BACK_SPACE))
			WebUI.delay(1)
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Date and Time'), input.getValue('date', row))
			WebUI.delay(1)
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Date and Time'), input.getValue('time', row))
			WebUI.delay(1)
			WebUI.takeScreenshot()
		}else {
			
//			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Switch'))
//			WebUI.delay(1)
			
//			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Button Schedule'))
//			WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/02-Summary Project/02-Project Setting/Div-'+input.getValue('schedule', row)))
			WebUI.delay(1)
			
			WebUI.sendKeys(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Date and Time'), Keys.chord(Keys.CONTROL, 'a'))
			WebUI.sendKeys(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Date and Time'), Keys.chord(Keys.BACK_SPACE))
			WebUI.delay(1)
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Date and Time'), input.getValue('date', row))
			WebUI.delay(1)
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Input Date and Time'), input.getValue('time', row))
			WebUI.delay(1)
			WebUI.takeScreenshot()
		}
	}else {
		if (WebUI.verifyTextPresent('Your project will be scanned', false, FailureHandling.OPTIONAL) == true) {
			
			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Switch'))
			WebUI.delay(1)
		}
	}	
	WebUI.scrollToPosition(0, 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Button Update Project'))
	WebUI.delay(1)
	if (WebUI.verifyTextPresent('Yes, keep update it', false, FailureHandling.OPTIONAL) == true)	{
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Project Setting/Button Yes, keep update'))
	}
	WebUI.takeScreenshot()
	WebUI.verifyTextPresent('Repository Valid', false, FailureHandling.OPTIONAL)
	WebUI.verifyTextPresent('Edit Project Data Success', false, FailureHandling.OPTIONAL)
}
