package br.com.carstore.service;

import br.com.carstore.dao.CarDao;
import br.com.carstore.dto.CarDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CarServiceImpl implements CarService {

    private CarDao dao;

    public CarServiceImpl(CarDao dao){
        this.dao = dao ;
    }

    public List<CarDTO> findAll() {
        return this.dao.findAll();
    }

    public void save(CarDTO carDTO) {
        if (carDTO.getId() == null){
            carDTO.setId(UUID.randomUUID().toString());
        }
        this.dao.save(carDTO);
    }

    public void deleteById(String id) {
        this.dao.deleteById(id);
    }

    public void update(String id, CarDTO carDTO) {
        this.dao.update(id, carDTO);
    }
}