package az.unitedpayment.gmt_integration_example_java.dto.request.job;


import az.unitedpayment.gmt_integration_example_java.dto.request.job.enums.TaskType;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Payload {
    // For TaskType task.statusGet
    @JsonProperty("payment_id")
    private String paymentId;
    @JsonProperty("requested_type")
    private TaskType requestedType;

    // For TaskType fx.rateGet.p2a
    @JsonProperty("pay_out_amount")
    private String payOutAmount;
    @JsonProperty("pay_in_currency")
    private String payInCurrency;
    @JsonProperty("pay_out_country")
    private String payOutCountry;
    @JsonProperty("pay_out_currency")
    private String payOutCurrency;

    // For TaskType fx.rateGet
    @JsonProperty("currency_in")
    private String currencyIn;  // alpha 3 currency code (ISO 4217)
    @JsonProperty("currency_out")
    private String currencyOut; // alpha 3 currency code (ISO 4217)
    @JsonProperty("amount_in")
    private String amountIn; // input amount for calculate FX rate
    @JsonProperty("payment_system")
    private String paymentSystem; // VISA or MASTERCARD

    // for TaskType card.createToken
    @JsonProperty("card_expire_date")
    private String cardExpireDate;


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
    private String fromGovernmentIdIssueDate;

    @JsonProperty("from_government_id_expiration_date")
    private String fromGovernmentIdExpirationDate;

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
    private String fromSenderDateOfBirth;

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
    private String toRecipientDateOfBirth;

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
    private String toGovernmentIdIssueDate;

    @JsonProperty("to_government_id_expiration_date")
    private String toGovernmentIdExpirationDate;

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

}

