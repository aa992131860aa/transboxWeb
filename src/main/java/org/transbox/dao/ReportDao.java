package org.transbox.dao;

import org.apache.ibatis.annotations.Param;
import org.transbox.entity.*;

import java.util.List;

public interface ReportDao {

    String gainZone(@Param("hospitalId") String hospitalId);

    List<Page2> gainReportOrgan(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<ReportDetail> gainReportOrganDetail(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("organ") String organ, @Param("page") int page, @Param("pageSize") int pageSize);

    int gainReportOrganDetailTotal(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("organ") String organ, @Param("page") int page, @Param("pageSize") int pageSize);


    Hospital gainHospital(@Param("cookieUserName") String cookieUserName);

    List<Page3> gainPage3(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<ReportDetail> gainPage3Detail(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("province") String province, @Param("page") int page, @Param("pageSize") int pageSize);

    List<Integer> gainPage4Total(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<String> gainPage4(@Param("transferId") String transferId);


    List<String> gainPage5Open(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime);


    List<ReportDetail> gainPage5OpenDetailNormal(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("flag") String flag, @Param("page") int page, @Param("pageSize") int pageSize);

    int gainPage5OpenDetailNormalTotalTemp(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("flag") String flag, @Param("page") int page, @Param("pageSize") int pageSize);

    int gainPage5CollisionDetailNormalTotalTemp(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("flag") String flag, @Param("page") int page, @Param("pageSize") int pageSize);

    List<String> gainPage5OpenDetailNormalTemp(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("flag") String flag, @Param("page") int page, @Param("pageSize") int pageSize);

    List<ReportDetail> gainPage5OpenDetailNoNormal(@Param("transferId") String transferId);

    List<String> gainPage5OpenDetailTotal(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("flag") String flag);

    List<String> gainPage5OpenDetailNormalTotal(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("flag") String flag);

    List<String> gainPage5Collision(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<ReportDetail> gainPage5CollisionDetailNormal(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("flag") String flag, @Param("page") int page, @Param("pageSize") int pageSize);

    List<ReportDetail> gainPage5CollisionDetailNoNormal(@Param("transferId") String transferId);

    List<String> gainPage5CollisionDetailTotal(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("flag") String flag);

    List<String> gainPage5CollisionDetailNormalTotal(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("flag") String flag);

    List<String> gainPage5Temperature(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime);


    List<ReportDetail> gainPage5TemperatureDetailNormal(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("flag") String flag, @Param("page") int page, @Param("pageSize") int pageSize);

    ReportDetail gainPage5TemperatureDetailNoNormal(@Param("transferId") String transferId);

    List<String> gainPage5TemperatureDetailTotal(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("flag") String flag);

    List<String> gainPage5TemperatureDetailNormalTotal(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("flag") String flag);

    int gainPage5Total(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<Page6> gainPage6(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<ReportDetail> gainPage6Detail(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("method") String method, @Param("page") int page, @Param("pageSize") int pageSize);

    int gainPage6DetailTotal(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("method") String method, @Param("page") int page, @Param("pageSize") int pageSize);


    List<Page7> gainPage7(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    int gainPage7Total(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<ReportDetail> gainPage7Detail(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("trueName") String trueName, @Param("page") int page, @Param("pageSize") int pageSize);

    List<Page8> gainPage8(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime);

    List<ReportDetail> gainPage8Detail(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("boxNo") String boxNo, @Param("page") int page, @Param("pageSize") int pageSize);

    int gainPage8DetailTotal(@Param("hospitalId") String hospitalId, @Param("startTime") String startTime, @Param("endTime") String endTime, @Param("boxNo") String boxNo, @Param("page") int page, @Param("pageSize") int pageSize);

}
