package pl.gov.arimr.spring.core.converter;

import pl.gov.arimr.spring.core.constant.UserRole;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class UserRoleConverter implements AttributeConverter<UserRole, String> {

    public UserRoleConverter() {
    }

    @Override
    public String convertToDatabaseColumn(UserRole attribute) {
        return attribute.name();
    }

    @Override
    public UserRole convertToEntityAttribute(String dbData) {
        return UserRole.getByName(dbData);
    }
}
