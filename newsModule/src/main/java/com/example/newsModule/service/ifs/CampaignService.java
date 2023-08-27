package com.example.newsModule.service.ifs;

import com.example.newsModule.entity.Campaign;
import com.example.newsModule.vo.CampaignResponse;

import java.util.List;

public interface CampaignService {
    
    public CampaignResponse addInfo(List<Campaign> CampaignList);
    
    public CampaignResponse changeInfo(List<Campaign> CampaignList);
    
    public CampaignResponse getInfo(String title);
    
    public CampaignResponse deleteInfo(String title);
    
    
    public CampaignResponse Top10Info();
    
    public CampaignResponse findAllInfo();

    public CampaignResponse getBetweenInfo(String time1, String time2);
    
}
