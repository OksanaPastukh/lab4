package lpnu.mapper;

import lpnu.dto.VehicleDTO;
import lpnu.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleToVehicleDTOMapper {
    public static VehicleDTO toDTO(Vehicle vehicle){
        VehicleDTO vehicleDTO = new VehicleDTO();
        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setNumberVehicle(vehicle.getNumberVehicle());
        vehicleDTO.setVehicleStatus(vehicle.getVehicleStatus());
        vehicleDTO.setDriverId((vehicle.getDriver())==null?0:vehicle.getDriver().getId());
        vehicleDTO.setDriverName((vehicle.getDriver())==null?"":
                vehicle.getDriver().getSurname()+" "+vehicle.getDriver().getName());

        return vehicleDTO;
    }

}
