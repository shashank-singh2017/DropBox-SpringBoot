package dropbox.dropbox.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class folders {
    private String admin;

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    private String folderName;
}
