package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.HeaderParam;

/**
 *
 */
public interface HeaderParamDAO {
    HeaderParam getHeaderParam(int pId);

    void setHeaderParam(HeaderParam pHeaderParam);

    void editHeaderParam(int pId, HeaderParam pHeaderParam);

    void deleteHeaderParam(int pId);
}
