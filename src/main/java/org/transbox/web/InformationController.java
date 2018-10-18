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
import org.transbox.service.InformationService;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Controller
@RequestMapping("/transboxWeb")
public class InformationController {
    @Autowired
    InformationService informationService;

    @RequestMapping(value = "/information/{cookieUserName}/index", method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest handler, @PathVariable("cookieUserName") String cookieUserName) {


        List<Information> informations = informationService.gainInformations(cookieUserName);

        //医院的登录名称
        model.addAttribute("cookieUserName", cookieUserName);
        model.addAttribute("informations", informations);
        //季度的分类
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        List<ReportList> times = new ArrayList<ReportList>();
        int currentYear = 2018;

        List<Hospital> hospitals = informationService.gainHospital(cookieUserName);
        for (Hospital h : hospitals) {
            for (int i = 0; i <= year - currentYear; i++) {

                if (i == (year - currentYear)) {
                    if (month <= 3) {
                        //times.add(new ReportList((currentYear+i)+"-03",(currentYear+i)+"年第一季度报告"));
                    } else if (month <= 6) {
                        times.add(new ReportList((currentYear + i) + "-01-01=" + (currentYear + i) + "-04-01", (currentYear + i) + "年第一季度报告", h));
                        //times.add(new ReportList((currentYear+i)+"-06",(currentYear+i)+"年第二季度报告"));
                    } else if (month <= 9) {
                        times.add(new ReportList((currentYear + i) + "-01-01=" + (currentYear + i) + "-04-01", (currentYear + i) + "年第一季度报告", h));
                        times.add(new ReportList((currentYear + i) + "-04-01=" + (currentYear + i) + "-07-01", (currentYear + i) + "年第二季度报告", h));
                        //times.add(new ReportList((currentYear+i)+"-09",(currentYear+i)+"年第三季度报告"));
                    } else if (month <= 12) {
                        times.add(new ReportList((currentYear + i) + "-01-01=" + (currentYear + i) + "-04-01", (currentYear + i) + "年第一季度报告", h));
                        times.add(new ReportList((currentYear + i) + "-04-01=" + (currentYear + i) + "-07-01", (currentYear + i) + "年第二季度报告", h));
                        times.add(new ReportList((currentYear + i) + "-09-01=" + (currentYear + i) + "-10-01", (currentYear + i) + "年第三季度报告", h));
                        //times.add(new ReportList((currentYear+i)+"-12",(currentYear+i)+"年第四季度报告"));
                    }

                } else {
                    times.add(new ReportList((currentYear + i) + "-01-01=" + (currentYear + i) + "-04-01", (currentYear + i) + "年第一季度报告", h));
                    times.add(new ReportList((currentYear + i) + "-04-01=" + (currentYear + i) + "-07-01", (currentYear + i) + "年第二季度报告", h));
                    times.add(new ReportList((currentYear + i) + "-07-01=" + (currentYear + i) + "-10-01", (currentYear + i) + "年第三季度报告", h));
                    times.add(new ReportList((currentYear + i) + "-10-01=" + (currentYear + i) + "-12-31", (currentYear + i) + "年第四季度报告", h));
                }

            }
        }

        model.addAttribute("times", times);

        //  /WEB-INF/jsp/information.jsp
        return "information";

    }

}
