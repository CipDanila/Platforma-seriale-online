package ro.tefacprogramator.m4.platformaonline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ro.tefacprogramator.m4.platformaonline.entity.Series;
import ro.tefacprogramator.m4.platformaonline.service.SeriesService;

@RestController
public class SeriesController {

    @Autowired
    public SeriesService seriesService;

    @CrossOrigin
    @PostMapping("/series/add")
    public String addSeries(@RequestBody Series s1) {

        if (seriesService.addSeries(s1)) {
            return "success";
        }

        return "failed!";
    }

    @GetMapping("/series/getAll")
    public List<Series> getAll() {
        return seriesService.getAllSeries();
    }

    @GetMapping("/series/getByCategory/{categoryName}")
    public List<Series> getByCategoryName(@PathVariable(value = "categoryName") String categoryName) {
        return seriesService.getByCategoryName(categoryName);
    }
    
}
