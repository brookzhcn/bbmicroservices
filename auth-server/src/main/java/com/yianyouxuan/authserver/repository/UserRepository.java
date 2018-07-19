package com.yianyouxuan.authserver.repository;

import com.yianyouxuan.authserver.domain.User;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    User findByUsername(String username);
}
