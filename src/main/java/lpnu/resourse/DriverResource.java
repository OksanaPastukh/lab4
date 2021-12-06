package lpnu.resourse;

import lpnu.dto.DriverDTO;
import lpnu.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
