package com.cristian.accounts.application.accounts.web.v1;

import com.cristian.accounts.domain.accounts.model.Account;
import com.cristian.accounts.domain.accounts.model.ContactDetail;
import com.cristian.accounts.infrastructure.mapper.EmailMapper;
import com.cristian.accounts.infrastructure.mapper.PhoneMapper;
import com.cristian.accounts.infrastructure.mapper.UuidMapper;
import lombok.Data;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import java.util.Map;
import java.util.Set;

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR,
    uses = {EmailMapper.class, PhoneMapper.class, UuidMapper.class})
public interface AccountsApiResponse {

  AccountDetailed accountDetailed(Account account);

  @Data
  class AccountDetailed {
    private String identity;
    private String email;
    private String name;
    private String surname;
    private String phone;
    private Set<ContactDetail> contactDetails;
    private Map<String, String> customFields;
  }
}
