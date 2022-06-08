import java.util.*;
import java.io.*;

public class HashMap_Board {
	public static void main(String[] args) {
		List<Board> list = new ArrayList<Board>();
		
		for(int i=0; i<5; i++) {
			Board vo = new Board();
			vo.setTitle("제목" + i);
			vo.setContents("내용" + i);
			vo.setContents("작성자" + i);
			list.add(vo);
		}
		
		System.out.println("list : " + list);
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("list", list);
		map.put("searchword", map);
		map.put("totalcount", 50);
		map.put("totalpage", 5);

		System.out.println(map.get("list").getClass());
		System.out.println(map.get("totalpage").getClass());
		System.out.println(map.get("searchword").getClass());
		
		View(map);
	}

	static void View(Map m) {
		
		System.out.println("총갯수 : " + m.get("totalcount"));
		System.out.println("총페이지 : " + m.get("totalpage"));
		System.out.println("검색어 : " + m.get("searchword"));
		
		ArrayList<Board> list = (ArrayList<Board>) m.get("list");
		
		for(Board vo : list) {
			System.out.println(vo.getTitle() + " " + vo.getContents());
		}
		
	}
}
