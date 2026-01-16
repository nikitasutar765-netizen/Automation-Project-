package com.banking.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelUtils {
    public static String getdata(int row,int col){
        try {
            File src = new File("src/test/resources/TestData.xlsx");
            FileInputStream fis = new FileInputStream(src);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sheet = wb.getSheetAt(0);
            String data = sheet.getRow(row).getCell(col).getStringCellValue();
            wb.close();
            return data;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
