package lpnu.resourse;

import lpnu.dto.*;
import lpnu.service.CarService;
import lpnu.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CarResource {
    @Autowired
    private CarService carService;


    @PostMapping("/cars")
    public VehicleDTO createCar(@RequestBody @Validated final NewCarDTO newCarDTO){
        return carService.createCar(newCarDTO);
    }
    @GetMapping("/cars")
    public List<VehicleDTO> getAllReadyCar(){return carService.getAllReadyCar();}

}
