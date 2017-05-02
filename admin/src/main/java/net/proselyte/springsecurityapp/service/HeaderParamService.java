package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.HeaderParam;

/**
 *
 */
public interface HeaderParamService {
    HeaderParam getHeaderParam(int pId);

    void setHeaderParam(HeaderParam pHeaderParam);

    void editHeaderParam(int pId, HeaderParam pHeaderParam);

    void deleteHeaderParam(int pId);
}
