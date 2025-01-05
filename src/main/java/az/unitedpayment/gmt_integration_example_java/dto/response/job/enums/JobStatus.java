package az.unitedpayment.gmt_integration_example_java.dto.response.job.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum JobStatus {
    SAVED(0, "SAVED"),
    PUBLISHED(1, "PUBLISHED"),
    APPROVED(2, "APPROVED"),
    FINISHED(3, "FINISHED");

    private final int id;
    private final String value;


    private static final Map<String, JobStatus> STRING_TO_ENUM = new HashMap<>();
    private static final Map<Integer, JobStatus> INT_TO_ENUM = new HashMap<>();
    private static final Map<JobStatus, String> ENUM_TO_STRING = new HashMap<>();
    private static final Map<JobStatus, Integer> ENUM_TO_INT = new HashMap<>();

    static {
        for (JobStatus status : values()) {
            STRING_TO_ENUM.put(status.value, status);
            INT_TO_ENUM.put(status.id, status);
            ENUM_TO_STRING.put(status, status.value);
            ENUM_TO_INT.put(status, status.id);
        }

    }

    // Constructor
    JobStatus(int id, String value) {
        this.id = id;
        this.value = value;
    }

    // JSON Serialize (Enum -> String or Integer)
    @JsonValue
    public Object toJson() {
        return ENUM_TO_STRING.get(this);
    }

    // JSON Deserialize (String or Integer -> Enum)
    @JsonCreator
    public static JobStatus fromJson(Object value) {
        if (value instanceof String) {
            JobStatus status = STRING_TO_ENUM.get(value);
            if (status == null) {
                throw new IllegalArgumentException("Invalid JobStatus value: " + value);
            }
            return status;
        } else if (value instanceof Integer) {
            JobStatus status = INT_TO_ENUM.get(value);
            if (status == null) {
                throw new IllegalArgumentException("Invalid JobStatus ID: " + value);
            }
            return status;
        }
        throw new IllegalArgumentException("Unsupported type for JobStatus: " + value);
    }


    @Override
    public String toString() {
        return value;
    }


    public static JobStatus fromString(String value) {
        return fromJson(value);
    }

    public static JobStatus fromInt(int id) {
        return fromJson(id);
    }
}