package com.enset.bankservice.mapper;

import com.enset.bankservice.dto.BankAccountDTOResponse;
import com.enset.bankservice.entity.BankAccount;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BankAccountMapper {

    @Mapping(source = "customer.name", target = "customerName")
   BankAccountDTOResponse toDto(BankAccount bankAccount);

}
