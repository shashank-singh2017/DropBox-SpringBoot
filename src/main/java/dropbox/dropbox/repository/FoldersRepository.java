package dropbox.dropbox.repository;
import dropbox.dropbox.model.files;
import dropbox.dropbox.model.folders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FoldersRepository extends MongoRepository<folders,String> {

    @Query("{admin : ?0 }")
    List<folders> findAllByAdmin(String admin);
}
