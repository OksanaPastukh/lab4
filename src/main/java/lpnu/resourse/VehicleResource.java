package lpnu.resourse;

import lpnu.dto.DriverDTO;
import lpnu.dto.VehicleAdvDTO;
import lpnu.dto.VehicleDTO;
import lpnu.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VehicleResource {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<VehicleAdvDTO> getAllVehicles(){return vehicleService.getAllVehicles();}


}
