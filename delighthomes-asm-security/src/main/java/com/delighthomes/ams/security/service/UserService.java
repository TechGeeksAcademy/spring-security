package com.delighthomes.ams.security.service;

import com.delighthomes.ams.security.domain.DelightUser;

import java.util.List;

public interface UserService {
    DelightUser create(DelightUser user);
    DelightUser get(String userId);
    DelightUser update(DelightUser user);
    Integer delete(String userId);
    List<DelightUser> getAll();
}
