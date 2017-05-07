package net.proselyte.springsecurityapp.controller;

        import net.proselyte.springsecurityapp.model.HeaderParam;
        import net.proselyte.springsecurityapp.service.HeaderParamService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Controller;
        import org.springframework.ui.Model;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RequestParam;

        import java.util.Collection;
        import java.util.List;

/**
 *
 */
@Controller
@RequestMapping("/edit/header")
public class HeaderParamController {

    @Autowired
    private HeaderParamService headerParamService;

    @RequestMapping(value = "/getParams",method = RequestMethod.GET)
    public String getParams(Model pModel){
        List<HeaderParam> headerParams = headerParamService.getHeaderParamList();
        pModel.addAttribute("headerParams", headerParams);
        return "header";
    }

    @RequestMapping(value = "/saveParam", method = RequestMethod.POST)
    public String saveParam(@RequestParam HeaderParam pParam, Model pModel){
        headerParamService.saveHeaderParam(pParam);
        return "header";
    }

    @RequestMapping(value = "/setParamDisplay", method = RequestMethod.POST)
    public String setParamDisplay(@RequestParam int pId, @RequestParam boolean isDisplay, Model pModel){
        headerParamService.setHeaderParamDisplay(pId, isDisplay);
        return "header";
    }

    @RequestMapping(value = "/deleteParam", method = RequestMethod.POST)
    public String deleteParam(@RequestParam int pId, Model pModel){
        headerParamService.deleteHeaderParam(pId);
        return "header";
    }
}

