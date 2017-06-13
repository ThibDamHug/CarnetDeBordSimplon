package co.simplon.mappers;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.models.Conclusion;

/**
 * 
 * @author Abdel Ahmar
 *
 */
@Service
public class ConclusionMapper {
	
	@Autowired
	private UserMapper userMapper;
	
	private Conclusion mapConclusion(Conclusion conclusion) {
		Conclusion conclusionDTO = new Conclusion();
		conclusionDTO.setId(conclusion.getId());
		conclusionDTO.setContent(conclusion.getContent());
		conclusionDTO.setUser(userMapper.mapSimpleUser(conclusion.getUser()));
		return conclusionDTO;
	}
	public List<Conclusion> mapConclusionsByStudentId(List<Conclusion> conclusions, int studentId) {
		List<Conclusion> result = new ArrayList<>();
		for (Conclusion conclusion : conclusions) {
			if (conclusion.getUser().getId() == studentId) {
				Conclusion conclusionDTO = mapConclusion(conclusion);
				result.add(conclusionDTO);
			}				
		}
		return result;
	}
	
	public List<Conclusion> mapConclusionsForTeacher(List<Conclusion> conclusions) {
		List<Conclusion> result = new ArrayList<>();
		for (Conclusion conclusion : conclusions) {
			Conclusion conclusionDTO = mapConclusion(conclusion);			
			result.add(conclusionDTO);
		}
		return result;
	}
}
