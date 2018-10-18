package org.transbox.service;

import org.transbox.entity.*;

import java.text.ParseException;
import java.util.List;

public interface ReportService {

    List<Page2> gainReportOrgan(String hospitalId, String startTime, String endTime);

    List<ReportDetail> gainReportOrganDetail(String hospitalId, String startTime, String endTime, String organ, int page, int pageSize);

    int gainReportOrganDetailTotal(String hospitalId, String startTime, String endTime, String organ, int page, int pageSize);

    Hospital gainHospital(String cookieUserName);

    List<Page3> gainPage3(String hospitalId, String startTime, String endTime);
    String gainZone(String hospitalId);

    List<ReportDetail> gainPage3Detail(String hospitalId, String startTime, String endTime, String province, int page, int pageSize);


    List<Page4> gainPage4(String hospitalId, String startTime, String endTime) throws ParseException;

    List<Page5> gainPage5(String hospitalId, String startTime, String endTime);

    List<ReportDetail> gainPage5Detail(String hospitalId, String startTime, String endTime, String flag, int index, int page, int pageSize);

    int gainPage5DetailTotal(String hospitalId, String startTime, String endTime, String flag, int index, int page, int pageSize);


    List<Page6> gainPage6(String hospitalId, String startTime, String endTime);

    List<ReportDetail> gainPage6Detail(String hospitalId, String startTime, String endTime, String method, int page, int pageSize);

    int gainPage6DetailTotal(String hospitalId, String startTime, String endTime, String method, int page, int pageSize);

    List<Page7> gainPage7(String hospitalId, String startTime, String endTime);

    int gainPage7Total(String hospitalId, String startTime, String endTime);
    List<ReportDetail> gainPage7Detail(String hospitalId, String startTime, String endTime, String trueName, int page, int pageSize);

    List<Page8> gainPage8(String hospitalId, String startTime, String endTime);

    List<ReportDetail> gainPage8Detail(String hospitalId, String startTime, String endTime, String boxNo, int page, int pageSize);

    int gainPage8DetailTotal(String hospitalId, String startTime, String endTime, String boxNo, int page, int pageSize);
}
