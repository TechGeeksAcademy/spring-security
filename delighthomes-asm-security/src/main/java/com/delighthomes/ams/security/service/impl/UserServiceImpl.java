package com.delighthomes.ams.security.service.impl;

import com.delighthomes.ams.security.domain.DelightUser;
import com.delighthomes.ams.security.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public DelightUser create(DelightUser user) {
        return DelightUser.builder()
                .id(1)
                .first_name("Harish")
                .second_name("Last Name")
                .build();
    }

    @Override
    public DelightUser get(String userId) {
        return DelightUser.builder()
                .id(1)
                .first_name("Harish")
                .second_name("Last Name")
                .build();
    }

    @Override
    public DelightUser update(DelightUser user) {
        return DelightUser.builder()
                .id(1)
                .first_name("Harish")
                .second_name("Last Name")
                .build();
    }

    @Override
    public Integer delete(String userId) {
        return 100;
    }

    @Override
    public List<DelightUser> getAll() {
        return List.of(DelightUser.builder()
                .id(1)
                .first_name("Harish")
                .second_name("Last Name")
                .build());
    }
}
