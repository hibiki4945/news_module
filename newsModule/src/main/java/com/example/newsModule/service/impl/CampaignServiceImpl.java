package com.example.newsModule.service.impl;

import com.example.newsModule.constants.RtnCode;
import com.example.newsModule.entity.Campaign;
import com.example.newsModule.repository.CampaignDao;
import com.example.newsModule.service.ifs.CampaignService;
import com.example.newsModule.vo.CampaignResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CampaignServiceImpl implements CampaignService{

    @Autowired
    private CampaignDao campaignDao;
    
    @Override
    public CampaignResponse addInfo(List<Campaign> campaignList) {
        // TODO Auto-generated method stub

//      check : campaignList = null?
        if(campaignList == null) {
            return new CampaignResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), campaignList);
        }
        for (Campaign item : campaignList) {
            CampaignResponse res = checkInfo(item, campaignList);
            if(res.getCode() != "200") {
                return res;
            }
//          check : existById(item.title)
            if(campaignDao.existsById(item.getTitle())) {
                return new CampaignResponse(RtnCode.TITLE_DUPLICATE_ERROR.getCode(), RtnCode.TITLE_DUPLICATE_ERROR.getMessage(), campaignList);       
            }
            
            campaignDao.save(item);
        }
        
        return new CampaignResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), campaignList);
    }

    @Override
    public CampaignResponse changeInfo(List<Campaign> campaignList) {
        // TODO Auto-generated method stub

//      check : campaignList = null?
        if(campaignList == null) {
            return new CampaignResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), campaignList);
        }
        for (Campaign item : campaignList) {
            CampaignResponse res = checkInfo(item, campaignList);
            if(res.getCode() != "200") {
                return res;
            }
            
//          check : not existById(item.title)
            if(!campaignDao.existsById(item.getTitle())) {
                return new CampaignResponse(RtnCode.TITLE_NO_FOUND_ERROR.getCode(), RtnCode.TITLE_NO_FOUND_ERROR.getMessage(), campaignList);       
            }          
            
            campaignDao.save(item);   
            
        }
        return new CampaignResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), campaignList);
    }

    private CampaignResponse checkInfo(Campaign item, List<Campaign> campaignList) {

//      check : item = null
        if(item == null) {
            return new CampaignResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), campaignList);
        }
//      check : item.title = null || item.title.isBlank()
        if(item.getTitle() == null || item.getTitle().isBlank()) {
            return new CampaignResponse(RtnCode.TITLE_ERROR.getCode(), RtnCode.TITLE_ERROR.getMessage(), campaignList);
        }
//      check : item.subTitle = null || item.subTitle.isBlank()
        if(item.getSubTitle() == null || item.getSubTitle().isBlank()) {
            return new CampaignResponse(RtnCode.SUB_TITLE_ERROR.getCode(), RtnCode.SUB_TITLE_ERROR.getMessage(), campaignList);
        }
//      check : item.startTime = \\d\\d\\d\\d-\\d\\d-\\d\\d
        if(!(item.getStartTime().matches("[\\d]{4}-[\\d]{2}-[\\d]{2}"))) {
            return new CampaignResponse(RtnCode.START_TIME_ERROR.getCode(), RtnCode.START_TIME_ERROR.getMessage(), campaignList);
        }
//      check : item.endTime = \\d\\d\\d\\d-\\d\\d-\\d\\d
        if(!(item.getEndTime().matches("[\\d]{4}-[\\d]{2}-[\\d]{2}"))) {
            return new CampaignResponse(RtnCode.END_TIME_ERROR.getCode(), RtnCode.END_TIME_ERROR.getMessage(), campaignList);
        }
//      check : item.content = null || item.content.isBlank()
        if(item.getContent() == null || item.getContent().isBlank()) {
            return new CampaignResponse(RtnCode.CONTENT_ERROR.getCode(), RtnCode.CONTENT_ERROR.getMessage(), campaignList);
        }
