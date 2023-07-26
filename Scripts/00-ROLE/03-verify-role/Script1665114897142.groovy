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
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import org.apache.poi.ss.usermodel.Sheet as Sheet
import org.apache.poi.ss.usermodel.Workbook as Workbook

TestData input = findTestData('Data Files/ROLE/00-Role')

for (int baris = 16; baris <= input.getRowNumbers(); baris++) {
	if(input.getValue('306', baris) || input.getValue('307', baris) ||input.getValue('308', baris) || input.getValue('309', baris) || input.getValue('310', baris) || input.getValue('311', baris) =='yes') {
		
		WebUI.callTestCase(findTestCase('Test Cases/00-Login/01-Login-sukses'), null)
		WebUI.callTestCase(findTestCase('Test Cases/00-ROLE/ROLE-EXTEND/101'), null)
		WebUI.click(findTestObject('Object Repository/ROLE/Menu/Administration/Button-ROLE'))
		WebUI.delay(1)
		WebUI.setText(findTestObject('Object Repository/ROLE/Role-Management/Input-SearchRoleName'), 'role-custom')
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/ROLE/Role-Management/Setting-role'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Object Repository/ROLE/Role-Management/Button-EditRole'))
		WebUI.delay(2)
		for (int custom = 3; custom <= 5; custom++) {
			TestObject checkbox = new TestObject().addProperty('xpath', ConditionType.EQUALS, "(//input[@type='checkbox'])[$custom]")
			if (WebUI.verifyElementChecked(checkbox, 0, FailureHandling.OPTIONAL)) {
				WebUI.click(checkbox)
			} else {
				WebUI.click(checkbox)
				WebUI.click(checkbox)
			}
		}
		if (input.getValue('101', baris) && input.getValue('102', baris) == 'yes') {
			WebUI.click(findTestObject('Object Repository/ROLE/i3gis-General/prefix-1'))
			WebUI.delay(1)
		}else {
			WebUI.click(findTestObject('Object Repository/ROLE/i3gis-General/Expand-i3gisGeneral'))
			WebUI.delay(1)
			if (input.getValue('101', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/i3gis-General/view-admin'))
				WebUI.delay(1)
			}
			if (input.getValue('102', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/i3gis-General/manage-admin'))
				WebUI.delay(1)
			}
			WebUI.click(findTestObject('Object Repository/ROLE/i3gis-General/Expand-i3gisGeneral'))
			WebUI.delay(1)
		}
		if (input.getValue('201', baris) && input.getValue('202', baris) && input.getValue('203', baris) == 'yes') {
			WebUI.click(findTestObject('Object Repository/ROLE/report-Security/prefix-2'))
			WebUI.delay(1)
		}else {
			WebUI.click(findTestObject('Object Repository/ROLE/report-Security/Expand-report-security'))
			WebUI.delay(1)
			if(input.getValue('201', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/report-Security/manage-audit-log'))
				WebUI.delay(1)
			}
			if (input.getValue('202', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/report-Security/manage-application-report'))
				WebUI.delay(1)
			}
			if (input.getValue('203', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/report-Security/manage-dynamic-report'))
				WebUI.delay(1)
			}
			WebUI.click(findTestObject('Object Repository/ROLE/report-Security/Expand-report-security'))
			WebUI.delay(1)
		}
		if (input.getValue('301', baris) && input.getValue('302', baris) && input.getValue('303', baris) && input.getValue('304', baris) && input.getValue('305', baris) && input.getValue('306', baris) && input.getValue('307', baris) && input.getValue('308', baris) && input.getValue('309', baris) && input.getValue('310', baris) && input.getValue('311', baris) == 'yes') {
			WebUI.click(findTestObject('Object Repository/ROLE/application-security/prefix-3'))
			WebUI.delay(1)
		}else {
			WebUI.click(findTestObject('Object Repository/ROLE/application-security/Expand-application-security'))
			WebUI.delay(1)
			if (input.getValue('301', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/view-project'))
				WebUI.delay(1)
			}
			if  (input.getValue('302', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/manage-project'))
				WebUI.delay(1)
			}
			if  (input.getValue('303', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/run-application-scan'))
				WebUI.delay(1)
			}
			if  (input.getValue('304', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/view-sast'))
				WebUI.delay(1)
			}
			if  (input.getValue('305', baris) == 'yes') {
				WebUI.scrollToElement(findTestObject('Object Repository/ROLE/application-security/view-sast'), 0)
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/manage-sast'))
				WebUI.delay(1)
			}
			if  (input.getValue('306', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/view-secret-check'))
				WebUI.delay(1)
			}
			if  (input.getValue('307', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/manage-secret-check'))
				WebUI.delay(1)
			}
			if  (input.getValue('308', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/view-sca'))
				WebUI.delay(1)
			}
			if  (input.getValue('309', baris) == 'yes') {
				WebUI.scrollToElement(findTestObject('Object Repository/ROLE/application-security/view-misconf'), 0)
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/manage-sca'))
				WebUI.delay(1)
			}
			if  (input.getValue('310', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/view-misconf'))
				WebUI.delay(1)
			}
			if  (input.getValue('311', baris) == 'yes') {
				WebUI.click(findTestObject('Object Repository/ROLE/application-security/manage-misconf'))
				WebUI.delay(1)
			}
			WebUI.scrollToElement(findTestObject('Object Repository/ROLE/application-security/Expand-application-security'), 0)
			WebUI.click(findTestObject('Object Repository/ROLE/application-security/Expand-application-security'))
			WebUI.delay(1)
		}
		WebUI.click(findTestObject('Object Repository/ROLE/Role-Management/Button-Saverole'))
		WebUI.delay(2)
		WebUI.callTestCase(findTestCase('Test Cases/00-Logout/00-Logout-sukses'), null)
		WebUI.callTestCase(findTestCase('Test Cases/00-Login/01-Login-sukses-admin'), null)
		WebUI.delay(2)
		WebUI.refresh()
		
		if (input.getValue('306', baris) == 'yes') {
			WebUI.delay(1)
			if (WebUI.verifyTextNotPresent('Filter Scan Secret', false, FailureHandling.OPTIONAL) == true) {
				WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Secret Check'))
				WebUI.delay(1)
			}
			for (int row = 16; row <= 17; row++) {
				TestObject secret = new TestObject().addProperty('xpath', ConditionType.EQUALS, "(//button[@type='button'])[$row]")
				button_secret = WebUI.verifyElementClickable(secret)
				if(button_secret == true) {
					WebUI.click(secret)
					WebUI.delay(1)
				}
				String Data = './excel/role.xlsx'
				Workbook excel = ExcelKeywords.getWorkbook(Data)
				Sheet sheet = excel.getSheet('Sheet1')
				for (int bar = baris; bar <= baris; bar++) {
					for (int kol = 30; kol <= 30; kol++) {
						ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, null)
						ExcelKeywords.saveWorkbook(Data, excel)
						if (button_secret) {
							ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, 'Pass')
							ExcelKeywords.saveWorkbook(Data, excel)
						} else {
							ExcelKeywords.setValueToCellByIndex(sheet, bar, kol, 'Fail')
							ExcelKeywords.saveWorkbook(Data, excel)
						}
					}
				}
			}
		}
		
		if (input.getValue('307', baris) == 'yes') {
			WebUI.delay(1)
			if (WebUI.verifyTextNotPresent('Filter Scan Secret', false, FailureHandling.OPTIONAL) == true) {
				WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Secret Check'))
				WebUI.delay(1)
			}
			WebUI.click(findTestObject('Object Repository/05-Secret Check/Button-Results Secret'))
			yes = WebUI.verifyElementClickable(findTestObject('Object Repository/05-Secret Check/Radio-Yes'))
			no = WebUI.verifyElementClickable(findTestObject('Object Repository/05-Secret Check/Radio-No'))
			skip = WebUI.verifyElementClickable(findTestObject('Object Repository/05-Secret Check/Radio-Skip'))
			WebUI.delay(1)
			String Data1 = './excel/role.xlsx'
			Workbook excel1 = ExcelKeywords.getWorkbook(Data1)
			Sheet sheet1 = excel1.getSheet('Sheet1')
			for (int bar = baris; bar <= baris; bar++) {
				for (int kol = 31; kol <= 31; kol++) {
					ExcelKeywords.setValueToCellByIndex(sheet1, bar, kol, null)
					ExcelKeywords.saveWorkbook(Data1, excel1)
					if (yes && no && skip) {
						ExcelKeywords.setValueToCellByIndex(sheet1, bar, kol, 'Pass')
						ExcelKeywords.saveWorkbook(Data1, excel1)
					} else {
						ExcelKeywords.setValueToCellByIndex(sheet1, bar, kol, 'Fail')
						ExcelKeywords.saveWorkbook(Data1, excel1)
					}
				}
			}
		}
		
		if (input.getValue('308', baris) == 'yes') {
			WebUI.delay(1)
			if (WebUI.verifyTextNotPresent('Filter Scan Vuln', false, FailureHandling.OPTIONAL) == true) {
				WebUI.click(findTestObject('Object Repository/04-SCA/Button-SCA'))
				WebUI.delay(1)
			}
			for (int row1 = 13; row1 <= 14; row1++) {
				TestObject sca = new TestObject().addProperty('xpath', ConditionType.EQUALS, "(//button[@type='button'])[$row1]")
				button_sca = WebUI.verifyElementClickable(sca)
				if(button_sca == true) {
					WebUI.click(sca)
					WebUI.delay(1)
				}
				String Data2 = './excel/role.xlsx'
				Workbook excel2 = ExcelKeywords.getWorkbook(Data2)
				Sheet sheet2 = excel2.getSheet('Sheet1')
				for (int bar = baris; bar <= baris; bar++) {
					for (int kol = 32; kol <= 32; kol++) {
						ExcelKeywords.setValueToCellByIndex(sheet2, bar, kol, null)
						ExcelKeywords.saveWorkbook(Data2, excel2)
						if (button_sca) {
							ExcelKeywords.setValueToCellByIndex(sheet2, bar, kol, 'Pass')
							ExcelKeywords.saveWorkbook(Data2, excel2)
						} else {
							ExcelKeywords.setValueToCellByIndex(sheet2, bar, kol, 'Fail')
							ExcelKeywords.saveWorkbook(Data2, excel2)
						}
					}
				}
			}
		}
		
		if (input.getValue('309', baris) == 'yes') {
			WebUI.delay(1)
			if (WebUI.verifyTextNotPresent('Filter Scan Secret', false, FailureHandling.OPTIONAL) == true) {
				WebUI.click(findTestObject('Object Repository/04-SCA/Button-Filter Scan Vuln'))
				WebUI.delay(1)
			}
			rescan_sca = WebUI.verifyElementClickable(findTestObject('Object Repository/04-SCA/Button-Add New Vulnerability ID'))
			WebUI.delay(1)
			String Data3 = './excel/role.xlsx'
			Workbook excel3 = ExcelKeywords.getWorkbook(Data3)
			Sheet sheet3 = excel3.getSheet('Sheet1')
			for (int bar = baris; bar <= baris; bar++) {
				for (int kol = 33; kol <= 33; kol++) {
					ExcelKeywords.setValueToCellByIndex(sheet3, bar, kol, null)
					ExcelKeywords.saveWorkbook(Data3, excel3)
					if (rescan_sca) {
						ExcelKeywords.setValueToCellByIndex(sheet3, bar, kol, 'Pass')
						ExcelKeywords.saveWorkbook(Data3, excel3)
					} else {
						ExcelKeywords.setValueToCellByIndex(sheet3, bar, kol, 'Fail')
						ExcelKeywords.saveWorkbook(Data3, excel3)
					}
				}
			}
		}
		if (input.getValue('310', baris) == 'yes') {
			misconf = WebUI.verifyElementClickable(findTestObject('Object Repository/06-Misconfiguration Repository/Button-Misconf Repository'))
			if (misconf == true) {
				WebUI.click(findTestObject('Object Repository/06-Misconfiguration Repository/Button-Misconf Repository'))
				WebUI.delay(1)
			}
			String Data4 = './excel/role.xlsx'
			Workbook excel4 = ExcelKeywords.getWorkbook(Data4)
			Sheet sheet4 = excel4.getSheet('Sheet1')
			for (int bar = baris; bar <= baris; bar++) {
				for (int kol = 34; kol <= 34; kol++) {
					ExcelKeywords.setValueToCellByIndex(sheet4, bar, kol, null)
					ExcelKeywords.saveWorkbook(Data4, excel4)
					if (misconf) {
						ExcelKeywords.setValueToCellByIndex(sheet4, bar, kol, 'Pass')
						ExcelKeywords.saveWorkbook(Data4, excel4)
					} else {
						ExcelKeywords.setValueToCellByIndex(sheet4, bar, kol, 'Fail')
						ExcelKeywords.saveWorkbook(Data4, excel4)
					}
				}
			}
		}
		
		if (input.getValue('311', baris) == 'yes') {
			misconf = WebUI.verifyElementClickable(findTestObject('Object Repository/06-Misconfiguration Repository/Button-Misconf Repository'))
			if (misconf == true) {
				WebUI.click(findTestObject('Object Repository/06-Misconfiguration Repository/Button-Misconf Repository'))
				WebUI.delay(1)
			}
			rescan_misconf = WebUI.verifyElementClickable(findTestObject('Object Repository/06-Misconfiguration Repository/Button-SeemoreDetail'))
			String Data5 = './excel/role.xlsx'
			Workbook excel5 = ExcelKeywords.getWorkbook(Data5)
			Sheet sheet5 = excel5.getSheet('Sheet1')
			for (int bar = baris; bar <= baris; bar++) {
				for (int kol = 35; kol <= 35; kol++) {
					ExcelKeywords.setValueToCellByIndex(sheet5, bar, kol, null)
					ExcelKeywords.saveWorkbook(Data5, excel5)
					if (rescan_misconf) {
						ExcelKeywords.setValueToCellByIndex(sheet5, bar, kol, 'Pass')
						ExcelKeywords.saveWorkbook(Data5, excel5)
					} else {
						ExcelKeywords.setValueToCellByIndex(sheet5, bar, kol, 'Fail')
						ExcelKeywords.saveWorkbook(Data5, excel5)
					}
				}
			}
		}
		WebUI.callTestCase(findTestCase('Test Cases/00-Logout/00-Logout-sukses'), null)
		
	}
}