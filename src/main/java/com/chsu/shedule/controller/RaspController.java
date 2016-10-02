package com.chsu.shedule.controller;

import com.chsu.shedule.service.IRaspService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/index")
public class RaspController {
    
    @Autowired
    private IRaspService raspService;

    @RequestMapping(method = RequestMethod.GET)
    public String getRasps(Model model) {
        
        List<String> groupList = raspService.getGroupList();
        model.addAttribute("groupList", groupList);
        
        List<String> prepodList = raspService.getPrepodList();
        model.addAttribute("prepodList", prepodList);
        
        return "index";
    }
    
    @RequestMapping(method = RequestMethod.POST, params="group")
    public String getRaspListByGroup(@ModelAttribute("group") String group, @ModelAttribute("daterange") String dateRange
                                , RedirectAttributes redirectAttributes) {
        Map raspMap = raspService.getRaspListByGroup(group, dateRange);
        
        redirectAttributes.addFlashAttribute("raspMap", raspMap);
        return "redirect:/index.htm";
    }
    
    @RequestMapping(method = RequestMethod.POST, params="prepod")
    public String getRaspListByPrepod(@ModelAttribute("prepod") String prepod, @ModelAttribute("daterange") String dateRange
                                , RedirectAttributes redirectAttributes) {
        Map raspMap = raspService.getRaspListByPrepod(prepod, dateRange);
        
        redirectAttributes.addFlashAttribute("raspMap", raspMap);
        return "redirect:/index.htm";
    }
    
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView showListInPdf() {
        
        
        return new ModelAndView("pdfDocument", "raspMaps", null);
    }
}
