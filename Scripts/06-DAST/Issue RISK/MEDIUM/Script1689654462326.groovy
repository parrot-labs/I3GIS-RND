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

WebUI.refresh()
WebUI.delay(2)
WebUI.click(findTestObject('Object Repository/07-DAST/Issue-Context/Filtering/Button-FilerRisk'))
WebUI.delay(1)
WebUI.enhancedClick(findTestObject('Object Repository/07-DAST/Issue-Context/Filtering/RISK-MEDIUM'))
WebUI.delay(1)
WebUI.takeScreenshot()

TestObject MEDIUM = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div/div[2]/div[2]/div/div[2]/div/div/div[2]/span")
String countMED = WebUI.getText(MEDIUM)
int countMEDIUM = Integer.valueOf(countMED)

if(countMEDIUM > 0) {
	isbreak = false
	int jumlah = 0
	for (int baris = 1; baris <= 15; baris++) {
		TestObject INFO = new TestObject().addProperty('xpath', ConditionType.EQUALS, "/html/body/div[1]/div[6]/div/div/div/div[3]/div[2]/div[1]/div[$baris]/div[1]/div/div[3]/span/div/span")
		String countINFO = WebUI.getText(INFO)
		println(countINFO)
		int count = Integer.valueOf(countINFO)
				
		jumlah += count
		println(jumlah)
		if(jumlah == countMEDIUM) {
			isbreak = true
			break;
			if(isbreak == true) {
				break;
			}
		}
		if(jumlah > countMEDIUM){
			FailureHandling.STOP_ON_FAILURE
		}
	}
}
