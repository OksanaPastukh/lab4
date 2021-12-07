package lpnu.service;

import lpnu.dto.CarDTO;
import lpnu.dto.CustomerDTO;
import lpnu.dto.NewCarDTO;

import java.util.List;

public interface CarService {
    CarDTO createCar(NewCarDTO newCarDTO);

}
