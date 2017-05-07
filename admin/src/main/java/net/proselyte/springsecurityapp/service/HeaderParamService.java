package net.proselyte.springsecurityapp.service;

import net.proselyte.springsecurityapp.model.HeaderParam;

import java.util.List;

/**
 *
 */
public interface HeaderParamService {
    HeaderParam getHeaderParam(int pId);

    void saveHeaderParam(HeaderParam pHeaderParam);

    void deleteHeaderParam(int pId);

    List<HeaderParam> getHeaderParamList();
}
