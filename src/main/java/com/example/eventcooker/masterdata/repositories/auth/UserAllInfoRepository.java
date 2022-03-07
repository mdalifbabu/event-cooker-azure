package com.example.eventcooker.masterdata.repositories.auth;

import com.example.eventcooker.masterdata.models.auth.UserAllInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAllInfoRepository extends JpaRepository<UserAllInfo, Long> {
    UserAllInfo findByUserName(String userName);
}
