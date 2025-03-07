package com.example.demo.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CharacterDetails;
//import com.example.demo.entity.CharacterDetails2;
import com.example.demo.entity.TotalStatsDetails;

@Service
public class TotalStats {

	private static final String API_KEY = "test_cfe2f1c46928427ec384090118eb693fc3efc0a18c7f71533c998616161ce8f6042c17b6efaa5f8fd964840c765b3b76";

	// 캐릭터 닉네임으로 OCID를 조회
	public String getOcidByNickname(String nickname) {
		try {
			String encodedNickname = URLEncoder.encode(nickname, StandardCharsets.UTF_8);
			String url = "https://open.api.nexon.com/maplestory/v1/id?character_name=" + encodedNickname;
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("x-nxopen-api-key", API_KEY);

			int responseCode = conn.getResponseCode();
			BufferedReader in;
			if (responseCode == 200) {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}

			StringBuilder response = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(response.toString());

			System.out.println("OCID : " + jsonObject.get("ocid").toString());
			return jsonObject.get("ocid").toString();
		} catch (Exception e) {
			System.err.println("Error while fetching OCID: " + e.getMessage());
			return null;
		}
	}


	// OCID로 캐릭터 정보를 조회
	public CharacterDetails getCharacterInfoByOcid(String ocid) {
		try {
			String url = "https://open.api.nexon.com/maplestory/v1/character/basic?ocid=" + ocid + "&date=2024-12-09";
			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("x-nxopen-api-key", API_KEY);

			int responseCode = conn.getResponseCode();
			BufferedReader in;
			if (responseCode == 200) {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}

			StringBuilder response = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(response.toString());

			String characterName = (String) jsonObject.get("character_name");
			String characterClass = (String) jsonObject.get("character_class");
			String level = (String) jsonObject.get("character_level");
			String expRate = (String) jsonObject.get("character_exp_rate");
			
			
			return new CharacterDetails(characterName, characterClass, level, expRate);
		} catch (Exception e) {
			System.err.println("Error while fetching character info: " + e.getMessage());
			return null;
		}
	}

	// 캐릭터 스탯 정보 조회
	public List<TotalStatsDetails> getTotalStats(String ocid) {
		// 반환할 리스트 생성
		List<TotalStatsDetails> statsDetailsList = new ArrayList<>();

		try {
			String url = "https://open.api.nexon.com/maplestory/v1/character/stat?ocid=" + ocid + "&date=2024-12-09";

			HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("x-nxopen-api-key", API_KEY);

			int responseCode = conn.getResponseCode();
			BufferedReader in;
			if (responseCode == 200) {
				in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			} else {
				in = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
			}

			StringBuilder response = new StringBuilder();
			String inputLine;
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// JSON 파싱
			JSONParser parser = new JSONParser();
			JSONObject jsonObject = (JSONObject) parser.parse(response.toString());

			System.out.println("API Response: " + jsonObject);

			// final_stat 배열(Array) 가져오기
			JSONArray finalStatArray = (JSONArray) jsonObject.get("final_stat");

			// 반복문을 사용해서 특정 key 값을 찾아내기
			for (Object statObject : finalStatArray) {
				JSONObject stat = (JSONObject) statObject;
				String statName = stat.get("stat_name").toString(); // stat_name 키 값
				String statValue = stat.get("stat_value").toString(); // stat_value 키 값

				TotalStatsDetails statsDetails = new TotalStatsDetails();
				// Service 에서는 final_stat 값만 가져오면 된다
				statsDetails.setStatName(statName);
				statsDetails.setStatValue(statValue);

				// 리스트에 추가
				statsDetailsList.add(statsDetails);
			}

		} catch (Exception e) {
			System.err.println("Error while fetching character info: " + e.getMessage());
			return null;
		}

		// 저장된 리스트 반환
		return statsDetailsList;
	}
}
