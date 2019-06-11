package com.tools.poi;


import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelHandle extends NoisyData {

    private String excelPath;

    private String aNewExcel;

    public ExcelHandle(String excelPath,String aNewExcel) {

        this.excelPath = excelPath;
        this.aNewExcel = aNewExcel;
    }

    private FileInputStream getInputStream() {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream(excelPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }

    private void outputStream(HSSFWorkbook workbook) {
        try (FileOutputStream stream = new FileOutputStream(aNewExcel)) {
            workbook.write(stream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void handle() {
        FileInputStream stream = getInputStream();
        try {
            HSSFWorkbook newBook = new HSSFWorkbook();
            HSSFSheet newSheet = newBook.createSheet("处理后");
            HSSFWorkbook workbook = new HSSFWorkbook(stream);
            Sheet sheet = workbook.getSheetAt(0);
            int index = 1;
            for (Row row : sheet) {
                //ignore title
                String item = "";
                if (row.getCell(3) != null && row.getRowNum() != 0) {
                    item = row.getCell(3).getStringCellValue();
                    //compare
                    if (!contain(item)) {
                        Row rowOne = newSheet.createRow(index++);
                        rowOne.createCell(0).setCellValue(row.getCell(0).getNumericCellValue());
                        rowOne.createCell(1).setCellValue(row.getCell(1).getStringCellValue());
                        rowOne.createCell(2).setCellValue(row.getCell(2).getNumericCellValue());
                        rowOne.createCell(3).setCellValue(row.getCell(3).getStringCellValue());
                    }
                }
            }
            outputStream(newBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ExcelHandle handle = new ExcelHandle("C:\\Users\\lenovo\\Desktop\\test.xls","C:\\Users\\lenovo\\Desktop\\test2.xls");
        handle.handle();
    }
}
