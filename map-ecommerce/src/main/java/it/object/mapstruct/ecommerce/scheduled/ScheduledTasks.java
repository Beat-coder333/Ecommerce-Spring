package it.object.mapstruct.ecommerce.scheduled;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import it.object.mapstruct.ecommerce.dto.DailyOrderCountDTO;
import it.object.mapstruct.ecommerce.repository.OrdineRepository;

@Component
public class ScheduledTasks {

	@Autowired
	private OrdineRepository orderRepo;

	private static Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

	@Scheduled(cron = "${scheduler.cron.expression.order-list}")
	public void writeReport() {

		log.info("Scheduled tasks - daily order list");
		String dateRecord = getDateReport();
		Integer ordiniEff = orderRepo.countByData(dateRecord);
		List<DailyOrderCountDTO> records = new ArrayList<DailyOrderCountDTO>();
		records.add(new DailyOrderCountDTO(dateRecord, ordiniEff));
		writeCsv(records);

	}

	private void writeCsv(List<DailyOrderCountDTO> records) {
		log.info("Scheduled Task - write csv");
		ICsvBeanWriter beanWriter = null;

		try {
			beanWriter = new CsvBeanWriter(new FileWriter("orderRecords.csv"), CsvPreference.STANDARD_PREFERENCE);
			String[] header = new String[] { "date", "countOrders" };
			beanWriter.writeHeader(header);
			for (DailyOrderCountDTO orders : records) {
				beanWriter.write(orders, header);
			}
			log.trace("Scheduled Task - csv written");
		} catch (IOException e) {
			log.error("Error Scheduled Task - write csv" + e);
		} finally {
			try {
				beanWriter.close();
			} catch (IOException e) {
				log.error("Error Scheduled Task - close bean writer" + e);
			}

		}
	}

	private static String getDateReport() {
		log.trace("Scheduled - get current date");
		LocalDate now = LocalDate.now();
		LocalDate ieri = now.minus(1, ChronoUnit.DAYS);
		String date = ieri.toString();
		return date;

	}

}
