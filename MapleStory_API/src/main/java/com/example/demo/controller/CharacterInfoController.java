package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.CharacterDetails;
import com.example.demo.entity.TotalStatsDetails;
import com.example.demo.service.TotalStats;

@Controller
public class CharacterInfoController {
	
	@Autowired
	public TotalStats totalStatsService;
	
	@GetMapping("/getCharacterInfo")
	public String getCharacterInfo(@RequestParam(value = "nickname", required = false, defaultValue = "") String nickname, Model model) {
		// 닉네임 입력이 되지 않았을 경우를 처리함
		if (nickname.isEmpty()) {
			model.addAttribute("error", "닉네임 입력은 필수입니다.");
			return "characterInput"; // 닉네입 입력 폼으로 다시 리다이렉트
		}
		
		// OCID 조회
		String ocid = totalStatsService.getOcidByNickname(nickname);
		
		CharacterDetails details2 = totalStatsService.getCharacterInfoByOcid(ocid);
		model.addAttribute("details2", details2);
		
		// OCID를 기반으로 캐릭터 정보(스탯) 조회
		List<TotalStatsDetails> statsList = totalStatsService.getTotalStats(ocid);
		
//		String characterClass = "character_class";
		
		model.addAttribute("nickname", nickname);
//		model.addAttribute("character_class", characterClass);
		model.addAttribute("stats", statsList);
		
		return "charcaterInfo";
	}
	
	// 'http://localhost:8080/getCharacterInfo?nickname=' -> 캐릭터 닉네임 입력 페이지로 이동
	// 'http://localhost:8080/getCharacterInfo?nickname=닉네임' -> 캐릭터 정보 출력 페이지로 이동
}
