package fr.polytech.covid.service;

import fr.polytech.covid.entity.Center;
import fr.polytech.covid.repository.CenterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CenterService {

    private final CenterRepository centerRepository;

    public CenterService(CenterRepository centerRepository) {
        this.centerRepository = centerRepository;
    }

    public List<Center> getCenters(){
        return new ArrayList<>(centerRepository.findByOrderByNameAsc());
    }
    public List<Center> getCenters(String city){
        if (city == null || city.equals("")) return getCenters();
        return new ArrayList<>(centerRepository.findByCityContainsIgnoreCaseOrderByNameAsc(city));
    }

    public List<Center> getCentersByName(String name){
        if(name == null || name.equals("")) return getCenters();
        return new ArrayList<>(centerRepository.findByNameContainsIgnoreCaseOrderByNameAsc(name));
    }

    public Center getCenter(int id){
        return centerRepository.findById(id).orElse(null);
    }


    public void addCenter(Center center) {
        centerRepository.save(center);
    }

    public void updateCenter(Center center){
        centerRepository.save(center);
    }

    public void deleteCenter(int id){
        centerRepository.deleteById(id);
    }

}
