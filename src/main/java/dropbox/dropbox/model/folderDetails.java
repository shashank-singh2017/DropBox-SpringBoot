package dropbox.dropbox.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class folderDetails {
    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public String getGroupMember() {
        return groupMember;
    }

    public void setGroupMember(String groupMember) {
        this.groupMember = groupMember;
    }

    private String folderName;
    private String groupMember;

}
