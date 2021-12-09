package lpnu.service.impl;

import lpnu.dto.VehicleDTO;
import lpnu.entity.Driver;
import lpnu.entity.Vehicle;
import lpnu.entity.enumeration.VehicleStatus;
import lpnu.exception.ServiceException;
import lpnu.mapper.VehicleToVehicleDTOMapper;
import lpnu.repository.DriverRepository;
import lpnu.repository.VehicleRepository;
import lpnu.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

 //   @Override
//    public List<VehicleAdvDTO> getAllVehicles() {
//        return VehicleRepository.getAllVehicles().stream()
//                .map(e -> VehicleToVehicleAdvDTOMapper.toDTO(e))
//                .collect(Collectors.toList());
//    }
    @Override
    public List<VehicleDTO> getAllVehicles() {
        return VehicleRepository.getAllVehicles().stream()
                .map(e -> VehicleToVehicleDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDTO setDriver(long id_v, long id_d) {
        Vehicle vehicle = VehicleRepository.getVehicleById(id_v);
        Driver driver = (id_d==0? null:DriverRepository.getDriverById(id_d));
        vehicle.setDriver(driver);
        return VehicleToVehicleDTOMapper.toDTO(vehicle);
    }

    @Override
    public VehicleDTO setStatus(long id_v, VehicleStatus vehicleStatus) {
        Vehicle vehicle = VehicleRepository.getVehicleById(id_v);
        vehicle.setVehicleStatus(vehicleStatus);
        return VehicleToVehicleDTOMapper.toDTO(vehicle);
    }

    @Override
    public VehicleDTO getVehicleById(long id) {
        return VehicleToVehicleDTOMapper.toDTO(VehicleRepository.getVehicleById(id));
    }
//todo delete
    @Override
    public VehicleDTO deleteVehicleById(long id) {
        Vehicle vehicle = VehicleRepository.getVehicleById(id);

        vehicle.setVehicleStatus(VehicleStatus.NOT_ACTIVE);
        return VehicleToVehicleDTOMapper.toDTO(vehicle);
    }
}
