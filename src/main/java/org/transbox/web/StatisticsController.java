package org.transbox.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.transbox.dto.TransferWebResult;
import org.transbox.entity.*;
import org.transbox.service.StatisticsService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/transboxWeb")
public class StatisticsController {

    /**
     * 统计界面
     */
    @Autowired
    StatisticsService statisticsService;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/statistics/{cookieUserName}/index", method = RequestMethod.GET)
    public String list(Model model, HttpServletRequest handler, @PathVariable("cookieUserName") String cookieUserName) {


        List<String> list = statisticsService.gainOrganType();
        List<String> transferPerson = statisticsService.gainTransferPerson(cookieUserName);
        //器官类型
        model.addAttribute("organType", list);
        //转运人
        model.addAttribute("transferPerson", transferPerson);
        //医院的登录名称
        model.addAttribute("cookieUserName", cookieUserName);
        //  /WEB-INF/jsp/"statistics".jsp
        return "statistics";

    }

    /**
     * 温湿度数据
     *
     * @param cookieUserName
     * @param startTime
     * @param endTime
     * @param organType
     * @param transferPerson
     * @param region
     * @return
     */
    @RequestMapping(value = "/statistics/gainTemperatureAndHumidity/charts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TransferWebResult<List<TemperatureAndHumidity>> gainTemperatureAndHumidity(@RequestParam("cookieUserName") String cookieUserName,
                                                                                      @RequestParam("startTime") String startTime,
                                                                                      @RequestParam("endTime") String endTime,
                                                                                      @RequestParam("organType") String organType,
                                                                                      @RequestParam("transferPerson") String transferPerson,
                                                                                      @RequestParam("region") String region) {
        List<TemperatureAndHumidity> list = statisticsService.gainTemperatureAndHumidity(cookieUserName, transferPerson, startTime, endTime, region, organType);
        logger.error("list={}", list);
        return new TransferWebResult<List<TemperatureAndHumidity>>(true, list);
    }

    /**
     * 器官类型
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/statistics/organType", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public String gainOrganType(Model model) {
        List<String> list = statisticsService.gainOrganType();
        model.addAttribute("organType", list);

        return "organType";
    }

    private List<Integer> heartList = new ArrayList<Integer>();
    private List<Integer> liverList = new ArrayList<Integer>();
    private List<Integer> kidneyList = new ArrayList<Integer>();
    private List<Integer> lungList = new ArrayList<Integer>();
    private List<Integer> spleenList = new ArrayList<Integer>();
    private List<Integer> corneaList = new ArrayList<Integer>();

    /**
     * 温湿度数据
     * 1.获取器官的类型
     * 2.根据省份分配数量
     *
     * @param cookieUserName
     * @param startTime
     * @param endTime
     * @param organType
     * @param transferPerson
     * @param region
     * @return
     */
    @RequestMapping(value = "/statistics/gainRegion/charts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TransferWebResult<RegionAnalysis> gainRegion(@RequestParam("cookieUserName") String cookieUserName,
                                                        @RequestParam("startTime") String startTime,
                                                        @RequestParam("endTime") String endTime,
                                                        @RequestParam("organType") String organType,
                                                        @RequestParam("transferPerson") String transferPerson,
                                                        @RequestParam("region") String region) {

        List<Region> regionList = statisticsService.gainRegion(cookieUserName, transferPerson, startTime, endTime, region, organType);
        //上一条的省份
        String oldProvince = null;
        RegionAnalysis regionAnalysis = new RegionAnalysis();

        heartList = new ArrayList<Integer>();
        liverList = new ArrayList<Integer>();
        kidneyList = new ArrayList<Integer>();
        lungList = new ArrayList<Integer>();
        spleenList = new ArrayList<Integer>();
        corneaList = new ArrayList<Integer>();
        List<String> typeList = new ArrayList<String>();
        List<String> provinceList = new ArrayList<String>();
        typeList = statisticsService.gainOrganTypeOrder();


        //类型的排序 心脏 眼角膜 肝脏 肺 肾脏 胰脏
        for (int i = 0; i < regionList.size(); i++) {
            Region r = regionList.get(i);
            boolean isLast = (i == (regionList.size() - 1)) ? true : false;
            //和上一条是同一省份
            if (r.getProvince().equals(oldProvince)) {
                dealOrgan(r.getOrgan(), r.getOrganCount(), isLast);
            } else {
                //和上一条不是同一省份,判断是否是第一条和最后一条
                if (i == 0) {

                }

                provinceList.add(r.getProvince());

                dealOrgan(r.getOrgan(), r.getOrganCount(), isLast);


            }
            oldProvince = r.getProvince();

        }
        regionAnalysis.setHeartList(heartList);
        regionAnalysis.setCorneaList(corneaList);
        regionAnalysis.setLiverList(liverList);
        regionAnalysis.setLungList(lungList);
        regionAnalysis.setKidneyList(kidneyList);
        regionAnalysis.setSpleenList(spleenList);
        regionAnalysis.setProvinceList(provinceList);
        regionAnalysis.setTypeList(typeList);
        logger.debug("regionList={}", regionList);
        logger.debug("regionAnalysis={}", regionAnalysis);

        return new TransferWebResult<RegionAnalysis>(true, regionAnalysis);
    }