//      check : item.subContent = null || item.subContent.isBlank()
        if(item.getSubContent() == null || item.getSubContent().isBlank()) {
            return new CampaignResponse(RtnCode.SUB_CONTENT_ERROR.getCode(), RtnCode.SUB_CONTENT_ERROR.getMessage(), campaignList);
        }
        
        return new CampaignResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), campaignList);
        
    }
    
    @Override
    public CampaignResponse getInfo(String title) {
        // TODO Auto-generated method stub

        List<Campaign> campaignList = new ArrayList<Campaign>();
//      check : title = null
        if(title == null || title.isBlank()) {
            return new CampaignResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), campaignList);
        }
//      check : not existById(item.title)
        if(!campaignDao.existsById(title)) {
            return new CampaignResponse(RtnCode.TITLE_NO_FOUND_ERROR.getCode(), RtnCode.TITLE_NO_FOUND_ERROR.getMessage(), campaignList);       
        }

        Optional<Campaign> res = campaignDao.findById(title);
        Campaign campaign = res.get();   
        campaignList.add(campaign);
//        if(campaignList == null) {
//            return new CampaignResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), campaignList);            
//        }
//        else {
            return new CampaignResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), campaignList);        
//        }
        
//        return new CampaignResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), Campaign);
    }

    @Override
    public CampaignResponse deleteInfo(String title) {
        // TODO Auto-generated method stub
        List<Campaign> campaignList = new ArrayList<Campaign>();

//      check : title = null
        if(title == null || title.isBlank()) {
            return new CampaignResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), campaignList);
        }
//      check : not existById(item.title)
        if(!campaignDao.existsById(title)) {
            return new CampaignResponse(RtnCode.TITLE_NO_FOUND_ERROR.getCode(), RtnCode.TITLE_NO_FOUND_ERROR.getMessage(), campaignList);       
        }
        Optional<Campaign> res = campaignDao.findById(title);
        Campaign campaign = res.get();   
        campaignList.add(campaign);
//        if(campaignList == null) {
//            return new CampaignResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), campaignList);            
//        }
//        else {
            campaignDao.deleteById(title);
            return new CampaignResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), campaignList);        
//        }
    }

    @Override
    public CampaignResponse Top10Info() {
        // TODO Auto-generated method stub
        List<Campaign> campaignList = new ArrayList<Campaign>();
        
//        List<Campaign> campaignList = campaignDao.findByTitleContaining(str);
        campaignList = campaignDao.findTop10ByStartTimeContainingOrderByStartTimeDesc("-");

        return new CampaignResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), campaignList);
    }

    @Override
    public CampaignResponse findAllInfo() {
        // TODO Auto-generated method stub
//      check : item.title = null || item.title.isBlank()
//      check : existById(item.title)            

        List<Campaign> campaignList = campaignDao.findByStartTimeContainingOrderByStartTimeDesc("-");

        return new CampaignResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), campaignList);
    }

    @Override
    public CampaignResponse getBetweenInfo(String time1, String time2) {
        // TODO Auto-generated method stub
            List<Campaign> campaignList = new ArrayList<Campaign>();
//          check : title = null
            if(time1 == null || time1.isBlank()) {
                return new CampaignResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), campaignList);
            }
//          check : title = null
            if(time2 == null || time2.isBlank()) {
                return new CampaignResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), campaignList);
            }
//          check : item.startTime = \\d\\d\\d\\d-\\d\\d-\\d\\d
            if(!(time1.matches("[\\d]{4}-[\\d]{2}-[\\d]{2}"))) {
                return new CampaignResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), campaignList);
            }
//          check : item.startTime = \\d\\d\\d\\d-\\d\\d-\\d\\d
            if(!(time2.matches("[\\d]{4}-[\\d]{2}-[\\d]{2}"))) {
                return new CampaignResponse(RtnCode.DATA_ERROR.getCode(), RtnCode.DATA_ERROR.getMessage(), campaignList);
            }
//            
            campaignList = campaignDao.findByStartTimeBetweenOrderByStartTimeDesc(time1, time2);   
            
        return new CampaignResponse(RtnCode.SUCCESSFUL.getCode(), RtnCode.SUCCESSFUL.getMessage(), campaignList);
    
    }

}
