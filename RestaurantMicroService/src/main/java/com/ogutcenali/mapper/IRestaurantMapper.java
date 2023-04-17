package com.ogutcenali.mapper;

import com.ogutcenali.dto.response.GetAllInfoForRestaurant;
import com.ogutcenali.rabbitmq.model.RegisterRestaurant;
import com.ogutcenali.repository.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IRestaurantMapper {

    IRestaurantMapper INSTANCE = Mappers.getMapper(IRestaurantMapper.class);

    Restaurant toRestaurant(final RegisterRestaurant registerRestaurant);

    GetAllInfoForRestaurant GET_ALL_INFO_FOR_RESTAURANT(final Restaurant restaurant);
}
