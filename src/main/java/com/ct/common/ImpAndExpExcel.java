package com.ct.common;

import com.alibaba.fastjson.JSONArray;
import com.ct.entity.Product;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImpAndExpExcel {
    public static boolean isExcel2003(String filePath)
    {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    public static boolean isExcel2007(String filePath)
    {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    /**
     * 导入excel
     * @param file
     * @return
     */
    public static List<Product> importData(File file, int maxId)
    {
        Workbook wb = null;
        List<Product> productList = new ArrayList();
        try
        {
            if (ImpAndExpExcel.isExcel2007(file.getPath())) {
                wb = new XSSFWorkbook(new FileInputStream(file));
            } else {
                wb = new HSSFWorkbook(new FileInputStream(file));
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();

            return null;
        }

        Sheet sheet = wb.getSheetAt(0);//获取第一张表
        for (int i = 0; i < sheet.getLastRowNum(); i++)
        {
            Row row = sheet.getRow(i);//获取索引为i的行，以0开始
            String name= StringTools.StringIsNull((row.getCell(0).getStringCellValue()));//获取第i行的索引为0的单元格数据
              String productName= StringTools.StringIsNull((row.getCell(1).getStringCellValue()));//获取第i行的索引为0的单元格数据
              String productPrice= StringTools.StringIsNull((row.getCell(2).getStringCellValue()));//获取第i行的索引为0的单元格数据
              String productCurrency=StringTools.StringIsNull((row.getCell(3).getStringCellValue()));//获取第i行的索引为0的单元格数据
              String productPrice2=StringTools.StringIsNull((row.getCell(4).getStringCellValue()));//获取第i行的索引为0的单元格数据
              String productCurrency2= StringTools.StringIsNull((row.getCell(5).getStringCellValue()));//获取第i行的索引为0的单元格数据
              String productPrice3= StringTools.StringIsNull((row.getCell(6).getStringCellValue()));//获取第i行的索引为0的单元格数据
              String productCurrency3= StringTools.StringIsNull((row.getCell(7).getStringCellValue()));//获取第i行的索引为0的单元格数据
              String productUnit=StringTools.StringIsNull((row.getCell(8).getStringCellValue()));//获取第i行的索引为0的单元格数据
              String productUnit2=StringTools.StringIsNull((row.getCell(9).getStringCellValue()));//获取第i行的索引为0的单元格数据
              String productCount= StringTools.StringIsNull((row.getCell(10).getStringCellValue()));//获取第i行的索引为0的单元格数据
              String productCount2=StringTools.StringIsNull((row.getCell(11).getStringCellValue()));//获取第i行的索引为0的单元格数据
              String productId=StringTools.StringIsNull((row.getCell(12).getStringCellValue()));//获取第i行的索引为0的单元格数据
              String remar= StringTools.StringIsNull((row.getCell(13).getStringCellValue()));//获取第i行的索引为0的单元格数据
             JSONArray imgList=JSONArray.parseArray(StringTools.StringIsNull((row.getCell(0).getStringCellValue())));//获取第i行的索引为0的单元格数据)

            Product product=new Product();
            product.setProductId(String.valueOf(maxId+productId));
            product.setProductName(productName);
            product.setProductPrice(productPrice);
            product.setProductCurrency(productCurrency);
            product.setProductPrice2(productPrice2);
            product.setProductCurrency2(productCurrency2);
            product.setProductPrice3(productPrice3);
            product.setProductCurrency3(productCurrency3);
            product.setProductCount(productCount);
            product.setProductUnit(productUnit);
            product.setProductCount2(productCount2);
            product.setProductUnit2(productUnit2);
            product.setRemark(remar);
            product.setImgList(imgList);
            productList.add(product);

        }
        try
        {
            wb.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        return productList;
    }
    /**
     * 导出excel
     * @param heroList
     * @param templetFilePath
     * @param exportFilePath
     */
    public static void exportHeroInfo(List<Product> heroList, String templetFilePath, String exportFilePath){
        try {
            File exportFile=new File(exportFilePath);
            File templetFile= new File(templetFilePath);
            Workbook workBook;

            if(!exportFile.exists()){
                exportFile.createNewFile();
            }

            FileOutputStream out = new FileOutputStream(exportFile);
            FileInputStream fis = new FileInputStream(templetFile);
            if(isExcel2007(templetFile.getPath())){
                workBook=new XSSFWorkbook(fis);
            }else {
                workBook=new HSSFWorkbook(fis);
            }

            Sheet sheet=workBook.getSheetAt(0);

            int rowIndex = 1 ;
//            for (Hero item :heroList) {
//                Row row=sheet.createRow(rowIndex);
//                row.createCell(0).setCellValue(item.getHeroAge());
//                row.createCell(1).setCellValue(item.getHeroName());
//                rowIndex++;
//            }

            workBook.write(out);
            out.flush();
            out.close();

            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
