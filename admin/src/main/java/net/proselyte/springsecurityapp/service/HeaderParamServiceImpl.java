package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.HeaderParamDAO;
import net.proselyte.springsecurityapp.model.HeaderParam;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

/**
 *
 */
public class HeaderParamServiceImpl implements HeaderParamService {
    @Autowired
    private HeaderParamDAO headerParamDAO;

    @Override
    public HeaderParam getHeaderParam(int pId) {
        return headerParamDAO.getOne(pId);
    }

    @Override
    public void saveHeaderParam(HeaderParam pHeaderParam) {
        headerParamDAO.saveAndFlush(pHeaderParam);
    }

    @Override
    public void deleteHeaderParam(int pId) {
        headerParamDAO.delete(pId);
    }

    @Override
    public List<HeaderParam> getHeaderParamList() {
        return headerParamDAO.findAll();
    }
}
