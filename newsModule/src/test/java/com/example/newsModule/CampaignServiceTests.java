package com.example.newsModule;

import com.example.newsModule.constants.RtnCode;
import com.example.newsModule.entity.Campaign;
import com.example.newsModule.repository.CampaignDao;
import com.example.newsModule.service.ifs.CampaignService;
import com.example.newsModule.vo.CampaignResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CampaignServiceTests {

    @Autowired
    private CampaignService campaignService;

    @Autowired
    private CampaignDao campaignDao;
    
    @Test
    public void addInfoTest() {

//      check_01 : campaignList = null?
        CampaignResponse res = campaignService.addInfo(null);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.DATA_ERROR.getMessage()), "Failed!(check_01)");
//      ========================================

//      check_02 : item = null
        List<Campaign> campaignList = new ArrayList<>();
        Campaign campaign = null;
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.DATA_ERROR.getMessage()), "Failed!(check_02)");
//      ========================================

//      check_03 : item.title = null || item.title.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign(null, "demo", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.TITLE_ERROR.getMessage()), "Failed!(check_03)");
//      ========================================

//      check_03-1 : item.title = null || item.title.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign(" ", "demo", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.TITLE_ERROR.getMessage()), "Failed!(check_03-1)");
//      ========================================
        
//      check_04 : item.subTitle = null || item.subTitle.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", null, "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUB_TITLE_ERROR.getMessage()), "Failed!(check_04)");
//      ========================================
        
//      check_04-1 : item.subTitle = null || item.subTitle.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", " ", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUB_TITLE_ERROR.getMessage()), "Failed!(check_04-1)");
//      ========================================

//      check_05 : item.startTime = \\d\\d\\d\\d-\\d\\d-\\d\\d
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-010", "2023-08-26","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.START_TIME_ERROR.getMessage()), "Failed!(check_05)");
//      ========================================

//      check_06 : item.endTime = \\d\\d\\d\\d-\\d\\d-\\d\\d
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-260","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.END_TIME_ERROR.getMessage()), "Failed!(check_06)");
//      ========================================

//      check_07 : item.content = null || item.content.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-26", null, "demo");
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.CONTENT_ERROR.getMessage()), "Failed!(check_07)");
//      ========================================

//      check_07-1 : item.content = null || item.content.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-26", " ", "demo");
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.CONTENT_ERROR.getMessage()), "Failed!(check_07-1)");
//      ========================================

//      check_08 : item.subContent = null || item.subContent.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-26","demo", null);
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUB_CONTENT_ERROR.getMessage()), "Failed!(check_08)");
//      ========================================

//      check_08-1 : item.subContent = null || item.subContent.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-26","demo", " ");
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUB_CONTENT_ERROR.getMessage()), "Failed!(check_08-1)");
//      ========================================

//      check_09 : normal
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUCCESSFUL.getMessage()), "Failed!(check_09)");
//      ========================================

//      check_10 : existById(item.title)
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.TITLE_DUPLICATE_ERROR.getMessage()), "Failed!(check_10)");
//      ========================================
        
        campaignDao.deleteById(campaign.getTitle());
        
    }

    @Test
    public void changeInfoTest() {

//      check_01 : campaignList = null?
        CampaignResponse res = campaignService.addInfo(null);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.DATA_ERROR.getMessage()), "Failed!(check_01)");
//      ========================================

//      check_02 : item = null
        List<Campaign> campaignList = new ArrayList<>();
        Campaign campaign = null;
        campaignList.add(campaign);
        res = campaignService.changeInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.DATA_ERROR.getMessage()), "Failed!(check_02)");
//      ========================================

//      check_03 : item.title = null || item.title.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign(null, "demo", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.changeInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.TITLE_ERROR.getMessage()), "Failed!(check_03)");
//      ========================================

//      check_03-1 : item.title = null || item.title.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign(" ", "demo", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.changeInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.TITLE_ERROR.getMessage()), "Failed!(check_03-1)");
//      ========================================
        
//      check_04 : item.subTitle = null || item.subTitle.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", null, "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.changeInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUB_TITLE_ERROR.getMessage()), "Failed!(check_04)");
//      ========================================
        
//      check_04-1 : item.subTitle = null || item.subTitle.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", " ", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.changeInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUB_TITLE_ERROR.getMessage()), "Failed!(check_04-1)");
//      ========================================

//      check_05 : item.startTime = \\d\\d\\d\\d-\\d\\d-\\d\\d
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-010", "2023-08-26","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.changeInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.START_TIME_ERROR.getMessage()), "Failed!(check_05)");
//      ========================================

