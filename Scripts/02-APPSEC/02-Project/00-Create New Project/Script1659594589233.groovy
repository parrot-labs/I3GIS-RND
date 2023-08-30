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
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

TestData input = findTestData('Data Files/project')

WebUI.click(findTestObject('Object Repository/AppSec/div_Application'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Menu Summary Project/Button Summary Project'))
WebUI.delay(1)
WebUI.takeScreenshot()

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
	
	if (WebUI.verifyTextPresent('PROJECT NOT FOUND', false, FailureHandling.OPTIONAL) == true) {
		
		WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Create New Project'))
		WebUI.delay(1)
		WebUI.waitForElementClickable(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Project Name'), 0, FailureHandling.OPTIONAL)
		WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Project Name'), input.getValue('project-name', baris))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Description'), input.getValue('desc', baris))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Repository Url'), input.getValue('repo-url', baris))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Branch Name'))
		WebUI.delay(1)
		
		if (WebUI.verifyTextPresent(input.getValue('branch', baris), false, FailureHandling.OPTIONAL) == true) {
			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/div-'+input.getValue('branch', baris)))
			WebUI.delay(1)
		}else {
			WebUI.sendKeys(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/div-master'), Keys.chord(Keys.ESCAPE))
			WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Custom Branch'))
			WebUI.delay(1)
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Branch Name'), input.getValue('branch', baris))
			WebUI.delay(1)
			WebUI.takeScreenshot()
		}
		WebUI.scrollToElement(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Create project'), 0, FailureHandling.OPTIONAL)
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Repo Access'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Div-'+input.getValue('access', baris)))
		WebUI.delay(1)
		if (input.getValue('access', baris) == 'Private')	{
			WebUI.delay(1)
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Username'), input.getValue('username-repo', baris))
			WebUI.delay(1)
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Token'), input.getValue('token-repo', baris))
			WebUI.delay(1)
			WebUI.takeScreenshot()
		}
		WebUI.takeScreenshot()
		
		for (int row = 1; row <= input.getRowNumbers(); row++) {
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input User'), input.getValue('user', row))
			WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Div Select User'))
			WebUI.delay(1)
		}
		WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Group User'), input.getValue('group', baris))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Div Select Group'))
		WebUI.delay(1)
		WebUI.takeScreenshot()
		
