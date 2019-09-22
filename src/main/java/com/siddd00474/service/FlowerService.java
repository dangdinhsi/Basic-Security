package com.siddd00474.service;

import com.siddd00474.entity.Flower;
import com.siddd00474.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class FlowerService {
    @Autowired
    private FlowerRepository flowerRepository;

    //list

    public List<Flower> getList(){
        return flowerRepository.findAll();
    }

    //find flower by name

    public List<Flower> getListByName(String name){
        return flowerRepository.findAllByNameAndStatus(name,1);
    }

    //add flower
    public Flower addFlower(Flower flower){
        flower.setStatus(1);
        flower.setCreatedAt(Calendar.getInstance().getTimeInMillis());
        flowerRepository.save(flower);
        return flower;
    }
}
