package com.sql_zsgc.control.Utils;

import com.sql_zsgc.pojo.Student;
import com.sql_zsgc.pojo.Szygdl;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ExcelUtil {

    public static void createTitle(HSSFWorkbook workbook, HSSFSheet sheet) {
        HSSFRow row = sheet.createRow(0);


        HSSFCell cell;

        cell = row.createCell(0);
        cell.setCellValue("订单号");

        cell = row.createCell(1);
        cell.setCellValue("物料号");


        cell = row.createCell(2);
        cell.setCellValue("物料描述");

        cell = row.createCell(3);
        cell.setCellValue("序列号");

        cell = row.createCell(4);
        cell.setCellValue("条码");

        cell = row.createCell(5);
        cell.setCellValue("工厂英文名");

        cell = row.createCell(6);
        cell.setCellValue("工厂名称");

        cell = row.createCell(7);
        cell.setCellValue("用途");

        cell = row.createCell(8);
        cell.setCellValue("标识");

        cell = row.createCell(9);
        cell.setCellValue("用途说明");

        cell = row.createCell(10);
        cell.setCellValue("非标信息");

        cell = row.createCell(11);
        cell.setCellValue("创建人");

        cell = row.createCell(12);
        cell.setCellValue("创建日期");

        cell = row.createCell(13);
        cell.setCellValue("检查信息");

        cell = row.createCell(14);
        cell.setCellValue("备注");

        cell = row.createCell(15);
        cell.setCellValue("物料规格");

        cell = row.createCell(16);
        cell.setCellValue("物料规格数量");

        cell = row.createCell(17);
        cell.setCellValue("物料规格单位");

        cell = row.createCell(18);
        cell.setCellValue("订单日期");

        cell = row.createCell(19);
        cell.setCellValue("状态");

        cell = row.createCell(20);
        cell.setCellValue("打印数量");


    }


    public static void addSheetContent(HSSFWorkbook workbook, HSSFSheet sheet, List<Szygdl> materialList) {

        int rowNum = 1;
        for (int i = 0; i < materialList.size(); i++) {

            HSSFRow row = sheet.createRow(rowNum);
            HSSFCell cell;

            cell = row.createCell(0);
            cell.setCellValue(materialList.get(i).getPporderHId());

            cell = row.createCell(1);
            cell.setCellValue(materialList.get(i).getMaterialId());

            cell = row.createCell(2);
            cell.setCellValue(materialList.get(i).getMaterialDesc());

            cell = row.createCell(3);
            cell.setCellValue(materialList.get(i).getSerialNo());

            cell = row.createCell(4);
            cell.setCellValue(materialList.get(i).getBaccoderId());

            cell = row.createCell(5);
            cell.setCellValue(materialList.get(i).getPlantEnglishId());

            cell = row.createCell(6);
            cell.setCellValue(materialList.get(i).getPlantDesc());

            cell = row.createCell(7);
            cell.setCellValue(materialList.get(i).getUsageId());

            cell = row.createCell(8);
            cell.setCellValue(materialList.get(i).getMarginId());

            cell = row.createCell(9);
            cell.setCellValue(materialList.get(i).getUsageData());

            cell = row.createCell(10);
            cell.setCellValue(materialList.get(i).getUustandardinfo());

            cell = row.createCell(11);
            cell.setCellValue(materialList.get(i).getCreateUser());

            cell = row.createCell(12);
            cell.setCellValue(materialList.get(i).getCreateDate().toString());

            cell = row.createCell(13);
            cell.setCellValue(materialList.get(i).getCheckInfo());

            cell = row.createCell(14);
            cell.setCellValue(materialList.get(i).getReserve());

            cell = row.createCell(15);
            cell.setCellValue(materialList.get(i).getMaterialSpecial());

            cell = row.createCell(16);
            cell.setCellValue(materialList.get(i).getCety() == null ? 0.0D : materialList.get(i).getCety());

            cell = row.createCell(17);
            cell.setCellValue(materialList.get(i).getUnit());

            cell = row.createCell(18);
            cell.setCellValue(materialList.get(i).getPporderDate().toString());

            cell = row.createCell(19);
            cell.setCellValue(materialList.get(i).getSta());

            cell = row.createCell(20);
            cell.setCellValue(materialList.get(i).getPrintCount() == null ? 0.0D : materialList.get(i).getPrintCount());

            rowNum++;
        }
    }


    public static void addStuSheetContent(HSSFWorkbook workbook, HSSFSheet sheet, List<Student> students) {

        int rowNum = 1;
        for (int i = 0; i < students.size(); i++) {

            HSSFRow row = sheet.createRow(rowNum);
            HSSFCell cell;

            cell = row.createCell(0);
            cell.setCellValue(students.get(i).getSname());

            cell = row.createCell(1);
            cell.setCellValue(students.get(i).getSix());

            cell = row.createCell(2);
            cell.setCellValue(students.get(i).getAge().doubleValue());

            cell = row.createCell(3);
            cell.setCellValue(students.get(i).getAddress());

            cell = row.createCell(4);
            cell.setCellValue(students.get(i).getScore());

            cell = row.createCell(5);
            cell.setCellValue(students.get(i).getClaId());

            cell = row.createCell(6);
            cell.setCellValue(students.get(i).getBirthday().toString());

            rowNum++;
        }
    }

    public static List<Szygdl> importExcel(File file) throws Exception {
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(file));
        HSSFSheet sheet = null;
        sheet = workbook.getSheetAt(0);
        List<Szygdl> list = new ArrayList<Szygdl>();
        SimpleDateFormat sft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        for (int j = 1; j < sheet.getPhysicalNumberOfRows(); j++) {
            Row row = sheet.getRow(j);

            Szygdl szygdl = new Szygdl();

            Cell cell0 = row.getCell(0);
            szygdl.setPporderHId(cell0.getStringCellValue());

            Cell cell1 = row.getCell(1);
            szygdl.setMaterialId(cell1.getStringCellValue());

            Cell cell2 = row.getCell(2);
            szygdl.setMaterialDesc(cell2.getStringCellValue());


            Cell cell3 = row.getCell(3);
            szygdl.setSerialNo(cell3.getStringCellValue());

            Cell cell4 = row.getCell(4);
            szygdl.setBaccoderId(cell4.getStringCellValue());

            Cell cell5 = row.getCell(5);
            szygdl.setPlantEnglishId(cell1.getStringCellValue());


            Cell cell6 = row.getCell(6);
            szygdl.setPlantDesc(cell6.getStringCellValue());

            Cell cell7 = row.getCell(7);
            szygdl.setUsageId(cell7.getStringCellValue());

            Cell cell8 = row.getCell(8);
            szygdl.setMarginId(cell8.getStringCellValue());


            Cell cell9 = row.getCell(9);
            szygdl.setUsageData(cell9.getStringCellValue());

            Cell cell10 = row.getCell(10);
            szygdl.setUustandardinfo(cell10.getStringCellValue());

            Cell cell11 = row.getCell(11);
            szygdl.setCreateUser(cell11.getStringCellValue());


            Cell cell12 = row.getCell(12);
            szygdl.setCreateDate(sft.parse(cell12.getStringCellValue()));

            Cell cell13 = row.getCell(13);
            szygdl.setCheckInfo(cell13.getStringCellValue());

            Cell cell14 = row.getCell(14);
            szygdl.setReserve(cell14.getStringCellValue());


            Cell cell15 = row.getCell(15);
            szygdl.setMaterialSpecial(cell15.getStringCellValue());

            Cell cell16 = row.getCell(16);

            szygdl.setCety(cell16.getNumericCellValue());

            Cell cell17 = row.getCell(17);
            szygdl.setUnit(cell17.getStringCellValue());


            Cell cell18 = row.getCell(18);
            szygdl.setPporderDate(sft.parse(cell18.getStringCellValue()));

            Cell cell19 = row.getCell(19);
            szygdl.setSta(cell9.getStringCellValue());

            Cell cell20 = row.getCell(20);
            szygdl.setPrintCount((cell20.getNumericCellValue()));

            list.add(szygdl);

        }

        return list;
    }



}