//		for (int rownumber = 1; rownumber <= 1; rownumber++) {
//			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Tags'), input.getValue('tags', rownumber))
//			WebUI.delay(1)
//		}
		
		WebUI.takeScreenshot()
		WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Create project'))
		WebUI.delay(4)
		WebUI.verifyTextPresent(input.getValue('verify', baris), false, FailureHandling.OPTIONAL)
		WebUI.callTestCase(findTestCase('Test Cases/02-APPSEC/02-Project/06-Scaning Project normal'), [:], FailureHandling.STOP_ON_FAILURE)
	}else {
		
		WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Existing Project/Button Project Current'))
		WebUI.delay(1)
		WebUI.sendKeys(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Existing Project/Input Search Project'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.delay(1)
		WebUI.sendKeys(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Existing Project/Input Search Project'), Keys.chord(Keys.'BACK_SPACE'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Existing Project/Input Search Project'), input.getValue('project-name', baris))
		WebUI.delay(2)
		
		if(WebUI.verifyElementClickable(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Existing Project/Div Project'), FailureHandling.OPTIONAL) == true) {
			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Existing Project/Div Project'))
			WebUI.delay(4)
			if(input.getValue('project-name', baris) == 'Secret-test') {
				WebUI.callTestCase(findTestCase('Test Cases/02-APPSEC/02-Project/03-Delete Project'), [:], FailureHandling.STOP_ON_FAILURE)
				WebUI.delay(1)
				WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Existing Project/Button Project Current'))
				WebUI.delay(1)
				WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Create New Project'))
				WebUI.delay(1)
				WebUI.waitForElementClickable(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Project Name'), 0, FailureHandling.OPTIONAL)
				WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Project Name'), input.getValue('project-name', baris))
				WebUI.delay(1)
				WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Description'), input.getValue('desc', baris))
				WebUI.delay(1)
			//	WebUI.click(findTestObject('Object Repository/02-Summary Project/02-Detail Project-Create Project/Div-'+input.getValue('repo', baris)))
			//	WebUI.delay(1)
				WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Repository Url'), input.getValue('repo-url', baris))
				WebUI.delay(7)
				WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Branch Name'))
				WebUI.delay(1)
				
				if (WebUI.verifyTextPresent(input.getValue('branch', baris), false, FailureHandling.OPTIONAL) == true) {
					WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/div-'+input.getValue('branch', baris)))
					WebUI.delay(1)
				}else {
					WebUI.sendKeys(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/div-master'), Keys.chord(Keys.ESCAPE))
					WebUI.delay(1)
					WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Custom Branch'))
					WebUI.delay(1)
					WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Branch Name'), input.getValue('branch', baris))
					WebUI.delay(1)
					WebUI.takeScreenshot()
				}
				WebUI.scrollToElement(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Create project'), 0, FailureHandling.OPTIONAL)
				WebUI.delay(1)
				WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Repo Access'))
				WebUI.delay(1)
				WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Div-'+input.getValue('access', baris)))
				WebUI.delay(1)
				if (input.getValue('access', baris) == 'Private')	{
					WebUI.delay(1)
					WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Username'), input.getValue('username-repo', baris))
					WebUI.delay(1)
					WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Token'), input.getValue('token-repo', baris))
					WebUI.delay(1)
					WebUI.takeScreenshot()
				}
				WebUI.takeScreenshot()
				
				for (int row = 1; row <= input.getRowNumbers(); row++) {
				WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input User'), input.getValue('user', row))
				WebUI.delay(1)
				WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Div Select User'))
				WebUI.delay(1)
			}
				WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Group User'), input.getValue('group', baris))
				WebUI.delay(1)
				WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Div Select Group'))
				WebUI.delay(1)
				WebUI.takeScreenshot()
				
				WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Create project'))
				WebUI.delay(5)
				WebUI.takeScreenshot()
				WebUI.verifyTextPresent(input.getValue('verify', baris), false, FailureHandling.OPTIONAL)
				WebUI.callTestCase(findTestCase('Test Cases/02-APPSEC/02-Project/06-Scaning Project normal'), [:], FailureHandling.STOP_ON_FAILURE)
			}
			if(input.getValue('rescan', baris) == 'YES'){
				WebUI.callTestCase(findTestCase('Test Cases/02-APPSEC/02-Project/06-Scaning Project normal'), [:], FailureHandling.STOP_ON_FAILURE)
			}
		}else {
			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Create New Project'))
			WebUI.delay(1)
			WebUI.waitForElementClickable(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Project Name'), 0, FailureHandling.OPTIONAL)
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Project Name'), input.getValue('project-name', baris))
			WebUI.delay(1)
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Description'), input.getValue('desc', baris))
			WebUI.delay(1)
		//	WebUI.click(findTestObject('Object Repository/02-Summary Project/02-Detail Project-Create Project/Div-'+input.getValue('repo', baris)))
		//	WebUI.delay(1)
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Repository Url'), input.getValue('repo-url', baris))
			WebUI.delay(7)
			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Branch Name'))
			WebUI.delay(1)
			
			if (WebUI.verifyTextPresent(input.getValue('branch', baris), false, FailureHandling.OPTIONAL) == true) {
				WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/div-'+input.getValue('branch', baris)))
				WebUI.delay(1)
			}else {
				WebUI.sendKeys(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/div-master'), Keys.chord(Keys.ESCAPE))
				WebUI.delay(1)
				WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Custom Branch'))
				WebUI.delay(1)
				WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Branch Name'), input.getValue('branch', baris))
				WebUI.delay(1)
				WebUI.takeScreenshot()
			}
			WebUI.scrollToElement(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Create project'), 0, FailureHandling.OPTIONAL)
			WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Repo Access'))
			WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Div-'+input.getValue('access', baris)))
			WebUI.delay(1)
			if (input.getValue('access', baris) == 'Private')	{
				WebUI.delay(1)
				WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Username'), input.getValue('username-repo', baris))
				WebUI.delay(1)
				WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Token'), input.getValue('token-repo', baris))
				WebUI.delay(1)
				WebUI.takeScreenshot()
			}
			WebUI.takeScreenshot()
			
			for (int row = 1; row <= input.getRowNumbers(); row++) {
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input User'), input.getValue('user', row))
			WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Div Select User'))
			WebUI.delay(1)
		}
			WebUI.setText(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Input Group User'), input.getValue('group', baris))
			WebUI.delay(1)
			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Div Select Group'))
			WebUI.delay(1)
			WebUI.takeScreenshot()
			
			WebUI.click(findTestObject('Object Repository/AppSec/02-Summary Project/02-Detail Project-Create Project/Button Create project'))
			WebUI.delay(4)
			WebUI.takeScreenshot()
			WebUI.verifyTextPresent(input.getValue('verify', baris), false, FailureHandling.OPTIONAL)
			WebUI.callTestCase(findTestCase('Test Cases/02-APPSEC/02-Project/06-Scaning Project normal'), [:], FailureHandling.STOP_ON_FAILURE)
		}	
		}
	
}