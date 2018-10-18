package org.transbox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.transbox.dao.ReportDao;
import org.transbox.entity.*;
import org.transbox.service.ReportService;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReportServiceImpl implements ReportService {
    @Autowired
    ReportDao reportDao;

    public    String gainZone(String hospitalId){
        return reportDao.gainZone(hospitalId);
    }
    public List<Page2> gainReportOrgan(String hospitalId, String startTime, String endTime) {

        return reportDao.gainReportOrgan(hospitalId, startTime, endTime);
    }

    public List<ReportDetail> gainReportOrganDetail(String hospitalId, String startTime, String endTime, String organ, int page, int pageSize) {
        return reportDao.gainReportOrganDetail(hospitalId, startTime, endTime, organ, page, pageSize);
    }

    public int gainReportOrganDetailTotal(String hospitalId, String startTime, String endTime, String organ, int page, int pageSize) {
        return reportDao.gainReportOrganDetailTotal(hospitalId, startTime, endTime, organ, page, pageSize);
    }

    public List<ReportDetail> gainPage3Detail(String hospitalId, String startTime, String endTime, String province, int page, int pageSize) {
        return reportDao.gainPage3Detail(hospitalId, startTime, endTime, province, page, pageSize);
    }


    public Hospital gainHospital(String cookieUserName) {
        return reportDao.gainHospital(cookieUserName);
    }

    public List<Page3> gainPage3(String hospitalId, String startTime, String endTime) {
        return reportDao.gainPage3(hospitalId, startTime, endTime);
    }


    public List<Page4> gainPage4(String hospitalId, String startTime, String endTime) throws ParseException {
        List<Integer> transferIds = reportDao.gainPage4Total(hospitalId, startTime, endTime);
        List<Page4> page4s = new ArrayList<Page4>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        int hour6 = 0;
        int hour12 = 0;
        int hour18 = 0;
        int hour24 = 0;
        int hour25 = 0;
        int hourAll = 0;

        for (int i = 0; i < transferIds.size(); i++) {

            List<String> times = reportDao.gainPage4(transferIds.get(i) + "");

            if (times != null && times.size() >= 2) {
                try {
                    long time = (sdf.parse(times.get(1)).getTime() - sdf.parse(times.get(0)).getTime()) / 1000 / 3600;
                    if (time < 6) {
                        hour6++;
                    } else if (time < 12) {
                        hour12++;
                    } else if (time < 18) {
                        hour18++;
                    } else if (time < 24) {
                        hour24++;
                    } else {
                        hour25++;
                    }
                } catch (Exception e) {
                    hour6++;
                }
            } else {
                hour6++;
            }

            hourAll++;

        }
        List<Integer> hours = new ArrayList<Integer>();
        hours.add(hour6);
        hours.add(hour12);
        hours.add(hour18);
        hours.add(hour24);
        hours.add(hour25);

        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < hours.size(); i++) {
            String name = "";
            if (i == 0) {
                name = "0-6";
            } else if (i == 1) {
                name = "6-12";
            } else if (i == 2) {
                name = "12-18";
            } else if (i == 3) {
                name = "18-24";
            } else if (i == 4) {
                name = "24以上";
            }
            if (max < hours.get(i)) {
                max = hours.get(i);
                maxIndex = i;
            }

            page4s.add(new Page4(name, hours.get(i), (hours.get(i) * 100 / hourAll)));
        }
        page4s.get(maxIndex).setFlag(100);

        return page4s;
    }

    public List<Page5> gainPage5(String hospitalId, String startTime, String endTime) {
        int total = reportDao.gainPage5Total(hospitalId, startTime, endTime);
        List<String> page5Opens = reportDao.gainPage5Open(hospitalId, startTime, endTime);
        List<String> page5Collisions = reportDao.gainPage5Collision(hospitalId, startTime, endTime);
        List<String> page5Temperatures = reportDao.gainPage5Temperature(hospitalId, startTime, endTime);
        List<Page5> page5s = new ArrayList<Page5>();

        Page5 page5 = new Page5();
        page5.setName("温度");
        BigDecimal ratio = new BigDecimal((page5Temperatures.size()) * 100 / total).setScale(0, BigDecimal.ROUND_HALF_UP);
        page5.setY(ratio.intValue());
        page5s.add(page5);

        page5 = new Page5();
        page5.setName("温度");
        //ratio = new BigDecimal(page5Temperatures.size() * 100 / total).setScale(0, BigDecimal.ROUND_HALF_UP);
        page5.setY(100 - ratio.intValue());
        page5s.add(page5);

        page5 = new Page5();
        page5.setName("开箱");
        ratio = new BigDecimal((total - page5Opens.size()) * 100 / total).setScale(0, BigDecimal.ROUND_HALF_UP);
        page5.setY(ratio.intValue());
        page5s.add(page5);

        page5 = new Page5();
        page5.setName("开箱");
        //ratio = new BigDecimal(page5Opens.size() * 100/total).setScale(0, BigDecimal.ROUND_HALF_UP);
        page5.setY(100 - ratio.intValue());
        page5s.add(page5);

        page5 = new Page5();
        page5.setName("碰撞");
        ratio = new BigDecimal((total - page5Collisions.size()) * 100 / total).setScale(0, BigDecimal.ROUND_HALF_UP);
        page5.setY(ratio.intValue());
        page5s.add(page5);

        page5 = new Page5();
        page5.setName("碰撞");
        //ratio = new BigDecimal(page5Collisions.size() * 100 / total).setScale(0, BigDecimal.ROUND_HALF_UP);
        page5.setY(100 - ratio.intValue());
        page5s.add(page5);


        return page5s;
    }

    public int gainPage5DetailTotal(String hospitalId, String startTime, String endTime, String flag, int index, int page, int pageSize) {


        if (index == 1) {

            //colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],

            //合格的温度
            if ("4EBFFD".equals(flag)) {
                return reportDao.gainPage5TemperatureDetailNormalTotal(hospitalId, startTime, endTime, flag).size();
            } else {
                List<String> detailList = reportDao.gainPage5Temperature(hospitalId, startTime, endTime);
                List<String> totalList = reportDao.gainPage5TemperatureDetailTotal(hospitalId, startTime, endTime, flag);
                for (int i = totalList.size() - 1; i >= 0; i--) {
                    for (String id : detailList) {
                        if (id.equals(totalList.get(i))) {
                            totalList.remove(i);
                            break;
                        }
                    }
                }

                return totalList.size();
            }
        } else if (index == 2) {

            //colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],

            //合格的温度
            if ("4EBFFD".equals(flag)) {


                List<String> detailList = reportDao.gainPage5Open(hospitalId, startTime, endTime);
                List<String> totalList = reportDao.gainPage5OpenDetailTotal(hospitalId, startTime, endTime, flag);
                for (int i = totalList.size() - 1; i >= 0; i--) {
                    for (String id : detailList) {
                        if (id.equals(totalList.get(i))) {
                            totalList.remove(i);
                            break;
                        }
                    }
                }

                return totalList.size();
            } else {
                return reportDao.gainPage5OpenDetailNormalTotalTemp(hospitalId, startTime, endTime, flag, page, pageSize);
            }
        } else if (index == 3) {

            //colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],

            //合格的温度
            if ("4EBFFD".equals(flag)) {

                //List<String> page5Opens = reportDao.gainPage5Open(hospitalId, startTime, endTime);
                List<String> detailList = reportDao.gainPage5Collision(hospitalId, startTime, endTime);
                List<String> totalList = reportDao.gainPage5CollisionDetailTotal(hospitalId, startTime, endTime, flag);
                for (int i = totalList.size() - 1; i >= 0; i--) {
                    for (String id : detailList) {
                        if (id.equals(totalList.get(i))) {
                            totalList.remove(i);
                            break;
                        }
                    }
                }

                return totalList.size();
            } else {
                return reportDao.gainPage5CollisionDetailNormalTotalTemp(hospitalId, startTime, endTime, flag, page, pageSize);
            }
        }
        return 0;
    }

    public List<ReportDetail> gainPage5Detail(String hospitalId, String startTime, String endTime, String flag, int index, int page, int pageSize) {
        List<ReportDetail> reportDetailList = new ArrayList<ReportDetail>();
        if (index == 1) {

            //colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],

            //合格的温度
            if ("4EBFFD".equals(flag)) {
                reportDetailList = reportDao.gainPage5TemperatureDetailNormal(hospitalId, startTime, endTime, flag, page, pageSize);

            } else {
                List<String> detailList = reportDao.gainPage5Temperature(hospitalId, startTime, endTime);
                List<String> totalList = reportDao.gainPage5TemperatureDetailTotal(hospitalId, startTime, endTime, flag);
                for (int i = totalList.size() - 1; i >= 0; i--) {
                    for (String id : detailList) {
                        if (id.equals(totalList.get(i))) {
                            totalList.remove(i);
                            break;
                        }
                    }
                }

                for (int i = page; i < (page + pageSize); i++) {
                    if (i > totalList.size() - 1) {
                        continue;
                    } else {
                        ReportDetail reportDetail = reportDao.gainPage5TemperatureDetailNoNormal(totalList.get(i));
                        reportDetailList.add(reportDetail);
                    }
                }

            }
        } else if (index == 2) {

            //colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],

            //合格的温度
            if ("4EBFFD".equals(flag)) {

                List<String> detailList = reportDao.gainPage5Open(hospitalId, startTime, endTime);
                List<String> totalList = reportDao.gainPage5OpenDetailTotal(hospitalId, startTime, endTime, flag);
                for (int i = totalList.size() - 1; i >= 0; i--) {
                    for (String id : detailList) {
                        if (id.equals(totalList.get(i))) {
                            totalList.remove(i);
                            break;
                        }
                    }
                }

                for (int i = page; i < (page + pageSize); i++) {
                    if (i > totalList.size() - 1) {
                        continue;
                    } else {
                        List<ReportDetail> reportDetail = reportDao.gainPage5OpenDetailNoNormal(totalList.get(i));
                        if (reportDetail != null && reportDetail.size() >= 1) {
                            reportDetailList.add(reportDetail.get(0));
                        }

                    }
                }

            } else {
                reportDetailList = reportDao.gainPage5OpenDetailNormal(hospitalId, startTime, endTime, flag, page, pageSize);

            }
        } else if (index == 3) {

            //colors: ['#4EBFFD', '#FAD200', '#2EC4B6'],

            //合格的温度
            if ("4EBFFD".equals(flag)) {

                List<String> detailList = reportDao.gainPage5Collision(hospitalId, startTime, endTime);
                List<String> totalList = reportDao.gainPage5CollisionDetailTotal(hospitalId, startTime, endTime, flag);
                for (int i = totalList.size() - 1; i >= 0; i--) {
                    for (String id : detailList) {
                        if (id.equals(totalList.get(i))) {
                            totalList.remove(i);
                            break;
                        }
                    }
                }

                for (int i = page; i < (page + pageSize); i++) {
                    if (i > totalList.size() - 1) {
                        continue;
                    } else {
                        List<ReportDetail> reportDetail = reportDao.gainPage5CollisionDetailNoNormal(totalList.get(i));
                        if (reportDetail != null && reportDetail.size() >= 1) {
                            reportDetailList.add(reportDetail.get(0));
                        }

                    }
                }

            } else {
                reportDetailList = reportDao.gainPage5CollisionDetailNormal(hospitalId, startTime, endTime, flag, page, pageSize);

            }
        }
        return reportDetailList;
    }


    public List<Page6> gainPage6(String hospitalId, String startTime, String endTime) {
        return reportDao.gainPage6(hospitalId, startTime, endTime);
    }

    public List<ReportDetail> gainPage6Detail(String hospitalId, String startTime, String endTime, String method, int page, int pageSize) {
        return reportDao.gainPage6Detail(hospitalId, startTime, endTime, method, page, pageSize);
    }

    public int gainPage6DetailTotal(String hospitalId, String startTime, String endTime, String method, int page, int pageSize) {
        return reportDao.gainPage6DetailTotal(hospitalId, startTime, endTime, method, page, pageSize);
    }

    public List<Page7> gainPage7(String hospitalId, String startTime, String endTime) {
        return reportDao.gainPage7(hospitalId, startTime, endTime);
    }

    public int gainPage7Total(String hospitalId, String startTime, String endTime) {
        return reportDao.gainPage7Total(hospitalId, startTime, endTime);
    }
    public List<ReportDetail> gainPage7Detail(String hospitalId, String startTime, String endTime, String trueName, int page, int pageSize) {
        return reportDao.gainPage7Detail(hospitalId, startTime, endTime, trueName, page, pageSize);
    }
    public List<Page8> gainPage8(String hospitalId, String startTime, String endTime) {
        return reportDao.gainPage8(hospitalId, startTime, endTime);
    }

    public List<ReportDetail> gainPage8Detail(String hospitalId, String startTime, String endTime, String boxNo, int page, int pageSize) {
        return reportDao.gainPage8Detail(hospitalId, startTime, endTime, boxNo, page, pageSize);
    }

    public int gainPage8DetailTotal(String hospitalId, String startTime, String endTime, String boxNo, int page, int pageSize) {
        return reportDao.gainPage8DetailTotal(hospitalId, startTime, endTime, boxNo, page, pageSize);
    }

}
