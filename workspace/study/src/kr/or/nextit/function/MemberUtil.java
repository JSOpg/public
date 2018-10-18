package kr.or.nextit.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kr.or.nextit.function.service.CommCodeVo;

public class MemberUtil {

	/**
	 * 성별 목록 List
	 * 
	 * @return
	 */
	public List<CommCodeVo> getSexItems() {
		List<CommCodeVo> result = new ArrayList<>();
		result.add(new CommCodeVo("M", "남성"));
		result.add(new CommCodeVo("W", "여성"));

		return result;
	}

	public static List<String> getHobby(String[] params) {
		List<String> result = new ArrayList<>();
		List<HashMap<String, Object>> hobbyList = getDisplayHobbyList();

		for (String hobby : params) {

			for (HashMap<String, Object> item : hobbyList) {
				String key = (String) item.get("key");
				if (hobby.equalsIgnoreCase(key)) {
					String dis = String.format("%s (%s)", item.get("display"), item.get("key"));
					result.add(dis);
					break;
				}
			}
		}
		return result;
	}

	public static List<CommCodeVo> getHobbyItems() {

		List<CommCodeVo> result = new ArrayList<>();

		CommCodeVo item = new CommCodeVo();
		item.setKey("HO001");
		item.setValue("자전거");
		result.add(item);

		item = new CommCodeVo();
		item.setKey("HO002");
		item.setValue("오토바이");
		result.add(item);

		result.add(new CommCodeVo("HO003", "야구"));
		result.add(new CommCodeVo("HO004", "축구"));

		return result;
	}

	/**
	 * 착한 아이만 보이는 취미 목록~~~
	 * 
	 * @return
	 */
	public static List<HashMap<String, Object>> getDisplayHobbyList() {

		List<HashMap<String, Object>> result = new ArrayList<>();

		HashMap<String, Object> item = new HashMap<>();
		item.put("key", "HO001");
		item.put("display", "잠자기");
		result.add(item);

		item = new HashMap<>();
		item.put("key", "HO002");
		item.put("display", "여행");
		result.add(item);

		item = new HashMap<>();
		item.put("key", "HO003");
		item.put("display", "자전거");
		result.add(item);

		item = new HashMap<>();
		item.put("key", "HO004");
		item.put("display", "화분 키우기");
		result.add(item);

		item = new HashMap<>();
		item.put("key", "HO005");
		item.put("display", "꿀 먹기~~");
		result.add(item);

		return result;
	}

	/**
	 * 미성년자 판단 및 나이 출력
	 * 
	 * @param age
	 * @return
	 */
	public static String getDisplayAge(int age) {

		if (age <= 18) {
			return String.format(" 미성년자 (%d) ", age);
		} else {
			return String.format(" 성인 (%d) ", age);
		}

	}
}
