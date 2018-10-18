package org.transbox.dao;

import org.apache.ibatis.annotations.Param;
import org.transbox.entity.Hospital;
import org.transbox.entity.Information;

import java.util.List;

public interface InformationDao {
    List<Information> gainInformations(@Param("cookieUserName")String cookieUserName);
    List<Hospital> gainHospital(@Param("cookieUserName") String cookieUserName);
}
