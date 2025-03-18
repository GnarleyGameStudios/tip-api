package com.poketeam.api.repository;

import com.poketeam.api.repository.dto.UserDO;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ReactiveCrudRepository<UserDO, Long> {
}
