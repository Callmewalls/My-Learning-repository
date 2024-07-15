package me.ferrandis.SupermarketComparator.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import me.ferrandis.SupermarketComparator.model.dto.StatsDTO;
import me.ferrandis.SupermarketComparator.service.StatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController


public class StatsController {

    private final StatsService statsService;

    public StatsController(StatsService statsService){
        this.statsService = statsService;
    }

    @GetMapping(value = "/api/v1/stats/basic/info")
    @Operation(summary = "Devuelve los stats de la fecha.")
    @ApiResponse(responseCode = "200" , description = "Estado de la fecha obtenida")

    public StatsDTO getStats(){
        return statsService.getSimpleStats();
    }

}
