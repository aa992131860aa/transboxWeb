package org.transbox.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.transbox.dto.TransferWebResult;
import org.transbox.entity.*;
import org.transbox.service.ReportService;
import org.transbox.utils.CONSTS;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/transboxWeb")
public class ReportController {
    @Autowired
    ReportService reportService;
    String startTime = "";
    String endTime = "";
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/report/{hospitalId}/{hospitalName}/{time}/{title}/index", method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest handler, @PathVariable("hospitalId") String hospitalId, @PathVariable("hospitalName") String hospitalName, @PathVariable("time") String time, @PathVariable("title") String title) {

        startTime = time.split("=")[0];
        endTime = time.split("=")[1];
        //Hospital hospital = reportService.gainHospital(cookieUserName);
        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("title", title);
        model.addAttribute("hospitalName", hospitalName);
        model.addAttribute("hospitalId", hospitalId);


        return "full_report";

    }

    @RequestMapping(value = "/report_detail/{hospitalId}/{startTime}/{endTime}/{organ}/{page}/page2", method = RequestMethod.GET)
    public String reportDetail(Model model, HttpServletRequest handler, @PathVariable("hospitalId") String hospitalId, @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime, @PathVariable("organ") String organ, @PathVariable("page") int page) {
        List<ReportDetail> reportDetails = reportService.gainReportOrganDetail(hospitalId, startTime, endTime, organ, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE);
        int total = reportService.gainReportOrganDetailTotal(hospitalId, startTime, endTime, organ, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE);

        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("hospitalId", hospitalId);
        model.addAttribute("organ", organ);
        model.addAttribute("page", page);
        model.addAttribute("pageSize", CONSTS.PAGE_SIZE);
        model.addAttribute("total", total);
        model.addAttribute("pageIndex", 2);
        model.addAttribute("reportDetails", reportDetails);

        //  /WEB-INF/jsp/report_detail.jsp
        return "report_detail";

    }


    /**
     * 温湿度数据
     *
     * @param startTime
     * @param endTime
     * @param hospitalId
     * @return
     */
    @RequestMapping(value = "/report/page2/charts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TransferWebResult<List<Page2>> gainTemperatureAndHumidity(
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime,
            @RequestParam("hospitalId") String hospitalId
    ) {
        List<Page2> page2s = reportService.gainReportOrgan(hospitalId, startTime, endTime);
        int organTotal = 0;
        int overOrganTotal = 0;
        //器官类型的字符
        String organTypeStr = "";
        //最大的标识
        int organMax = 0;
        //Page2 maxPage2 = new Page2();
        List<Page2> newPages = new ArrayList<Page2>();
        for (int i = 0; i < page2s.size(); i++) {
            if (organMax < page2s.get(i).getZ()) {
                organMax = i;
            }
            organTotal += page2s.get(i).getZ();
        }
        for (int i = 0; i < page2s.size(); i++) {
            int ratio = page2s.get(i).getZ() * 100 / organTotal;
            if (i == organMax) {
                page2s.get(i).setZ(100);
            }

            organTypeStr += page2s.get(i).getName();
            if (i == page2s.size() - 1) {
                ratio = 100 - overOrganTotal;
            }
            overOrganTotal += ratio;
            Page2 page2 = new Page2(page2s.get(i).getZ(), page2s.get(i).getName(), ratio);
            newPages.add(page2);
        }
        //maxPage2.setY(organMax * 100 / organTotal);
        //model.addAttribute("page2", newPages);
        //model.addAttribute("maxPage2", maxPage2);
        if (!organTypeStr.contains("心脏")) {
            newPages.add(0, new Page2(0, "心脏", 0));
        }
        if (!organTypeStr.contains("肝脏")) {
            newPages.add(1, new Page2(0, "肝脏", 0));
        }
        if (!organTypeStr.contains("肾脏")) {
            newPages.add(2, new Page2(0, "肾脏", 0));
        }
        if (!organTypeStr.contains("肺")) {
            newPages.add(3, new Page2(0, "肺", 0));
        }
        if (!organTypeStr.contains("胰脏")) {
            newPages.add(4, new Page2(0, "胰脏", 0));
        }
        if (!organTypeStr.contains("眼角膜")) {
            newPages.add(5, new Page2(0, "眼角膜", 0));
        }


        for (int i = 0; i < newPages.size(); i++) {
            int yTemp = newPages.get(i).getY();
            int zTemp = newPages.get(i).getZ();
            newPages.get(i).setY(zTemp);
            newPages.get(i).setZ(yTemp);

        }
        logger.error("list2={}", newPages);
        return new TransferWebResult<List<Page2>>(true, newPages);
    }

    /**
     * 温湿度数据
     *
     * @param startTime
     * @param endTime
     * @param hospitalId
     * @return
     */
    @RequestMapping(value = "/report/page3/charts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TransferWebResult<List<Page3>> gainPage3(
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime,
            @RequestParam("hospitalId") String hospitalId
    ) {
        List<Page3> page2s = reportService.gainPage3(hospitalId, startTime, endTime);
        String address = reportService.gainZone(hospitalId);
        int organTotal = 0;
        //最大的标识
        int organMaxIndex = 0;
        long organMaxValue = 0;
        //Page2 maxPage2 = new Page2();
        List<Page3> newPages = new ArrayList<Page3>();
        for (int i = 0; i < page2s.size(); i++) {
            if (organMaxValue < page2s.get(i).getValue()) {

                organMaxIndex = i;
                organMaxValue = page2s.get(i).getValue();
            }
            organTotal += page2s.get(i).getValue();
        }
        for (int i = 0; i < page2s.size(); i++) {
            int ratio = (int) (page2s.get(i).getValue() * 100 / organTotal);
            if (i == organMaxIndex) {
                page2s.get(i).setFlag(100);
            }
            String color = "";
            if (i % 2 == 0) {
                color = "#4EBFFD";
            } else {
                color = "#FAD200";
            }
            Page3 page2 = new Page3(color, page2s.get(i).getValue(), page2s.get(i).getName(), ratio, page2s.get(i).getFlag(), address.split("市")[0]);
            newPages.add(page2);
        }
        logger.error("list3Address={}", address + "," + address.split("市")[0]);
        logger.error("list3={}", newPages);
        return new TransferWebResult<List<Page3>>(true, newPages);
    }

    @RequestMapping(value = "/report_detail/{hospitalId}/{startTime}/{endTime}/{province}/{total}/{page}/page3", method = RequestMethod.GET)
    public String reportDetail3(Model model, HttpServletRequest handler, @PathVariable("hospitalId") String hospitalId, @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime, @PathVariable("province") String province, @PathVariable("total") int total, @PathVariable("page") int page) {
        List<ReportDetail> reportDetails = reportService.gainPage3Detail(hospitalId, startTime, endTime, province, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE);

        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("hospitalId", hospitalId);
        model.addAttribute("province", province);
        model.addAttribute("page", page);
        model.addAttribute("pageSize", CONSTS.PAGE_SIZE);
        model.addAttribute("total", total);
        model.addAttribute("pageIndex", 3);
        model.addAttribute("reportDetails", reportDetails);

        //  /WEB-INF/jsp/report_detail.jsp
        return "report_detail";

    }


    /**
     * 温湿度数据
     *
     * @param startTime
     * @param endTime
     * @param hospitalId
     * @return
     */
    @RequestMapping(value = "/report/page4/charts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TransferWebResult<List<Page4>> gainPage4(
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime,
            @RequestParam("hospitalId") String hospitalId
    ) {

        List<Page4> page7s = new ArrayList<Page4>();
        try {
            page7s = reportService.gainPage4(hospitalId, startTime, endTime);

        } catch (ParseException e) {
            e.printStackTrace();


        }



        return new TransferWebResult<List<Page4>>(true, page7s);
    }

    @RequestMapping(value = "/report_detail/{hospitalId}/{startTime}/{endTime}/{flag}/{index}/{page}/page5", method = RequestMethod.GET)
    public String reportDetail5(Model model, HttpServletRequest handler, @PathVariable("hospitalId") String hospitalId, @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime, @PathVariable("flag") String flag, @PathVariable("index") int index, @PathVariable("page") int page) {
        //List<ReportDetail> reportDetails = reportService.gainPage5Detail(hospitalId, startTime, endTime, flag, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE);

        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("hospitalId", hospitalId);

        model.addAttribute("page", page);
        model.addAttribute("pageSize", CONSTS.PAGE_SIZE);
        //model.addAttribute("total", total);
        model.addAttribute("pageIndex", 5);

        if (index == 1) {

            //colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],

            model.addAttribute("index", 1);
            model.addAttribute("total", reportService.gainPage5DetailTotal(hospitalId, startTime, endTime, flag, index, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE));
            model.addAttribute("reportDetails", reportService.gainPage5Detail(hospitalId, startTime, endTime, flag, index, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE));


        } else if (index == 2) {
            model.addAttribute("index", 2);
            model.addAttribute("total", reportService.gainPage5DetailTotal(hospitalId, startTime, endTime, flag, index, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE));
            model.addAttribute("reportDetails", reportService.gainPage5Detail(hospitalId, startTime, endTime, flag, index, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE));

        } else if (index == 3) {
            model.addAttribute("index", 3);
            model.addAttribute("total", reportService.gainPage5DetailTotal(hospitalId, startTime, endTime, flag, index, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE));
            model.addAttribute("reportDetails", reportService.gainPage5Detail(hospitalId, startTime, endTime, flag, index, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE));

        }
        //model.addAttribute("reportDetails", reportDetails);

        //  /WEB-INF/jsp/report_detail.jsp
        return "report_detail";

    }

    /**
     * 温湿度数据
     *
     * @param startTime
     * @param endTime
     * @param hospitalId
     * @return
     */
    @RequestMapping(value = "/report/page5/charts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TransferWebResult<List<Page5>> gainPage5(
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime,
            @RequestParam("hospitalId") String hospitalId
    ) {

        List<Page5> page7s = reportService.gainPage5(hospitalId, startTime, endTime);


        logger.error("list5={}", page7s);
        return new TransferWebResult<List<Page5>>(true, page7s);
    }

    /**
     * 温湿度数据
     *
     * @param startTime
     * @param endTime
     * @param hospitalId
     * @return
     */
    @RequestMapping(value = "/report/page6/charts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TransferWebResult<List<Page6>> gainPage6(
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime,
            @RequestParam("hospitalId") String hospitalId
    ) {
        List<Page6> page2s = reportService.gainPage6(hospitalId, startTime, endTime);
        int organTotal = 0;
        //最大的标识
        int organMax = 0;
        //Page2 maxPage2 = new Page2();
        List<Page6> newPages = new ArrayList<Page6>();
        for (int i = 0; i < page2s.size(); i++) {
            if (organMax < page2s.get(i).getY()) {

                organMax = i;
            }
            organTotal += page2s.get(i).getY();
        }
        for (int i = 0; i < page2s.size(); i++) {
            int ratio = (int) (page2s.get(i).getY() * 100 / organTotal);
            if (i == organMax) {
                page2s.get(i).setFlag(100);
            }
            String color;
            if (i % 2 == 0) {
                color = "#4EBFFD";
            } else {
                color = "#FAD200";
            }
            Page6 page2 = new Page6(color, page2s.get(i).getY(), page2s.get(i).getName(), ratio, page2s.get(i).getFlag());
            newPages.add(page2);
        }

        logger.error("list6={}", newPages);
        return new TransferWebResult<List<Page6>>(true, newPages);
    }

    @RequestMapping(value = "/report_detail/{hospitalId}/{startTime}/{endTime}/{method}/{page}/page6", method = RequestMethod.GET)
    public String reportDetail6(Model model, HttpServletRequest handler, @PathVariable("hospitalId") String hospitalId, @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime, @PathVariable("method") String method, @PathVariable("page") int page) {
        List<ReportDetail> reportDetails = reportService.gainPage6Detail(hospitalId, startTime, endTime, method, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE);
        int total = reportService.gainPage6DetailTotal(hospitalId, startTime, endTime, method, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE);

        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("hospitalId", hospitalId);
        model.addAttribute("method", method);
        model.addAttribute("page", page);
        model.addAttribute("pageSize", CONSTS.PAGE_SIZE);
        model.addAttribute("total", total);
        model.addAttribute("pageIndex", 6);
        model.addAttribute("reportDetails", reportDetails);

        //  /WEB-INF/jsp/report_detail.jsp
        return "report_detail";

    }


    /**
     * 温湿度数据
     *
     * @param startTime
     * @param endTime
     * @param hospitalId
     * @return
     */
    @RequestMapping(value = "/report/page7/charts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TransferWebResult<List<Page7>> gainPage7(
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime,
            @RequestParam("hospitalId") String hospitalId
    ) {
        int page7Total = reportService.gainPage7Total(hospitalId, startTime, endTime);
        List<Page7> page7s = reportService.gainPage7(hospitalId, startTime, endTime);

        for (int i = 0; i < page7s.size(); i++) {
            page7s.get(i).setTotal(page7Total);
        }
        logger.error("list7={}", page7s);
        return new TransferWebResult<List<Page7>>(true, page7s);
    }

    @RequestMapping(value = "/report_detail/{hospitalId}/{startTime}/{endTime}/{trueName}/{total}/{index}/{page}/page7", method = RequestMethod.GET)
    public String reportDetail7(Model model, HttpServletRequest handler, @PathVariable("hospitalId") String hospitalId, @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime, @PathVariable("trueName") String trueName, @PathVariable("total") int total, @PathVariable("index") int index, @PathVariable("page") int page) {
        List<ReportDetail> reportDetails = reportService.gainPage7Detail(hospitalId, startTime, endTime, trueName, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE);

        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("hospitalId", hospitalId);
        model.addAttribute("trueName", trueName);
        model.addAttribute("page", page);
        model.addAttribute("pageSize", CONSTS.PAGE_SIZE);
        model.addAttribute("total", total);
        model.addAttribute("index", index);
        model.addAttribute("pageIndex", 7);
        model.addAttribute("reportDetails", reportDetails);

        //  /WEB-INF/jsp/report_detail.jsp
        return "report_detail";

    }

    /**
     * 温湿度数据
     *
     * @param startTime
     * @param endTime
     * @param hospitalId
     * @return
     */
    @RequestMapping(value = "/report/page8/charts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TransferWebResult<List<Page8>> gainPage8(
            @RequestParam("startTime") String startTime,
            @RequestParam("endTime") String endTime,
            @RequestParam("hospitalId") String hospitalId
    ) {
        List<Page8> page2s = reportService.gainPage8(hospitalId, startTime, endTime);
        int organTotal = 0;
        //最大的标识
        int organMax = 0;
        //Page2 maxPage2 = new Page2();
        List<Page8> newPages = new ArrayList<Page8>();
        for (int i = 0; i < page2s.size(); i++) {
            if (organMax < page2s.get(i).getY()) {

                organMax = i;
            }
            organTotal += page2s.get(i).getY();
        }
        for (int i = 0; i < page2s.size(); i++) {
            int ratio = (int) (page2s.get(i).getY() * 100 / organTotal);
            if (i == organMax) {
                page2s.get(i).setFlag(100);
            }
            String color = "";
            if (i % 2 == 0) {
                color = "#4EBFFD";
            } else {
                color = "#FAD200";
            }
            Page8 page2 = new Page8(color, page2s.get(i).getY(), page2s.get(i).getName(), ratio, page2s.get(i).getFlag());
            newPages.add(page2);
        }

        logger.error("list8={}", newPages);
        return new TransferWebResult<List<Page8>>(true, newPages);
    }

    @RequestMapping(value = "/report_detail/{hospitalId}/{startTime}/{endTime}/{boxNo}/{page}/page8", method = RequestMethod.GET)
    public String reportDetail8(Model model, HttpServletRequest handler, @PathVariable("hospitalId") String hospitalId, @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime, @PathVariable("boxNo") String boxNo, @PathVariable("page") int page) {
        List<ReportDetail> reportDetails = reportService.gainPage8Detail(hospitalId, startTime, endTime, boxNo, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE);
        int total = reportService.gainPage8DetailTotal(hospitalId, startTime, endTime, boxNo, page * CONSTS.PAGE_SIZE, CONSTS.PAGE_SIZE);

        model.addAttribute("startTime", startTime);
        model.addAttribute("endTime", endTime);
        model.addAttribute("hospitalId", hospitalId);
        model.addAttribute("boxNo", boxNo);
        model.addAttribute("page", page);
        model.addAttribute("pageSize", CONSTS.PAGE_SIZE);
        model.addAttribute("total", total);
        model.addAttribute("pageIndex", 8);
        model.addAttribute("reportDetails", reportDetails);

        //  /WEB-INF/jsp/report_detail.jsp
        return "report_detail";

    }


}
