package br.com.bcredi.ui;

import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		System.out.println("Starting tests...");

		Parser<EventDto> eventDtoParser = new EventDtoTxtRowParserImpl();
		Map<EventSchema, EventDtoBuilder<Parseable>> parserUnity = new HashMap<>();
		parserUnity.put(EventSchema.PROPONENT,
				new EventDtoProponentEventDtoBuilderImpl(new ProponentEventDtoTxtRowParserImpl(eventDtoParser)));
		parserUnity.put(EventSchema.PROPOSAL,
				new EventDtoProposalEventDtoBuilderImpl(new ProposalEventDtoTxtRowParserImpl(eventDtoParser)));
		parserUnity.put(EventSchema.WARRANTY,
				new EventDtoWarrantyEventDtoBuilderImpl(new WarrantyEventDtoTxtRowParserImpl(eventDtoParser)));
		EventParserEngineImpl eventParserEngine = new EventParserEngineImpl(parserUnity);

		ProposalValidationsImpl proposalValidations = new ProposalValidationsImpl(new ArrayList<>());
		proposalValidations.addValidation(new LoanAmountValidationImpl());
		proposalValidations.addValidation(new NumberOfMonthlyInstallmentsValidationImpl());
		proposalValidations.addValidation(new CountOfProponentsValidationImpl());
		proposalValidations.addValidation(new CountOfMainProponentsValidationImpl());
		proposalValidations.addValidation(new MinimumOfWarrantiesByProposalValidationImpl());
		proposalValidations.addValidation(new ProponentAgeValidationImpl());
		proposalValidations.addValidation(new ProponentsMonthlyIncomeAgeBetween18And24YearsOldValidationImpl());
		proposalValidations.addValidation(new ProponentsMonthlyIncomeAgeBetween25And50YearsOldValidationImpl());
		proposalValidations.addValidation(new ProponentsMonthlyIncomeAgeMoreThan51YearsOldValidationImpl());
		proposalValidations.addValidation(new SumOfWarrantiesMoreThanProjectsProposalLoanValueValidationImpl());
		proposalValidations.addValidation(new WarrantiesProvinceAcceptedValidationImpl());
		Validator validator = new ProposalValidatorImpl(proposalValidations);

		ValidateProposalService validateProposalService = new ValidateProposalServiceImpl(validator);
		ProposalValidateController proposalValidateController = new ProposalValidateControllerImpl(eventDtoParser,
				eventParserEngine, validateProposalService);

//		String[] inputFiles = { "./../test/input/input000.txt", "./../test/input/input001.txt",
//				"./../test/input/input002.txt", "./../test/input/input003.txt", "./../test/input/input004.txt",
//				"./../test/input/input005.txt", "./../test/input/input006.txt", "./../test/input/input007.txt",
//				"./../test/input/input008.txt", "./../test/input/input009.txt", "./../test/input/input010.txt",
//				"./../test/input/input011.txt", "./../test/input/input012.txt" };

		String[] inputFiles = { "src/main/resources/test/input/input000.txt",
				"src/main/resources/test/input/input001.txt", "src/main/resources/test/input/input002.txt" };

//		String[] outputFiles = { "./../test/output/output000.txt", "./../test/output/output001.txt",
//				"./../test/output/output002.txt", "./../test/output/output003.txt", "./../test/output/output004.txt",
//				"./../test/output/output005.txt", "./../test/output/output006.txt", "./../test/output/output007.txt",
//				"./../test/output/output008.txt", "./../test/output/output009.txt", "./../test/output/output010.txt",
//				"./../test/output/output011.txt", "./../test/output/output012.txt" };

		String[] outputFiles = { "src/main/resources/test/output/output000.txt",
				"src/main/resources/test/output/output001.txt", "src/main/resources/test/output/output002.txt" };

		for (int i = 0; i <= outputFiles.length - 1; ++i) {
			Path inputPath = Paths.get(inputFiles[i]);
			Path outputPath = Paths.get(outputFiles[i]);

			List<String> inputLines = Files.readAllLines(inputPath);
			List<String> outputLines = Files.readAllLines(outputPath);

			String response = proposalValidateController.validate(inputLines);
			System.out.println(response);

			if (response.equals(outputLines.get(0))) {
				System.out.println(String.format("Test %s/%s - Passed", i + 1, outputFiles.length));
			} else {
				System.out.println(String.format("Test %s/%s - Failed", i + 1, outputFiles.length));
			}
		}
	}
	

}
