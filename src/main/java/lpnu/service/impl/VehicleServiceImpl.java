package lpnu.service.impl;

import lpnu.dto.VehicleDTO;
import lpnu.mapper.DriverToDriverDTOMapper;
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
    public List<VehicleDTO> getAllVehicles() {
        return VehicleRepository.getAllVehicles().stream()
                .map(e -> VehicleToVehicleDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }
}
