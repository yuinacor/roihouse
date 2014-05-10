package roi;

import java.io.IOException;

import net.guesthouse.roi.dto.model.DashboardTimeModel;
import net.guesthouse.roi.dto.model.RContainer;
import net.guesthouse.roi.dto.model.ReserveModel;
import net.guesthouse.roi.dto.model.ReserverModel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:test-context.xml")
public class MapperTest {

	@Test
	public void mapperTest() throws JsonParseException, JsonMappingException, IOException {
		String data = "{\"rName\":\"ddd\",\"gender\":\"M\",\"nationality\":\"kor\",\"phone\":\"010101\",\"email\":\"fdf@df.com\"}";
		String data2 = "{\"reservDate\":\"2014-04-27\",\"roomNo\":\"201\",\"chkin\":\"2014-04-30\",\"nights\":\"3\",\"rName\":\"ddd\",\"payPerDay\":\"30000\",\"payment\":\"90000\",\"deposit\":\"40000\",\"balance\":\"50000\",\"via\":\"no\"}}";
		String data3 = "{\"reserverModel\":{\"rName\":\"ddd\",\"gender\":\"M\",\"nationality\":\"kor\",\"phone\":\"010101\",\"email\":\"fdf@df.com\"},\"reserveModel\":{\"reservDate\":\"2014-04-27\",\"roomNo\":\"201\",\"chkin\":\"2014-04-30\",\"nights\":\"3\",\"rName\":\"ddd\",\"payPerDay\":\"30000\",\"payment\":\"90000\",\"deposit\":\"40000\",\"balance\":\"50000\",\"via\":\"no\"}}";

		
		ObjectMapper mapper = new ObjectMapper();
		ReserveModel reserveModel = mapper.readValue(data2, ReserveModel.class);
		ReserverModel reserverModel = mapper.readValue(data, ReserverModel.class);
		RContainer container = mapper.readValue(data3, RContainer.class);
		
		
		System.out.println("test!!!");
		
	}
	
	@Test
	public void calenderTest() throws JsonParseException, JsonMappingException, IOException{
		
		String data = "{\"start\":\"2014-05-01\",\"end\":\"2014-06-01\"}";
		System.out.println(data);
		
		ObjectMapper mapper = new ObjectMapper();
		
		DashboardTimeModel model = mapper.readValue(data, DashboardTimeModel.class);
		
	}
}
