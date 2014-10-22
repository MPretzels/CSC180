import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SimpleDateFormatConverter implements Converter<Date> {

	private SimpleDateFormat parser, formatter;
	private SimpleDateFormat sdf = new SimpleDateFormat("d MMMM yyyy");
	
	public SimpleDateFormatConverter() {
		parser = sdf;
		formatter = sdf;
	}
	
	public SimpleDateFormatConverter(SimpleDateFormat sdf) {
		parser = formatter = sdf;
	}
	
	public SimpleDateFormatConverter(SimpleDateFormat forParsing, SimpleDateFormat forFormatting) {
		if (forParsing == null) {
			forParsing = sdf;
		} 
		if (forFormatting == null) {
			forFormatting = sdf;
		}
		parser = forParsing;
		formatter = forFormatting;
	}
	
	@Override
	public Date parse(String fromString) {
		try {
			return parser.parse(fromString);
		} catch (ParseException px) {
			
		}
		return null;
	}

	@Override
	public String format(Date fromObject) {
		return formatter.format(fromObject);
	}

}
