package lpnu.service.impl;

import lpnu.dto.CarDTO;
import lpnu.dto.NewCarDTO;
import lpnu.dto.VehicleDTO;
import lpnu.entity.Car;
import lpnu.mapper.CarToCarDTOMapper;

import lpnu.mapper.VehicleToVehicleDTOMapper;
import lpnu.repository.CarRepository;

import lpnu.service.CarService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public VehicleDTO createCar(NewCarDTO newCarDTO) {
        Car car = CarRepository.createCar(newCarDTO);
        return VehicleToVehicleDTOMapper.toDTO(car);
    }

    @Override
    public List<VehicleDTO> getAllReadyCar() {
        return CarRepository.getAllReadyCar().stream()
                .map(e -> VehicleToVehicleDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }
}
