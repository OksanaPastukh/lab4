package lpnu.service;

import lpnu.dto.NewTruckDTO;
import lpnu.dto.TruckDTO;

public interface TruckService {
    TruckDTO createTruck(NewTruckDTO newTruckDTO);
}
