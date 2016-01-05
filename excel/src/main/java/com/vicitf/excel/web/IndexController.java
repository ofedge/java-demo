package com.vicitf.excel.web;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.vicitf.excel.util.ExcelUtil;

@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    
    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String submit(@RequestParam("file")MultipartFile file, RedirectAttributes attr){
        try {
            List<List<Object>> list = new ArrayList<List<Object>>();
            String name = file.getOriginalFilename();
            System.out.println(name);
            if ("xls".equals(ExcelUtil.getFileExt(name))) {
                list = ExcelUtil.getDataFromXls(file.getInputStream());
            } else {
                list = ExcelUtil.getDataFromXlsx(file.getInputStream());
            }
            System.out.println("size: " + list.size());
            attr.addFlashAttribute("list", list);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/";
    }
}
