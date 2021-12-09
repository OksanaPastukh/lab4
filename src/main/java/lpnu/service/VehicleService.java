package lpnu.service;

import lpnu.dto.VehicleDTO;
import lpnu.entity.enumeration.VehicleStatus;

import java.util.List;

public interface VehicleService {
    List<VehicleDTO> getAllVehicles();
    VehicleDTO setDriver(long id_v, long id_d);
    VehicleDTO setStatus(long id_v, VehicleStatus vehicleStatus);
    VehicleDTO getVehicleById(long id);
    VehicleDTO deleteVehicleById(long id);
}
