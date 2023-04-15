package com.ogutcenali.service;

import com.ogutcenali.dto.request.RegisterRestaurantRequestDto;
import com.ogutcenali.exception.ErrorType;
import com.ogutcenali.exception.RegisterException;
import com.ogutcenali.mapper.IRestaurantMapper;
import com.ogutcenali.rabbitmq.model.RegisterRestaurantForAuth;
import com.ogutcenali.rabbitmq.model.SupportRegisterRestaurant;
import com.ogutcenali.rabbitmq.producer.RegisterProducer;
import com.ogutcenali.repository.IRestaurantRepository;
import com.ogutcenali.repository.entity.Restaurant;
import com.ogutcenali.utility.EmailSenderService;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class RestaurantService extends ServiceManager<Restaurant, Long> {

    private final IRestaurantRepository restaurantRepository;
    private final AcceptRegisterRestaurantService acceptRegisterRestaurantService;
    private final RegisterProducer registerProducer;
    private final EmailSenderService emailSenderService;

    public RestaurantService(IRestaurantRepository restaurantRepository, AcceptRegisterRestaurantService acceptRegisterRestaurantService, RegisterProducer registerProducer, EmailSenderService emailSenderService) {
        super(restaurantRepository);
        this.restaurantRepository = restaurantRepository;

        this.acceptRegisterRestaurantService = acceptRegisterRestaurantService;
        this.registerProducer = registerProducer;
        this.emailSenderService = emailSenderService;
    }

    public Boolean register(RegisterRestaurantRequestDto restaurantRequestDto) throws MessagingException {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findOptionalByMail(restaurantRequestDto.getMail());
        if (restaurantOptional.isPresent()) throw new RegisterException(ErrorType.RESTAURANT_ALREADY_EXISTS);
        Restaurant restaurant = save(IRestaurantMapper.INSTANCE.toRestaurant(restaurantRequestDto));

        /**
         * KAYIT SONRASI PDF GONDERILDI
         */
        emailSenderService.sendMailWithAttachment(restaurant.getMail()
                ,  "The files you need to approve for the application process of your company named"+restaurant.getManagerName()
                , " Your last day to send the documents 7 after signing the files you are expected to send the file to our support team."
                , "C:/Users/PC/Desktop/ali.pdf");
        acceptRegisterRestaurantService.approvalProcess(restaurant.getId());
        return true;
    }
    public Boolean enoughForApproval(Long restaurantId) {
        Optional<Restaurant> restaurant = findById(restaurantId);
        if (restaurant.get().getProductsNumber() > 20) return true;
        return false;
    }
    public void registerRestaurantForAuth(Long restaurantId) {
        Optional<Restaurant> restaurant = findById(restaurantId);
        registerProducer.registerRestaurantForAuth(RegisterRestaurantForAuth.builder()
                .mail(restaurant.get().getMail())
                .password("1ali12345")
                .build());
    }

    public void acceptRestaurant(SupportRegisterRestaurant supportRegisterRestaurant) {
        Optional<Restaurant> restaurant = restaurantRepository.findOptionalByMail(supportRegisterRestaurant.getMail());
        System.out.println(restaurant.get());
        acceptRegisterRestaurantService.applyRestaurant(restaurant.get().getId());

    }
}
