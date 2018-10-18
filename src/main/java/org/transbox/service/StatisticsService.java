package org.transbox.service;

import org.apache.ibatis.annotations.Param;
import org.transbox.entity.*;

import java.util.List;

public interface StatisticsService {

    List<TemperatureAndHumidity> gainTemperatureAndHumidity(String cookieUserName,String userName,String startTime,String endTime,String region,String organType);
    List<String> gainTransferPerson(String cookieUserName);
    List<String> gainOrganType();
    List<String> gainOrganTypeOrder();
    List<TransferPerson> gainTransferPersonTotal(String cookieUserName);

    List<Region> gainRegion(String cookieUserName, String userName, String startTime, String endTime, String region, String organType);
    List<Organ> gainOrgan(String cookieUserName, String userName, String startTime, String endTime, String region, String organType);
    List<Transfer> gainTransfer(String cookieUserName, String userName, String startTime, String endTime, String region, String organType);

}