    private void dealOrgan(String organ, int organCount, boolean isLast) {
        if ("心脏".equals(organ)) {

            heartList.add(organCount);
        } else if ("眼角膜".equals(organ)) {


            corneaList.add(organCount);
            if (heartList.size() < corneaList.size()) {
                heartList.add(0);
            }
        } else if ("肝脏".equals(organ)) {

            liverList.add(organCount);

            if (heartList.size() < liverList.size()) {
                heartList.add(0);
            }
            if (corneaList.size() < liverList.size()) {
                corneaList.add(0);
            }
        } else if ("肺".equals(organ)) {

            lungList.add(organCount);

            if (heartList.size() < lungList.size()) {
                heartList.add(0);
            }
            if (corneaList.size() < lungList.size()) {
                corneaList.add(0);
            }
            if (liverList.size() < lungList.size()) {
                liverList.add(0);
            }

        } else if ("肾脏".equals(organ)) {

            kidneyList.add(organCount);
            if (heartList.size() < kidneyList.size()) {
                heartList.add(0);
            }
            if (corneaList.size() < kidneyList.size()) {
                corneaList.add(0);
            }
            if (liverList.size() < kidneyList.size()) {
                liverList.add(0);
            }
            if (lungList.size() < kidneyList.size()) {
                lungList.add(0);
            }
        } else if ("胰脏".equals(organ) || isLast) {

            spleenList.add(organCount);
            if (heartList.size() < spleenList.size()) {
                heartList.add(0);
            }
            if (corneaList.size() < spleenList.size()) {
                corneaList.add(0);
            }
            if (liverList.size() < spleenList.size()) {
                liverList.add(0);
            }
            if (lungList.size() < spleenList.size()) {
                lungList.add(0);
            }
            if (kidneyList.size() < spleenList.size()) {
                kidneyList.add(0);
            }
        }
    }


    private List<Organ> mOrganList = new ArrayList<Organ>();
    private List<Integer> mOrganCountList = new ArrayList<Integer>();

    /**
     * @param cookieUserName
     * @param startTime
     * @param endTime
     * @param organType
     * @param transferPerson
     * @param region
     * @return
     */
    @RequestMapping(value = "/statistics/gainOrgan/charts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TransferWebResult<OrganAnalysis> gainOrgan(@RequestParam("cookieUserName") String cookieUserName,
                                                      @RequestParam("startTime") String startTime,
                                                      @RequestParam("endTime") String endTime,
                                                      @RequestParam("organType") String organType,
                                                      @RequestParam("transferPerson") String transferPerson,
                                                      @RequestParam("region") String region) {
        List<Organ> organList = statisticsService.gainOrgan(cookieUserName, transferPerson, startTime, endTime, region, organType);
        OrganAnalysis organAnalysis = new OrganAnalysis();
        mOrganCountList = new ArrayList<Integer>();
        mOrganList = new ArrayList<Organ>();
        //类型的排序 心脏 眼角膜 肝脏 肺 肾脏 胰脏
        for (int i = 0; i < organList.size(); i++) {
            boolean isLast = (i == (organList.size() - 1)) ? true : false;
            dealOrganType(organList.get(i).getOrgan(), organList.get(i).getOrganCount(), isLast);
        }
        if (organList.size() == 0) {
            mOrganCountList.add(0);
            mOrganCountList.add(0);
            mOrganCountList.add(0);
            mOrganCountList.add(0);
            mOrganCountList.add(0);
            mOrganCountList.add(0);
        }
        List<OrganPie> organPies = new ArrayList<OrganPie>();

        for (int i = 0; i < mOrganList.size(); i++) {
            String color = "";

            if (i == 0) {
                color = "#6bb3e5";
            } else if (i == 1) {
                color = "#f0be77";
            } else if (i == 2) {
                color = "#86c66d";
            } else if (i == 3) {
                color = "#e7e29e";
            } else if (i == 4) {
                color = "#d1e369";
            } else if (i == 5) {
                color = "#e99688";
            }

            organPies.add(new OrganPie(mOrganList.get(i).getOrgan(), mOrganCountList.get(i), color));
        }

        organAnalysis.setOrganCount(mOrganCountList);
        organAnalysis.setOrgan(statisticsService.gainOrganTypeOrder());
        organAnalysis.setOrganList(organPies);


        logger.debug("organAnalysis={}", organAnalysis);
        return new TransferWebResult<OrganAnalysis>(true, organAnalysis);
    }

