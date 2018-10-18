package org.transbox.service.impl;

import ch.qos.logback.core.util.LocationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.transbox.dao.HistoryDao;
import org.transbox.dao.InformationDao;
import org.transbox.entity.BoxOrganSegInfo;
import org.transbox.entity.Hospital;
import org.transbox.entity.Information;
import org.transbox.entity.TransferInfo;
import org.transbox.service.HistoryService;
import org.transbox.service.InformationService;
import org.transbox.utils.LocationUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryDao historyDao;


    public List<TransferInfo> gainTransferInfoList(String cookieUserName, int box, int hospital, int getTime, int filterStatus, int page, int pageSize) {

        List<TransferInfo> transferInfoList = new ArrayList<TransferInfo>();
        //按照箱子排序
        if (box == 1) {

            List<String> allBoxList = historyDao.gainAllBox();
            for (int i = 0; i < allBoxList.size(); i++) {


                String remark = allBoxList.get(i);
                //箱子的所有转运
                List<BoxOrganSegInfo> boxOrganSegInfoList = historyDao.gainOrganSegList(remark);

                for (int k = 0; k < boxOrganSegInfoList.size(); k++) {
                    TransferInfo transferInfo = historyDao.gainTransferInfo(boxOrganSegInfoList.get(k).getTransferId());

                    double maxTemperature = historyDao.gainMaxTemperature(transferInfo.getId());
                    transferInfo.setMaxAvg(maxTemperature);
                    double minTemperature = historyDao.gainMinTemperature(transferInfo.getId());
                    transferInfo.setMinAvg(minTemperature);
                    double avgTemperature = historyDao.gainAvgTemperature(transferInfo.getId());
                    transferInfo.setAvgT(avgTemperature);
                    List<BoxOrganSegInfo> boxOrganSegInfoInnerList = historyDao.gainDetail(transferInfo.getId());
                    int distance = 0;
                    for (int j = boxOrganSegInfoInnerList.size() - 1; j >= 0; j--) {
                        if (j == 0) {
                            transferInfo.setPower(boxOrganSegInfoInnerList.get(j).getPower());
                            transferInfo.setGetTime(boxOrganSegInfoInnerList.get(j).getRecordAt());
                        } else {
                            BoxOrganSegInfo newLL = boxOrganSegInfoInnerList.get(j);
                            BoxOrganSegInfo oldLL = boxOrganSegInfoInnerList.get(j - 1);
                            distance += LocationUtils.getDistance(newLL.getLatitude(), newLL.getLongitude(), oldLL.getLatitude(), oldLL.getLongitude());
                        }
                    }
                    transferInfo.setDistance(distance);

                    int second = boxOrganSegInfoInnerList.size() * 30;
                    String time = second / 3600 + "时" + second % 3600 / 60 + "分";
                    transferInfo.setTrueDurationTime(time);
                    transferInfo.setCorrectDurationTime(time);
                    transferInfoList.add(transferInfo);

                }


                //后台记录的无转运的信息
                String firstTime = historyDao.gainNoOrganSegFirstTime(remark);
                //List<TransferInfo> trasnferNoList = new ArrayList<TransferInfo>();

                if (firstTime != null) {

                    transferNo(remark, firstTime, transferInfoList);

                    while (true) {
                        String maxTime = historyDao.gainNoOrganSegTime(remark, firstTime);
                        firstTime = maxTime;
                        if (maxTime == null) {
                            break;
                        } else {
                            transferNo(remark, firstTime, transferInfoList);
                        }
                        if (transferInfoList.size() > 10) {
                            return transferInfoList;
                        }
                    }

                }

                if (i > 2) {
                    break;
                }
            }
        }
        return transferInfoList;
        //return historyDao.gainTransferInfoList(cookieUserName, box, hospital, getTime, filterStatus, page, pageSize);
    }

    private void transferNo(String remark, String firstTime, List<TransferInfo> trasnferNoList) {
        TransferInfo transferInfo = new TransferInfo();

        double maxAvg = historyDao.gainNoMaxTemperature(remark, firstTime);
        transferInfo.setMaxAvg(maxAvg);

        double minAvg = historyDao.gainNoMinTemperature(remark, firstTime);
        transferInfo.setMinAvg(minAvg);

        List<BoxOrganSegInfo> boxOrganSegInfoInnerList = historyDao.gainNoDetail(remark, firstTime);
        int distance = 0;
        for (int j = boxOrganSegInfoInnerList.size() - 1; j >= 0; j--) {
            if (j == 0) {
                transferInfo.setPower(boxOrganSegInfoInnerList.get(j).getPower());
                transferInfo.setGetTime(boxOrganSegInfoInnerList.get(j).getRecordAt());
            } else {
                BoxOrganSegInfo newLL = boxOrganSegInfoInnerList.get(j);
                BoxOrganSegInfo oldLL = boxOrganSegInfoInnerList.get(j - 1);
                distance += LocationUtils.getDistance(newLL.getLatitude(), newLL.getLongitude(), oldLL.getLatitude(), oldLL.getLongitude());
            }
        }
        transferInfo.setDistance(distance);

        int second = boxOrganSegInfoInnerList.size() * 30;
        String time = second / 3600 + "时" + second % 3600 / 60 + "分";
        transferInfo.setTrueDurationTime(time);
        transferInfo.setCorrectDurationTime(time);
        trasnferNoList.add(transferInfo);

    }

}
