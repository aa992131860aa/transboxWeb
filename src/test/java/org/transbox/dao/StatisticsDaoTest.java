package org.transbox.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.transbox.entity.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class StatisticsDaoTest {
    @Autowired
    StatisticsDao statisticsDao;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void gainTemperatureAndHumidity() {
//     List<TemperatureAndHumidity> temperatureAndHumidities = statisticsDao.gainTemperatureAndHumidity("shulanadmin",null,null,null,null);
//     for(TemperatureAndHumidity t:temperatureAndHumidities){
//         System.out.println(t.toString());
//     }
//        temperatureAndHumidities = statisticsDao.gainTemperatureAndHumidity(null,null,null,null,null);
//        for(TemperatureAndHumidity t:temperatureAndHumidities){
//            System.out.println("two:"+t.toString());
//        }
    }

    @Test
    public void gainTransferPerson() {
        List<String> list = statisticsDao.gainTransferPerson("aa");
        System.out.println("transferPerson:" + list);
    }

    @Test
    public void gainOrganType() {
        List<String> list = statisticsDao.gainOrganType();
        System.out.println("organType:" + list);
    }

    private List<Integer> heartList = new ArrayList<Integer>();
    private List<Integer> liverList = new ArrayList<Integer>();
    private List<Integer> kidneyList = new ArrayList<Integer>();
    private List<Integer> lungList = new ArrayList<Integer>();
    private List<Integer> spleenList = new ArrayList<Integer>();
    private List<Integer> corneaList = new ArrayList<Integer>();

    @Test
    public void gainRegion() {

        List<Region> regionList = statisticsDao.gainRegion("admin", null, null, null, null, null);

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
        typeList = statisticsDao.gainOrganTypeOrder();


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

        logger.error("list={}", regionAnalysis);

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

    List<Integer> mOrganCountList;
    List<Organ> mOrganList;

    @Test
    public void gainOrgan() {
        List<Organ> organList = statisticsDao.gainOrgan("admin", null, null, null, null, null);
        OrganAnalysis organAnalysis = new OrganAnalysis();
        mOrganCountList = new ArrayList<Integer>();
        mOrganList = new ArrayList<Organ>();
        //类型的排序 心脏 眼角膜 肝脏 肺 肾脏 胰脏
        for (int i = 0; i < organList.size(); i++) {
            boolean isLast = (i == (organList.size() - 1)) ? true : false;
            dealOrganType(organList.get(i).getOrgan(), organList.get(i).getOrganCount(), isLast);
        }
        if (organList.size() <= 0 ) {
            mOrganCountList.add(0);
            mOrganCountList.add(0);
            mOrganCountList.add(0);
            mOrganCountList.add(0);
            mOrganCountList.add(0);
            mOrganCountList.add(0);
        }
        organAnalysis.setOrganCount(mOrganCountList);
        organAnalysis.setOrgan(statisticsDao.gainOrganTypeOrder());


        logger.debug("organAnalysis={}", organAnalysis);
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
            if (!"心脏".equals(organStr)) {
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
            if (!"心脏".equals(organStr)) {
                mOrganList.add(0, new Organ("心脏", 0));
                mOrganCountList.add(0, 0);
            }
            if (!"眼角膜".equals(organStr)) {
                mOrganList.add(1, new Organ("眼角膜", 0));
                mOrganCountList.add(1, 0);
            }
            if (!"肝脏".equals(organStr)) {
                mOrganList.add(2, new Organ("肝脏", 0));
                mOrganCountList.add(2, 0);
            }
        } else if ("肾脏".equals(organ)) {

            mOrganList.add(new Organ(organ, organCount));
            mOrganCountList.add(organCount);

            for (int i = 0; i < mOrganList.size(); i++) {
                organStr += mOrganList.get(i).getOrgan();
            }
            if (!"心脏".equals(organStr)) {
                mOrganList.add(0, new Organ("心脏", 0));
                mOrganCountList.add(0, 0);
            }
            if (!"眼角膜".equals(organStr)) {
                mOrganList.add(1, new Organ("眼角膜", 0));
                mOrganCountList.add(1, 0);
            }
            if (!"肝脏".equals(organStr)) {
                mOrganList.add(2, new Organ("肝脏", 0));
                mOrganCountList.add(2, 0);
            }
            if (!"肺".equals(organStr)) {
                mOrganList.add(3, new Organ("肺", 0));
                mOrganCountList.add(3, 0);
            }
        } else if ("胰脏".equals(organ) || isLast) {

            mOrganList.add(new Organ(organ, organCount));
            mOrganCountList.add(organCount);
            for (int i = 0; i < mOrganList.size(); i++) {
                organStr += mOrganList.get(i).getOrgan();
            }
            if (!"心脏".equals(organStr)) {
                mOrganList.add(0, new Organ("心脏", 0));
                mOrganCountList.add(0, 0);
            }
            if (!"眼角膜".equals(organStr)) {
                mOrganList.add(1, new Organ("眼角膜", 0));
                mOrganCountList.add(1, 0);
            }
            if (!"肝脏".equals(organStr)) {
                mOrganList.add(2, new Organ("肝脏", 0));
                mOrganCountList.add(2, 0);
            }
            if (!"肺".equals(organStr)) {
                mOrganList.add(3, new Organ("肺", 0));
                mOrganCountList.add(3, 0);
            }
            if (!"肾脏".equals(organStr)) {
                mOrganList.add(4, new Organ("肾脏", 0));
                mOrganCountList.add(4, 0);
            }
        }
    }

}