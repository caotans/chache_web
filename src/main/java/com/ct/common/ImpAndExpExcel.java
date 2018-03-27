package com.ct.common;

import com.alibaba.fastjson.JSONArray;
import com.ct.entity.Product;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImpAndExpExcel {
    public static String uploadPath = "d:/fileupload";

    public static boolean isExcel2003(String filePath) {
        return filePath.matches("^.+\\.(?i)(xls)$");
    }

    public static boolean isExcel2007(String filePath) {
        return filePath.matches("^.+\\.(?i)(xlsx)$");
    }

    /**
     * 导入excel
     *
     * @param file
     * @return
     */
    public static List<Product> importData(File file, int maxId) {
        List<Product> productArrayList = new ArrayList<Product>();
        //错误信息接收器
        String errorMsg = "";
        Workbook wb = null;
        try {
            if (ImpAndExpExcel.isExcel2007(file.getPath())) {
                wb = new XSSFWorkbook(new FileInputStream(file));
            } else {
                wb = new HSSFWorkbook(new FileInputStream(file));
            }
        } catch (IOException e) {
            e.printStackTrace();

            return null;
        }


        try {
            Sheet sheet = wb.getSheetAt(0);//获取第一张表
            //得到Excel的行数
            int totalRows = sheet.getPhysicalNumberOfRows();
            //总列数
            int totalCells = 0;
            //得到Excel的列数(前提是有行数)，从第二行算起
            if (totalRows >= 2 && sheet.getRow(1) != null) {
                totalCells = sheet.getRow(1).getPhysicalNumberOfCells();
            }

            Product product;

            String br = "<br/>";
            //循环Excel行数,从第二行开始。标题不入库
            for (int r = 1; r < totalRows; r++) {
                String rowMessage = "";
                Row row = sheet.getRow(r);
                if (row == null) {
                    errorMsg += br + "第" + (r) + "行数据有问题，请仔细检查！";
                    continue;
                }
                product = new Product();


                //循环Excel的列
                for (int c = 0; c < totalCells; c++) {
                    Cell cell = row.getCell(c);
                    cell.setCellType(CellType.STRING);
                    if (null != cell) {

                        if (c == 0) {
                            String productId = cell.getStringCellValue();
                            if (StringUtils.isEmpty(productId)) {
                                rowMessage += "问题不能为空；";
                            } else if (productId.length() > 60) {
                                rowMessage += "问题的字数不能超过60；";
                            }
                            product.setProductId(productId);
                        } else if (c == 1) {
                            String productName = cell.getStringCellValue();//获取第i行的索引为0的单元格数据
                            if (StringUtils.isEmpty(productName)) {
                                rowMessage += "产品不能为空；";
                            } else if (productName.length() > 20) {
                                rowMessage += "产品的字数不能超过20；";
                            }
                            product.setProductName(productName);
                        } else if (c == 2) {
                            String productPrice = cell.getStringCellValue();//获取第i行的索引为0的单元格数据
                            if (StringUtils.isEmpty(productPrice)) {
                                rowMessage += "价格一不能为空；";
                            } else if (productPrice.length() > 1000) {
                                rowMessage += "价格一的字数不能超过20；";
                            }
                            product.setProductPrice(productPrice);
                        } else if (c == 3) {
                            String productCurrency = cell.getStringCellValue();//获取第i行的索引为0的单元格数据
                            if (StringUtils.isEmpty(productCurrency)) {
                                rowMessage += "货币一不能为空；";
                            } else if (productCurrency.length() > 1000) {
                                rowMessage += "货币一的字数不能超过20；";
                            }
                            product.setProductCurrency(productCurrency);
                        } else if (c == 4) {
                            String productPrice2 = cell.getStringCellValue();//获取第i行的索引为0的单元格数据
//                            if (StringUtils.isEmpty(productPrice2)) {
//                                rowMessage += "价格二不能为空；";
//                            } else if (productPrice2.length() > 1000) {
//                                rowMessage += "价格二的字数不能超过20；";
//                            }
                            product.setProductPrice2(productPrice2);
                        } else if (c == 5) {
                            String productCurrency2 =cell.getStringCellValue();//获取第i行的索引为0的单元格数据
//                            if (StringUtils.isEmpty(productCurrency2)) {
//                                rowMessage += "货币二不能为空；";
//                            } else if (productCurrency2.length() > 1000) {
//                                rowMessage += "货币二的字数不能超过20；";
//                            }
                            product.setProductCurrency2(productCurrency2);
                        } else if (c == 6) {
                            String productPrice3 = cell.getStringCellValue();//获取第i行的索引为0的单元格数据
//                            if (StringUtils.isEmpty(productPrice3)) {
//                                rowMessage += "价格三不能为空；";
//                            } else if (productPrice3.length() > 1000) {
//                                rowMessage += "价格三的字数不能超过20；";
//                            }
                            product.setProductPrice3(productPrice3);
                        } else if (c == 7) {
                            String productCurrency3 =cell.getStringCellValue();//获取第i行的索引为0的单元格数据
//                            if (StringUtils.isEmpty(productCurrency3)) {
//                                rowMessage += "货币三不能为空；";
//                            } else if (productCurrency3.length() > 1000) {
//                                rowMessage += "货币三的字数不能超过20；";
//                            }
                            product.setProductCurrency3(productCurrency3);
                        } else if (c == 8) {
                            String productUnit =cell.getStringCellValue();//获取第i行的索引为0的单元格数据
                            if (StringUtils.isEmpty(productUnit)) {
                                rowMessage += "单位不能为空；";
                            } else if (productUnit.length() > 1000) {
                                rowMessage += "单位的字数不能超过20；";
                            }
                            product.setProductUnit(productUnit);
                        } else if (c == 9) {
                            String productCount =cell.getStringCellValue();//获取第i行的索引为0的单元格数据
                            if (StringUtils.isEmpty(productCount)) {
                                rowMessage += "数量不能为空；";
                            } else if (productCount.length() > 1000) {
                                rowMessage += "数量的字数不能超过20；";
                            }
                            product.setProductCount(productCount);
                        } else if (c == 10) {
                            String productUnit2 = cell.getStringCellValue();//获取第i行的索引为0的单元格数据
                            if (StringUtils.isEmpty(productUnit2)) {
                                rowMessage += "拼单单位不能为空；";
                            } else if (productUnit2.length() > 1000) {
                                rowMessage += "拼单单位的字数不能超过20；";
                            }
                            product.setProductUnit2(productUnit2);
                        } else if (c == 11) {
                            String productCount2 = cell.getStringCellValue();//获取第i行的索引为0的单元格数据
                            if (StringUtils.isEmpty(productCount2)) {
                                rowMessage += "拼单数量不能为空；";
                            } else if (productCount2.length() > 1000) {
                                rowMessage += "拼单数量的字数不能超过20；";
                            }
                            product.setProductUnit2(productCount2);
                        } else if (c == 12) {
                            String remark = cell.getStringCellValue();//获取第i行的索引为0的单元格数据
                            if (StringUtils.isEmpty(remark)) {
                                rowMessage += "备注不能为空；";
                            } else if (remark.length() > 1000) {
                                rowMessage += "备注的字数不能超过50；";
                            }
                            product.setRemark(remark);
                        } else if (c == 13) {
                            String imgString=cell.getStringCellValue();
                            JSONArray jsonArray=new JSONArray();
                            String [] imgArray=imgString.split(",");
                            for(int i=0;i<imgArray.length;i++){
                                jsonArray.add(imgArray[i]);
                            }
                            if (StringUtils.isEmpty(jsonArray)) {
                                rowMessage += "图片不能为空；";
                            } else if (jsonArray.size() > 10) {
                                rowMessage += "图片的字数不能超过50；";
                            }
                            product.setImgList(jsonArray);
                        }
                    } else {
                        rowMessage += "第" + (c + 1) + "列数据有问题，请仔细检查；";
                    }
                }
                //拼接每行的错误提示
                if (!StringUtils.isEmpty(rowMessage)) {
                    errorMsg += br + "第" + (r) + "行，" + rowMessage;
                    break;
                } else {
                    productArrayList.add(product);
                }
            }
            if(!StringUtils.isEmpty(errorMsg)){
                    productArrayList=new ArrayList<Product>();
                    Product product1=new Product();
                    product1.setRemark(errorMsg);
                    product1.setProductName("error");
                    productArrayList.add(product1);
            }
            //删除上传的临时文件
            if (file.exists()) {
                file.delete();
            }
            wb.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productArrayList;
    }

    /**
     * 导出excel
     *
     * @param heroList
     * @param templetFilePath
     * @param exportFilePath
     */
    public static void exportHeroInfo(List<Product> heroList, String templetFilePath, String exportFilePath) {
        try {
            File exportFile = new File(exportFilePath);
            File templetFile = new File(templetFilePath);
            Workbook workBook;

            if (!exportFile.exists()) {
                exportFile.createNewFile();
            }

            FileOutputStream out = new FileOutputStream(exportFile);
            FileInputStream fis = new FileInputStream(templetFile);
            if (isExcel2007(templetFile.getPath())) {
                workBook = new XSSFWorkbook(fis);
            } else {
                workBook = new HSSFWorkbook(fis);
            }

            Sheet sheet = workBook.getSheetAt(0);

            int rowIndex = 1;
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
