package org.transbox.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.transbox.entity.Hospital;
import org.transbox.entity.Information;
import org.transbox.entity.ReportList;
import org.transbox.entity.TransferInfo;
import org.transbox.service.HistoryService;
import org.transbox.service.InformationService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/transboxWeb")
public class HistoryController {
    @Autowired
    HistoryService historyService;

    @RequestMapping(value = "/history/{cookieUserName}/index", method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest handler, @PathVariable("cookieUserName") String cookieUserName) {


       // List<Information> informations = historyService.gainTransferInfoList(cookieUserName,page,pageSize);

        //医院的登录名称
        model.addAttribute("cookieUserName", cookieUserName);



        //  /WEB-INF/jsp/information.jsp
        return "history";

    }

    //0 不排序    1排序
    @RequestMapping(value = "/history/{cookieUserName}/{boxNo}/{hospital}/{getTime}/{filterStatus}/{page}/{pageSize}/index", method = RequestMethod.GET)
    public String historyDetail(Model model, HttpServletRequest handler, @PathVariable("cookieUserName") String cookieUserName,@PathVariable("boxNo")int boxNo,@PathVariable("hospital")int hospital,@PathVariable("getTime")int getTime,@PathVariable("filterStatus")int filterStatus,@PathVariable("page") int page,@PathVariable("pageSize") int pageSize) {


         List<TransferInfo> transferInfoList = historyService.gainTransferInfoList(cookieUserName,boxNo,hospital,getTime,filterStatus,page,pageSize);

        //医院的登录名称
        model.addAttribute("cookieUserName", cookieUserName);
        model.addAttribute("transferInfoList",transferInfoList);


        //  /WEB-INF/jsp/information.jsp
        return "history_detail";

    }

}
