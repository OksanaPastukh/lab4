package lpnu.service.impl;

import lpnu.dto.VehicleAdvDTO;
import lpnu.dto.VehicleDTO;
import lpnu.mapper.DriverToDriverDTOMapper;
import lpnu.mapper.VehicleToVehicleAdvDTOMapper;
import lpnu.mapper.VehicleToVehicleDTOMapper;
import lpnu.repository.DriverRepository;
import lpnu.repository.VehicleRepository;
import lpnu.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Override
    public List<VehicleAdvDTO> getAllVehicles() {
        return VehicleRepository.getAllVehicles().stream()
                .map(e -> VehicleToVehicleAdvDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }
}
