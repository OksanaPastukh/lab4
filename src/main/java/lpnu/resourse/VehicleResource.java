package lpnu.resourse;


import lpnu.dto.VehicleDTO;
import lpnu.entity.enumeration.VehicleStatus;
import lpnu.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class VehicleResource {

    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public List<VehicleDTO> getAllVehicles(){return vehicleService.getAllVehicles();}

    @PutMapping ("/vehicles/driver/{id_v}/{id_d}")
    public VehicleDTO setDriver(@PathVariable final long id_v, @PathVariable final long id_d){
        return vehicleService.setDriver(id_v,id_d);
    }


  @PutMapping ("/vehicles/status/{id_v}/{status}")
  public VehicleDTO setStatus(@PathVariable final long id_v, @PathVariable VehicleStatus status)
  {
        return vehicleService.setStatus(id_v,status);
  }
    @GetMapping("/vehicles/{id}")
    public VehicleDTO getVehicleById(@PathVariable final long id) {
        return vehicleService.getVehicleById(id);
    }

    @DeleteMapping("/vehicles/{id}")
    public VehicleDTO deleteVehicleById(@PathVariable final  long id){
        return vehicleService.deleteVehicleById(id);
    }

}
