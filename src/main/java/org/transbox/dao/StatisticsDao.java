package org.transbox.dao;

import org.apache.ibatis.annotations.Param;
import org.transbox.entity.*;

import java.util.List;

public interface StatisticsDao {
       List<TemperatureAndHumidity> gainTemperatureAndHumidity(@Param("cookieUserName")String cookieUserName,@Param("userName") String userName,@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("region") String region,@Param("organType") String organType);
       List<String> gainTransferPerson(@Param("cookieUserName")String cookieUserName);
       List<String> gainOrganType();
       List<String> gainOrganTypeOrder();
       List<Region> gainRegion(@Param("cookieUserName")String cookieUserName,@Param("userName") String userName,@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("region") String region,@Param("organType") String organType);
       List<TransferPerson> gainTransferPersonTotal(@Param("cookieUserName")String cookieUserName);
       List<Organ> gainOrgan(@Param("cookieUserName")String cookieUserName, @Param("userName") String userName, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("region") String region, @Param("organType") String organType);
       List<Transfer> gainTransfer(@Param("cookieUserName")String cookieUserName, @Param("userName") String userName, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("region") String region, @Param("organType") String organType);
}
