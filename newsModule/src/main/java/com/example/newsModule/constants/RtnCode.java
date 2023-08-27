package com.example.newsModule.constants;

public enum RtnCode {

    SUCCESSFUL("200", "successful!"),
    DATA_ERROR("400", "data error"),
    TITLE_ERROR("400", "title error"),
    SUB_TITLE_ERROR("400", "sub title error"),
    START_TIME_ERROR("400", "start time error"),
    END_TIME_ERROR("400", "end time error"),
    CONTENT_ERROR("400", "content error"),
    SUB_CONTENT_ERROR("400", "sub content error"),
    TITLE_DUPLICATE_ERROR("400", "title duplicate error"),
    TITLE_NO_FOUND_ERROR("400", "title no found error");
    
    private String code;
    
    private String message;

    private RtnCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
}
