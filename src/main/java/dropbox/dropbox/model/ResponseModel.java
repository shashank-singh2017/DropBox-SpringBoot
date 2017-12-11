package dropbox.dropbox.model;

import java.io.File;


public class ResponseModel {

    public ResponseModel(){}
    public ResponseModel(File[] resArray,String result,int status){
        this.resArray = resArray;
        this.result=result;
        this.status=status;
    }
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
