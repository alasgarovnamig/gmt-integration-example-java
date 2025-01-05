package az.unitedpayment.gmt_integration_example_java.dto.response.job.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum TaskStatus {
    CREATED(0, "CREATED"),
    ACCEPTED(1, "ACCEPTED"),
    PROCESSING(2, "PROCESSING"),
    SUCCESS(3, "SUCCESS"),
    FAILED(4, "FAILED"),
    SKIPPED(5, "SKIPPED");

    private final int id;
    private final String value;


    private static final Map<String, TaskStatus> STRING_TO_ENUM = new HashMap<>();
    private static final Map<Integer, TaskStatus> INT_TO_ENUM = new HashMap<>();
    private static final Map<TaskStatus, String> ENUM_TO_STRING = new HashMap<>();
    private static final Map<TaskStatus, Integer> ENUM_TO_INT = new HashMap<>();

    static {
        for (TaskStatus status : values()) {
            STRING_TO_ENUM.put(status.value, status);
            INT_TO_ENUM.put(status.id, status);
            ENUM_TO_STRING.put(status, status.value);
            ENUM_TO_INT.put(status, status.id);
        }
    }

    // Constructor
    TaskStatus(int id, String value) {
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
    public static TaskStatus fromJson(Object value) {
        if (value instanceof String) {
            TaskStatus status = STRING_TO_ENUM.get(value);
            if (status == null) {
                throw new IllegalArgumentException("Invalid TaskStatus value: " + value);
            }
            return status;
        } else if (value instanceof Integer) {
            TaskStatus status = INT_TO_ENUM.get(value);
            if (status == null) {
                throw new IllegalArgumentException("Invalid TaskStatus ID: " + value);
            }
            return status;
        }
        throw new IllegalArgumentException("Unsupported type for TaskStatus: " + value);
    }


    @Override
    public String toString() {
        return value;
    }


    public static TaskStatus fromString(String value) {
        return fromJson(value);
    }

    public static TaskStatus fromInt(int id) {
        return fromJson(id);
    }
}