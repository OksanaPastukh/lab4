package lpnu.service;

import lpnu.dto.VehicleAdvDTO;
import lpnu.dto.VehicleDTO;
import lpnu.entity.enumeration.VehicleStatus;

import java.util.List;

public interface VehicleService {
    //List<VehicleAdvDTO> getAllVehicles();
    List<VehicleDTO> getAllVehicles();
    VehicleDTO setDriver(long id_v, long id_d);
    VehicleDTO setStatus(long id_v, VehicleStatus vehicleStatus);
}
