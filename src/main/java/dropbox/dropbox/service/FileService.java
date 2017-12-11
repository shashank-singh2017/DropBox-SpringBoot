package dropbox.dropbox.service;

import dropbox.dropbox.model.ResponseModel;
import dropbox.dropbox.model.files;
import dropbox.dropbox.model.folderDetails;
import dropbox.dropbox.model.folders;
import dropbox.dropbox.repository.FolderDetailsRepository;
import dropbox.dropbox.repository.FoldersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class FileService {
    @Autowired
    private FoldersRepository foldersRepository;
    @Autowired
    private FolderDetailsRepository folderDetailsRepository;
    private static String dir = System.getProperty("user.dir");
    ResponseModel model=new ResponseModel();


    public File[] findFiles(String username){

     //   return fileRepository.findAllByParent_id(username);

        File folder = new File(dir+"/UserData/"+username+"/");
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                System.out.println("File " + listOfFiles[i].getName());
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
        return listOfFiles;
    }

    public void addFolder(folders folder)
    {
        foldersRepository.save(folder);
    }

    public void addFolderDetails(folderDetails folderDetail)
    {
        folderDetailsRepository.save(folderDetail);
    }
}
