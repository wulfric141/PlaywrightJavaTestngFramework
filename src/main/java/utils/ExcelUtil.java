package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.util.*;

public class ExcelUtil {

    public static Map<String, String> getTestCaseData(String sheetName, String testCaseName) {
        Map<String, String> rowData = new HashMap<>();

        try (FileInputStream fis = new FileInputStream("./resources/TestData.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) return rowData;

            Row headerRow = sheet.getRow(0);
            int totalRows = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < totalRows; i++) {
                Row row = sheet.getRow(i);
                if (row == null) continue;

                Cell testCaseCell = row.getCell(0); // Assuming first column is "TestCaseName"
                if (testCaseCell == null) continue;

                String currentTestCaseName = testCaseCell.getStringCellValue().trim();
                if (!currentTestCaseName.equalsIgnoreCase(testCaseName)) continue;

                for (int j = 0; j < row.getLastCellNum(); j++) {
                    String key = headerRow.getCell(j).getStringCellValue();
                    String value = getCellValueAsString(row.getCell(j));
                    rowData.put(key, value);
                }

                break; // Only return the first matching test case
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return rowData;
    }

    private static String getCellValueAsString(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING: return cell.getStringCellValue();
            case NUMERIC: return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            case FORMULA: return cell.getCellFormula();
            case BLANK: return "";
            default: return "";
        }
    }
}
