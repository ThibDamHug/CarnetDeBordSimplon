package co.simplon.mappers;

import org.springframework.beans.factory.annotation.Autowired;

import co.simplon.models.Conclusion;

public class ConclusionMapper {
	
	@Autowired
	private UserMapper userMapper;
	
	public Conclusion mapConclusion(Conclusion conclusion) {
		Conclusion conclusionDTO = new Conclusion();
		conclusionDTO.setId(conclusion.getId());
		conclusionDTO.setContent(conclusion.getContent());
		conclusionDTO.setUser(userMapper.mapSimpleUser(conclusion.getUser()));
		return conclusionDTO;
	}

}
