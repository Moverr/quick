package com.k15t.pat.repository;
import com.k15t.pat.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * User repository
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
