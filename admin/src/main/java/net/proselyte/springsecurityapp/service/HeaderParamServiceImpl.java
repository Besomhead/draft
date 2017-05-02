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
        return headerParamDAO.getHeaderParam(pId);
    }

    @Override
    public void setHeaderParam(HeaderParam pHeaderParam) {
        headerParamDAO.setHeaderParam(pHeaderParam);
    }

    @Override
    public void editHeaderParam(int pId, HeaderParam pHeaderParam) {
        headerParamDAO.editHeaderParam(pId, pHeaderParam);
    }

    @Override
    public void deleteHeaderParam(int pId) {
        headerParamDAO.deleteHeaderParam(pId);
    }
}
