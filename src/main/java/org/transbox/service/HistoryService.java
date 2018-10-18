package org.transbox.service;

import org.transbox.entity.Hospital;
import org.transbox.entity.Information;
import org.transbox.entity.TransferInfo;

import java.util.List;

public interface HistoryService {
    List<TransferInfo> gainTransferInfoList(String cookieUserName, int box, int hospital, int getTime, int filterStatus, int page, int pageSize);


}
