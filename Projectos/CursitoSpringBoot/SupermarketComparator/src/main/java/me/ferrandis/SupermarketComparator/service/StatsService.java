package me.ferrandis.SupermarketComparator.service;

import me.ferrandis.SupermarketComparator.model.dto.StatsDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class StatsService {


    public StatsDTO getSimpleStats(){
        StatsDTO stats = new StatsDTO();
        stats.setDateStats(LocalDateTime.of(2020, 11, 28, 17,0,0));
        return stats;
    }
}
