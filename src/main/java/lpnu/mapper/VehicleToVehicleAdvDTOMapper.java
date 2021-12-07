package lpnu.mapper;

import lpnu.dto.VehicleAdvDTO;
import lpnu.entity.Vehicle;


public class VehicleToVehicleAdvDTOMapper {
    public static VehicleAdvDTO toDTO(Vehicle vehicle)
    {
        VehicleAdvDTO vehicleAdvDTO = new VehicleAdvDTO();
        switch (vehicle.getClass().getTypeName()) {
            case "lpnu.entity.Car":
                vehicleAdvDTO.setTypeVehicle("Passenger car");
                break;
            case "lpnu.entity.Truck":
                vehicleAdvDTO.setTypeVehicle("Truck");
                break;
        }
        vehicleAdvDTO.setId(vehicle.getId());
        vehicleAdvDTO.setNumberVehicle(vehicle.getNumberVehicle());
        vehicleAdvDTO.setVehicleStatus(vehicle.getVehicleStatus());
        vehicleAdvDTO.setDriverId((vehicle.getDriver())==null?0:vehicle.getDriver().getId());
        vehicleAdvDTO.setDriverName((vehicle.getDriver())==null?"":
                vehicle.getDriver().getSurname()+" "+vehicle.getDriver().getName());

        return vehicleAdvDTO;
    }
}
