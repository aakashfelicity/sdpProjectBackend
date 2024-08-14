package com.reviewWebsite.flicSite.Repository;

import com.reviewWebsite.flicSite.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);

    void deleteByUsername(String username);

}
