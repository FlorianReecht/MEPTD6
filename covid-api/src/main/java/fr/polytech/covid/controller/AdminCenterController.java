package fr.polytech.covid.controller;

import fr.polytech.covid.entity.Center;
import fr.polytech.covid.service.CenterService;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("api/admin")

public class AdminCenterController {

    private final CenterService centerService;

    public AdminCenterController(CenterService centerService) {
        this.centerService = centerService;
    }

    @PostMapping("/center")
    public void setCenter(@RequestBody Center center){
        centerService.addCenter(center);
    }

    @PutMapping("/center")
    public void updateCenter(@RequestBody Center center){
        centerService.updateCenter(center);
    }

    @DeleteMapping("/center")
    public void deleteCenter(@RequestBody Center center){
        Center centerDB = centerService.getCenter(center.getId());
        if (centerDB.equals(center)) centerService.deleteCenter(center.getId());
    }
}
