
package com.sql_zsgc.control;

import com.sql_zsgc.Repository.SzygdlRepository;
import com.sql_zsgc.control.Utils.ExcelUtil;
import com.sql_zsgc.pojo.Szygdl;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
//返回页面用controller注解和 @RequestMapping
@Controller
public class Zsgc2 {


    @Autowired
    private SzygdlRepository szygdlRepository;

    @RequestMapping("infoM")
    public String getinfo(Model model) {
        List<Szygdl> resultList = szygdlRepository.findAll();
        model.addAttribute("resultList",resultList);
        return "materialInfo";
    }

    //新增物料添加一个空实体到数据库,获取主键.跳转到编辑回显页面
    @RequestMapping(value = "addM")
    public String  addMaterial(Szygdl szygdl,Model model)
            throws IOException{
        szygdl.setCreateDate(new Date());
        szygdl.setPporderDate(new Date());
        szygdlRepository.save(szygdl);
        int id = szygdl.getPpmaterialBarcoderId();
        model.addAttribute("editorAfterInfo",szygdlRepository.getLast());
        return "EditorMaterial";
    }


    //修改物料跳回显页面
    @RequestMapping(value = "editorM")
    public String editorAddMaterial(Model model, int id) {
        List ids = new ArrayList();
        ids.add(id);
        List<Szygdl> resultList = szygdlRepository.findAllById(ids);
        model.addAttribute("editorAfterInfo", resultList.get(0));
        return "EditorMaterial";
    }


    //修改物料并提交保存
    @RequestMapping("/editorM_Up")
    public void queryByiId(Szygdl szygdl, String name,HttpServletResponse response)
            throws Exception{
        int ppmaterialBarcoderId = szygdl.getPpmaterialBarcoderId();
        List ids = new ArrayList();
        ids.add(ppmaterialBarcoderId);
        List<Szygdl> resultList = szygdlRepository.findAllById(ids);
        Szygdl sz = resultList.get(0);
        Date createDate = sz.getCreateDate();
        if(createDate==null){
            sz.setCreateDate(new Date());
        }else {
            szygdl.setCreateDate(createDate);
        }

        Date pporderDate = sz.getPporderDate();
        if(pporderDate==null){
            sz.setPporderDate(new Date());
        }else{
            sz.setPporderDate(pporderDate);
        }

        szygdl.setPporderDate(pporderDate);
        szygdlRepository.save(szygdl);
        response.sendRedirect("/infoM");

    }

    //根据id删除物料
    @RequestMapping("deleteM_ById")
    public void batchesDeleteMaterial(String name,HttpServletResponse response,int id) throws IOException {
        szygdlRepository.deleteById(id);
        response.sendRedirect("/infoM");
    }

    //根据id删除物料
    @RequestMapping("BatchDeleteM_ById")
    public void BatchDeleteM_ById(String name,HttpServletResponse response,int[] checkId) throws IOException {
        for (int id : checkId){
            szygdlRepository.deleteById(id);
        }
        response.sendRedirect("/infoM");
    }


    //跳转到批量删除物料
    @RequestMapping("BatchDeleteM")
    public String deleteMaterial(Model model){
        List<Szygdl> resultList = szygdlRepository.findAllByOrderByPpmaterialBarcoderId();
        model.addAttribute("resultList", resultList);
        return "deleteMaterial";
    }




    //导出物料
    @RequestMapping("exportM")
    public void exportData(HttpServletResponse response) throws Exception {
        List<Szygdl> resultList = szygdlRepository.findAll();
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet();
        ExcelUtil.createTitle(workbook, sheet);
        ExcelUtil.addSheetContent(workbook, sheet, resultList);


        String fileName = "物料数据";
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));

        try {
            OutputStream outputStream = response.getOutputStream();
            workbook.write(outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //导入物料
    @PostMapping("importM")
    public void importData(@RequestParam("file") MultipartFile file, HttpServletRequest req, String name, HttpServletResponse response)
            throws Exception {
        String fileName = System.currentTimeMillis()+file.getOriginalFilename();
       // String destFileName=req.getServletContext().getRealPath("")+"uploaded"+ File.separator+fileName;
        String destFileName=req.getServletContext().getRealPath("") + File.separator+fileName;

        File destFile = new File(destFileName);
        file.transferTo(destFile);
        List<Szygdl> szygdls = ExcelUtil.importExcel(destFile);

        for(Szygdl szygdl: szygdls){
            szygdlRepository.saveAndFlush(szygdl);
        }
        response.sendRedirect("/infoM");
    }


}

