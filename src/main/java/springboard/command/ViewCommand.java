package springboard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import springboard.model.JDBCTemplateDAO;
import springboard.model.SpringBbsDTO;

public class ViewCommand implements BbsCommandImpl{
	@Override
	public void execute(Model model) {
		
		Map<String, Object> paraMap = model.asMap();
		HttpServletRequest req = (HttpServletRequest)paraMap.get("req");
		
		String idx = req.getParameter("idx");
		String nowPage = req.getParameter("nowPage");
		
		JDBCTemplateDAO dao = new JDBCTemplateDAO();
		SpringBbsDTO dto = new SpringBbsDTO();
		dto = dao.view(idx);
		if(dto != null) {
		//줄바꿈 처리위해 <br/>로 변경
		dto.setContents(dto.getContents().replace("\r\n", "<br/>"));
		}
		model.addAttribute("viewRow", dto);
		model.addAttribute("nowPage", nowPage);
		
	}
}
