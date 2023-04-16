package com.ogutcenali.service;

import com.ogutcenali.dto.response.AllApprovalRegisterRestaurant;
import com.ogutcenali.repository.IAcceptRegisterRestaurantRepository;
import com.ogutcenali.repository.entity.AcceptRegisterRestaurant;
import com.ogutcenali.repository.enums.EStatus;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AcceptRegisterRestaurantService extends ServiceManager<AcceptRegisterRestaurant, UUID> {

    private final IAcceptRegisterRestaurantRepository acceptRegisterRestaurantRepository;
    private final RestaurantService restaurantService;

    public AcceptRegisterRestaurantService(IAcceptRegisterRestaurantRepository acceptRegisterRestaurantRepository, @Lazy RestaurantService restaurantService) {
        super(acceptRegisterRestaurantRepository);
        this.acceptRegisterRestaurantRepository = acceptRegisterRestaurantRepository;
        this.restaurantService = restaurantService;
    }

    public void approvalProcess(Long id) {
        AcceptRegisterRestaurant registerRestaurant =
                AcceptRegisterRestaurant.builder().restaurantId(id).eStatus(EStatus.PENDING).applicationDate(LocalDate.now()).build();
        save(registerRestaurant);
    }


    public List<AllApprovalRegisterRestaurant> getALLAproval() {
        List<AllApprovalRegisterRestaurant> allApprovalRegisterRestaurants = new ArrayList<>();
        List<AcceptRegisterRestaurant> acceptRegisterRestaurants = acceptRegisterRestaurantRepository.findAll().stream().filter(x -> x.getEStatus().equals(EStatus.PENDING)).toList();
        acceptRegisterRestaurants.forEach(x -> {
            allApprovalRegisterRestaurants.add(AllApprovalRegisterRestaurant.builder().restaurantId(x.getRestaurantId()).eStatus(x.getEStatus()).message(x.getMessage()).build());
        });
        return allApprovalRegisterRestaurants;

    }

    public Boolean applyRestaurant(Long id) {
        Optional<AcceptRegisterRestaurant> acceptRegisterRestaurant = acceptRegisterRestaurantRepository.findOptionalByRestaurantId(id);
        if (restaurantService.enoughForApproval(acceptRegisterRestaurant.get().getRestaurantId())) {
            acceptRegisterRestaurant.get().setEStatus(EStatus.ACCEPT);
            acceptRegisterRestaurant.get().setMessage("Your registration has been confirmed");
            update(acceptRegisterRestaurant.get());
            restaurantService.registerRestaurantForAuth(acceptRegisterRestaurant.get().getRestaurantId());
            return true;
        }
        acceptRegisterRestaurant.get().setEStatus(EStatus.NOT_ACCEPTED);
        acceptRegisterRestaurant.get().setMessage("Your registration has not been confirmed");
        update(acceptRegisterRestaurant.get());
        return false;
    }
}
