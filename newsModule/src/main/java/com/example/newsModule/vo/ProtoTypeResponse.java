package com.example.newsModule.vo;

import com.example.newsModule.entity.ProtoType;

import java.util.List;

public class ProtoTypeResponse {

    private String code;
    
    private String Message;
    
    private List<ProtoType> protoTypeList;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public List<ProtoType> getProtoTypeList() {
        return protoTypeList;
    }

    public void setProtoTypeList(List<ProtoType> protoTypeList) {
        this.protoTypeList = protoTypeList;
    }

    public ProtoTypeResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ProtoTypeResponse(String code, String message, List<ProtoType> protoTypeList) {
        super();
        this.code = code;
        Message = message;
        this.protoTypeList = protoTypeList;
    }
    
}
