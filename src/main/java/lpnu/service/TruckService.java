package lpnu.service;

import lpnu.dto.NewTruckDTO;
import lpnu.dto.TruckDTO;
import lpnu.dto.VehicleDTO;

import java.util.List;

public interface TruckService {
    VehicleDTO createTruck(NewTruckDTO newTruckDTO);
    List<VehicleDTO> getAllReadyTruck();
}
