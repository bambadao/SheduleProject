package com.chsu.shedule.controller;

import com.chsu.shedule.domain.Rasp;
import com.chsu.shedule.service.IRaspService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RaspController {
    
    @Autowired
    private IRaspService raspService;
    
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String getRasps(Model model) {
        
//        List<Rasp> rasps = raspService.getRaspList();
//        model.addAttribute("raspList", rasps);
        List<String> groupList = raspService.getGroupList();
        model.addAttribute("groupList", groupList);
        
        List<String> prepodList = raspService.getPrepodList();
        model.addAttribute("prepodList", prepodList);
        
        return "index";
    }
    //
}
