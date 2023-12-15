package com.BipSyncRecuritment.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findUserByUsername(String username);
    User findByUserEmail(String userEmail);

    User save (User user);


    boolean existsByUsername(String username);

    boolean existsByUserEmail(String userEmail);

}
