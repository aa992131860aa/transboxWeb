package org.transbox.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;
import org.transbox.entity.BoxOrganSegInfo;
import org.transbox.entity.Hospital;
import org.transbox.entity.Information;
import org.transbox.entity.TransferInfo;

import java.util.List;

public interface HistoryDao {
    List<TransferInfo> gainTransferInfoList(@Param("cookieUserName") String cookieUserName, @Param("boxNo") int boxNo, @Param("hospital") int hospital, @Param("getTime") int getTime, @Param("filterStatus") int filterStatus, @Param("page") int page, @Param("pageSize") int pageSize);

    List<String> gainAllBox();

    String gainNoOrganSegFirstTime(@Param("remark") String remark);

    String gainNoOrganSegTime(@Param("remark") String remark, @Param("maxTime") String maxTime);

    /**
     * 获取当前箱子的转运
     *
     * @param remark
     * @return
     */
    List<BoxOrganSegInfo> gainOrganSegList(@Param("remark") String remark);

    double gainNoMaxTemperature(@Param("remark") String remark, @Param("maxTime") String maxTime);

    double gainNoMinTemperature(@Param("remark") String remark, @Param("maxTime") String maxTime);

    double gainNoAvgTemperature(@Param("remark") String remark, @Param("maxTime") String maxTime);

    List<BoxOrganSegInfo> gainNoDetail(@Param("remark") String remark, @Param("maxTime") String maxTime);

    TransferInfo gainTransferInfo(@Param("transferId") int transferId);

    double gainMaxTemperature(@Param("transferId") int transferId);

    double gainMinTemperature(@Param("transferId") int transferId);

    double gainAvgTemperature(@Param("transferId") int transferId);

    List<BoxOrganSegInfo> gainDetail(@Param("transferId") int transferId);
}
