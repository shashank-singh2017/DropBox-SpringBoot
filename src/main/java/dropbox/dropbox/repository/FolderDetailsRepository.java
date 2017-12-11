package dropbox.dropbox.repository;


import dropbox.dropbox.model.folderDetails;
import dropbox.dropbox.model.folders;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface FolderDetailsRepository extends MongoRepository<folderDetails,String> {

    @Query("{folderName : ?0}")
    List<folderDetails> findAllByFolderName(String folderName);
}
