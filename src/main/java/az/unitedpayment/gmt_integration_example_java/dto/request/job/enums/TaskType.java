package az.unitedpayment.gmt_integration_example_java.dto.request.job.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum TaskType {
    PAY_TO_CARD(0, "pay.toCard"),
    PAY_TO_ACCOUNT(1, "pay.toAccount"),
    FX_RATE_GET(2, "fx.rateGet"),
    CARD_INFO_GET(3, "card.infoGet"),
    TASK_STATUS_GET(4, "task.statusGet"),
    GET_BALANCE(5, "getBalance"),
    CARD_CREATE_TOKEN(6, "card.createToken"),
    FX_RATE_GET_P2A(7, "fx.rateGet.p2a");

    // Enum'un ID olarak alınması
    private final int id;
    // Enum'un String olarak alınması
    private final String value;

    // String ve Integer için Map'ler
    private static final Map<String, TaskType> STRING_TO_ENUM = new HashMap<>();
    private static final Map<Integer, TaskType> INT_TO_ENUM = new HashMap<>();
    private static final Map<TaskType, String> ENUM_TO_STRING = new HashMap<>();
    private static final Map<TaskType, Integer> ENUM_TO_INT = new HashMap<>();

    static {
        for (TaskType type : values()) {
            STRING_TO_ENUM.put(type.value, type);
            INT_TO_ENUM.put(type.id, type);
            ENUM_TO_STRING.put(type, type.value);
            ENUM_TO_INT.put(type, type.id);
        }
    }

    // Constructor
    TaskType(int id, String value) {
        this.id = id;
        this.value = value;
    }

    // JSON Serialize (Enum -> String veya Integer)
    @JsonValue
    public Object toJson() {
        return ENUM_TO_STRING.get(this); // Varsayılan olarak String döndürüyoruz
    }

    // JSON Deserialize (String veya Integer -> Enum)
    @JsonCreator
    public static TaskType fromJson(Object value) {
        if (value instanceof String) {
            TaskType type = STRING_TO_ENUM.get(value);
            if (type == null) {
                throw new IllegalArgumentException("Invalid TaskType value: " + value);
            }
            return type;
        } else if (value instanceof Integer) {
            TaskType type = INT_TO_ENUM.get(value);
            if (type == null) {
                throw new IllegalArgumentException("Invalid TaskType ID: " + value);
            }
            return type;
        }
        throw new IllegalArgumentException("Unsupported type for TaskType: " + value);
    }

    // Enum'un String olarak temsil edilmesi
    @Override
    public String toString() {
        return value;
    }

    // String veya Integer'dan Enum elde etmek için metotlar
    public static TaskType fromString(String value) {
        return fromJson(value);
    }

    public static TaskType fromInt(int id) {
        return fromJson(id);
    }
}