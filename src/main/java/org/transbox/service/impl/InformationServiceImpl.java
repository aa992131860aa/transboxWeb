package org.transbox.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.transbox.dao.InformationDao;
import org.transbox.entity.Hospital;
import org.transbox.entity.Information;
import org.transbox.service.InformationService;

import java.util.List;

@Service
public class InformationServiceImpl implements InformationService {
    @Autowired
    InformationDao informationDao;

    public List<Information> gainInformations(String cookieUserName) {
        return informationDao.gainInformations(null);
    }

    public List<Hospital> gainHospital(String cookieUserName) {
        return informationDao.gainHospital(cookieUserName);
    }
}
