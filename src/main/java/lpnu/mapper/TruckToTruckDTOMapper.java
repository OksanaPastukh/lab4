package lpnu.mapper;

import lpnu.dto.TruckDTO;
import lpnu.entity.Truck;
import org.springframework.stereotype.Component;

@Component
public class TruckToTruckDTOMapper {
    public static TruckDTO toDTO(Truck truck)
    {
        TruckDTO truckDTO = new TruckDTO();
        truckDTO.setLiftingСapacity(truck.getLiftingСapacity());
        truckDTO.setId(truck.getId());
        truckDTO.setNumberVehicle(truck.getNumberVehicle());
        truckDTO.setVehicleStatus(truck.getVehicleStatus());
        truckDTO.setDriverId((truck.getDriver())==null?0:truck.getDriver().getId());
        truckDTO.setDriverName((truck.getDriver())==null?"":
                truck.getDriver().getSurname()+" "+truck.getDriver().getName());

        return truckDTO;
    }
}
