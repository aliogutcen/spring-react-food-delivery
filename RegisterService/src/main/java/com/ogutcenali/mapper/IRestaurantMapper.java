package com.ogutcenali.mapper;

import com.ogutcenali.dto.request.RegisterRestaurantRequestDto;
import com.ogutcenali.rabbitmq.model.RegisterRestaurant;
import com.ogutcenali.repository.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestaurantMapper {

    IRestaurantMapper INSTANCE = Mappers.getMapper(IRestaurantMapper.class);

    Restaurant toRestaurant(final RegisterRestaurantRequestDto restaurantRequestDto);

    @Mapping(target = "authid",source = "id")
    RegisterRestaurant toRegisterRestaurant(final Restaurant restaurant);
}
