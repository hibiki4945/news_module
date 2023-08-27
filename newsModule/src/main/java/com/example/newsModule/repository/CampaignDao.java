package com.example.newsModule.repository;

import com.example.newsModule.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CampaignDao extends JpaRepository<Campaign, String>{

//    public List<Campaign> FindTop3ByStartTimeOrderStartTimeDesc();
    
//    public List<Campaign> findTop3ByStartTime();
//    
    public List<Campaign> findByTitleContaining(String Title);
    
//    public List<Campaign> findBySubTitleContaining(String SubTitle);
//
    public List<Campaign> findTop10ByStartTimeContainingOrderByStartTimeDesc(String str);

    public List<Campaign> findByStartTimeContainingOrderByStartTimeDesc(String str);

    public List<Campaign> findByStartTimeBetweenOrderByStartTimeDesc(String time1, String time2);
    
}
