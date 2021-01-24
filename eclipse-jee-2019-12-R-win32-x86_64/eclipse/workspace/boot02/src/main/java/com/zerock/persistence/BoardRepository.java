package com.zerock.persistence;

import org.springframework.data.repository.CrudRepository;

import com.zerock.domain.Board;

public interface BoardRepository extends CrudRepository<Board, Long> {

}