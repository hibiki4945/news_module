package com.example.newsModule.vo;

import com.example.newsModule.entity.Campaign;

import java.util.List;

public class CampaignResponse {

    private String code;
    
    private String Message;
    
//    @JsonProperty("info")
    private List<Campaign> CampaignList;

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

    public List<Campaign> getCampaignList() {
        return CampaignList;
    }

    public void setCampaignList(List<Campaign> campaignList) {
        CampaignList = campaignList;
    }

    public CampaignResponse() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CampaignResponse(String code, String message, List<com.example.newsModule.entity.Campaign> campaign) {
        super();
        this.code = code;
        Message = message;
        CampaignList = campaign;
    }
    
}
