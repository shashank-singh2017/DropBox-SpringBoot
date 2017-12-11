package dropbox.dropbox.repository;
import dropbox.dropbox.model.users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<users,String> {

    @Query("{email : ?0 }")
    List<users> findAllByEmail(String email);

    @Query("{email : ?0,password:?1 }")
    List<users> findAllByUsernameAndPassword(String email,String password);

    @Query("{username : ?0 }")
    List<users> findByUsername(String username);
}
