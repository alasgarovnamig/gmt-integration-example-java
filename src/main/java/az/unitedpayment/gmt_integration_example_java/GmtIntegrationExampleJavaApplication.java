package az.unitedpayment.gmt_integration_example_java;

import az.unitedpayment.gmt_integration_example_java.client.AuthClient;
import az.unitedpayment.gmt_integration_example_java.dto.request.auth.PartnerLoginDto;
import az.unitedpayment.gmt_integration_example_java.dto.request.job.JobCreateDto;
import az.unitedpayment.gmt_integration_example_java.dto.request.job.Payload;
import az.unitedpayment.gmt_integration_example_java.dto.request.job.TaskDto;
import az.unitedpayment.gmt_integration_example_java.dto.request.job.enums.TaskType;
import az.unitedpayment.gmt_integration_example_java.dto.response.ResponseBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.SearchBase;
import az.unitedpayment.gmt_integration_example_java.dto.response.auth.AuthResponse;
import az.unitedpayment.gmt_integration_example_java.dto.response.country.CountryData;
import az.unitedpayment.gmt_integration_example_java.dto.response.job.JobCreateResponseDto;
import az.unitedpayment.gmt_integration_example_java.service.CountryService;
import az.unitedpayment.gmt_integration_example_java.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@EnableFeignClients
@SpringBootApplication
@RequiredArgsConstructor
public class GmtIntegrationExampleJavaApplication implements CommandLineRunner {
	@Value("${app.partner_unique_id}")
	private String partnerUniqueId;

	@Value("${app.password}")
	private String password;

