package lpnu.mapper;

import lpnu.dto.VehicleAdvDTO;
import lpnu.dto.VehicleDTO;
import lpnu.entity.Car;
import lpnu.entity.Truck;
import lpnu.entity.Vehicle;
import org.springframework.stereotype.Component;

@Component
public class VehicleToVehicleDTOMapper {
    public static VehicleDTO toDTO(Vehicle vehicle){
        // VehicleDTO vehicleDTO = new VehicleDTO();
        VehicleDTO vehicleDTO = new VehicleDTO();
        switch (vehicle.getClass().getTypeName()) {
            case "lpnu.entity.Car":
                vehicleDTO = CarToCarDTOMapper.toDTO((Car) vehicle);
                break;
            case "lpnu.entity.Truck":
                 vehicleDTO =  TruckToTruckDTOMapper.toDTO((Truck) vehicle);
                break;
            default:
                //todo exception
        }
        vehicleDTO.setId(vehicle.getId());
        vehicleDTO.setNumberVehicle(vehicle.getNumberVehicle());
        vehicleDTO.setVehicleStatus(vehicle.getVehicleStatus());
        vehicleDTO.setDriverId((vehicle.getDriver())==null?0:vehicle.getDriver().getId());
        vehicleDTO.setDriverName((vehicle.getDriver())==null?"":
                vehicle.getDriver().getSurname()+" "+vehicle.getDriver().getName());

        return vehicleDTO;
    }

}
