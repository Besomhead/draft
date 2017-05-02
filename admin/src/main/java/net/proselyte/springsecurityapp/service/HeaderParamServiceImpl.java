package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.dao.HeaderParamDAO;
import net.proselyte.springsecurityapp.model.HeaderParam;
import org.springframework.beans.factory.annotation.Autowired;

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
    public void setHeaderParam(HeaderParam pHeaderParam) {
        headerParamDAO.save(pHeaderParam);
    }

    @Override
    public void editHeaderParam(HeaderParam pHeaderParam) {
        headerParamDAO.save(pHeaderParam);
    }

    @Override
    public void deleteHeaderParam(int pId) {
        headerParamDAO.delete(pId);
    }
}