    private void dealOrganType(String organ, int organCount, boolean isLast) {
        String organStr = "";
        if ("心脏".equals(organ)) {

            mOrganList.add(new Organ(organ, organCount));
            mOrganCountList.add(organCount);
        } else if ("眼角膜".equals(organ)) {


            mOrganList.add(new Organ(organ, organCount));
            mOrganCountList.add(organCount);
            for (int i = 0; i < mOrganList.size(); i++) {
                organStr += mOrganList.get(i).getOrgan();
            }
            if (!"心脏".equals(organStr)) {
                mOrganList.add(0, new Organ("心脏", 0));
                mOrganCountList.add(0, 0);
            }
        } else if ("肝脏".equals(organ)) {

            mOrganList.add(new Organ(organ, organCount));
            mOrganCountList.add(organCount);

            for (int i = 0; i < mOrganList.size(); i++) {
                organStr += mOrganList.get(i).getOrgan();
            }
            if (!organStr.contains("心脏")) {
                mOrganList.add(0, new Organ("心脏", 0));
                mOrganCountList.add(0, 0);
            }
            if (!"眼角膜".equals(organStr)) {
                mOrganList.add(1, new Organ("眼角膜", 0));
                mOrganCountList.add(1, 0);
            }

        } else if ("肺".equals(organ)) {

            mOrganList.add(new Organ(organ, organCount));
            mOrganCountList.add(organCount);

            for (int i = 0; i < mOrganList.size(); i++) {
                organStr += mOrganList.get(i).getOrgan();
            }
            if (!organStr.contains("心脏")) {
                mOrganList.add(0, new Organ("心脏", 0));
                mOrganCountList.add(0, 0);
            }
            if (!organStr.contains("眼角膜")) {
                mOrganList.add(1, new Organ("眼角膜", 0));
                mOrganCountList.add(1, 0);
            }
            if (!organStr.contains("肝脏")) {
                mOrganList.add(2, new Organ("肝脏", 0));
                mOrganCountList.add(2, 0);
            }
        } else if ("肾脏".equals(organ)) {

            mOrganList.add(new Organ(organ, organCount));
            mOrganCountList.add(organCount);

            for (int i = 0; i < mOrganList.size(); i++) {
                organStr += mOrganList.get(i).getOrgan();
            }
            if (!organStr.contains("心脏")) {
                mOrganList.add(0, new Organ("心脏", 0));
                mOrganCountList.add(0, 0);
            }
            if (!organStr.contains("眼角膜")) {
                mOrganList.add(1, new Organ("眼角膜", 0));
                mOrganCountList.add(1, 0);
            }
            if (!organStr.contains("肝脏")) {
                mOrganList.add(2, new Organ("肝脏", 0));
                mOrganCountList.add(2, 0);
            }
            if (!organStr.contains("肺")) {
                mOrganList.add(3, new Organ("肺", 0));
                mOrganCountList.add(3, 0);
            }
        } else if ("胰脏".equals(organ) || isLast) {

            mOrganList.add(new Organ(organ, organCount));
            mOrganCountList.add(organCount);
            for (int i = 0; i < mOrganList.size(); i++) {
                organStr += mOrganList.get(i).getOrgan();
            }
            if (!organStr.contains("心脏")) {
                mOrganList.add(0, new Organ("心脏", 0));
                mOrganCountList.add(0, 0);
            }
            if (!organStr.contains("眼角膜")) {
                mOrganList.add(1, new Organ("眼角膜", 0));
                mOrganCountList.add(1, 0);
            }
            if (!organStr.contains("肝脏")) {
                mOrganList.add(2, new Organ("肝脏", 0));
                mOrganCountList.add(2, 0);
            }
            if (!organStr.contains("肺")) {
                mOrganList.add(3, new Organ("肺", 0));
                mOrganCountList.add(3, 0);
            }
            if (!organStr.contains("肾脏")) {
                mOrganList.add(4, new Organ("肾脏", 0));
                mOrganCountList.add(4, 0);
            }
        }
    }

    /**
     * @param cookieUserName
     * @param startTime
     * @param endTime
     * @param organType
     * @param transferPerson
     * @param region
     * @return
     */
    @RequestMapping(value = "/statistics/gainTransfer/charts", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public TransferWebResult<TransferAnalysis> gainTransfer(@RequestParam("cookieUserName") String cookieUserName,
                                                            @RequestParam("startTime") String startTime,
                                                            @RequestParam("endTime") String endTime,
                                                            @RequestParam("organType") String organType,
                                                            @RequestParam("transferPerson") String transferPerson,
                                                            @RequestParam("region") String region) {
        List<Transfer> transferList = statisticsService.gainTransfer(cookieUserName, transferPerson, startTime, endTime, region, organType);
        TransferAnalysis transferAnalysis = new TransferAnalysis();
        List<String> trueNameList = new ArrayList<String>();
        List<Integer> trueNameCountList = new ArrayList<Integer>();
        for (Transfer transfer : transferList) {
            trueNameList.add(transfer.getTrueName());
            trueNameCountList.add(transfer.getTrueNameCount());
        }
        transferAnalysis.setTrueNameList(trueNameList);
        transferAnalysis.setTrueNameCountList(trueNameCountList);

        logger.debug("transferAnalysis={}", transferAnalysis);
        return new TransferWebResult<TransferAnalysis>(true, transferAnalysis);
    }

}
