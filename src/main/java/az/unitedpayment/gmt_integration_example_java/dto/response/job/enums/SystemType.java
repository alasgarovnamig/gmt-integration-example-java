package az.unitedpayment.gmt_integration_example_java.dto.response.job.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum SystemType {
    DEFAULT(0, "DEFAULT"),
    VISA(1, "VISA"),
    MASTERCARD(2, "MASTERCARD"),
    FINANCE(3, "FINANCE"),
    ACCOUNT(4, "ACCOUNT");

    private final int id;
    private final String value;


    private static final Map<String, SystemType> STRING_TO_ENUM = new HashMap<>();
    private static final Map<Integer, SystemType> INT_TO_ENUM = new HashMap<>();
    private static final Map<SystemType, String> ENUM_TO_STRING = new HashMap<>();
    private static final Map<SystemType, Integer> ENUM_TO_INT = new HashMap<>();

    static {
        for (SystemType type : values()) {
            STRING_TO_ENUM.put(type.value, type);
            INT_TO_ENUM.put(type.id, type);
            ENUM_TO_STRING.put(type, type.value);
            ENUM_TO_INT.put(type, type.id);
        }
    }

    // Constructor
    SystemType(int id, String value) {
        this.id = id;
        this.value = value;
    }

    // JSON Serialize (Enum -> String or Integer)
    @JsonValue
    public Object toJson() {
        return ENUM_TO_STRING.get(this); // Varsayılan olarak String döndürüyoruz
    }

    // JSON Deserialize (String or Integer -> Enum)
    @JsonCreator
    public static SystemType fromJson(Object value) {
        if (value instanceof String) {
            SystemType type = STRING_TO_ENUM.get(value);
            if (type == null) {
                throw new IllegalArgumentException("Invalid SystemType value: " + value);
            }
            return type;
        } else if (value instanceof Integer) {
            SystemType type = INT_TO_ENUM.get(value);
            if (type == null) {
                throw new IllegalArgumentException("Invalid SystemType ID: " + value);
            }
            return type;
        }
        throw new IllegalArgumentException("Unsupported type for SystemType: " + value);
    }


    @Override
    public String toString() {
        return value;
    }


    public static SystemType fromString(String value) {
        return fromJson(value);
    }

    public static SystemType fromInt(int id) {
        return fromJson(id);
    }
}