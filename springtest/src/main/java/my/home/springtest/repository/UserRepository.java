package my.home.springtest.repository;

import my.home.springtest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User getUserByName(String name);
    User getUserById(Long id);

}
