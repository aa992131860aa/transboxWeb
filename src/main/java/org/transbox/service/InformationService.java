package org.transbox.service;

import org.transbox.entity.Hospital;
import org.transbox.entity.Information;

import java.util.List;

public interface InformationService {
    List<Information> gainInformations(String cookieUserName);

    List<Hospital> gainHospital(String cookieUserName);
}
