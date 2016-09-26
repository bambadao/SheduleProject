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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RaspController {
    
    @Autowired
    private IRaspService raspService;
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getRasps(Model model) {
        
        List<String> groupList = raspService.getGroupList();
        model.addAttribute("groupList", groupList);
        
        List<String> prepodList = raspService.getPrepodList();
        model.addAttribute("prepodList", prepodList);
        
        return "index";
    }
    
    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String getRaspList(@ModelAttribute("group") String str, @ModelAttribute("daterange") String dateRange
                                , Model model, RedirectAttributes redirectAttributes) {
        Map raspMap = raspService.getRaspListByGroup(str, dateRange);
        
        redirectAttributes.addFlashAttribute("raspMap", raspMap);
        return "redirect:/index.htm";
    }
}
