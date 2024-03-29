package com.srainbow.leisureten.data.APIData;

/**
 * Created by SRainbow on 2017/4/13.
 */

public class ShowApiPicClassificationData {
    public int showapi_res_code;
    public String showapi_res_error;
    public ShowApiPicClassificationDetail showapi_res_body;

    public ShowApiPicClassificationData() {
    }

    public ShowApiPicClassificationData(int showapi_res_code, String showapi_res_error, ShowApiPicClassificationDetail showapi_res_body) {
        this.showapi_res_code = showapi_res_code;
        this.showapi_res_error = showapi_res_error;
        this.showapi_res_body = showapi_res_body;
    }

    public int getShowapi_res_code() {
        return showapi_res_code;
    }

    public String getShowapi_res_error() {
        return showapi_res_error;
    }

    public ShowApiPicClassificationDetail getShowapi_res_body() {
        return showapi_res_body;
    }

    public void setShowapi_res_code(int showapi_res_code) {
        this.showapi_res_code = showapi_res_code;
    }

    public void setShowapi_res_error(String showapi_res_error) {
        this.showapi_res_error = showapi_res_error;
    }

    public void setShowapi_res_body(ShowApiPicClassificationDetail showapi_res_body) {
        this.showapi_res_body = showapi_res_body;
    }
}
