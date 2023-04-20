package com.ogutcenali.service;

import com.ogutcenali.dto.request.AddAddressRequestDto;
import com.ogutcenali.dto.request.DeleteAddressRequestDto;
import com.ogutcenali.rabbitmq.model.RegisterUser;
import com.ogutcenali.repository.ICustomerRepository;
import com.ogutcenali.repository.entity.Address;
import com.ogutcenali.repository.entity.Customer;
import com.ogutcenali.utility.JwtTokenManager;
import com.ogutcenali.utility.ServiceManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService extends ServiceManager<Customer, String> {

    private final ICustomerRepository customerRepository;
    private final JwtTokenManager jwtTokenManager;

    public CustomerService(ICustomerRepository customerRepository, JwtTokenManager jwtTokenManager) {
        super(customerRepository);
        this.customerRepository = customerRepository;
        this.jwtTokenManager = jwtTokenManager;
    }

    public void saveCustomerFromRegister(RegisterUser registerUser) {
        Customer customer = Customer.builder()
                .authId(registerUser.getUserId())
                .mail(registerUser.getMail())
                .username(registerUser.getUsername())
                .build();
        save(customer);

    }

    public Boolean addAddress(AddAddressRequestDto addressRequestDto) {
        Optional<Long> authId = jwtTokenManager.decodeToken(addressRequestDto.getToken());
        Optional<Customer> customer = customerRepository.findOptionalByAuthId(authId.get());
        if (customer.get().getAddressList() == null) {
            List<Address> addressList = new ArrayList<>();
            Address address = Address.builder()
                    .openAddress(addressRequestDto.getOpenAddress())
                    .city(addressRequestDto.getCity())
                    .doorNo(addressRequestDto.getDoorNo())
                    .district(addressRequestDto.getDistrict())
                    .neighbourhood(addressRequestDto.getNeighbourhood())
                    .build();
            addressList.add(address);
            customer.get().setAddressList(addressList);
            update(customer.get());
        }
        Address address = Address.builder()
                .openAddress(addressRequestDto.getOpenAddress())
                .city(addressRequestDto.getCity())
                .doorNo(addressRequestDto.getDoorNo())
                .district(addressRequestDto.getDistrict())
                .neighbourhood(addressRequestDto.getNeighbourhood())
                .build();
        customer.get().getAddressList().add(address);
        update(customer.get());
        return true;
    }


    public List<Address> getAllAddress(String token) {
        Optional<Long> authId = jwtTokenManager.decodeToken(token);
        Optional<Customer> customer = customerRepository.findOptionalByAuthId(authId.get());
        return customer.get().getAddressList();
    }

    public Object deleteAddress(DeleteAddressRequestDto deleteAddressRequestDto) {
        Optional<Long> authId = jwtTokenManager.decodeToken(deleteAddressRequestDto.getToken());
        Optional<Customer> customer = customerRepository.findOptionalByAuthId(authId.get());
        Optional<Address> address = customer.get().getAddressList().stream().filter(x -> x.getCity().equals(deleteAddressRequestDto.getCity())).filter(x -> x.getOpenAddress().equals(deleteAddressRequestDto.getOpenAddress())).findFirst();
        customer.get().getAddressList().remove(address.get());
        update(customer.get());
        return true;
    }
}
