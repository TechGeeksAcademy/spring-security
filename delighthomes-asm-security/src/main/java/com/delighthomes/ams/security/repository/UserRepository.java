package com.delighthomes.ams.security.repository;

import com.delighthomes.ams.security.domain.DelightUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<DelightUser,Integer> {
}
