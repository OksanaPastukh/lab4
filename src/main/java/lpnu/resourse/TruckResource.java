package lpnu.resourse;

import lpnu.dto.CarDTO;
import lpnu.dto.NewCarDTO;
import lpnu.dto.NewTruckDTO;
import lpnu.dto.TruckDTO;
import lpnu.service.TruckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TruckResource {

    @Autowired
    private TruckService truckService;

    @PostMapping("/trucks")
    public TruckDTO createTruck(@RequestBody @Validated final NewTruckDTO newTruckDTO){
        return truckService.createTruck(newTruckDTO);
    }
}