	private final AuthClient authClient;
	private final JobService jobService;
	private final CountryService countryService;
	public static void main(String[] args) {
		SpringApplication.run(GmtIntegrationExampleJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ResponseBase<AuthResponse> resp = authClient.partnerLogin(PartnerLoginDto.builder()
				.partnerUniqueId(partnerUniqueId)
				.password(password)
				.build());

		JobCreateDto request = JobCreateDto.builder()
				.partnerJobId(UUID.randomUUID().toString())
				.taskSet(new HashSet<TaskDto>(Set.of(
						TaskDto.builder()
								.taskType(TaskType.FX_RATE_GET_P2A)
								.taskPartnerId(UUID.randomUUID().toString())
								.payload(
										Payload.builder()
												.payOutAmount("5")
												.payInCurrency("USD")
												.payOutCountry("DK")
												.payOutCurrency("DKK")
												.build()
								)
								.taskCallbackUri("http://localhost:8098/v1/callback")
								.build(),
						TaskDto.builder()
								.taskType(TaskType.FX_RATE_GET)
								.taskPartnerId(UUID.randomUUID().toString())
								.payload(
										Payload.builder()
												.amountIn("5.0")
												.currencyIn("USD")
												.paymentSystem("VISA")
												.currencyOut("DKK")
												.build()
								)
								.taskCallbackUri("http://localhost:8098/v1/callback")
								.build(),
						TaskDto.builder()
								.taskType(TaskType.CARD_INFO_GET)
								.taskPartnerId(UUID.randomUUID().toString())
								.payload(
										Payload.builder()
												.cardNumber("4716439086866511")
												.build()
								)
								.taskCallbackUri("http://localhost:8098/v1/callback")
								.build(),
						TaskDto.builder()
								.taskType(TaskType.CARD_CREATE_TOKEN)
								.taskPartnerId(UUID.randomUUID().toString())
								.payload(
										Payload.builder()
												.cardNumber("4716439086866511")
												.cardExpireDate("05/23")
												.build()
								)
								.taskCallbackUri("http://localhost:8098/v1/callback")
								.build(),
						TaskDto.builder()
								.taskType(TaskType.PAY_TO_ACCOUNT)
								.taskPartnerId(UUID.randomUUID().toString())
								.payload(
										Payload.builder()
												.fromSenderType("Individual")
												.fromSenderAddressLine1("31, GARABAKH STR")
												.fromSenderAddressCountry("AZ")
												.fromSenderAddressCity("Baku")
												.fromSenderAddressZip("12345")
												.fromGovernmentIdType("NationalPassport")
												.fromGovernmentIdNumber("1234567890")
												.fromGovernmentIdIssuingCountry("AZ")
												.fromGovernmentIdIssueDate("2023-05-05")
												.fromGovernmentIdExpirationDate("2026-01-01")
												.fromSenderAccountIdentifierType("Ewallet")
												.fromSenderAccountIdentifier("CUSTOMER1234")
												.fromSenderAccountCountry("AZ")
												.fromSenderAccountCurrency("AZN")
												.fromSenderAccountProvider("UPAZ")
												.fromSenderFirstName("Tomas")
												.fromSenderLastName("Tomanson")
												.fromSenderNationality("AZ")
												.fromSenderDateOfBirth("1980-01-01")
												.fromSenderSourceTransactionInstrumentIdentifierType("PrepaidAccount")
												.fromSenderSourceTransactionInstrumentAccountIdentifier("0300c3e2-507c-46a4-8ec4-57881bb817e4")
												.fromSenderSourceTransactionInstrumentCurrency("USD")
												.toDestinationTransactionInstrumentIdentifierType("IBAN")
												.toDestinationTransactionInstrumentAccountIdentifier("GB82WYST12345698765432")
												.toDestinationTransactionInstrumentAccountName("GB82WY")
												.toDestinationTransactionInstrumentCurrency("AED")
												.toDestinationTransactionInstrumentCountry("AE")
												.toRecipientType("Individual")
												.toRecipientAddressLine1("35, Al Tareq Road")
												.toRecipientAddressCountry("AE")
												.toRecipientAddressCity("Dubai")
												.toRecipientAddressZip("78600")
												.toRecipientAddressCountrySubdivision("Al Warqaá 5")
												.toRecipientFirstName("Tomas")
												.toRecipientLastName("Lee")
												.toRecipientDateOfBirth("1980-01-01")
												.toRecipientPhone("123456")
												.toRecipientNationality("AE")
												.toGovernmentIdType("NationalPassport")
												.toGovernmentIdNumber("1234567890")
												.toGovernmentIdIssuingCountry("AE")
												.toGovernmentIdIssueDate("2023-05-05")
												.toGovernmentIdExpirationDate("2026-01-01")
												.transferAmount(new BigDecimal("10.25"))
												.transferCurrency("AED")
												.purposeOfPayment("ISSALA")
												.sourceOfFounds("Salary")
												.paymentType("P2P")
												.invoiceId(UUID.randomUUID().toString())
												.comment("This is the test payment!")
												.build()
								)
								.taskCallbackUri("http://localhost:8098/v1/callback")
								.build(),
						TaskDto.builder()
								.taskType(TaskType.PAY_TO_CARD)
								.taskPartnerId(UUID.randomUUID().toString())
								.payload(
										Payload.builder()
												.cardToken("123456498484")
												.paymentSystem("MASTERCARD")
												.toRecipientFirstName("Derufrewe")
												.toRecipientLastName("Hecdioht")
												.transferAmount(new BigDecimal("10.78"))
												.transferCurrency("USD")
												.birthYear(1972)
												.toRecipientNationality("GB")
												.countryOfResidence("GB")
												.fromSenderFirstName("Paysend")
												.fromSenderLastName("Paysend")
												.fromSenderAddressZip("EH42HS")
												.fromSenderAddressCountry("GB")
												.fromSenderAddressCity("London")
												.fromSenderAddressLine1("Orchard Brae House,30 Queensferry Road,Edinburgh")
												.invoiceId(UUID.randomUUID().toString()) // Invoice ID must be unique
												.comment("test pay.toCard")
												.build()
								)
								.taskCallbackUri("http://localhost:8098/v1/callback")
								.build(),
						TaskDto.builder()
								.taskType(TaskType.PAY_TO_CARD)
								.taskPartnerId(UUID.randomUUID().toString())
								.payload(
										Payload.builder()
												.cardNumber("4716439086866511")
												.toRecipientFirstName("Derufrewe")
												.toRecipientLastName("Hecdioht")
												.transferAmount(new BigDecimal("10.65"))
												.transferCurrency("USD")
												.birthYear(1972)
												.toRecipientNationality("GB")
												.countryOfResidence("GB")
												.fromSenderFirstName("Paysend")
												.fromSenderLastName("Paysend")
												.fromSenderAddressZip("EH42HS")
												.fromSenderAddressCountry("GB")
												.fromSenderAddressCity("London")
												.fromSenderAddressLine1("Orchard Brae House,30 Queensferry Road,Edinburgh")
												.invoiceId(UUID.randomUUID().toString()) // Invoice ID must be unique
												.comment("test pay.toCard")
												.build()
								)
								.taskCallbackUri("http://localhost:8098/v1/callback")
								.build()
				)))
				.build();
		System.out.println(request);
		ResponseBase<JobCreateResponseDto> rb = jobService.Create(request);
		System.out.println(rb);

		ResponseBase<SearchBase<JobCreateResponseDto>> sb = jobService.Search();
		System.out.println(sb);

		ResponseBase<SearchBase<CountryData>> sbc = countryService.Search();
		System.out.println(sbc);
	}
}
