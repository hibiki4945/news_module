package com.example.newsModule.controller;

import com.example.newsModule.entity.Campaign;
import com.example.newsModule.service.ifs.CampaignService;
import com.example.newsModule.vo.CampaignResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {
    
    @Autowired
    private CampaignService campaignService;
    
    @RequestMapping(value = "/home")
    public String home(@RequestParam(name = "name", required = false, defaultValue = "World0") String name, Model model) {
        CampaignResponse res = campaignService.Top10Info();
        model.addAttribute("res", res.getCampaignList());
        return "home";
    }

    @RequestMapping(value = "/all_news")
    public String all_news(@RequestParam(name = "name", required = false, defaultValue = "World0") String name, Model model) {
        CampaignResponse res = campaignService.findAllInfo();
        model.addAttribute("res", res.getCampaignList());
        model.addAttribute("search", "");
        model.addAttribute("change", "");
        model.addAttribute("delete", "");
        return "all_news";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        Campaign campaign = new Campaign();
        model.addAttribute("campaign", campaign);
        model.addAttribute("error", "");
        return "edit";
    }
    
    @PostMapping("/edit")
    public String edit_show(@ModelAttribute("campaign") Campaign campaign, Model model) {
        System.out.println(campaign);
        List<Campaign> CampaignList = new ArrayList<Campaign>(Arrays.asList(campaign));
        CampaignResponse res = campaignService.addInfo(CampaignList);
        if(res.getCode() != "200") {
            model.addAttribute("error", res.getMessage());
            return "edit";
        }
        return "edit_done";
    }

    @GetMapping("/delete")
    public String delete(Model model) {
        Campaign campaign = new Campaign();
        model.addAttribute("campaign", campaign);
        model.addAttribute("error", "");
        return "delete";
    }
    
    @PostMapping("/delete")
    public String delete(@ModelAttribute("campaign") Campaign campaign, Model model) {
        System.out.println(campaign);
        CampaignResponse res = campaignService.deleteInfo(campaign.getTitle());
        if(res.getCode() != "200") {
            model.addAttribute("error", res.getMessage());
            return "delete";
        }
        return "delete_done";
    }

    @GetMapping("/change_select")
    public String change_select(Model model) {
        Campaign campaign = new Campaign();
        model.addAttribute("campaign", campaign);
        model.addAttribute("error", "");
        return "change_select";
    }
    
    @PostMapping("/change_select")
    public String change_select(@ModelAttribute("campaign") Campaign campaign, Model model) {
        System.out.println(campaign);
        CampaignResponse res = campaignService.getInfo(campaign.getTitle());
        for (Campaign item : res.getCampaignList()) {
            campaign = item;    
        }
        System.out.println(campaign);
        model.addAttribute("campaign", campaign);
        if(res.getCode() != "200") {
            model.addAttribute("error", res.getMessage());
            return "change_select";
        }
        return "change";
    }

    @GetMapping("/change")
    public String change(Model model) {
        Campaign campaign = new Campaign();
        model.addAttribute("campaign", campaign);
        model.addAttribute("error", "");
        return "change";
    }
    
    @PostMapping("/change")
    public String change(@ModelAttribute("campaign") Campaign campaign, Model model) {
        System.out.println(campaign);
        List<Campaign> CampaignList = new ArrayList<Campaign>(Arrays.asList(campaign));
        CampaignResponse res = campaignService.changeInfo(CampaignList);
        if(res.getCode() != "200") {
            model.addAttribute("error", res.getMessage());
            return "change";
        }
        return "change_done";
    }

    @GetMapping("/search")
    public String search(Model model) {
        Campaign campaign = new Campaign();
        model.addAttribute("campaign", campaign);
        model.addAttribute("error", "");
        return "search";
    }
    
    @PostMapping("/search")
    public String search(@ModelAttribute("campaign") Campaign campaign, Model model) {
        System.out.println(campaign);
        List<Campaign> campaignList = new ArrayList<Campaign>();
        CampaignResponse res = campaignService.getBetweenInfo(campaign.getStartTime(), campaign.getEndTime());
        if(res.getCode() != "200") {
            model.addAttribute("error", res.getMessage());
            return "search";
        }
        campaignList = res.getCampaignList();
        model.addAttribute("res", campaignList);
        return "search_done";
    }
    
}
