package com.ogutcenali.mapper;

import com.ogutcenali.dto.response.GetAllInfoForRestaurant;
import com.ogutcenali.rabbitmq.model.RegisterRestaurant;
import com.ogutcenali.repository.entity.Restaurant;
import com.ogutcenali.repository.enums.WeekDays;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-17T20:20:08+0300",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.5.1.jar, environment: Java 17.0.4.1 (Oracle Corporation)"
)
@Component
public class IRestaurantMapperImpl implements IRestaurantMapper {

    @Override
    public Restaurant toRestaurant(RegisterRestaurant registerRestaurant) {
        if ( registerRestaurant == null ) {
            return null;
        }

        Restaurant.RestaurantBuilder<?, ?> restaurant = Restaurant.builder();

        restaurant.authid( registerRestaurant.getAuthid() );
        restaurant.productsNumber( registerRestaurant.getProductsNumber() );
        restaurant.country( registerRestaurant.getCountry() );
        restaurant.restaurantName( registerRestaurant.getRestaurantName() );
        restaurant.city( registerRestaurant.getCity() );
        restaurant.district( registerRestaurant.getDistrict() );
        restaurant.neighbourhood( registerRestaurant.getNeighbourhood() );
        restaurant.managerName( registerRestaurant.getManagerName() );
        restaurant.managerSurname( registerRestaurant.getManagerSurname() );

        return restaurant.build();
    }

    @Override
    public GetAllInfoForRestaurant GET_ALL_INFO_FOR_RESTAURANT(Restaurant restaurant) {
        if ( restaurant == null ) {
            return null;
        }

        GetAllInfoForRestaurant.GetAllInfoForRestaurantBuilder getAllInfoForRestaurant = GetAllInfoForRestaurant.builder();

        getAllInfoForRestaurant.id( restaurant.getId() );
        getAllInfoForRestaurant.productsNumber( restaurant.getProductsNumber() );
        getAllInfoForRestaurant.country( restaurant.getCountry() );
        getAllInfoForRestaurant.restaurantName( restaurant.getRestaurantName() );
        getAllInfoForRestaurant.city( restaurant.getCity() );
        getAllInfoForRestaurant.district( restaurant.getDistrict() );
        getAllInfoForRestaurant.neighbourhood( restaurant.getNeighbourhood() );
        getAllInfoForRestaurant.managerName( restaurant.getManagerName() );
        getAllInfoForRestaurant.managerSurname( restaurant.getManagerSurname() );
        List<WeekDays> list = restaurant.getOpenDays();
        if ( list != null ) {
            getAllInfoForRestaurant.openDays( new ArrayList<WeekDays>( list ) );
        }
        getAllInfoForRestaurant.openTime( restaurant.getOpenTime() );
        getAllInfoForRestaurant.closeTime( restaurant.getCloseTime() );

        return getAllInfoForRestaurant.build();
    }
}