//      check_06 : item.endTime = \\d\\d\\d\\d-\\d\\d-\\d\\d
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-260","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.changeInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.END_TIME_ERROR.getMessage()), "Failed!(check_06)");
//      ========================================

//      check_07 : item.content = null || item.content.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-26", null, "demo");
        campaignList.add(campaign);
        res = campaignService.changeInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.CONTENT_ERROR.getMessage()), "Failed!(check_07)");
//      ========================================

//      check_07-1 : item.content = null || item.content.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-26", " ", "demo");
        campaignList.add(campaign);
        res = campaignService.changeInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.CONTENT_ERROR.getMessage()), "Failed!(check_07-1)");
//      ========================================

//      check_08 : item.subContent = null || item.subContent.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-26","demo", null);
        campaignList.add(campaign);
        res = campaignService.changeInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUB_CONTENT_ERROR.getMessage()), "Failed!(check_08)");
//      ========================================

//      check_08-1 : item.subContent = null || item.subContent.isBlank()
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-26","demo", " ");
        campaignList.add(campaign);
        res = campaignService.changeInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUB_CONTENT_ERROR.getMessage()), "Failed!(check_08-1)");
//      ========================================

//      check_09 : existById(item.title)
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign);
        res = campaignService.changeInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.TITLE_NO_FOUND_ERROR.getMessage()), "Failed!(check_09)");
//      ========================================

//      check_10 : normal
        campaignList = new ArrayList<>();
        campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign);
        campaignService.addInfo(campaignList);
        res = campaignService.changeInfo(campaignList);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUCCESSFUL.getMessage()), "Failed!(check_10)");
//      ========================================

        campaignDao.deleteById(campaign.getTitle());
        
    }

    @Test
    public void getInfo() {

//      check_01 : title = null || title.isBlank()
        CampaignResponse res = campaignService.getInfo(null);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.DATA_ERROR.getMessage()), "Failed!(check_01)");
//      ========================================

//      check_01-1 : title = null || title.isBlank()
        res = campaignService.getInfo(" ");
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.DATA_ERROR.getMessage()), "Failed!(check_01-1)");
//      ========================================

//      check_02 : existById(item.title)
        res = campaignService.getInfo("demo");
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.TITLE_NO_FOUND_ERROR.getMessage()), "Failed!(check_02)");
//      ========================================

//      check_03 : normal
        Campaign campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-26","demo", "demo");
        List<Campaign> campaignList = new ArrayList<Campaign>();
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);res = campaignService.getInfo(campaign.getTitle());
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUCCESSFUL.getMessage()), "Failed!(check_03)");
//      ========================================
        
        campaignDao.deleteById(campaign.getTitle());
        
    }

    @Test
    public void deleteInfo() {

//      check_01 : title = null || title.isBlank()
        CampaignResponse res = campaignService.deleteInfo(null);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.DATA_ERROR.getMessage()), "Failed!(check_01)");
//      ========================================

//      check_01-1 : title = null || title.isBlank()
        res = campaignService.deleteInfo(" ");
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.DATA_ERROR.getMessage()), "Failed!(check_01-1)");
//      ========================================

//      check_02 : existById(item.title)
        res = campaignService.deleteInfo("demo");
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.TITLE_NO_FOUND_ERROR.getMessage()), "Failed!(check_02)");
//      ========================================

//      check_03 : normal
        Campaign campaign = new Campaign("demo", "demo", "1999-01-01", "2023-08-26","demo", "demo");
        List<Campaign> campaignList = new ArrayList<Campaign>();
        campaignList.add(campaign);
        res = campaignService.addInfo(campaignList);
        res = campaignService.deleteInfo(campaign.getTitle());
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUCCESSFUL.getMessage()), "Failed!(check_03)");
//      ========================================
        
