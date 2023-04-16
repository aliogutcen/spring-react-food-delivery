package com.ogutcenali.mapper;

import com.ogutcenali.rabbitmq.model.RegisterRestaurant;
import com.ogutcenali.repository.entity.Restaurant;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-17T00:43:04+0300",
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
}
