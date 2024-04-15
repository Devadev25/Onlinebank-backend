package com.banking.banking.repository;

import com.banking.banking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  @Query(value = "Select * from users u where u.email = :email", nativeQuery = true)
  Optional<User> existByEmail(@Param("email") String email);

  Optional<User> findByEmail(String email);
  @Query(value = "SELECT u FROM User u JOIN u.account a WHERE a.accountNumber = :accountNumber")
  Optional<User> existByAccountNumber(String accountNumber);

  @Query("SELECT u FROM User u WHERE u.email = :email")
  User findByEmailAccount(@Param("email") String email);


}
