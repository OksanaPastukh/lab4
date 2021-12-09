package lpnu.resourse;

import lpnu.dto.*;
import lpnu.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TruckResource {

    @Autowired
    private TruckService truckService;

    @PostMapping("/trucks")
    public VehicleDTO createTruck(@RequestBody @Validated final NewTruckDTO newTruckDTO){
        return truckService.createTruck(newTruckDTO);
    }

    @GetMapping("/trucks")
    public List<VehicleDTO> getAllReadyTruck(){return truckService.getAllReadyTruck();}
}
