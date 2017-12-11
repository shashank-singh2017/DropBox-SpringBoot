package dropbox.dropbox.model;

import java.io.File;

public class ResponseModel {


    public File[] getResArray() {
        return resArray;
    }

    public void setResArray(File[] resArray) {
        this.resArray = resArray;
    }

    private File[] resArray;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    private String result;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private int status;

}
