package az.unitedpayment.gmt_integration_example_java.dto.response.job;


import az.unitedpayment.gmt_integration_example_java.dto.request.job.enums.TaskType;
import az.unitedpayment.gmt_integration_example_java.dto.response.SearchMarker;
import az.unitedpayment.gmt_integration_example_java.dto.response.card.CardData;
import az.unitedpayment.gmt_integration_example_java.dto.response.job.enums.SystemType;
import az.unitedpayment.gmt_integration_example_java.dto.response.job.enums.TaskStatus;
import az.unitedpayment.gmt_integration_example_java.dto.response.rate.RateData;
import az.unitedpayment.gmt_integration_example_java.utils.MultiFormatDateDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TaskCreateResponseDto implements SearchMarker {


    private Long id;

    @JsonProperty("created_at")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime createdAt;

    @JsonProperty("updated_at")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime updatedAt;

    @JsonProperty("deleted_at")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime deletedAt;

    @JsonProperty("up_reference")
    private String upReference;

    private TaskStatus status;

    private TaskType type;

    @JsonProperty("task_partner_id")
    private String taskPartnerId;

    @JsonProperty("task_callback_url")
    private String taskCallbackUrl;

    @JsonProperty("task_paysend_status")
    private String taskPaysendStatus;

    @JsonProperty("task_paysend_code")
    private int taskPaysendCode;

    @JsonProperty("task_response_paysend_payment_id")
    private String taskResponsePaysendPaymentId;

    @JsonProperty("task_response_comment")
    private String taskResponseComment;

    @JsonProperty("requested_type")
    private String requestedType;

    @JsonProperty("payout_amount")
    private BigDecimal payoutAmount;

    @JsonProperty("payin_currency")
    private String payinCurrency;

    @JsonProperty("payout_currency")
    private String payoutCurrency;

    @JsonProperty("payout_country")
    private String payoutCountry;

    @JsonProperty("amount_in")
    private BigDecimal amountIn;

    @JsonProperty("currency_in")
    private String currencyIn;

    @JsonProperty("currency_out")
    private String currencyOut;

    @JsonProperty("pay_system")
    private SystemType paySystem;

    @JsonProperty("from_sender_type")
    private String fromSenderType;

    @JsonProperty("from_sender_name")
    private String fromSenderName;

    @JsonProperty("from_sender_address_line1")
    private String fromSenderAddressLine1;

    @JsonProperty("from_sender_address_country")
    private String fromSenderAddressCountry;

    @JsonProperty("from_sender_address_city")
    private String fromSenderAddressCity;

    @JsonProperty("from_sender_address_zip")
    private String fromSenderAddressZip;

    @JsonProperty("from_government_id_type")
    private String fromGovernmentIdType;

    @JsonProperty("from_government_id_number")
    private String fromGovernmentIdNumber;

    @JsonProperty("from_government_id_issuing_country")
    private String fromGovernmentIdIssuingCountry;

    @JsonProperty("from_government_id_issue_date")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime fromGovernmentIdIssueDate;

    @JsonProperty("from_government_id_expiration_date")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime fromGovernmentIdExpirationDate;

    @JsonProperty("from_sender_account_identifier_type")
    private String fromSenderAccountIdentifierType;

    @JsonProperty("from_sender_account_identifier")
    private String fromSenderAccountIdentifier;

    @JsonProperty("from_sender_account_country")
    private String fromSenderAccountCountry;

    @JsonProperty("from_sender_account_currency")
    private String fromSenderAccountCurrency;

    @JsonProperty("from_sender_account_provider")
    private String fromSenderAccountProvider;

    @JsonProperty("from_sender_first_name")
    private String fromSenderFirstName;

    @JsonProperty("from_sender_last_name")
    private String fromSenderLastName;

    @JsonProperty("from_sender_nationality")
    private String fromSenderNationality;

    @JsonProperty("from_sender_date_of_birth")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime fromSenderDateOfBirth;

    @JsonProperty("from_sender_source_transaction_instrument_identifier_type")
    private String fromSenderSourceTransactionInstrumentIdentifierType;

    @JsonProperty("from_sender_source_transaction_instrument_account_identifier")
    private String fromSenderSourceTransactionInstrumentAccountIdentifier;

    @JsonProperty("from_sender_source_transaction_instrument_currency")
    private String fromSenderSourceTransactionInstrumentCurrency;

    @JsonProperty("to_destination_transaction_instrument_identifier_type")
    private String toDestinationTransactionInstrumentIdentifierType;

    @JsonProperty("to_destination_transaction_instrument_account_identifier")
    private String toDestinationTransactionInstrumentAccountIdentifier;

    @JsonProperty("to_destination_transaction_instrument_account_name")
    private String toDestinationTransactionInstrumentAccountName;

    @JsonProperty("to_destination_transaction_instrument_currency")
    private String toDestinationTransactionInstrumentCurrency;

    @JsonProperty("to_destination_transaction_instrument_country")
    private String toDestinationTransactionInstrumentCountry;

    @JsonProperty("to_recipient_type")
    private String toRecipientType;

    @JsonProperty("to_recipient_address_line1")
    private String toRecipientAddressLine1;

    @JsonProperty("to_recipient_address_country")
    private String toRecipientAddressCountry;

    @JsonProperty("to_recipient_address_city")
    private String toRecipientAddressCity;

    @JsonProperty("to_recipient_address_zip")
    private String toRecipientAddressZip;

    @JsonProperty("to_recipient_address_country_subdivision")
    private String toRecipientAddressCountrySubdivision;

    @JsonProperty("to_recipient_first_name")
    private String toRecipientFirstName;

    @JsonProperty("to_recipient_last_name")
    private String toRecipientLastName;

    @JsonProperty("to_recipient_date_of_birth")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime toRecipientDateOfBirth;

    @JsonProperty("to_recipient_phone")
    private String toRecipientPhone;

    @JsonProperty("to_recipient_nationality")
    private String toRecipientNationality;

    @JsonProperty("to_government_id_type")
    private String toGovernmentIdType;

    @JsonProperty("to_government_id_number")
    private String toGovernmentIdNumber;

    @JsonProperty("to_government_id_issuing_country")
    private String toGovernmentIdIssuingCountry;

    @JsonProperty("to_government_id_issue_date")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime toGovernmentIdIssueDate;

    @JsonProperty("to_government_id_expiration_date")
    @JsonDeserialize(using = MultiFormatDateDeserializer.class)
    private ZonedDateTime toGovernmentIdExpirationDate;

    @JsonProperty("transfer_amount")
    private BigDecimal transferAmount;

    @JsonProperty("transfer_currency")
    private String transferCurrency;

    @JsonProperty("purpose_of_payment")
    private String purposeOfPayment;

    @JsonProperty("source_of_founds")
    private String sourceOfFounds;

    @JsonProperty("payment_type")
    private String paymentType;

    @JsonProperty("invoice_id")
    private String invoiceId;

    @JsonProperty("comment")
    private String comment;

    @JsonProperty("card_token")
    private String cardToken;

    @JsonProperty("card_number")
    private String cardNumber;

    @JsonProperty("birth_year")
    private int birthYear;

    @JsonProperty("country_of_residence")
    private String countryOfResidence;

    @JsonProperty("cardExpire_date")
    private String cardExpireDate;

    private List<RateData> rates;

    private List<CardData> cards;

    @JsonProperty("payment_results")
    private List<PaymentResult> paymentResults;

}
