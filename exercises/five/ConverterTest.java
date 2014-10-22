import org.junit.Assert;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;


public class ConverterTest {

	@Test
	public void test() {
		Converter<Date> dates = new SimpleDateFormatConverter(new SimpleDateFormat("d MMMM yyyy"));
		Converter<Date> formattedDates = new SimpleDateFormatConverter(new SimpleDateFormat("d MMMM yyyy"));
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 21);
		
		Date d = cal.getTime();
		String format = dates.format(d);
		
		Assert.assertEquals(format, "21 October 2015");
	}
	
	@Test
	public void test2() {
		Converter<Date> dates = new SimpleDateFormatConverter(new SimpleDateFormat("d MMM yyyy"));
		Converter<Date> formattedDates = new SimpleDateFormatConverter(new SimpleDateFormat("d MMMM yyyy"), new SimpleDateFormat("d MM yyyy"));

		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 21);
		Date d = cal.getTime();
		
		String format = formattedDates.format(d);
		
		Assert.assertEquals(format, "21 10 2015");		
	}
	
	@Test
	public void test3() {
		Converter<Date> dates = new SimpleDateFormatConverter(new SimpleDateFormat("d MMM yyyy"));
		Converter<Date> formattedDates = new SimpleDateFormatConverter(new SimpleDateFormat("d MMMM yyyy"), new SimpleDateFormat("d MM yyyy"));
		Converter<Date> empty = new SimpleDateFormatConverter();
		
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.YEAR, 2015);
		cal.set(Calendar.MONTH, 9);
		cal.set(Calendar.DATE, 21);
		Date d = cal.getTime();
		
		String format = empty.format(d);
		
		Assert.assertEquals(format, "21 10 2015");		
	
	}
	
	@Test
	public void testFormat() {
		Auction auc = new Auction(2323, "water", 1, "H20 in a glass");
		Converter<Auction> auction = new TableRowAuctionConverter();
		String format = auction.format(auc);
		
		Assert.assertEquals("2323	water  $1	H20 in a glass", format);
	}

	@Test
	public void testFormat2() {
		
			Auction auc = new Auction(4653, "traffic cone", 50, "Road signals");
			Converter<Auction> auction = new TableRowAuctionConverter();
			String format = auction.format(auc);
			
			Assert.assertEquals(" 4653\ttraffic cone\t$50\tRoadSignals ", format);
			
		
	}
}
