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

WebUI.refresh()
WebUI.delay(3)

TestObject data_text = findTestObject('Object Repository/03-SAST/03-Issues Code/Count Page')
String text = WebUI.getText(data_text)
println(text)

int page = Integer.valueOf(text)
println(page)

for (int j = 1; j <= page-1; j++) {
	
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Click Issue'))
	WebUI.delay(1)
	WebUI.scrollToPosition(0, 0)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Click Issue'))
	WebUI.delay(3)
	
	long lastHeight=((Number) WebUI.executeJavaScript("return document.body.scrollHeight", null)).longValue();
	println(lastHeight)
	height = ((lastHeight/916)+1)
	println(height)
	String newHeight = height
	akhir = newHeight.substring(0, newHeight.length()-11)
	println(akhir)
	//y = newHeight
	hasilakhir = ((height * 916))
	println(hasilakhir)

	int mulai = 0
	int next = 916
	println(next)
	String z = hasilakhir
	String hasil = z.substring(0, z.length()-11)
	println(hasil)
	int end = Integer.valueOf(hasil)
	int x = Integer.valueOf(akhir)
	
	for (int i = 1; i <= x; i++) {
		int awal = (next + mulai)
		println(awal)
		mulai = awal
		println(mulai)
		
		if (mulai < end) {
			WebUI.takeScreenshot()
			WebUI.sendKeys(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Next Page'), Keys.chord(Keys.PAGE_DOWN))
			
		}else {
			break;
		}
	}
	WebUI.delay(1)
	WebUI.scrollToPosition(0, 0)
	WebUI.delay(1)
	WebUI.click(findTestObject('Object Repository/03-SAST/03-Issues Code/Button Next Page'))
	WebUI.delay(2)

}