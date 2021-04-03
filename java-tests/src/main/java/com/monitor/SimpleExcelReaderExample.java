package com.monitor;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


public class SimpleExcelReaderExample {
  public static void main(String[] args) throws IOException {
//    String excelFilePath = "Books.xlsx";
    String excelFilePath = "c:\\work\\123.xls";
    FileInputStream inputStream = new FileInputStream(new File(excelFilePath));

    // *.xlsx
//    XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(path)));
//    XSSFSheet sheet = workbook.getSheetAt(0);

    // .xls
//    HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(new File(path)));
//    HSSFSheet sheet = workbook.getSheetAt(0);
    Workbook workbook = new HSSFWorkbook(inputStream);
    Sheet firstSheet = workbook.getSheetAt(0);
    Iterator<Row> iterator = firstSheet.iterator();

    while (iterator.hasNext()) {
      Row nextRow = iterator.next();
      Iterator<Cell> cellIterator = nextRow.cellIterator();

      while (cellIterator.hasNext()) {
        Cell cell = cellIterator.next();

        switch (cell.getCellType()) {
          case STRING:
            System.out.print(cell.getStringCellValue());
            break;
          case BOOLEAN:
            System.out.print(cell.getBooleanCellValue());
            break;
          case NUMERIC:
            System.out.print(cell.getNumericCellValue());
            break;
          default:
            System.out.println("Unexpected value: " + cell.getCellType());
        }
        System.out.print(" - ");
      }
      System.out.println();
    }

    workbook.close();
    inputStream.close();
  }
}
