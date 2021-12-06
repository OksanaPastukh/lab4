package lpnu.resourse;

import lpnu.dto.CustomerDTO;
import lpnu.dto.DriverDTO;
import lpnu.dto.NewCustomerDTO;
import lpnu.dto.NewDriverDTO;
import lpnu.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class DriverResource {

    @Autowired
    private DriverService driverService;

    @GetMapping("/drivers")
    public List<DriverDTO> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @PostMapping("/drivers")
    public DriverDTO createDriver(@RequestBody @Validated final NewDriverDTO newDriverDTO){
        return driverService.createDriver(newDriverDTO);
    }
    @PutMapping("/drivers")
    public DriverDTO updateDriver(@RequestBody @Validated final DriverDTO driverDTO)
    {
        return driverService.updateDriver(driverDTO);
    }
    @GetMapping("/drivers/{id}")
    public DriverDTO getDriverById(@PathVariable final long id){
        return driverService.getDriverById(id);
    }

}
