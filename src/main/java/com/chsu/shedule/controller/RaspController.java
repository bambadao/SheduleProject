package com.chsu.shedule.controller;

import com.chsu.shedule.service.IRaspService;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
    
    @RequestMapping(method = RequestMethod.POST, params={"group","daterange"})
    public String getRaspListByGroup(@ModelAttribute("group") String group, @ModelAttribute("daterange") String dateRange
                                , RedirectAttributes redirectAttributes) {
        if (!group.equals("") && !dateRange.equals("")) {
            Map raspMap = raspService.getRaspListByGroup(group, dateRange);
            redirectAttributes.addFlashAttribute("groupMap", raspMap);
        }
        return "redirect:/index.htm";
    }
    
    @RequestMapping(method = RequestMethod.POST, params={"prepod","daterange"})
    public String getRaspListByPrepod(@ModelAttribute("prepod") String prepod, @ModelAttribute("daterange") String dateRange
                                , RedirectAttributes redirectAttributes) {
        if (!prepod.equals("") && !dateRange.equals("")) {
            Map raspMap = raspService.getRaspListByPrepod(prepod, dateRange);
            redirectAttributes.addFlashAttribute("prepodMap", raspMap);
        }
        return "redirect:/index.htm";
    }
    
    @RequestMapping(value = "/getPDF", method = RequestMethod.GET)
    public ModelAndView showListInPdf(HttpServletRequest request) {
        
        Map raspMap = (Map) request.getAttribute("groupMap");
        int msg = raspMap.size();
        return new ModelAndView("pdfDocument", "msg", msg);
    }
}
