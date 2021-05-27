package pl.juniorjavadeveloper.project.weatherman.service.mapper;

import org.modelmapper.ModelMapper;
import pl.juniorjavadeveloper.project.weatherman.dao.hibernate.LocationEntity;
import pl.juniorjavadeveloper.project.weatherman.model.LocationModel;

import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class LocationMapper {
    private static final Logger LOGGER = Logger.getLogger(LocationMapper.class.getName());

    public List<LocationModel> fromList(List<LocationEntity> locationEntities) {
        LOGGER.info("from(" + locationEntities + ")");
        return locationEntities.stream()
                .map(this::from)
                .collect(Collectors.toList());
    }

    public LocationEntity from(LocationModel locationModel) {
        LOGGER.info("from(" + locationModel + ")");
        ModelMapper modelMapper = new ModelMapper();
        LocationEntity locationEntity = modelMapper.map(locationModel, LocationEntity.class);
        LOGGER.info("from(...) = " + locationEntity);
        return locationEntity;
    }

    public LocationModel from(LocationEntity locationEntity) {
        LOGGER.info("from(" + locationEntity + ")");

//        ModelMapper modelMapper = new ModelMapper();
//        LocationModel locationModel = modelMapper.map(locationEntity, LocationModel.class);

        LocationModel locationModel = new LocationModel();
        if (locationEntity != null) {
            locationModel.setId(locationEntity.getId());
            locationModel.setCity(locationEntity.getCity());
            locationModel.setCountryCode(locationEntity.getCountryCode());
            locationModel.setLatitude(locationEntity.getLatitude());
            locationModel.setLongitude(locationEntity.getLongitude());
            locationModel.setTemperature(locationEntity.getTemperature());
            locationModel.setPressure(locationEntity.getPressure());
            locationModel.setHumidity(locationEntity.getHumidity());
            locationModel.setWindSpeed(locationEntity.getWindSpeed());
        }

        LOGGER.info("from(...) = " + locationModel);
        return locationModel;
    }
}
