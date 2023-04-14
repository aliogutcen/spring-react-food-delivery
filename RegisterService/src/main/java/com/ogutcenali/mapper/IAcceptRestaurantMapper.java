package com.ogutcenali.mapper;

import com.ogutcenali.dto.response.AllApprovalRegisterRestaurant;
import com.ogutcenali.repository.entity.AcceptRegisterRestaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAcceptRestaurantMapper {

    IAcceptRestaurantMapper INSTANCE = Mappers.getMapper(IAcceptRestaurantMapper.class);

    AllApprovalRegisterRestaurant toRestaurant(final AcceptRegisterRestaurant acceptRegisterRestaurant);
}
