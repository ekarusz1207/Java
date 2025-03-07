package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.TotalStatsDetails;
import com.example.demo.service.TotalStats;

@Controller
public class TotalStatsController {
	
	@Autowired
	private TotalStats totalStatsService;
	
	@GetMapping("/stats")
	public String getStats(@RequestParam("nickname") String nickname, Model model) {
		// OCID 조회
		String ocid = totalStatsService.getOcidByNickname(nickname);
		
		// OCID를 기반으로 캐릭터 스탯 조회
		List<TotalStatsDetails> statsList = totalStatsService.getTotalStats(ocid);
		
//		// 데이터를 모델에 추가
//		model.addAttribute("nickname", nickname);
//		model.addAttribute("statList", statList);
		
		// 필요한 스탯을 개별로 찾는 과정
		String minAtkValue = null;
		String maxAtkValue = null;
		String dmgValue = null;
		String bossDmgValue = null;
		String finalDmgValue = null;
		String ignArmorValue = null;
		String criChanceValue = null;
		String criDmgValue = null;
		String starFoceValue = null;
		String arcaneForceValue = null;
		String authenticForceValue = null;
		String strValue = null;
		String dexValue = null;
		String intValue = null;
		String lukValue = null;
		String hpValue = null;
		String mpValue = null;
		
		for (TotalStatsDetails stat : statsList) {
			
			 System.out.println("Stat Name: " + stat.getStatName() + ", Value: " + stat.getStatValue());
			 System.out.println("Character Name :" + nickname);
			 
			if ("최소 스탯공격력".equals(stat.getStatName())) {
				minAtkValue = stat.getStatValue();
			} else if ("최대 스탯공격력".equals(stat.getStatName())) {
				maxAtkValue = stat.getStatValue();
			} else if ("데미지".equals(stat.getStatName())) {
				dmgValue = stat.getStatValue();
			} else if ("보스 몬스터 데미지".equals(stat.getStatName())) {
				bossDmgValue = stat.getStatValue();
			} else if ("최종 데미지".equals(stat.getStatName())) {
				finalDmgValue = stat.getStatValue();
			} else if ("방어율 무시".equals(stat.getStatName())) {
				ignArmorValue = stat.getStatValue();
			} else if ("크리티컬 확률".equals(stat.getStatName())) {
				criChanceValue = stat.getStatValue();
			} else if ("크리티컬 데미지".equals(stat.getStatName())) {
				criDmgValue = stat.getStatValue();
			} else if ("스타포스".equals(stat.getStatName())) {
				starFoceValue = stat.getStatValue();
			} else if ("아케인포스".equals(stat.getStatName())) {
				arcaneForceValue = stat.getStatValue();
			} else if ("어센틱포스".equals(stat.getStatName())) {
				authenticForceValue = stat.getStatValue();
			} else if ("STR".equals(stat.getStatName())) {
				strValue = stat.getStatValue();
			} else if ("DEX".equals(stat.getStatName())) {
				dexValue = stat.getStatValue();
			} else if ("INT".equals(stat.getStatName())) {
				intValue = stat.getStatValue();
			} else if ("LUK".equals(stat.getStatName())) {
				lukValue = stat.getStatValue();
			} else if ("HP".equals(stat.getStatName())) {
				hpValue = stat.getStatValue();
			} else if ("MP".equals(stat.getStatName())) {
				mpValue = stat.getStatValue();
			}
		}
		
//		System.out.println("STR: " + strValue);
//		System.out.println("DEX: " + dexValue);
//		System.out.println("INT: " + intValue);
		
		// 모델에 개별 값 추가하는 과정
		model.addAttribute("nickname", nickname);
		model.addAttribute("minAtkValue", minAtkValue);
		model.addAttribute("maxAtkValue", maxAtkValue);
		model.addAttribute("dmgValue", dmgValue);
		model.addAttribute("bossDmgValue", bossDmgValue);
		model.addAttribute("finalDmgValue", finalDmgValue);
		model.addAttribute("ignArmorValue", ignArmorValue);
		model.addAttribute("criChanceValue", criChanceValue);
		model.addAttribute("criDmgValue", criDmgValue);
		model.addAttribute("starFoceValue", starFoceValue);
		model.addAttribute("arcaneForceValue", arcaneForceValue);
		model.addAttribute("authenticForceValue", authenticForceValue);
		model.addAttribute("strValue", strValue);
		model.addAttribute("dexValue", dexValue);
		model.addAttribute("intValue", intValue);
		model.addAttribute("lukValue", lukValue);
		model.addAttribute("hpValue", hpValue);
		model.addAttribute("mpValue", mpValue);
		
		
		// View 이름 반환
		// templates/totalStats.html
		return "totalStats";
	}
}
