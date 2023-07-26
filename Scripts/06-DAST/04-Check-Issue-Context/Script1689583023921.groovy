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

for (int baris = 1; baris <= input.getRowNumbers(); baris++) {
	
//	WebUI.click(findTestObject('Object Repository/07-DAST/Button-DAST'))
//	WebUI.delay(1)
//	WebUI.click(findTestObject('Object Repository/07-DAST/Button-SiteScan'))
//	WebUI.delay(1)
//	WebUI.waitForElementClickable(findTestObject('Object Repository/07-DAST/CreateProject-SiteDetails/Button-CreateSites'), 0)
//	WebUI.takeScreenshot()
//	WebUI.sendKeys(findTestObject('Object Repository/07-DAST/Sites/Input-NameSite'), Keys.chord(Keys.CONTROL, 'a'))
//	WebUI.sendKeys(findTestObject('Object Repository/07-DAST/Sites/Input-NameSite'), Keys.chord(Keys.BACK_SPACE))
//	if(input.getValue('site-type', baris)== 'API') {
//		WebUI.setText(findTestObject('Object Repository/07-DAST/Sites/Input-NameSite'), input.getValue('site-name-api', baris))
//		WebUI.delay(1)
//	}else {
//		WebUI.setText(findTestObject('Object Repository/07-DAST/Sites/Input-NameSite'), input.getValue('site-name', baris))
//		WebUI.delay(1)
//	}
//	WebUI.click(findTestObject('Object Repository/07-DAST/Sites/div-Sites'))
//	WebUI.delay(1)
//	WebUI.takeScreenshot()
	WebUI.setText(findTestObject('Object Repository/07-DAST/Issue-Context/Input-SearchContextName'), input.getValue('context', baris))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Div-Context'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/div_Latest Scan Version'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Button-AssignIssue'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/07-DAST/Issue-Context/Input-username'), input.getValue('user', baris))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Selecet-user'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Button-Save'))
	WebUI.delay(1)
	WebUI.verifyTextPresent('Success assign users to this issue', false, FailureHandling.OPTIONAL)
	WebUI.takeScreenshot()
	
	TestObject issueALL = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div/div[3]/div[2]/div[1]/div[1]/div[1]/a/div")
	String titleALL = WebUI.getText(issueALL)
	println(titleALL)
	
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Button-MyIssue'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	
	TestObject issue = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div/div[3]/div[2]/div[1]/div[1]/div[1]/a/div")
	String title = WebUI.getText(issue)
	println(title)
	
	if(titleALL != issue) {
		FailureHandling.STOP_ON_FAILURE
	}
	
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Button-AssignIssueMy'))
	WebUI.delay(1)
	WebUI.setText(findTestObject('Object Repository/07-DAST/Issue-Context/Input-username'), input.getValue('user', baris))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Selecet-user'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Button-Save'))
	WebUI.delay(1)
	WebUI.verifyTextPresent('Success revoke user to this issue', false, FailureHandling.OPTIONAL)
	WebUI.takeScreenshot()
	WebUI.refresh()
	WebUI.delay(2)
	WebUI.takeScreenshot()
	WebUI.callTestCase(findTestCase('Test Cases/06-DAST/HIGH'), [:], FailureHandling.STOP_ON_FAILURE)
	WebUI.callTestCase(findTestCase('Test Cases/06-DAST/MEDIUM'), [:], FailureHandling.STOP_ON_FAILURE)
	WebUI.callTestCase(findTestCase('Test Cases/06-DAST/LOW'), [:], FailureHandling.STOP_ON_FAILURE)
	WebUI.callTestCase(findTestCase('Test Cases/06-DAST/INFO'), [:], FailureHandling.STOP_ON_FAILURE)
	WebUI.refresh()
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Button-Solution'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Button-OK'))
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Button-See Detail'))
	WebUI.delay(1)
	WebUI.takeScreenshot()
	
	TestObject issues = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div[2]/div[1]/div/div[1]/div/div")
	String issuesdetail = WebUI.getText(issues)
	println(issuesdetail)
	
	if(titleALL != issuesdetail) {
		FailureHandling.STOP_ON_FAILURE
	}
	
	
	WebUI.back()
	
	
	
	
}