package lpnu.service;

import lpnu.dto.CarDTO;
import lpnu.dto.CustomerDTO;
import lpnu.dto.NewCarDTO;
import lpnu.dto.VehicleDTO;

import java.util.List;

public interface CarService {
    VehicleDTO createCar(NewCarDTO newCarDTO);
    List<VehicleDTO> getAllReadyCar();
}
