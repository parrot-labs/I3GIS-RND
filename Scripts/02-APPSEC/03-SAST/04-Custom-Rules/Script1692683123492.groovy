import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

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

TestData input = findTestData('Data Files/AppSec-customrules')

WebUI.refresh()
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/AppSec/div_Application'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/03-SAST/Button SAST'))
WebUI.delay(1)
WebUI.click(findTestObject('Object Repository/AppSec/Custom-Rules/Button-Custom Rules'))
WebUI.delay(1)
WebUI.verifyTextPresent('Custom Rules', false, FailureHandling.OPTIONAL)
WebUI.delay(1)
WebUI.takeScreenshot()

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
	
	WebUI.setText(findTestObject('Object Repository/AppSec/Custom-Rules/Search-Language'), input.getValue('language', baris))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	if(WebUI.verifyTextPresent(input.getValue('name-rules', baris), false, FailureHandling.OPTIONAL) == true) {
		for (int brs = 1; baris <= 10; brs++) {
			isbreak=false;
			TestObject name = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div/div[2]/div/div[3]/div[1]/div/table/tbody/tr[1]/td[$brs]/div/a/div")
			String language = WebUI.getText(name)
			if(language == input.getValue('name-rules', baris)) {
				TestObject delete = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div/div[2]/div/div[3]/div[1]/div/table/tbody/tr[$brs]/td[6]/div/div[1]/button")
				WebUI.click(delete)
				WebUI.takeScreenshot()
				WebUI.click(findTestObject('Object Repository/AppSec/Custom-Rules/Button-Delete'))
				WebUI.delay(2)
				WebUI.takeScreenshot()
				WebUI.verifyTextPresent('Profile successfully deleted', false, FailureHandling.OPTIONAL)
				isbreak=true;
				break;
			}
		}
	}
	
	WebUI.click(findTestObject('Object Repository/AppSec/Custom-Rules/Button-Create Profile'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.setText(findTestObject('Object Repository/AppSec/Custom-Rules/Input-Name-ruleName'), input.getValue('name-rules', baris))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/AppSec/Custom-Rules/Span-Language'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/AppSec/Custom-Rules/li_Java'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/AppSec/Custom-Rules/Button-Create'))
	WebUI.delay(2)
	WebUI.takeScreenshot()
	WebUI.verifyTextPresent('Profile successfully created', false, FailureHandling.STOP_ON_FAILURE)
	
}