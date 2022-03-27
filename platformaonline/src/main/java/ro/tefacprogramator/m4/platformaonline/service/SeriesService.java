package ro.tefacprogramator.m4.platformaonline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.tefacprogramator.m4.platformaonline.entity.Series;
import ro.tefacprogramator.m4.platformaonline.repository.SeriesRepository;

@Service
public class SeriesService {
    
    @Autowired
    public SeriesRepository repo;

    public boolean addSeries(Series s1) {
        Series saved = repo.save(s1);

        if (saved != null) {
            return true;
        }
        
        return false;
    }

    public List<Series> getAllSeries() {
        return repo.findAll();
    }

    public List<Series> getByCategoryName(String categoryName) {
        return repo.getSeriesByCategoryName(categoryName);
    }

}
