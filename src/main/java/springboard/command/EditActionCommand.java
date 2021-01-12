package springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import springboard.model.JDBCTemplateDAO;
import springboard.model.SpringBbsDTO;

public class EditActionCommand implements BbsCommandImpl{
	
	@Override
	public void execute(Model model) {

		//파라미터 한번에 받기..
		Map<String, Object> map = model.asMap();
		HttpServletRequest req = (HttpServletRequest)map.get("req");
		
		SpringBbsDTO springBbsDTO =
				(SpringBbsDTO)map.get("springBbsDTO");
		
		JDBCTemplateDAO dao = new JDBCTemplateDAO();
		
		dao.edit(springBbsDTO);
		
	}
}
