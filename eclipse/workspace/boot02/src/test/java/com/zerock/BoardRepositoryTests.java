package com.zerock;

import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zerock.domain.Board;
import com.zerock.persistence.BoardRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTests {

	@Autowired
	private BoardRepository boardRepo;
	
	@Test
	public void inspect()
	{
		Class<?> clz = boardRepo.getClass();
		
		System.out.println(clz.getName());
		Class<?>[] interfaces = clz.getInterfaces();
		
		Stream.of(interfaces).forEach(inter -> System.out.println(inter.getName()));
		
		Class<?> superClasses  = clz.getSuperclass();
		
		System.out.println(superClasses.getName());
	}
	
	@Test
	public void testInsert()
	{
		Board board = new Board();
		board.setTitle("게시물의 제목");
		board.setContent("게시물 내용 넣기...");
		board.setWriter("uer00");
		
		boardRepo.save(board);
	}
	
	@Test
	public void testRead()
	{
		Board board = boardRepo.findById(1L).get();
		System.out.println(board);
	}
	
	@Test
	public void testUpdate()
	{
		System.out.println("Read First...........................");
		Board board = boardRepo.findById(1L).get();
		
		System.out.println("Update Title...........................");
		board.setTitle("수정된 제목입니다");
		
		System.out.println("Call Save() ............................");
		boardRepo.save(board);
	}
	
	@Test
	public void testDelete()
	{
		System.out.println("DELETE Entity ");
		boardRepo.deleteById(1L);
	}
}
