package lpnu.service.impl;

import lpnu.dto.CarDTO;
import lpnu.dto.NewCarDTO;
import lpnu.entity.Car;
import lpnu.mapper.CarToCarDTOMapper;
import lpnu.mapper.CustomerToCustomerDTOMapper;
import lpnu.repository.CarRepository;
import lpnu.repository.CustomerRepository;
import lpnu.repository.VehicleRepository;
import lpnu.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public CarDTO createCar(NewCarDTO newCarDTO) {
        Car car = CarRepository.createCar(newCarDTO);
        return CarToCarDTOMapper.toDTO(car);
    }


}
