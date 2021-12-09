package lpnu.service.impl;

import lpnu.dto.NewTruckDTO;
import lpnu.dto.TruckDTO;
import lpnu.dto.VehicleDTO;
import lpnu.entity.Car;
import lpnu.entity.Truck;
import lpnu.mapper.CarToCarDTOMapper;
import lpnu.mapper.TruckToTruckDTOMapper;
import lpnu.mapper.VehicleToVehicleDTOMapper;
import lpnu.repository.CarRepository;
import lpnu.repository.TruckRepository;
import lpnu.service.TruckService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TruckServiceImpl implements TruckService {

    @Override
    public VehicleDTO createTruck(NewTruckDTO newTruckDTO) {
        Truck truck = TruckRepository.createTruck(newTruckDTO);
        return VehicleToVehicleDTOMapper.toDTO(truck);
    }

    @Override
    public List<VehicleDTO> getAllReadyTruck() {
        return TruckRepository.getAllReadyTruck().stream()
                .map(e -> VehicleToVehicleDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }
}
