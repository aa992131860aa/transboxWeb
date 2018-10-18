package org.transbox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.transbox.dao.StatisticsDao;
import org.transbox.entity.*;
import org.transbox.service.StatisticsService;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {
    @Autowired
    StatisticsDao statisticsDao;

    public List<TemperatureAndHumidity> gainTemperatureAndHumidity(String cookieUserName, String userName, String startTime, String endTime, String region, String organType) {
        return statisticsDao.gainTemperatureAndHumidity(cookieUserName, userName, startTime, endTime, region, organType);
    }

    public List<String> gainTransferPerson(String cookieUserName) {

        return statisticsDao.gainTransferPerson(cookieUserName);
    }

    public List<String> gainOrganType() {
        return statisticsDao.gainOrganType();
    }

    public List<String> gainOrganTypeOrder() {
        return statisticsDao.gainOrganTypeOrder();
    }

    public List<TransferPerson> gainTransferPersonTotal(String cookieUserName) {
        return null;
    }

    public List<Region> gainRegion(String cookieUserName, String userName, String startTime, String endTime, String region, String organType) {

        List<Region> regionEntity = statisticsDao.gainRegion(cookieUserName, userName, startTime, endTime, region, organType);

        return regionEntity;
    }

    public List<Organ> gainOrgan(String cookieUserName, String userName, String startTime, String endTime, String region, String organType) {

        List<Organ> organEntity = statisticsDao.gainOrgan(cookieUserName, userName, startTime, endTime, region, organType);

        return organEntity;
    }

    public List<Transfer> gainTransfer(String cookieUserName, String userName, String startTime, String endTime, String region, String organType) {

        List<Transfer> transferEntity = statisticsDao.gainTransfer(cookieUserName, userName, startTime, endTime, region, organType);

        return transferEntity;
    }
}
