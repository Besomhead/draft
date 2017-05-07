package net.proselyte.springsecurityapp.dao;

import net.proselyte.springsecurityapp.model.HeaderParam;
import net.proselyte.springsecurityapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 *
 */
public interface HeaderParamDAO extends JpaRepository<HeaderParam, Integer> {
}
