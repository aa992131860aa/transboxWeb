package org.transbox.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.transbox.entity.Information;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class InformationDaoTest {
    @Autowired
    InformationDao informationDao;

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void gainInformations() {
        List<Information> informations = informationDao.gainInformations(null);
        logger.error("information:{}" + informations);
    }
}