//        campaignDao.deleteById(campaign.getTitle());
        
    }
    
    @Test
    public void Top10Info() {

//      check_01 : normal
        List<Campaign> campaignList = new ArrayList<Campaign>();
        Campaign campaign1 = new Campaign("demo1", "demo", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign1);
        Campaign campaign2 = new Campaign("demo2", "demo", "1999-02-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign2);
        Campaign campaign3 = new Campaign("demo3", "demo", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign3);
        Campaign campaign4 = new Campaign("demo4", "demo", "1999-03-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign4);
        Campaign campaign5 = new Campaign("demo5", "demo", "1999-04-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign5);
        Campaign campaign6 = new Campaign("demo6", "demo", "1999-06-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign6);
        Campaign campaign7 = new Campaign("demo7", "demo", "1999-05-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign7);
        Campaign campaign8 = new Campaign("demo8", "demo", "1999-10-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign8);
        Campaign campaign9 = new Campaign("demo9", "demo", "1999-12-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign9);
        Campaign campaign10 = new Campaign("demo10", "demo", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign10);
        Campaign campaign11 = new Campaign("demo11", "demo", "1999-10-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign11);
        
        CampaignResponse res = campaignService.addInfo(campaignList);
        res = campaignService.Top10Info();
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUCCESSFUL.getMessage()), "Failed!(check_03)");
//      ========================================

        res = campaignService.deleteInfo(campaign1.getTitle());
        res = campaignService.deleteInfo(campaign2.getTitle());
        res = campaignService.deleteInfo(campaign3.getTitle());
        res = campaignService.deleteInfo(campaign4.getTitle());
        res = campaignService.deleteInfo(campaign5.getTitle());
        res = campaignService.deleteInfo(campaign6.getTitle());
        res = campaignService.deleteInfo(campaign7.getTitle());
        res = campaignService.deleteInfo(campaign8.getTitle());
        res = campaignService.deleteInfo(campaign9.getTitle());
        res = campaignService.deleteInfo(campaign10.getTitle());
        res = campaignService.deleteInfo(campaign11.getTitle());
        
    }

    @Test
    public void findAllInfo() {

//      check_01 : normal
        List<Campaign> campaignList = new ArrayList<Campaign>();
        Campaign campaign1 = new Campaign("demo1", "demo", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign1);
        Campaign campaign2 = new Campaign("demo2", "demo", "1999-02-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign2);
        Campaign campaign3 = new Campaign("demo3", "demo", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign3);
        Campaign campaign4 = new Campaign("demo4", "demo", "1999-03-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign4);
        Campaign campaign5 = new Campaign("demo5", "demo", "1999-04-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign5);
        Campaign campaign6 = new Campaign("demo6", "demo", "1999-06-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign6);
        Campaign campaign7 = new Campaign("demo7", "demo", "1999-05-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign7);
        Campaign campaign8 = new Campaign("demo8", "demo", "1999-10-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign8);
        Campaign campaign9 = new Campaign("demo9", "demo", "1999-12-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign9);
        Campaign campaign10 = new Campaign("demo10", "demo", "1999-01-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign10);
        Campaign campaign11 = new Campaign("demo11", "demo", "1999-10-01", "2023-08-26","demo", "demo");
        campaignList.add(campaign11);
        
        CampaignResponse res = campaignService.addInfo(campaignList);
        res = campaignService.Top10Info();
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUCCESSFUL.getMessage()), "Failed!(check_03)");
//      ========================================

        res = campaignService.deleteInfo(campaign1.getTitle());
        res = campaignService.deleteInfo(campaign2.getTitle());
        res = campaignService.deleteInfo(campaign3.getTitle());
        res = campaignService.deleteInfo(campaign4.getTitle());
        res = campaignService.deleteInfo(campaign5.getTitle());
        res = campaignService.deleteInfo(campaign6.getTitle());
        res = campaignService.deleteInfo(campaign7.getTitle());
        res = campaignService.deleteInfo(campaign8.getTitle());
        res = campaignService.deleteInfo(campaign9.getTitle());
        res = campaignService.deleteInfo(campaign10.getTitle());
        res = campaignService.deleteInfo(campaign11.getTitle());
        
    }

    @Test
    public void getBetweenInfo() {

//      check_01 : item = null
        CampaignResponse res = campaignService.getBetweenInfo(null, "1999-01-01");
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.DATA_ERROR.getMessage()), "Failed!(check_01)");
//      ========================================

//      check_01-1 : item = null
        res = campaignService.getBetweenInfo("1999-01-01", null);
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.DATA_ERROR.getMessage()), "Failed!(check_01-1)");
//      ========================================

//      check_02 : time1 = \\d\\d\\d\\d-\\d\\d-\\d\\d
        res = campaignService.getBetweenInfo("1999-01-010", "1999-01-02");
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.DATA_ERROR.getMessage()), "Failed!(check_02)");
//      ========================================

//      check_03 : time2 = \\d\\d\\d\\d-\\d\\d-\\d\\d
        res = campaignService.getBetweenInfo("1999-01-01", "1999-01-020");
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.DATA_ERROR.getMessage()), "Failed!(check_03)"+res.getMessage());
//      ========================================
        
//      check_04 : normal
        res = campaignService.getBetweenInfo("1999-01-01", "2023-01-01");
//      確認 回傳結果
        Assert.isTrue(res.getMessage().equals(RtnCode.SUCCESSFUL.getMessage()), "Failed!(check_04)");
//      ========================================
        
    }
    
    
}



