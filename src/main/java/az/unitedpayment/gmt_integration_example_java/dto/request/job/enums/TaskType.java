package az.unitedpayment.gmt_integration_example_java.dto.request.job.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.HashMap;
import java.util.Map;

public enum TaskType {
    PAY_TO_CARD("pay.toCard"),
    PAY_TO_ACCOUNT("pay.toAccount"),
    FX_RATE_GET("fx.rateGet"),
    CARD_INFO_GET("card.infoGet"),
    TASK_STATUS_GET("task.statusGet"),
    GET_BALANCE("getBalance"),
    CARD_CREATE_TOKEN("card.createToken"),
    FX_RATE_GET_P2A("fx.rateGet.p2a");

    private final String value;

    private static final Map<String, TaskType> STRING_TO_ENUM = new HashMap<>();
    private static final Map<TaskType, String> ENUM_TO_STRING = new HashMap<>();

    static {
        for (TaskType type : values()) {
            STRING_TO_ENUM.put(type.value, type);
            ENUM_TO_STRING.put(type, type.value);
        }
    }

    // Constructor
    TaskType(String value) {
        this.value = value;
    }

    // JSON Serialize (Enum -> String)
    @JsonValue
    public String toJson() {
        return ENUM_TO_STRING.get(this);
    }

    // JSON Deserialize (String -> Enum)
    @JsonCreator
    public static TaskType fromJson(String value) {
        TaskType type = STRING_TO_ENUM.get(value);
        if (type == null) {
            throw new IllegalArgumentException("Invalid TasksType value: " + value);
        }
        return type;
    }

    @Override
    public String toString() {
        return value;
    }
}